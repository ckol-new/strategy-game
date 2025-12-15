package cpsc219.strategygame.Controllers;

import cpsc219.strategygame.Game;
import cpsc219.strategygame.Model.EntityMap;
import cpsc219.strategygame.Model.TerrainMap;
import cpsc219.strategygame.View.GridView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class GameController {
    // state
    Game gameInstance;
    GridView gridView = new GridView();

    //DEBUG
    TerrainMap tm = new TerrainMap();
    // DEBUG
    EntityMap em = new EntityMap(tm);

    // FXML field
    @FXML
    BorderPane root;
    @FXML
    MenuBar gameMenu;
    @FXML
    MenuItem returnMenuItem;
    @FXML
    MenuItem testTerrainDraw;
    @FXML
    MenuItem testEntityDraw;
    @FXML
    MenuItem testEffectDraw;


    // constructor
    public GameController() {
    }

    // initialize (After field injection)
    @FXML
    public void initialize() {
        setUItext();
        setUIhandlers();
        setGridView();
    }
    // set gridview
    public void setGridView() {
        root.setCenter(gridView);
    }

    // set ui
    public void setUItext() {
        testTerrainDraw.setText("test terrain draw");
        testEntityDraw.setText("test entity draw");
        testEffectDraw.setText("test effect draw");
    }
    public void setUIhandlers() {
        returnMenuItem.setOnAction(evt -> quitToMainMenu());
        testTerrainDraw.setOnAction(evt -> testDrawTerrain());
        testEntityDraw.setOnAction(evt -> testDrawEntity());
    }

    // quit to main menu
    private void quitToMainMenu() {
        gameInstance.setSceneMenu();
    }

    //DEBUG
    // test draw terrain
    private void testDrawTerrain() {
        gridView.drawTerrain(tm);
    }
    //DEBUG
    // test draw entities
    private void testDrawEntity() {
        gridView.drawEntities(em);
    }





    // set instance of game
    public void setGameInstance(Game game) {
        gameInstance = game;
    }
}
