import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tiles.Tile;

public class Scrabble extends Application {
    public void start(Stage stage) {
        Board board = new Board();

        Tile tile = new Tile('A');

        board.addTile(tile, 8, 8);

        Scene scene = new Scene(board);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

