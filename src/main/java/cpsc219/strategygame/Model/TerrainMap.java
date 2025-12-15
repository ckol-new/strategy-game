package cpsc219.strategygame.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TerrainMap {
    // fields
    Tile[][] terrainMatrix;
    int[] mapSize=

    // constructor
    public TerrainMap() {
        // generate map
        String mapName = "map1.txt";

        terrainMatrix = convertToTerrainMatrix(mapName);
    }

    // convert map file to terrain matrix
    // set class field of mapSize to its size
    private Tile[][] convertToTerrainMatrix(String mapName) {
        Path mapPath;
        List<String> mapList;

        try {
            // get path
            mapPath = Paths.get(TerrainMap.class.getResourceAsStream("/cpsc219/strategygame/maps/" + mapName).toString());

            // get list
            mapList = Files.readAllLines(mapPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // first line of map list is size (and clear first line)
        findMapSize(mapList);
        // DEBUG
        System.out.println(Arrays.toString(mapSize));
        mapList.removeFirst();

        Tile[][] matrix = new Tile[mapSize[0]][mapSize[1]];

        // for each line -> convert to proper tile
        for (String line : mapList) {
            // split into string array
            String[] strArr = line.strip().split("");



        }
    }

    // get map size (first line of mapList)
    private void findMapSize(List<String> mapList) {
        String size = mapList.getFirst();
        String[] strSize = size.strip().split(" ");
        int[] intSize = new int[]{Integer.parseInt(strSize[0]), Integer.parseInt(strSize[1])};
        mapSize = intSize;
    }

}
