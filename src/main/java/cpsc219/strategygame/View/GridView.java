package cpsc219.strategygame.View;

import cpsc219.strategygame.Model.TerrainMap;
import cpsc219.strategygame.Model.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GridView extends StackPane {
    // static fields
    int width = 40;
    int height = 40;

    // fields
    Canvas terrainCanvas = new Canvas(400, 400);
    Canvas entityCanvas = new Canvas(400, 400);
    Canvas effectsCanvas = new Canvas(400, 400);
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
        gcTerrain.clearRect(0, 0, 2000, 2000);

        Tile[][] terrainMatrix = terrainMap.getTerrainMatrix();
        int[] mapSize = terrainMap.getMapSize();

        for (int y = 0; y < mapSize[0]; y++) {
            for (int x = 0; x < mapSize[1]; x++) {
                // get tile
                Tile tile = terrainMatrix[y][x];

                // get img
                Image tileImg = new Image(GridView.class.getResourceAsStream("/cpsc219/strategygame/textures/" + tile.getTextureName()));

                // draw image
                gcTerrain.drawImage(tileImg, x * width, y * height, width, height);

            }
        }
    }
}
