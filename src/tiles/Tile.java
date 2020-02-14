package tiles;

public class Tile {
    private char letter;
    private int value;

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
    }

    public char getLetter() {
        return letter;
    }

    public int getValue() {
        return value;
    }
}
