import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tiles.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Scrabble extends Application {
    private final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz_".toCharArray();
    private final int[] AMOUNTS = new int[] {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};
    private ArrayList<Character> bag = new ArrayList<>();
    private ArrayList<Tile> p1tiles = new ArrayList<>();
    private ArrayList<Tile> p2tiles = new ArrayList<>();

    public void start(Stage stage) {
        fillBag();
        giveTiles(p1tiles);
        giveTiles(p2tiles);
        Board board = new Board();
        BorderPane wholeThing = new BorderPane();

        PlayerMenu p1 = new PlayerMenu();
        p1.setPrefHeight(50);
        PlayerMenu p2 = new PlayerMenu();
        p2.setPrefHeight(50);

        wholeThing.setTop(p1);
        wholeThing.setCenter(board);
        wholeThing.setBottom(p2);


        Scene scene = new Scene(wholeThing);

        stage.setScene(scene);

        stage.show();
    }

    public void giveTiles(ArrayList<Tile> tiles){
        int needed = 7 - tiles.size();
        for (int i = 0; i < needed; i++){
            int tileIndex = (int)(Math.random() * bag.size());
            tiles.add(new Tile(bag.get(tileIndex)));
            bag.remove(tileIndex);
        }
    }

    public void fillBag(){
        for (int i = 0; i < ALPHABET.length; i++){
            for (int j = 0; j < AMOUNTS[i]; j++){
                bag.add(ALPHABET[i]);
            }
        }
    }
}

