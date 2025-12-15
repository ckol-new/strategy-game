module cpsc219.strategygame {
    requires javafx.controls;
    requires javafx.fxml;


    opens cpsc219.strategygame to javafx.fxml;
    exports cpsc219.strategygame;

    opens cpsc219.strategygame.Controllers to javafx.fxml;
    exports cpsc219.strategygame.Controllers;
}