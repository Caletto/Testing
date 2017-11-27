import java.awt.*;

public class Hexgrid {

	Hexagon[][] grid;
	int numHexagons = 1;
	private int gridRows = 1;
	private int gridColumns = 1;
	private int[][] gridTFMVisibility = new int[][] {

			{ 0, 0, 1, 1, 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 0, 0 } };

	private int border = 2;
	private int hexSize = 40;

	public Hexgrid() {

		new Hexgrid(1, 1);
	}

	public Hexgrid(int rows, int columns) {

		int xPos = 0;
		int yPos = 0;

		int taper = (new Hexagon(xPos, yPos, hexSize).getTaper());

		setGridRows(rows);
		setGridColumns(columns);

		grid = new Hexagon[rows][columns];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < columns; j++) {

				if (i % 2 == 0) {

					xPos = (border + hexSize / 2) + (j * hexSize) + (j * border);

				} else if (i % 2 == 1) {
					xPos = (border + hexSize) + (j * hexSize) + (j * border) + (border / 2);
				}

				yPos = (border + hexSize / 2) + (i * (hexSize / 2 + taper)) + (i * border);
				grid[i][j] = new Hexagon(xPos, yPos, hexSize);

			}
		}

		initGridVisibility();

	}

	public int getGridRows() {

		int i = gridRows;

		return i;

	}

	private void setGridRows(int i) {

		gridRows = i;
	}

	public int getGridColumns() {

		int i = gridColumns;

		return i;

	}

	private void setGridColumns(int j) {

		gridColumns = j;
	}

	// numHexVisible = number of visible hexagons starting from the center of the
	// hex grid row and growing
	// Helper method for initGridVisibility
	private void setRowVisibility(int row, int[] hexVisible) {

		for (int i = 0; i < getGridColumns(); i++) {

			if (hexVisible[i] == 0) {
				grid[row][i].setVisible(false);
			}

		}

	}

	// initializes grid assuming TFM shape
	private void initGridVisibility() {

		for (int i = 0; i < getGridRows(); i++)
			setRowVisibility(i, gridTFMVisibility[i]);
	}

	public void relocateGrid(int xPos, int yPos) {

		int centerRow = gridRows / 2;
		int centerColumn = gridColumns / 2;

		int xDelta = xPos - grid[centerRow][centerColumn].getXCenter();
		int yDelta = yPos - grid[centerRow][centerColumn].getYCenter();

		for (int i = 0; i < gridRows; i++) {

			for (int j = 0; j < gridColumns; j++) {

				grid[i][j].hex.translate(xDelta, yDelta);
			}
		}

	}

	public void changeHexSize(int size) {
		
		hexSize = size;
		
		
		
	}
}