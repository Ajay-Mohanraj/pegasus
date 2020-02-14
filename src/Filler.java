import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Filler extends Rectangle {
    public int magnitude;

    public Filler(int amt){
        magnitude = amt;
        setStroke(Color.BLACK);
    }

    public Filler(){
        magnitude = 1;
        setStroke(Color.BLACK);
    }
}
