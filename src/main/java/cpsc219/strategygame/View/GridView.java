package cpsc219.strategygame.View;

import cpsc219.strategygame.Model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class GridView extends StackPane {
    // static fields
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

    // constructor
    public GridView() {
        this.getChildren().addAll(terrainCanvas, entityCanvas, effectsCanvas);
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
