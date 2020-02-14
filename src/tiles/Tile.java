package tiles;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
    private char letter;
    private int value;
    public boolean isPlaced = false;

    public Tile(char letter) {
        this.letter = letter;
        if (letter == 'D' || letter == 'G'){
            value = 2;
        }
        else if (letter == 'B' || letter == 'C' || letter == 'M' || letter == 'P'){
            value = 3;
        }
        else if (letter == 'F' || letter == 'H' || letter == 'V' || letter == 'W' || letter == 'Y'){
            value = 4;
        }
        else if (letter == 'K'){
            value = 5;
        }
        else if (letter == 'J' || letter == 'X'){
            value = 8;
        }
        else if (letter == 'Q' || letter == 'Z'){
            value = 10;
        }
        else if (letter == '_'){
            value = 0;
        }
        else {
            value = 1;
        }

        Rectangle r = new Rectangle();
        r.setHeight(30);
        r.setWidth(30);
        r.setArcHeight(10);
        r.setArcWidth(10);
        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);

        Text t = new Text("" + letter);
        t.setFont(Font.font("Calibri", 25));

        this.getChildren().addAll(r, t);
    }

    public String getLetter() {
        return Character.toString(letter);
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return getLetter();
    }
}
