package cpsc219.strategygame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader;
        Scene menuScene;
        Parent root;
        try {
            // load menu
            loader = new FXMLLoader(Game.class.getResource("/cpsc219/strategygame/menu.fxml"));
            root = loader.load();
            menuScene = new Scene(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // set menu stage
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }


}
