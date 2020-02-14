import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tiles.Tile;
import java.util.HashMap;


import java.util.HashMap;

public class Scrabble extends Application {
    HashMap<Character, Integer> bag = new HashMap<>();

    public void start(Stage stage) {
        fillBag();
        Board board = new Board();

        Scene scene = new Scene(board);

        stage.setScene(scene);

        stage.show();
    }



    public void fillBag() {
        bag.put('A', 9);
        bag.put('B', 2);
        bag.put('C', 2);
        bag.put('D', 4);
        bag.put('E', 12);
        bag.put('F', 2);
        bag.put('G', 3);
        bag.put('H', 2);
        bag.put('I', 9);
        bag.put('J', 1);
        bag.put('K', 1);
        bag.put('L', 4);
        bag.put('M', 2);
        bag.put('N', 6);
        bag.put('O', 8);
        bag.put('P', 2);
        bag.put('Q', 1);
        bag.put('R', 6);
        bag.put('S', 4);
        bag.put('T', 6);
        bag.put('U', 4);
        bag.put('V', 2);
        bag.put('W', 2);
        bag.put('X', 1);
        bag.put('Y', 2);
        bag.put('Z', 1);
        bag.put('_', 2);
    }
}

