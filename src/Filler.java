import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Filler extends Rectangle {
    public int magnitude;
    private int letterMult;
    private int wordMult;

    public Filler(int amt){
        magnitude = amt;
        setStrokeWidth(.5);
        setStroke(Color.BLACK);
    }

    public Filler(){
        magnitude = 1;
        setStrokeWidth(.5);
        setStroke(Color.BLACK);
    }

    public int getLetterMult() {
        return letterMult;
    }

    public int getWordMult() {
        return wordMult;
    }
}
