package blackjack2.blackjack2;

import java.io.IOException;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


class Game {

    User user;
    Dealer house;
    Deck deck;

    private Stage stage;
    private Scene scene;
    Parent root;

    //GUI elements i want to update
    Text budgetValue;
    Text betValue;
    Text handValue;
    Text BustPopUpHVText;
    Text HouseBustPopUpHVText;
    Slider BetSlider;
    AnchorPane HouseBlackjackPopUp;
    AnchorPane HouseBustPopUp;
    AnchorPane AceValueChangePopUp;
    AnchorPane BustPopUp;
    AnchorPane BlackjackPopUp;
    AnchorPane BrokePopUp;
    AnchorPane betPopUp;

    Scanner scanner = new Scanner(System.in);


    public Game(Parent root) {
        this.root = root;

        this.budgetValue = (Text) root.lookup("#budgetValue");
        this.betValue = (Text) root.lookup("#betValue");
        this.handValue = (Text) root.lookup("#handValue");
        this.BustPopUpHVText = (Text) root.lookup("#BustPopUpHVText");
        this.HouseBustPopUpHVText = (Text) root.lookup("#HouseBustPopUpHVText");
        this.BetSlider = (Slider) root.lookup("#BetSlider");
        this.HouseBlackjackPopUp = (AnchorPane) root.lookup("#HouseBlackjackPopUp");
        this.HouseBustPopUp = (AnchorPane) root.lookup("#HouseBustPopUp");
        this.AceValueChangePopUp = (AnchorPane) root.lookup("#AceValueChangePopUp");
        this.BustPopUp = (AnchorPane) root.lookup("#BustPopUp");
        this.BlackjackPopUp = (AnchorPane) root.lookup("#BlackjackPopUp");
        this.BrokePopUp = (AnchorPane) root.lookup("#BrokePopUp");
        this.betPopUp = (AnchorPane) root.lookup("#betPopUp");

        user = new User(root);
        house = new Dealer(root);
        deck = new Deck(root);
        deck.initial();
        deck.shuffle();

//        //printS("Welcome to BlackJack!");
//        round();
//        //printS("Would you like to play another round? (y/n)");
//        String answer;
//        do {
//            if (user.getBudget() == 0) {
//                //printS("You are out of money! Game over.");
//                return;
//            }
//            answer = scanner.next();
//            if (!(answer.equals("y") || answer.equals("n")))
//                printS("Invalid input. Please enter 'y' or 'n'");
//            else if (answer.equals("y")) {
//                round();
//                //printS("Would you like to play another round? (y/n)");
//            }
//        } while (answer.equals("y") || !answer.equals("n"));
//        printS(user.getName() + "'s budget: " + user.getBudget());
    }

    public void startGame() {
        Platform.runLater(() -> budgetValue.setText("" + (int)user.getBudget()));
    }

    public void round() {
        //printS("Round Start!");
        //printS(user.getName() + "'s turn:");
        //printS("Budget: " + user.getBudget());
        //this.budgetValue.setText(""+user.getBudget());

        //user.bet();

//        printS(user.getName() + " draws ");
//        user.draw(deck);
//        user.printHand();
//
//        //printS(house.getName() + " draws ");
//        house.draw(deck);
//        house.printHand();
//
//        //printS(user.getName() + " draws ");
//        user.draw(deck);
//        user.printHand();
//
//        //printS(house.getName() + " draws ");
//        house.draw(deck);
//
//        if (checkBust(user))  {
//            endRound();
//            return;
//        }
//
//
//        if (checkBlackJack(user))  {
//            endRound();
//            return;
//        }
//
//        System.out.println();
//
//
//        //printS("Would you like to draw another Card? (y/n)");
//        String answer;
//        do {
//            answer = scanner.next();
//            if (!(answer.equals("y") || answer.equals("n")))
//                printS("Invalid input. Please enter 'y' or 'n'");
//            else if (answer.equals("y")) {
//                printS(user.getName() + " draws ");
//                user.draw(deck);
//                user.printHand();
//                if (checkBust(user)) {
//                    endRound();
//                    return;
//                }
//                if (checkBlackJack(user)) {
//                    endRound();
//                    return;
//                }
//                //printS("Would you like to draw another Card? (y/n)");
//            }
//        } while (answer.equals("y") || !answer.equals("n"));
//
//        house.printHand();
//
//        while (getHandValue(house) < 17) {
//            //printS(house.getName() + " draws ");
//            house.draw(deck);
//            house.printHand();
//            if (checkBust(house)) {
//                user.budget += user.bet * 2;
//                endRound();
//                return;
//            }
//        }
//
//        System.out.println("Deck is empty. Reshuffling deck.");
//        deck.reshuffle();
//
//        I AM HERE
//
//        if (getHandValue(user) > getHandValue(house)) {
//            //printS(user.getName() + " wins!");
//            user.budget += user.bet + (user.bet * 2);
//            user.bet = 0;
//            endRound();
//            return;
//        } else if (getHandValue(user) < getHandValue(house)) {
//            //printS(house.getName() + " wins!");
//            user.bet = 0;
//            endRound();
//            return;
//        } else {
//            //printS("Draw!");
//            user.budget += user.bet;
//            user.bet = 0;
//            endRound();
//            return;
//        }
    }

    public int getHandValue (Player p){
        int handValue = 0;
        for (int i = 0; i < p.hand.size(); i++)
            handValue += p.hand.get(i).getValue();
        return handValue;
    }

//    public void discardHand (Player p){
//        for (int i = 0; i < p.hand.size(); i++) {
//            Deck.discard.add(p.hand.get(i));
//            p.hand.remove(i);
//        }
//    }

    public boolean checkBlackJack (Player p) {
        if (p instanceof Dealer) {
            if (this.getHandValue(p) == 21) {
                HouseBlackjackPopUp.setVisible(true);
                return true;
            }
            return false;
        } else {
            if (this.getHandValue(p) == 21) {
                BlackjackPopUp.setVisible(true);
                p.budget += p.bet + (p.bet * 1.5);
                p.updateBudgetValue();
                p.bet = 0;
                return true;
            }
            return false;
        }
    }

    public boolean checkBust (Player p) {
        if (p instanceof Dealer) {
            if (this.getHandValue(p) > 21) {
                for (int i = 0; i < p.hand.size(); i++) {
                    if (p.hand.get(i).getValue() == 11) {
                        p.hand.get(i).setValue(1);
                        p.updateHandValue();
                        break;
                    }
                }
                if (this.getHandValue(p) > 21) {
                    HouseBustPopUpHVText.setText("House Hand Value (" + this.getHandValue(p) + ")");
                    HouseBustPopUp.setVisible(true);

                    p.bet = 0.0;
                    return true;
                }
            }
        } else {
            if (this.getHandValue(p) > 21) {
                for (int i = 0; i < p.hand.size(); i++) {
                    if (p.hand.get(i).getValue() == 11) {
                        AceValueChangePopUp.setVisible(true);
                        p.hand.get(i).setValue(1);
                        p.updateHandValue();
                        break;
                    }
                }
                if (this.getHandValue(p) > 21) {
                    BustPopUpHVText.setText("Your Hand Value (" + this.getHandValue(p) + ")");
                    BustPopUp.setVisible(true);

                    p.setBet(0.0);
                    return true;
                }
            }
        }
        return false;
    }

    public void endRound () throws IOException {
        deck.discardHand(user);
        deck.discardHand(house);

        if (user.budget == 0) {
            BrokePopUp.setVisible(true);
            return;
        } else {
            BetSlider.setMax(user.budget);
            betPopUp.setVisible(true);
        }

        betValue.setText("");
        handValue.setText("");
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