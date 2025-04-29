package blackjack2.blackjack2;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

class User extends Player {

    Text betValue;
    Text budgetValue;
    Text PopUpBetValue;
    Text betPopUpText;
    Button DrawButton;
    Button StandButton;
    AnchorPane betPopUp;
    AnchorPane acePopUp;

    public User(Parent root) {
        super(root);
        this.betValue = (Text) root.lookup("#betValue");
        this.budgetValue = (Text) root.lookup("#budgetValue");
        this.PopUpBetValue = (Text) root.lookup("#PopUpBetValue");
        this.betPopUpText = (Text) root.lookup("#betPopUpText");
        this.DrawButton = (Button) root.lookup("#DrawButton");
        this.StandButton = (Button) root.lookup("#StandButton");
        this.betPopUp = (AnchorPane) root.lookup("#betPopUp");
        this.acePopUp = (AnchorPane) root.lookup("#acePopUp");

    }

    @Override
    public void draw(Deck deck) {
        if (deck.isEmpty()) {
            deck.reshuffle();
//            printS("Deck has been reshuffled.");
        }

        DrawButton.setDisable(false);
        StandButton.setDisable(false);

        Card c = deck.getDeck().get(0);

//        for (Card i : this.hand) {
//            if (c.getValue() == 0 && (i.getValue() == 1 || i.getValue() == 11)) {
//                draw(deck);
//            }
//        }

        if (c.getValue() == 0) {
            acePopUp.setVisible(true);
        }

        this.hand.add(c);
        deck.getDeck().remove(0);

        updateHandValue();

        showCard(this.hand.get(this.hand.size() - 1));

    }

    public void showCard(Card c) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(500));
        tt.setNode(c.getCardImage());
        switch (this.hand.size()) {
            case 1:
                c.getCardImage().setOpacity(1);
                tt.setByX(-1344);
                tt.setByY(713);
                tt.play();
                break;
            case 2:
                c.getCardImage().setOpacity(1);
                tt.setByX(-1114);
                tt.setByY(713);
                tt.setDuration(Duration.millis(580));
                tt.play();
                break;
            case 3:
                c.getCardImage().setOpacity(1);
                tt.setDuration(Duration.millis(500));
                tt.setByX(-884);
                tt.setByY(713);
                tt.play();
                break;
            case 4:
                c.getCardImage().setOpacity(1);
                tt.setDuration(Duration.millis(500));
                tt.setByX(-654);
                tt.setByY(713);
                tt.play();
                break;
            case 5:
                c.getCardImage().setOpacity(1);
                tt.setDuration(Duration.millis(500));
                tt.setByX(-424);
                tt.setByY(713);
                tt.play();
                break;
            case 6:
                c.getCardImage().setOpacity(1);
                tt.setDuration(Duration.millis(500));
                tt.setByX(-194);
                tt.setByY(713);
                tt.play();
                break;
        }

    }

    @Override
    public double bet() {
        betPopUp.setVisible(true);
        bet = Double.parseDouble(PopUpBetValue.getText());


        this.bet = bet;
        budget -= bet;
        betValue.setText("" + (int)this.bet);
        budgetValue.setText("" + (int)this.budget);

        betPopUp.setVisible(false);
        return bet;

    }

    public static void printS(String message) {
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            System.out.print(ch);
            //Thread.sleep(0); // Sleep 100ms (0.1 seconds)
        }
        System.out.println();
    }
}
