import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import tiles.Tile;

public class Board extends GridPane {
	//public GridPane boardPane = new GridPane();
	public Board() {
		for (int row = 0; row < 15; row++) {
			for (int column = 0; column < 15; column++) {
				this.addTile(new Tile(' '), row, column);
			}
		}
	}
	public void addTile(Tile tile, int x, int y) {
		add(new Text(tile.getLetter()), x, y);
	}
}
