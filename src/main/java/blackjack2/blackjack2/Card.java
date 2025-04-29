package blackjack2.blackjack2;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

class Card {
    private int value;
    private String suit;
    private String rank;
    private ImageView cardImage;

    public Card(Parent root) {}

    public Card(int value , String suit , String rank) {
        this.value = value;
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public ImageView getCardImage() {
        return cardImage;
    }

    public void setCardImage(ImageView cardImage) {
        this.cardImage = cardImage;
    }
}