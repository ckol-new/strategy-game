package cpsc219.strategygame.Controllers;

import cpsc219.strategygame.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class GameController {
    // state
    Game gameInstance;

    // FXML field
    @FXML
    Label testLabel;
    @FXML
    MenuBar gameMenu;
    @FXML
    MenuItem returnMenuItem;

    // constructor
    public GameController() {
    }

    // initialize (After field injection)
    @FXML
    public void initialize() {
        setUItext();
        setUIhandlers();
    }

    // set ui
    public void setUItext() {
        testLabel.setText("game");
    }
    public void setUIhandlers() {
        returnMenuItem.setOnAction(evt -> quitToMainMenu());
    }
    // quit to main menu
    private void quitToMainMenu() {
        gameInstance.setSceneMenu();
    }





    // set instance of game
    public void setGameInstance(Game game) {
        gameInstance = game;
    }
}
