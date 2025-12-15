package cpsc219.strategygame.Controllers;

import cpsc219.strategygame.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuController {
    // fields
    Game gameInstance;

    // fxml fields
    @FXML
    VBox menuVBox;
    @FXML
    Label titleLabel;
    @FXML
    Button playButton;
    @FXML
    Button optionsButton;
    @FXML
    Button quitButton;

    // constructor
    public MenuController() {}

    // initialize (after FXML field injection via reflection)
    @FXML
    public void initialize() {
        setUItext();
        setUIhandlers();
}

    // set ui
    private void setUItext() {
        titleLabel.setText("GAME TITLE");
        playButton.setText("PLAY");
        optionsButton.setText("OPTIONS");
        quitButton.setText("QUIT");
    }
    private void setUIhandlers() {
        playButton.setOnAction(evt -> playGame());
        quitButton.setOnAction(evt -> quitGame());
    }

    // play game event handler
    private void playGame() {
        gameInstance.setSceneGame(); // switch scenes to game
    }
    // quit game -> close window
    private void quitGame() {
        gameInstance.closeGame();
    }

    // get instance of game controller
    public void setGameInstance(Game game) {
        gameInstance = game;
    }

}
