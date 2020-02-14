import javafx.scene.layout.Pane;
import tiles.Tile;

import java.util.ArrayList;

public class PlayerMenu extends Pane {
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public PlayerMenu() {
        ArrayList<Integer> used = new ArrayList<>();

        ArrayList<Tile> tiles = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            int random = (int)(Math.random() * 25);
            while (used.contains(random)) {
                random = (int)(Math.random()*25);
            }
            used.add(random);
            Tile tile = new Tile(alphabet[random]);
            tiles.add(tile);
        }

        for (int i = 1; i <= 7; i++) {
            tiles.get(i - 1).setX(getWidth()/7 * i);
            tiles.get(i - 1).setY(10);
            getChildren().add(tiles.get(i - 1));

        }


    }
}
