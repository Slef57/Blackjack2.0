package blackjack2.blackjack2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    AnchorPane namePopUp;
    @FXML
    private TextField nameField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    @FXML
    protected void onExitButtonClick(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    protected void onPlayButtonClick(ActionEvent event) {
        namePopUp.setVisible(true);
    }

    @FXML
    protected void onCancelButtonClick(ActionEvent event) {
        nameField.setText("");
        namePopUp.setVisible(false);
    }

    @FXML
    public void onSubmitButtonClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
        root = loader.load();

        GameBoardController controller = loader.getController();

        Game game = new Game(root);
        game.user.setName(nameField.getText());

        controller.setGame(game);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
        game.startGame();
    }

    @FXML
    public void onInstructionsButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Instructions.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }
}