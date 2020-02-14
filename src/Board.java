import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import tiles.Tile;

public class Board extends GridPane {
	//public GridPane boardPane = new GridPane();
	public Board() {
		setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));
		//setPadding(new Insets(35,15,75,15));
		setWidth(525);
	    setHeight(525);
		for (int row = 0; row < 15; row++) {
			for (int column = 0; column < 15; column++) {
				Normal m = new Normal();
				m.setFill(Color.SANDYBROWN);
				m.setHeight(getHeight() / 15);
				m.setWidth(getWidth() / 15);
				add(m, column, row);
			}
		}
		for (int row = 0; row < 15; row++) {
			for (int column = 0; column < 15; column++) {
			    if (row == column || row + column == 14) {
                    MultWord m = new MultWord(2);
                    m.setFill(Color.RED);
                    m.setHeight(getHeight() / 15);
                    m.setWidth(getWidth() / 15);
                    add(m, column, row);
                }
				if ((row == 0 || row == 14 || row == 7) && (column == 0 || column == 14 || column == 7) && !(row == 7 && column == 7)){
					MultWord m = new MultWord(2);
					m.setFill(Color.MAROON);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
			    if ((row == 0 || row == 14) && (column == 3 || column == 11)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.LIGHTBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
				if ((column == 0 || column == 14) && (row == 3 || row == 11)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.LIGHTBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
				if (column == 7 && (row == 3 || row == 11)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.LIGHTBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
				if (row == 7 && (column == 3 || column == 11)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.LIGHTBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
				if ((row == 6 || row == 8) && (column == 2 || column == 12 || column == 6 || column == 8)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.LIGHTBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
				if ((column == 6 || column == 8) && (row == 2 || row == 12 || row == 6 || row == 8)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.LIGHTBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
				if ((row == 5 || row == 9 || row == 1 || row == 13) && (column == 5 || column == 9)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.DARKBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
				if ((column == 5 || column == 9 || column == 1 || column == 13) && (row == 5 || row == 9)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.DARKBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
			}
		}

	}
	public void addTile(Tile tile, int x, int y) {
		add(tile, x / 35, y / 35);
		tile.isPlaced = true;
	}
}
