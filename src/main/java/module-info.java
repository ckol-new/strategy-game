module cpsc219.strategygame {
    requires javafx.controls;
    requires javafx.fxml;


    opens cpsc219.strategygame to javafx.fxml;
    exports cpsc219.strategygame;

    opens cpsc219.strategygame.Controllers to javafx.fxml;
    exports cpsc219.strategygame.Controllers;

    opens cpsc219.strategygame.View to javafx.fxml;
    exports cpsc219.strategygame.View;

    opens cpsc219.strategygame.Model to javafx.fxml;
    exports cpsc219.strategygame.Model;
}