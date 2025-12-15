package cpsc219.strategygame.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class menuController {
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
    public menuController() {}

    // initialize (after FXML field injection via reflection)
    @FXML
    public void initialize() {
        setUItext();
    }

    // set ui
    private void setUItext() {
        titleLabel.setText("GAME TITLE");
        playButton.setText("PLAY");
        optionsButton.setText("OPTIONS");
        quitButton.setText("QUIT");
    }
    private void setUIhandlers() {

    }


}
