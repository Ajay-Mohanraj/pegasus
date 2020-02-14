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

        board.getChildren().add(new Text(tile.getLetter()));

        Scene scene = new Scene(board);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

