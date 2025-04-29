package blackjack2.blackjack2;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

class Deck {
    ArrayList<Card> deck;
    static ArrayList<Card> discard;
    Parent root;

    ImageView SecondCardFlipped;

    public Deck(Parent root) {
        this.root = root;
        deck = new ArrayList<Card>(52);
        discard = new ArrayList<Card>();
        for (int i = 0 ; i < 52 ; i++)
            deck.add(new Card(root));

        SecondCardFlipped = (ImageView) root.lookup("#SecondCardFlipped");
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

//    public void initial() {
//        this.deck.get(0).setValue(1);
//        this.deck.get(0).setSuit("Ace");
//        this.deck.get(0).setRank("Hearts");
//        this.deck.get(0).setCardImage((ImageView) root.lookup("#AceOfHearts"));
//
//        this.deck.get(1).setValue(2);
//        this.deck.get(1).setSuit("Two");
//        this.deck.get(1).setRank("Hearts");
//        this.deck.get(1).setCardImage((ImageView) root.lookup("#TwoOfHearts"));
//
//        this.deck.get(2).setValue(3);
//        this.deck.get(2).setSuit("Three");
//        this.deck.get(2).setRank("Hearts");
//        this.deck.get(2).setCardImage((ImageView) root.lookup("#ThreeOfHearts"));
//
//        this.deck.get(3).setValue(4);
//        this.deck.get(3).setSuit("Four");
//        this.deck.get(3).setRank("Hearts");
//        this.deck.get(3).setCardImage((ImageView) root.lookup("#FourOfHearts"));
//
//        this.deck.get(4).setValue(5);
//        this.deck.get(4).setSuit("Five");
//        this.deck.get(4).setRank("Hearts");
//        this.deck.get(4).setCardImage((ImageView) root.lookup("#FiveOfHearts"));
//
//        this.deck.get(5).setValue(6);
//        this.deck.get(5).setSuit("Six");
//        this.deck.get(5).setRank("Hearts");
//        this.deck.get(5).setCardImage((ImageView) root.lookup("#SixOfHearts"));
//
//        this.deck.get(6).setValue(7);
//        this.deck.get(6).setSuit("Seven");
//        this.deck.get(6).setRank("Hearts");
//        this.deck.get(6).setCardImage((ImageView) root.lookup("#SevenOfHearts"));
//
//        this.deck.get(7).setValue(8);
//        this.deck.get(7).setSuit("Eight");
//        this.deck.get(7).setRank("Hearts");
//        this.deck.get(7).setCardImage((ImageView) root.lookup("#EightOfHearts"));
//
//        this.deck.get(8).setValue(9);
//        this.deck.get(8).setSuit("Nine");
//        this.deck.get(8).setRank("Hearts");
//        this.deck.get(8).setCardImage((ImageView) root.lookup("#NineOfHearts"));
//
//        this.deck.get(9).setValue(10);
//        this.deck.get(9).setSuit("Ten");
//        this.deck.get(9).setRank("Hearts");
//        this.deck.get(9).setCardImage((ImageView) root.lookup("#TenOfHearts"));
//
//        this.deck.get(10).setValue(10);
//        this.deck.get(10).setSuit("Jack");
//        this.deck.get(10).setRank("Hearts");
//        this.deck.get(10).setCardImage((ImageView) root.lookup("#JackOfHearts"));
//
//        this.deck.get(11).setValue(10);
//        this.deck.get(11).setSuit("Queen");
//        this.deck.get(11).setRank("Hearts");
//        this.deck.get(11).setCardImage((ImageView) root.lookup("#QueenOfHearts"));
//
//        this.deck.get(12).setValue(10);
//        this.deck.get(12).setSuit("King");
//        this.deck.get(12).setRank("Hearts");
//        this.deck.get(12).setCardImage((ImageView) root.lookup("#KingOfHearts"));
//
//        this.deck.get(13).setValue(1);
//        this.deck.get(13).setSuit("Ace");
//        this.deck.get(13).setRank("Clubs");
//        this.deck.get(13).setCardImage((ImageView) root.lookup("#AceOfClubs"));
//
//        this.deck.get(14).setValue(2);
//        this.deck.get(14).setSuit("Two");
//        this.deck.get(14).setRank("Clubs");
//        this.deck.get(14).setCardImage((ImageView) root.lookup("#TwoOfClubs"));
//
//        this.deck.get(15).setValue(3);
//        this.deck.get(15).setSuit("Three");
//        this.deck.get(15).setRank("Clubs");
//        this.deck.get(15).setCardImage((ImageView) root.lookup("#ThreeOfClubs"));
//
//        this.deck.get(16).setValue(4);
//        this.deck.get(16).setSuit("Four");
//        this.deck.get(16).setRank("Clubs");
//        this.deck.get(16).setCardImage((ImageView) root.lookup("#FourOfClubs"));
//
//        this.deck.get(17).setValue(5);
//        this.deck.get(17).setSuit("Five");
//        this.deck.get(17).setRank("Clubs");
//        this.deck.get(17).setCardImage((ImageView) root.lookup("#FiveOfClubs"));
//
//        this.deck.get(18).setValue(6);
//        this.deck.get(18).setSuit("Six");
//        this.deck.get(18).setRank("Clubs");
//        this.deck.get(18).setCardImage((ImageView) root.lookup("#SixOfClubs"));
//
//        this.deck.get(19).setValue(7);
//        this.deck.get(19).setSuit("Seven");
//        this.deck.get(19).setRank("Clubs");
//        this.deck.get(19).setCardImage((ImageView) root.lookup("#SevenOfClubs"));
//
//        this.deck.get(20).setValue(8);
//        this.deck.get(20).setSuit("Eight");
//        this.deck.get(20).setRank("Clubs");
//        this.deck.get(20).setCardImage((ImageView) root.lookup("#EightOfClubs"));
//
//        this.deck.get(21).setValue(9);
//        this.deck.get(21).setSuit("Nine");
//        this.deck.get(21).setRank("Clubs");
//        this.deck.get(21).setCardImage((ImageView) root.lookup("#NineOfClubs"));
//
//        this.deck.get(22).setValue(10);
//        this.deck.get(22).setSuit("Ten");
//        this.deck.get(22).setRank("Clubs");
//        this.deck.get(22).setCardImage((ImageView) root.lookup("#TenOfClubs"));
//
//        this.deck.get(23).setValue(10);
//        this.deck.get(23).setSuit("Jack");
//        this.deck.get(23).setRank("Clubs");
//        this.deck.get(23).setCardImage((ImageView) root.lookup("#JackOfClubs"));
//
//        this.deck.get(24).setValue(10);
//        this.deck.get(24).setSuit("Queen");
//        this.deck.get(24).setRank("Clubs");
//        this.deck.get(24).setCardImage((ImageView) root.lookup("#QueenOfClubs"));
//
//        this.deck.get(25).setValue(10);
//        this.deck.get(25).setSuit("King");
//        this.deck.get(25).setRank("Clubs");
//        this.deck.get(25).setCardImage((ImageView) root.lookup("#KingOfClubs"));
//
//        this.deck.get(26).setValue(1);
//        this.deck.get(26).setSuit("Ace");
//        this.deck.get(26).setRank("Diamonds");
//        this.deck.get(26).setCardImage((ImageView) root.lookup("#AceOfDiamonds"));
//
//        this.deck.get(27).setValue(2);
//        this.deck.get(27).setSuit("Two");
//        this.deck.get(27).setRank("Diamonds");
//        this.deck.get(27).setCardImage((ImageView) root.lookup("#TwoOfDiamonds"));
//
//        this.deck.get(28).setValue(3);
//        this.deck.get(28).setSuit("Three");
//        this.deck.get(28).setRank("Diamonds");
//        this.deck.get(28).setCardImage((ImageView) root.lookup("#ThreeOfDiamonds"));
//
//        this.deck.get(29).setValue(4);
//        this.deck.get(29).setSuit("Four");
//        this.deck.get(29).setRank("Diamonds");
//        this.deck.get(29).setCardImage((ImageView) root.lookup("#FourOfDiamonds"));
//
//        this.deck.get(30).setValue(5);
//        this.deck.get(30).setSuit("Five");
//        this.deck.get(30).setRank("Diamonds");
//        this.deck.get(30).setCardImage((ImageView) root.lookup("#FiveOfDiamonds"));
//
//        this.deck.get(31).setValue(6);
//        this.deck.get(31).setSuit("Six");
//        this.deck.get(31).setRank("Diamonds");
//        this.deck.get(31).setCardImage((ImageView) root.lookup("#SixOfDiamonds"));
//
//        this.deck.get(32).setValue(7);
//        this.deck.get(32).setSuit("Seven");
//        this.deck.get(32).setRank("Diamonds");
//        this.deck.get(32).setCardImage((ImageView) root.lookup("#SevenOfDiamonds"));
//
//        this.deck.get(33).setValue(8);
//        this.deck.get(33).setSuit("Eight");
//        this.deck.get(33).setRank("Diamonds");
//        this.deck.get(33).setCardImage((ImageView) root.lookup("#EightOfDiamonds"));
//
//        this.deck.get(34).setValue(9);
//        this.deck.get(34).setSuit("Nine");
//        this.deck.get(34).setRank("Diamonds");
//        this.deck.get(34).setCardImage((ImageView) root.lookup("#NineOfDiamonds"));
//
//        this.deck.get(35).setValue(10);
//        this.deck.get(35).setSuit("Ten");
//        this.deck.get(35).setRank("Diamonds");
//        this.deck.get(35).setCardImage((ImageView) root.lookup("#TenOfDiamonds"));
//
//        this.deck.get(36).setValue(10);
//        this.deck.get(36).setSuit("Jack");
//        this.deck.get(36).setRank("Diamonds");
//        this.deck.get(36).setCardImage((ImageView) root.lookup("#JackOfDiamonds"));
//
//        this.deck.get(37).setValue(10);
//        this.deck.get(37).setSuit("Queen");
//        this.deck.get(37).setRank("Diamonds");
//        this.deck.get(37).setCardImage((ImageView) root.lookup("#QueenOfDiamonds"));
//
//        this.deck.get(38).setValue(10);
//        this.deck.get(38).setSuit("King");
//        this.deck.get(38).setRank("Diamonds");
//        this.deck.get(38).setCardImage((ImageView) root.lookup("#KingOfDiamonds"));
//
//        this.deck.get(39).setValue(1);
//        this.deck.get(39).setSuit("Ace");
//        this.deck.get(39).setRank("Spades");
//        this.deck.get(39).setCardImage((ImageView) root.lookup("#AceOfSpades"));
//
//        this.deck.get(40).setValue(2);
//        this.deck.get(40).setSuit("Two");
//        this.deck.get(40).setRank("Spades");
//        this.deck.get(40).setCardImage((ImageView) root.lookup("#TwoOfSpades"));
//
//        this.deck.get(41).setValue(3);
//        this.deck.get(41).setSuit("Three");
//        this.deck.get(41).setRank("Spades");
//        this.deck.get(41).setCardImage((ImageView) root.lookup("#ThreeOfSpades"));
//
//        this.deck.get(42).setValue(4);
//        this.deck.get(42).setSuit("Four");
//        this.deck.get(42).setRank("Spades");
//        this.deck.get(42).setCardImage((ImageView) root.lookup("#FourOfSpades"));
//
//        this.deck.get(43).setValue(5);
//        this.deck.get(43).setSuit("Five");
//        this.deck.get(43).setRank("Spades");
//        this.deck.get(43).setCardImage((ImageView) root.lookup("#FiveOfSpades"));
//
//        this.deck.get(44).setValue(6);
//        this.deck.get(44).setSuit("Six");
//        this.deck.get(44).setRank("Spades");
//        this.deck.get(44).setCardImage((ImageView) root.lookup("#SixOfSpades"));
//
//        this.deck.get(45).setValue(7);
//        this.deck.get(45).setSuit("Seven");
//        this.deck.get(45).setRank("Spades");
//        this.deck.get(45).setCardImage((ImageView) root.lookup("#SevenOfSpades"));
//
//        this.deck.get(46).setValue(8);
//        this.deck.get(46).setSuit("Eight");
//        this.deck.get(46).setRank("Spades");
//        this.deck.get(46).setCardImage((ImageView) root.lookup("#EightOfSpades"));
//
//        this.deck.get(47).setValue(9);
//        this.deck.get(47).setSuit("Nine");
//        this.deck.get(47).setRank("Spades");
//        this.deck.get(47).setCardImage((ImageView) root.lookup("#NineOfSpades"));
//
//        this.deck.get(48).setValue(10);
//        this.deck.get(48).setSuit("Ten");
//        this.deck.get(48).setRank("Spades");
//        this.deck.get(48).setCardImage((ImageView) root.lookup("#TenOfSpades"));
//
//        this.deck.get(49).setValue(10);
//        this.deck.get(49).setSuit("Jack");
//        this.deck.get(49).setRank("Spades");
//        this.deck.get(49).setCardImage((ImageView) root.lookup("#JackOfSpades"));
//
//        this.deck.get(50).setValue(10);
//        this.deck.get(50).setSuit("Queen");
//        this.deck.get(50).setRank("Spades");
//        this.deck.get(50).setCardImage((ImageView) root.lookup("#QueenOfSpades"));
//
//        this.deck.get(51).setValue(10);
//        this.deck.get(51).setSuit("King");
//        this.deck.get(51).setRank("Spades");
//        this.deck.get(51).setCardImage((ImageView) root.lookup("#KingOfSpades"));
//    }

    public void initial() {
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        int[] values = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};


        int cardIndex = 0;
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                Card card = this.deck.get(cardIndex++);
                card.setValue(values[i]);
                card.setSuit(ranks[i]);
                card.setRank(suit);
                card.setCardImage((ImageView) root.lookup("#" + ranks[i] + "Of" + suit));
            }
        }
    }

    public void shuffle() {
        for ( int i = 0 ; i < this.deck.size() ; i++ ) {
            int random = (int)(Math.random()*this.deck.size());
            Card temp = this.deck.get(i);
            this.deck.set(i, this.deck.get(random));
            this.deck.set(random, temp);
        }
    }

    public void reshuffle() {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(100));
        for ( int i = 0 ; i < discard.size() ; i++ ) {
            this.deck.add(discard.get(i));
            tt.setNode(discard.get(i).getCardImage());
            tt.setByX(-1524);
            tt.play();
        }
        discard.clear();
        shuffle();
    }

    public void discardHand(Player p) {
        SequentialTransition st = new SequentialTransition();

        if (p instanceof User) {
            for (int i = 0; i < p.hand.size(); i++) {
                Card c = p.hand.get(i);
                Deck.discard.add(c);
                TranslateTransition tt = new TranslateTransition();
                tt.setDuration(javafx.util.Duration.millis(500));
                tt.setNode(c.getCardImage());
                switch (i) {
                    case 0:
                        tt.setByX(-180);
                        tt.setByY(-713);
                        break;
                    case 1:
                        tt.setByX(-410);
                        tt.setByY(-713);
                        break;
                    case 2:
                        tt.setByX(-640);
                        tt.setByY(-713);
                        break;
                    case 3:
                        tt.setByX(-870);
                        tt.setByY(-713);
                        break;
                    case 4:
                        tt.setByX(-1100);
                        tt.setByY(-713);
                        break;
                }
                st.getChildren().add(tt);
            }
        } else {
            for (int i = 0; i < p.hand.size(); i++) {
                Card c = p.hand.get(i);
                Deck.discard.add(c);
                TranslateTransition tt = new TranslateTransition();
                tt.setDuration(javafx.util.Duration.millis(350));
                tt.setNode(c.getCardImage());
                switch (i) {
                    case 0:
                        tt.setByX(-230);
                        tt.setByY(-43);
                        break;
                    case 1:
                        c.getCardImage().setOpacity(1);
                        SecondCardFlipped.setOpacity(0);
                        SecondCardFlipped.setLayoutX(1644);
                        SecondCardFlipped.setLayoutY(32);
                        tt.setByX(-460);
                        tt.setByY(-43);
                        break;
                    case 2:
                        tt.setByX(-690);
                        tt.setByY(-43);
                        break;
                    case 3:
                        tt.setByX(-920);
                        tt.setByY(-43);
                        break;
                    case 4:
                        tt.setByX(-1150);
                        tt.setByY(-43);
                        break;
                    case 5:
                        tt.setByX(-230);
                        tt.setByY(-43);
                        break;
                }
                st.getChildren().add(tt);
            }
        }
//        st.setOnFinished(event -> {
//            PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
//            pause.setOnFinished(e -> p.hand.clear());
//            pause.play();
//        });
        st.play();
        p.hand.clear();
    }
}