package cpsc219.strategygame;

import cpsc219.strategygame.Controllers.GameController;
import cpsc219.strategygame.Controllers.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    // primary stage
    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        FXMLLoader loader;
        Scene menuScene;
        MenuController menuController;
        Parent root;
        try {
            // load menu
            loader = new FXMLLoader(Game.class.getResource("/cpsc219/strategygame/menu.fxml"));
            root = loader.load();
            menuController = loader.getController();
            menuScene = new Scene(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // pass instance of Game.java into its own controller
        menuController.setGameInstance(this);

        // set menu stage
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    // play game (switch scenes)
    public void setSceneGame() {
        FXMLLoader loader;
        Scene gameScene;
        GameController gameController;
        Parent root;

        // load scene
        try {
            loader = new FXMLLoader(Game.class.getResource("/cpsc219/strategygame/game.fxml"));
            root = loader.load();
            gameController = loader.getController();
            gameScene = new Scene(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // pass instance of Game.java to GameController
        gameController.setGameInstance(this);

        // set stage
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    // quit to menu (switch scene)
    public void setSceneMenu() {
        FXMLLoader loader;
        Scene menuScene;
        MenuController menuController;
        Parent root;

        // load scene
        try {
            loader = new FXMLLoader(Game.class.getResource("/cpsc219/strategygame/menu.fxml"));
            root = loader.load();
            menuController = loader.getController();
            menuScene = new Scene(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // pass instance of Game.java to GameController
        menuController.setGameInstance(this);

        // set stage
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }
}
