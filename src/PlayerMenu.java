import javafx.scene.layout.Pane;
import tiles.Tile;

import java.util.ArrayList;

public class PlayerMenu extends Pane {
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public PlayerMenu(ArrayList<Tile> tiles) {
        for (int i = 1; i <= 7; i++) {
            Tile t = tiles.get(i - 1);
            t.setLayoutX(30 * i);
            t.setLayoutY(getHeight()/2);

            t.setOnMouseClicked(e -> {

            });

            getChildren().add(t);


        }


    }
}
