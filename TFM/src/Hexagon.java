import java.awt.*;


public class Hexagon {

	public Polygon hex; // Polygon that will hold the xVertices & yVertices
	private int xCenter = 0; // x position of the center of the hexagon relative to the screen (pixels)
	private int yCenter = 0; // y position of the center of the hexagon relative to the screen (pixels)
	private int hexSize = 20; // size of the hexagon (pixels) top to bottom
	private int taper = 20; // height the corners of the hexagon move towards center
	public Color backgroundColor = Color.LIGHT_GRAY;

	private int[] xVertices, yVertices; // array of X & Y coordinates specific to the verticies that make up the hexagon

	private final int SIDES = 6; // Number of sides that make up a hexagon
	private boolean visible = true;

	// Default constructor that will create a Hexagon of size 10 @ (10,10)
	public Hexagon() {

		new Hexagon(10, 10, 10);
	}

	/*********************************************************
	 * Name: Hexagon() Parameters: (xPos,yPos,size) xPos = x-position of the center
	 * point of hexagon yPos = y-position of the center point of hexagon size =
	 * height & width of hexagon Called from: Hexagon() Purpose: Initializes a
	 * Polygon at center location (xPos,yPos) with a width and height of size Notes:
	 * First point is bottom center most point
	 *********************************************************/
	public Hexagon(int xPos, int yPos, int size) {
		// System.out.println("xPos = " + xPos + " yPos = " + yPos +" size = " +size+
		// "\n taper = "+taper);

		hexSize = size;

		calculateTaper(size);

		setXCenter(xPos);
		setYCenter(yPos);

		setXVertices(xPos, size);
		setYVertices(yPos, size);

		hex = new Polygon(xVertices, yVertices, SIDES);

	}

	/*********************************************************
	 * Name: getHex() Parameters: () Returns: Polygon Purpose: Returns Polygon class
	 * representation of Hexagon for drawing purposes
	 *********************************************************/

	private void calculateTaper(int size) {
		double radians = Math.toRadians(30.0);

		double hexBorder = size / 2;
		double side = hexBorder / Math.cos(radians);

		taper = (int) (side * (Math.sin(radians)));

	}

	private void setXVertices(int x, int size) {
		int halfSize = size / 2;

		xVertices = new int[] { x, (x + halfSize), (x + halfSize), x, (x - halfSize), (x - halfSize) };

	}

	private void setYVertices(int y, int size) {

		int halfSize = size / 2;
		yVertices = new int[] { y + halfSize, y + taper, y - taper, y - halfSize, y - taper, y + taper };

	}

	public int getXCenter() {

		int i = xCenter;

		return i;

	}

	private void setXCenter(int x) {

		xCenter = x;
	}

	public int getYCenter() {

		int i = yCenter;

		return i;
	}

	private void setYCenter(int y) {

		yCenter = y;
	}

	public int getTaper() {

		int i = taper;

		return i;

	}

	public int getHexSize() {
		int i = hexSize;

		return i;
	}

	public int[] getXVerticies() {

		int i[] = xVertices;

		return i;
	}

	public int[] getYVerticies() {

		int i[] = yVertices;

		return i;
	}

	public void setVisible(boolean b) {

		visible = b;

	}

	public boolean getVisible() {

		boolean b = visible;

		return b;

	}

}