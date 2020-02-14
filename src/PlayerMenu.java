import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import tiles.Tile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PlayerMenu extends Pane {
    private static ArrayList<String> words = new ArrayList<>();
    private String[] word = {""};
    private ArrayList<Tile> tileList = new ArrayList<>();

    public PlayerMenu() throws FileNotFoundException{
        setWords();
    }

    public int doTurn(ArrayList<Tile> tiles, Board board) {
        int[] points = {0};
        drawTiles(tiles);
        for (Tile t : tiles) {

            t.requestFocus();
            t.setOnMouseClicked(e -> {
                board.setOnMouseClicked(a -> {
                    if (!t.isPlaced) {
                        if (tileList.size() == 1){
                            if ((int)a.getX() / 35 == (int)tileList.get(tileList.size() - 1).getLayoutX() / 35 && (int)a.getY() / 35 > (int)tileList.get(tileList.size() - 1).getLayoutY() / 35){
                                board.addTile(t, (int)tileList.get(tileList.size() - 1).getLayoutX(), (int)tileList.get(tileList.size() - 1).getLayoutY() + 35);
                                tileList.add(t);
                            }
                            else if ((int)a.getX() / 35 == (int)tileList.get(tileList.size() - 1).getLayoutX() / 35 && (int)a.getY() / 35 < (int)tileList.get(0).getLayoutY() / 35){
                                board.addTile(t, (int)tileList.get(tileList.size() - 1).getLayoutX(), (int)tileList.get(0).getLayoutY() - 35);
                                tileList.add(t);
                            }
                            else if ((int)a.getY() / 35 == (int)tileList.get(tileList.size() - 1).getLayoutY() / 35 && (int)a.getX() / 35 > (int)tileList.get(tileList.size() - 1).getLayoutX() / 35) {
                                board.addTile(t, (int)tileList.get(tileList.size() - 1).getLayoutX() + 35, (int)tileList.get(tileList.size() - 1).getLayoutY());
                                tileList.add(t);
                            }
                            else if ((int)a.getY() / 35 == (int)tileList.get(tileList.size() - 1).getLayoutY() / 35 && (int)a.getX() / 35 < (int)tileList.get(0).getLayoutX() / 35) {
                                board.addTile(t, (int)tileList.get(0).getLayoutX() - 35, (int)tileList.get(tileList.size() - 1).getLayoutY());
                                tileList.add(t);
                            }
                            Collections.sort(tileList);
                        }
                        else if (tileList.size() > 1) {
                            if ((int)tileList.get(tileList.size() - 1).getLayoutX() / 35 == (int)tileList.get(tileList.size() - 2).getLayoutX() / 35 && (int)a.getY() / 35 < (int)tileList.get(0).getLayoutY() / 35){
                                board.addTile(t, (int)tileList.get(tileList.size() - 1).getLayoutX(), (int)tileList.get(0).getLayoutY() - 35);
                                tileList.add(t);
                            }
                            else if ((int)tileList.get(tileList.size() - 1).getLayoutX() / 35 == (int)tileList.get(tileList.size() - 2).getLayoutX() / 35 && (int)a.getY() / 35 > (int)tileList.get(tileList.size() - 1).getLayoutY() / 35) {
                                board.addTile(t, (int)tileList.get(tileList.size() - 1).getLayoutX(), (int)tileList.get(tileList.size() - 1).getLayoutY() + 35);
                                tileList.add(t);
                            }
                            else if ((int)tileList.get(tileList.size() - 1).getLayoutY() / 35 == (int)tileList.get(tileList.size() - 2).getLayoutY() / 35 && (int)a.getX() / 35 < (int)tileList.get(0).getLayoutX() / 35){
                                board.addTile(t, (int)tileList.get(0).getLayoutX() - 35, (int)tileList.get(tileList.size() - 1).getLayoutY());
                                tileList.add(t);
                            }
                            else if ((int)tileList.get(tileList.size() - 1).getLayoutY() / 35 == (int)tileList.get(tileList.size() - 2).getLayoutY() / 35 && (int)a.getX() / 35 > (int)tileList.get(tileList.size() - 1).getLayoutX() / 35){
                                board.addTile(t, (int)tileList.get(tileList.size() - 1).getLayoutX() + 35, (int)tileList.get(tileList.size() - 1).getLayoutY());
                                tileList.add(t);
                            }
                            Collections.sort(tileList);
                        }
                        else {
                            board.addTile(t, (int) a.getX(), (int) a.getY());
                            tileList.add(t);
                            Collections.sort(tileList);
                        }
                        Collections.sort(tileList);
                    }
                    getScene().setOnKeyPressed(k -> {
                        for (Tile o : tileList){
                            word[0] += o.getLetter();
                        }
                        if (k.getCode().equals(KeyCode.ENTER)){
                            System.out.println(Arrays.toString(word));
                            if (words.contains(word[0])){
                                points[0] = getPoints(word[0].toCharArray());
                            }
                            else {
                                returnTiles(tiles);
                            }
                        }
                    });
                });
            });
        }
        return points[0];
    }

    public void returnTiles(ArrayList<Tile> tiles){
        for (Tile t : tiles){
            t.setLayoutX(t.originalX);
            t.setLayoutY(t.originalY);
        }
    }

    public void drawTiles(ArrayList<Tile> tiles) throws IllegalArgumentException{
        for (int i = 1; i <= 7; i++) {
            Tile t = tiles.get(i - 1);
            t.setLayoutX(30 * i);
            t.setLayoutY(getHeight()/2);
            t.saveCoords();
            getChildren().add(t);
        }
    }

    private int getPoints(char[] word){
        int points = 0;
        for (char c : word){
            points += new Tile(c).getValue();
        }
        return points;
    }

    private static void setWords() throws FileNotFoundException {
        Scanner file = new Scanner(new FileReader("data/text_large"));
        while(file.hasNextLine()){
            String word = file.nextLine();
            if(word.length() == 0 || word.charAt(0) == '#') //skip blank lines or starting with #, treating them as comments
                continue;
            words.add(word);
        }
        file.close();
    }
}
