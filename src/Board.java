import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import tiles.Tile;

public class Board extends GridPane {
	//public GridPane boardPane = new GridPane();
	public Board() {
		setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));
		setWidth(600);
	    setHeight(600);
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
				else if ((row == 0 || row == 14) && (column == 0 || column == 14)){
					MultWord m = new MultWord(2);
					m.setFill(Color.LIGHTBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
			    else if ((row == 0 || row == 14) && (column == 3 || column == 11)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.LIGHTBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
				else if ((column == 0 || column == 14) && (row == 3 || row == 11)){
					MultLetter m = new MultLetter(2);
					m.setFill(Color.LIGHTBLUE);
					m.setHeight(getHeight() / 15);
					m.setWidth(getWidth() / 15);
					add(m, column, row);
				}
			}
		}

	}
	public void addTile(Tile tile, int x, int y) {
		add(new Text(tile.getLetter()), x, y);
	}
}
