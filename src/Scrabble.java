import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Scrabble extends Application {
    private final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    private final int[] AMOUNTS = new int[] {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 2, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 3, 2, 1, 2, 1};
    private ArrayList<Character> bag = new ArrayList<>();
    private ArrayList<Tile> p1tiles = new ArrayList<>();
    private ArrayList<Tile> p2tiles = new ArrayList<>();
    private PlayerMenu pm;
    private Board board;
    public ArrayList<Integer> pts1 = new ArrayList<>();
    public ArrayList<Integer> pts2 = new ArrayList<>();
    public BorderPane wholeThing;

    public void start(Stage stage) throws FileNotFoundException {
        fillBag();
        giveTiles(p1tiles);
        giveTiles(p2tiles);
        board = new Board();
        wholeThing = new BorderPane();

        pm = new PlayerMenu();
        pm.setPrefHeight(50);
        wholeThing.setCenter(board);
        wholeThing.setBottom(pm);

        Scene scene = new Scene(wholeThing);

        stage.setScene(scene);

        stage.show();

        play();
    }

    public void play(){
        pm.doTurn(p1tiles, board, pts1, wholeThing);

        //TODO: wait until doTurn returns >= 1

        giveTiles(p1tiles);
        System.out.println(p1tiles);

        pm.doTurn(p2tiles, board, pts2, wholeThing);

        //TODO: same as above

        giveTiles(p2tiles);
        System.out.println(pts2);

        if (bag.isEmpty()){
            String winner = pts1.get(0) > pts2.get(0) ? "player !1" : "player 2!";
            if (pts1 != pts2) {
                System.out.println("The winner is " + winner);
            }
            else{
                System.out.println("It's a tie!");
            }
            return;
        }
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

