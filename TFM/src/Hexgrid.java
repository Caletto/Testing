import java.awt.*;

public class Hexgrid {

	Hexagon[][] grid ;
	int numHexagons = 1;
	private int gridRows = 1;
	private int gridColumns = 1;

	final int DBORDER = 0;
	final int DHEXSIZE = 100;

	public Hexgrid() {

		new Hexgrid(1, 1);
	}

	public Hexgrid(int rows, int columns) {
		int taper = (new Hexagon(0, 0, DHEXSIZE).getTaper());
		int xPos = 0;
		int yPos = 0;
		
		
		gridRows = rows;
		gridColumns = columns;

		grid = new Hexagon[rows][columns];
		
		
		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < columns; j++) {

				
				if (i % 2 == 0) {

					xPos = (DBORDER + DHEXSIZE / 2) + j * (DBORDER + DHEXSIZE);

				} else if (i % 2 == 1) {
					xPos = (DBORDER + DHEXSIZE) + j * (DBORDER + DHEXSIZE);
				}

				yPos = (DBORDER + DHEXSIZE / 2) + i * (DHEXSIZE-55 );
				System.out.println("xPos = " + xPos +" yPos = " + yPos + '\n');
				grid[i][j] = new Hexagon(xPos, yPos, DHEXSIZE);

			}
		}
	}

	public int getGridRows() {

		int i = gridRows;

		return i;

	}

	public int getGridColumns() {

		int i = gridColumns;

		return i;

	}

}