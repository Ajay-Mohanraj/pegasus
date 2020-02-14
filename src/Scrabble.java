import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tiles.Tile;

import java.util.ArrayList;

public class Scrabble extends Application {
    private final char[] alphabet = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
    private int[] amounts = new int[] {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};
    private ArrayList<Tile> tiles = new ArrayList<>();
    private ArrayList<Character> bag = new ArrayList<>();
    private int tilesGiven = 0;

    public void start(Stage stage) {
        updateBag();
        giveTiles();
        Board board = new Board();

        Scene scene = new Scene(board);

        stage.setScene(scene);

        stage.show();
    }

    public void giveTiles(){
        int needed = 7 - tiles.size();
        int bagSize = 100 - tilesGiven;
        for (int i = 0; i < bagSize; i++){
            int tileIndex = 0;
        }
    }

    public void updateBag(){

    }
}

