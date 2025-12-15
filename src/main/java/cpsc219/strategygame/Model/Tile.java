package cpsc219.strategygame.Model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public enum Tile {
    STONE_FLOOR(true, 2, "stone_floor.png"),
    STONE_WALL(false, 0, "stone_wall.png");

    // fields
    final boolean IS_WALKABLE;
    final int MOVEMENT_TYPE;
    static final int NORMAL_MOVEMENT = 2;
    static final int SLOW_MOVEMENT = 1;
    static final int NO_MOVEMENT = 0;
    Path texturePath;

    private Tile(boolean isWalkable, int movementType, String textureName) {
        IS_WALKABLE = isWalkable;
        MOVEMENT_TYPE = movementType;
        texturePath = convertToPath(textureName);
    }

    // convert texture name to path
    private Path convertToPath(String textureName) {
        Path path;
        // convert to path
        path = Paths.get(Tile.class.getResourceAsStream("/cpsc219/strategygame/textures/" + textureName).toString());

        return path;
    }


    // getters
    public Path getTexturePath() { return texturePath; }
    public int getMovementType() { return MOVEMENT_TYPE; }
    public boolean isWalkable() { return IS_WALKABLE; }
}
