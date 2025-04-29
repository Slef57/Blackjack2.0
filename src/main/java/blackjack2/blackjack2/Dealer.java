package blackjack2.blackjack2;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

class Dealer extends Player {

    AnchorPane acePopUp;
    ImageView SecondCardFlipped;

    public Dealer(Parent root) {
        super(root);
        budget = 1000000000;
        name = "House";
        this.acePopUp = (AnchorPane) root.lookup("#acePopUp");
        this.SecondCardFlipped = (ImageView) root.lookup("#SecondCardFlipped");
    }

    @Override
    public void draw(Deck deck) {
        if (deck.isEmpty()) {
            deck.reshuffle();
//            printS("Deck has been reshuffled.");
        }

        this.hand.add(deck.getDeck().get(0));
        deck.getDeck().remove(0);
        if (this.hand.get(this.hand.size() - 1).getValue() == 0)
            this.hand.get(this.hand.size() - 1).setValue(11);

        showCard(this.hand.get(this.hand.size() - 1));

    }

    public void showCard(Card c) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(300));
        tt.setNode(c.getCardImage());
        switch (this.hand.size()) {
            case 1:
                c.getCardImage().setOpacity(1);
                tt.setByX(-1294);
                tt.setByY(43);
                tt.play();
                break;
            case 2:
                c.getCardImage().setOpacity(0);
                c.getCardImage().setLayoutX(580);
                c.getCardImage().setLayoutY(75);

                SecondCardFlipped.setLayoutX(1644);
                SecondCardFlipped.setLayoutY(32);
                SecondCardFlipped.setOpacity(1);

                System.out.println(SecondCardFlipped.getLayoutX()+" X");
                System.out.println(SecondCardFlipped.getLayoutY()+" Y");

                tt.setNode(SecondCardFlipped);
                SecondCardFlipped.setOpacity(1);
                tt.setByX(-1064);
                tt.setByY(30);
                tt.play();
                break;
            case 3:
                tt.setNode(c.getCardImage());
                c.getCardImage().setOpacity(1);
                tt.setByX(-834);
                tt.setByY(43);
                tt.play();
                break;
            case 4:
                c.getCardImage().setOpacity(1);
                tt.setByX(-604);
                tt.setByY(43);
                tt.play();;
                break;
            case 5:
                c.getCardImage().setOpacity(1);
                tt.setByX(-1294);
                tt.setByY(365);
                tt.play();
                break;
            case 6:
                c.getCardImage().setOpacity(1);
                tt.setByX(-1064);
                tt.setByY(365);
                tt.play();
                break;
        }
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