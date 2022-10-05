package sweeper;

import java.util.ArrayList;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoords;

    public static Coord getSize() {
        return size;
    }

    static void setSize(Coord size) {
        Ranges.size = size;
        allCoords = new ArrayList<>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoords.add(new Coord(x, y));
            }
        }
    }

    public static ArrayList<Coord> getAllCoords() {
        return allCoords;
    }
}
