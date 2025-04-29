package blackjack2.blackjack2;

import javafx.scene.Parent;
import javafx.scene.text.Text;

import java.util.ArrayList;

class Player {

    ArrayList<Card> hand;
    double budget;
    double bet;
    String name;

    Parent root;
    Text handValue;
    Text budgetValue;

    public Player(Parent root) {
        this.root = root;
        hand = new ArrayList<Card>();
        budget = 100;
        bet = 0;
        this.handValue = (Text) root.lookup("#handValue");
        this.budgetValue = (Text) root.lookup("#budgetValue");
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Text getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue.setText(""+ handValue);
    }

    public void draw(Deck deck) {}

    public double bet() {return 0;}

    public void printHand() {
        printS(this.getName() + "'s hand:");
        int handValue = 0;
        for (int i = 0; i < hand.size(); i++) {
            printS(hand.get(i).getSuit() + " of " + hand.get(i).getRank());
            handValue += hand.get(i).getValue();
        }
        printS("Hand value: " + handValue + "\n");
    }

    public void updateHandValue() {
        int handValue = 0;
        for (int i = 0; i < hand.size(); i++) {
            handValue += hand.get(i).getValue();
        }
        this.handValue.setText("" + handValue);
    }

    public void updateBudgetValue() {
        this.budgetValue.setText("" + (int)budget);
    }

    public void printBudget() {
        printS(this.getName() + "'s budget: " + budget);
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
