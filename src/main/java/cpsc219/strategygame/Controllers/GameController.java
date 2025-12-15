package cpsc219.strategygame.Controllers;

import cpsc219.strategygame.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    // state
    Game gameInstance;

    // FXML field
    @FXML
    Label testLabel;

    // constructor
    public GameController() {
    }

    // initialize (After field injection)
    @FXML
    public void initialize() {
        setUItext();
    }

    // set ui
    public void setUItext() {
        testLabel.setText("game");
    }

    // set instance of game
    public void setGameInstance(Game game) {
        gameInstance = game;
    }
}
