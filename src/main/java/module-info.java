module blackjack2.blackjack2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens blackjack2.blackjack2 to javafx.fxml;
    exports blackjack2.blackjack2;
}