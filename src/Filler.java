import javafx.scene.shape.Rectangle;

public class Filler extends Rectangle {
    public int magnitude;

    public Filler(int amt){
        magnitude = amt;
    }

    public Filler(){
        magnitude = 1;
    }
}
