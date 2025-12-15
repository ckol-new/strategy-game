package cpsc219.strategygame.View;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

public class GridView extends StackPane {
    // static fields
    int[] tileSize = new int[]{40, 60}; // width x height

    // fields


    Canvas terrainCanvas;
    Canvas entityCanvas;
    Canvas effectsCanvas;
    GraphicsContext gcTerrain;
    GraphicsContext gcEntity;
    GraphicsContext gcEffects;

    // constructor
    public GridView() {
        this.getChildren().addAll(terrainCanvas, entityCanvas, effectsCanvas);
    }

}
