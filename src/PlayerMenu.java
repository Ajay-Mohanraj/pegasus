import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import tiles.Tile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerMenu extends Pane {
    private static ArrayList<String> words = new ArrayList<>();
    private String[] word = {""};

    public PlayerMenu(ArrayList<Tile> tiles, Board board) throws FileNotFoundException{
        setWords();
        for (int i = 1; i <= 7; i++) {
            Tile t = tiles.get(i - 1);
            t.setLayoutX(30 * i);
            t.setLayoutY(getHeight()/2);

            t.setOnMouseClicked(e -> {
                board.setOnMouseClicked(a -> {
                    if (!t.isPlaced) {
                        word[0] = word[0] + t.getLetter();
                        board.addTile(t, (int) a.getX(), (int) a.getY());
                    }
                    getScene().setOnKeyPressed(k -> {
                        if (k.getCode().equals(KeyCode.ENTER)){
                            if (words.contains(word[0])){
                                getPoints(word[0].toCharArray());
                            }
                        }
                    });
                });
            });


            getChildren().add(t);
        }
    }

    private int getPoints(char[] word){
        int points = 0;
        for (char c : word){
            points += new Tile(c).getValue();
        }
        System.out.println(points);
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
