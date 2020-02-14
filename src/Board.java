import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import tiles.Tile;

public class Board extends GridPane {
	//public GridPane boardPane = new GridPane();
	public Board() {

	}
	public void addTile(Tile tile, int x, int y) {
		getChildren().add(new Text(tile.getLetter()));
	}
}
