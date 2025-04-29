package blackjack2.blackjack2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GameBoardController implements Initializable {

    @FXML
    private Text budgetValue;
    @FXML
    private Text betValue;
    @FXML
    private Text handValue;
    @FXML
    private Text testing;
    @FXML
    private Text PopUpBetValue;
    @FXML
    private Text betPopUpText;
    @FXML
    private Text WinPopUpHVText;
    @FXML
    private Text WinPopUpHouseHVText;
    @FXML
    private Text LosePopUpHVText;
    @FXML
    private Text LosePopUpHouseHVText;
    @FXML
    private Text DrawPopUpHVText;
    @FXML
    private AnchorPane betPopUp;
    @FXML
    private AnchorPane AceValueChangePopUp;
    @FXML
    private AnchorPane BustPopUp;
    @FXML
    private AnchorPane BlackjackPopUp;
    @FXML
    private AnchorPane HouseBustPopUp;
    @FXML
    private AnchorPane HouseBlackjackPopUp;
    @FXML
    private AnchorPane WinPopUp;
    @FXML
    private AnchorPane LosePopUp;
    @FXML
    private AnchorPane DrawPopUp;
    @FXML
    private ImageView SecondCardFlipped;
    @FXML
    private Slider BetSlider;
    @FXML
    private Button DrawButton;
    @FXML
    private Button BetPopUpSubmitButton;

    private Game game;
    int bet;

    public void setGame(Game game) {
        this.game = game;
    }

    @FXML
    public void updatePopUpBetValue() {
        PopUpBetValue.setText(String.valueOf((int) BetSlider.getValue()));
    }

    @FXML
    public void onBetPopUpSubmitButtonClick() {
        double bet = game.user.bet();
        game.user.draw(game.deck);
        game.house.draw(game.deck);
        game.user.draw(game.deck);
        game.house.draw(game.deck);

        if (game.checkBust(game.user))
            return;
        if (game.checkBlackJack(game.user))
            return;
    }

    @FXML
    public void onDrawButtonClick() {
        game.user.draw(game.deck);
        Card c = game.user.hand.get(game.user.hand.size() - 1);

        if (game.checkBust(game.user))
            return;
        if (game.checkBlackJack(game.user))
            return;
    }

    @FXML
    public void onStandButtonClick() throws InterruptedException, IOException {
        DrawButton.setDisable(true);
        SecondCardFlipped.setOpacity(0);
        game.house.hand.get(1).getCardImage().setOpacity(1);

        while (game.getHandValue(game.house) < 17) {
            game.house.draw(game.deck);
            if (game.checkBust(game.house)) {
                System.out.println("House bust with value: " + game.getHandValue(game.house));
                game.user.budget += game.user.bet * 2;
                game.user.updateBudgetValue();
//                game.endRound();
                return;
            } else if (game.checkBlackJack(game.house)) {
                System.out.println("House blackjack with value: " + game.getHandValue(game.house));
                game.user.updateBudgetValue();
//                game.endRound();
                return;
            }
        }

        if (game.getHandValue(game.user) > game.getHandValue(game.house)) {
            WinPopUpHVText.setText("Your Hand Value (" + game.getHandValue(game.user) + ")");
            WinPopUpHouseHVText.setText("is above house Hand Value (" + game.getHandValue(game.house) + ")");
            WinPopUp.setVisible(true);

            game.user.budget += game.user.bet * 2;
            game.user.bet = 0;
            game.user.updateBudgetValue();
            game.endRound();
        } else if (game.getHandValue(game.user) < game.getHandValue(game.house)) {
            LosePopUpHVText.setText("Your Hand Value (" + game.getHandValue(game.user) + ")");
            LosePopUpHouseHVText.setText("is below house Hand Value (" + game.getHandValue(game.house) + ")");
            LosePopUp.setVisible(true);

            game.user.bet = 0;
            game.endRound();
        } else {
            DrawPopUpHVText.setText("Hand Value (" + game.getHandValue(game.user) + ")");
            DrawPopUp.setVisible(true);

            game.user.budget += game.user.bet;
            game.user.bet = 0;
            game.user.updateBudgetValue();
            game.endRound();
        }
    }

    @FXML
    public void onAcePopUp1ButtonClick() {
        for (int i = 0; i < game.user.hand.size(); i++) {
            if (game.user.hand.get(i).getValue() == 0) {
                game.user.hand.get(i).setValue(1);
                game.checkBust(game.user);
                game.checkBlackJack(game.user);
                break;
            }
        }

        game.user.acePopUp.setVisible(false);
        game.user.updateHandValue();
    }

    @FXML
    public void onAcePopUp11ButtonClick() {
        for (int i = 0; i < game.user.hand.size(); i++) {
            if (game.user.hand.get(i).getValue() == 0) {
                game.user.hand.get(i).setValue(11);
                game.checkBust(game.user);
                game.checkBlackJack(game.user);
                break;
            }
        }
        game.user.acePopUp.setVisible(false);
        game.user.updateHandValue();
    }

    @FXML
    public void onAceValueChangePopUpOKButtonClick() {
        AceValueChangePopUp.setVisible(false);
        game.user.updateHandValue();
    }

    @FXML
    public void onBustPopUpPlayAgainButtonClick() throws IOException {
        BustPopUp.setVisible(false);
        game.endRound();
    }

    @FXML
    public void onBustPopUpExitButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML void onHouseBustPopUpPlayAgainButtonClick() throws IOException {
        HouseBustPopUp.setVisible(false);
        game.endRound();
    }

    @FXML
    public void onHouseBustPopUpExitButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void onBlackjackPopUpPlayAgainButtonClick() throws IOException {
        BlackjackPopUp.setVisible(false);
        game.endRound();
    }

    @FXML
    public void onBlackjackPopUpExitButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void onHouseBlackjackPopUpPlayAgainButtonClick() throws IOException {
        HouseBlackjackPopUp.setVisible(false);
        game.endRound();
    }

    @FXML
    public void onHouseBlackjackPopUpExitButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void onWinPopUpPlayAgainButtonClick() throws IOException {
        WinPopUp.setVisible(false);
        game.endRound();
    }

    @FXML
    public void onWinPopUpExitButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void onLosePopUpPlayAgainButtonClick() throws IOException {
        LosePopUp.setVisible(false);
        game.endRound();
    }

    @FXML
    public void onLosePopUpExitButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void onDrawPopUpPlayAgainButtonClick() throws IOException {
        DrawPopUp.setVisible(false);
        game.endRound();
    }

    @FXML
    public void onDrawPopUpExitButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void onBrokePopUpExitButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BetSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                bet = (int) BetSlider.getValue();
                PopUpBetValue.setText(Integer.toString(bet));
                if (bet == 0) {
                    DrawButton.setDisable(true);
                    BetPopUpSubmitButton.setDisable(true);
                    betPopUpText.setText("You cannot bet 0!!!");
                } else {
                    DrawButton.setDisable(false);
                    BetPopUpSubmitButton.setDisable(false);
                    betPopUpText.setText("Please enter your bet");
                }
            }
        });
    }
}