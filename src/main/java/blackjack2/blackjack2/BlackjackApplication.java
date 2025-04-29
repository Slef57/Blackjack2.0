package blackjack2.blackjack2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BlackjackApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        HomeController homeController = loader.getController();
        Game game = null;
        homeController.setGame(game);

        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.setFullScreenExitHint("");
        stage.setTitle("Blackjack!");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}