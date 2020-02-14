import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlayerMenu extends Pane {
    private static ArrayList<String> words = new ArrayList<>();
    private String[] word = {""};
    private ArrayList<Tile> tileList = new ArrayList<>();

    public PlayerMenu() throws FileNotFoundException{
        setWords();
    }

    public void doTurn(ArrayList<Tile> tiles, Board board, ArrayList<Integer> points, BorderPane bp) {
        points.add(0);
        drawTiles(tiles);
        for (Tile t : tiles) {
            t.requestFocus();
            t.setOnMouseClicked(e -> {
                board.setOnMouseClicked(a -> {
                    if (!t.isPlaced) {
                        if (tileList.size() == 1) {
                            if ((int) a.getX() / 35 == (int) tileList.get(tileList.size() - 1).getLayoutX() / 35 && (int) a.getY() / 35 > (int) tileList.get(tileList.size() - 1).getLayoutY() / 35) {
                                board.addTile(t, (int) tileList.get(tileList.size() - 1).getLayoutX(), (int) tileList.get(tileList.size() - 1).getLayoutY() + 35);
                                tileList.add(t);
                            } else if ((int) a.getX() / 35 == (int) tileList.get(tileList.size() - 1).getLayoutX() / 35 && (int) a.getY() / 35 < (int) tileList.get(0).getLayoutY() / 35) {
                                board.addTile(t, (int) tileList.get(tileList.size() - 1).getLayoutX(), (int) tileList.get(0).getLayoutY() - 35);
                                tileList.add(t);
                            } else if ((int) a.getY() / 35 == (int) tileList.get(tileList.size() - 1).getLayoutY() / 35 && (int) a.getX() / 35 > (int) tileList.get(tileList.size() - 1).getLayoutX() / 35) {
                                board.addTile(t, (int) tileList.get(tileList.size() - 1).getLayoutX() + 35, (int) tileList.get(tileList.size() - 1).getLayoutY());
                                tileList.add(t);
                            } else if ((int) a.getY() / 35 == (int) tileList.get(tileList.size() - 1).getLayoutY() / 35 && (int) a.getX() / 35 < (int) tileList.get(0).getLayoutX() / 35) {
                                board.addTile(t, (int) tileList.get(0).getLayoutX() - 35, (int) tileList.get(tileList.size() - 1).getLayoutY());
                                tileList.add(t);
                            }
                            Collections.sort(tileList);
                        } else if (tileList.size() > 1) {
                            if ((int) tileList.get(tileList.size() - 1).getLayoutX() / 35 == (int) tileList.get(tileList.size() - 2).getLayoutX() / 35 && (int) a.getY() / 35 < (int) tileList.get(0).getLayoutY() / 35) {
                                board.addTile(t, (int) tileList.get(tileList.size() - 1).getLayoutX(), (int) tileList.get(0).getLayoutY() - 35);
                                tileList.add(t);
                            } else if ((int) tileList.get(tileList.size() - 1).getLayoutX() / 35 == (int) tileList.get(tileList.size() - 2).getLayoutX() / 35 && (int) a.getY() / 35 > (int) tileList.get(tileList.size() - 1).getLayoutY() / 35) {
                                board.addTile(t, (int) tileList.get(tileList.size() - 1).getLayoutX(), (int) tileList.get(tileList.size() - 1).getLayoutY() + 35);
                                tileList.add(t);
                            } else if ((int) tileList.get(tileList.size() - 1).getLayoutY() / 35 == (int) tileList.get(tileList.size() - 2).getLayoutY() / 35 && (int) a.getX() / 35 < (int) tileList.get(0).getLayoutX() / 35) {
                                board.addTile(t, (int) tileList.get(0).getLayoutX() - 35, (int) tileList.get(tileList.size() - 1).getLayoutY());
                                tileList.add(t);
                            } else if ((int) tileList.get(tileList.size() - 1).getLayoutY() / 35 == (int) tileList.get(tileList.size() - 2).getLayoutY() / 35 && (int) a.getX() / 35 > (int) tileList.get(tileList.size() - 1).getLayoutX() / 35) {
                                board.addTile(t, (int) tileList.get(tileList.size() - 1).getLayoutX() + 35, (int) tileList.get(tileList.size() - 1).getLayoutY());
                                tileList.add(t);
                            }
                            Collections.sort(tileList);
                        } else {
                            board.addTile(t, (int) a.getX(), (int) a.getY());
                            tileList.add(t);
                            Collections.sort(tileList);
                        }
                        Collections.sort(tileList);
                    }
                    getScene().setOnKeyPressed(k -> {
                        int i = 0;
                        Filler[] multipliers = new Filler[tileList.size()];
                        for (Tile o : tileList) {
                            word[0] += o.getLetter();
                            multipliers[i++] = o.getMultiplier();
                        }
                        if (k.getCode().equals(KeyCode.ENTER)) {
                            if (words.contains(word[0])) {
                                points.set(0, points.get(0) + getPoints(word[0].toCharArray(), multipliers));
                            } else {
                                returnTiles(tiles, bp);
                            }
                        } else if (k.getCode().equals(KeyCode.BACK_SPACE)) {
                            returnTiles(tiles, bp);
                        }
                    });
                });
            });
        }
    }

    public void returnTiles(ArrayList<Tile> tiles, BorderPane bp){
        for (int i = 1; i <= 7; i++){
            Tile t = tiles.get(i - 1);
            t.multplier = new Normal();
            t.isPlaced = false;
            bp.getChildren().add(t);
            t.setLayoutX(30 * i);
            t.setLayoutY(getHeight() * 5/6);
        }
    }

    public void drawTiles(ArrayList<Tile> tiles) throws IllegalArgumentException{
        for (int i = 1; i <= 7; i++) {
            Tile t = tiles.get(i - 1);
            t.setLayoutX(30 * i);
            t.setLayoutY(getHeight()/2 - 15);
            t.saveCoords();
            getChildren().add(t);
        }
    }

    private int getPoints(char[] word, Filler[] mults){
        int points = 0;
        int wordTimes = 1;
        for (int i = 0; i < word.length; i++){
            points += new Tile(word[i]).getValue() * mults[i].getLetterMult();
            wordTimes *= mults[i].getWordMult();
        }
        System.out.println(points * wordTimes);
        return points * wordTimes;
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
