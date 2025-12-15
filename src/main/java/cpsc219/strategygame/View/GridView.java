package cpsc219.strategygame.View;

import cpsc219.strategygame.Model.*;
import javafx.animation.PauseTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class GridView extends StackPane {
    // static fields
    static final String selectImageFileName = "select.png";

    int tileWidth = 40;
    int tileHeight = 40;
    int width = 400;
    int height = 400;

    // fields
    Canvas terrainCanvas = new Canvas(width, height);
    Canvas entityCanvas = new Canvas(width, height);
    Canvas effectsCanvas = new Canvas(width, height);
    GraphicsContext gcTerrain = terrainCanvas.getGraphicsContext2D();
    GraphicsContext gcEntity = entityCanvas.getGraphicsContext2D();
    GraphicsContext gcEffects = effectsCanvas.getGraphicsContext2D();

    Pane inputOverlay = new Pane();


    // constructor
    public GridView() {
        setInputOverlay();
        setHandlers();

        this.getChildren().addAll(terrainCanvas, entityCanvas, effectsCanvas, inputOverlay);
    }

    // set input overlay positon
    private void setInputOverlay() {
        // pane does is not by default resizeable, i need to bind it to grid view with/height
        inputOverlay.prefWidthProperty().bind(this.widthProperty());
        inputOverlay.prefHeightProperty().bind(this.heightProperty());
        inputOverlay.setPickOnBounds(true);
        inputOverlay.setMouseTransparent(false);
    }

    // add event handlers to inputOverlay
    private void setHandlers() {
        inputOverlay.setOnMouseClicked(evt -> {
            System.out.println(evt.getSource().getClass());

            int gridPosX = (int) (evt.getX() / tileWidth);
            int gridPosY = (int) (evt.getY() / tileHeight);

            System.out.println(gridPosY + " " + gridPosX);
        });

        /*

        //TODO change how highlights work
        // highlight square (yellow for now)
        inputOverlay.setOnMouseMoved(evt -> {
            int gridPosX = (int) (evt.getX() / tileWidth);
            int gridPosY = (int) (evt.getY() / tileHeight);

            Image selectImg = new Image(GridView.class.getResourceAsStream("/cpsc219/strategygame/textures/select.png"));
            gcEffects.drawImage(selectImg, gridPosX * tileWidth, gridPosY * tileHeight, tileWidth, tileHeight);

            PauseTransition p = new PauseTransition(Duration.millis(500));
            p.setOnFinished(evt2 -> {
                gcEffects.clearRect(gridPosX * tileWidth, gridPosY * tileHeight, tileWidth, tileHeight);
            });
            p.play();
        });

         */
    }

    // draw terrain map
    public void drawTerrain(TerrainMap terrainMap) {
        // clear first
        gcTerrain.clearRect(0, 0, width, height);

        Tile[][] terrainMatrix = terrainMap.getTerrainMatrix();
        int[] mapSize = terrainMap.getMapSize();

        for (int y = 0; y < mapSize[0]; y++) {
            for (int x = 0; x < mapSize[1]; x++) {
                // get tile
                Tile tile = terrainMatrix[y][x];

                // get img
                Image tileImg = new Image(GridView.class.getResourceAsStream("/cpsc219/strategygame/textures/" + tile.getTextureName()));

                // draw image
                gcTerrain.drawImage(tileImg, x * tileWidth, y * tileHeight, tileWidth, tileHeight);

            }
        }
    }

    // draw entity map
    public void drawEntities(EntityMap entityMap) {
        // clear first
        gcEntity.clearRect(0, 0, width, height);

        int[] mapSize = entityMap.getMapSize();

        for (int y = 0; y < mapSize[0]; y++) {
            for (int x = 0; x < mapSize[1]; x++) {
                Entity entity = entityMap.getEntityAtPos(y, x);

                // null check and IMPASSABLE
                if ((entity == null) || (entity instanceof IMPASSABLE)) {
                    continue;
                }

                // get image
                Image entityTexture = new Image(GridView.class.getResourceAsStream("/cpsc219/strategygame/textures/" + entity.getTextureName()));

                // draw image
                gcEntity.drawImage(entityTexture, x * tileWidth, y * tileHeight, tileWidth, tileHeight);
            }
        }

    }
}
