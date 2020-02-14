import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import tiles.Tile;

public class Board extends GridPane {
	//public GridPane boardPane = new GridPane();
	public Board() {
		setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));
		for (int row = 0; row < 15; row++) {
			for (int column = 0; column < 15; column++) {
				if (row == column) {
					add(new MultWord(2), column, row);
				}
			}
		}

	}
	public void addTile(Tile tile, int x, int y) {
		add(new Text(tile.getLetter()), x, y);
	}
}
