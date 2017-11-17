import java.awt.*;

public class Hexagon {

	public Polygon hex; // Polygon that will hold the xVertices & yVertices
	private int xCenter = 0; // x position of the center of the hexagon relative to the screen (pixels)
	private int yCenter = 0; // y position of the center of the hexagon relative to the screen (pixels)
	private int hexSize = 20; // size of the hexagon (pixels) top to bottom
	private int taper = 20; // height the corners of the hexagon move towards center

	private int[] xVertices, yVertices; // array of X & Y coordinates specific to the verticies that make up the hexagon

	private final int SIDES = 6; // Number of sides that make up a hexagon

	// Default constructor that will create a Hexagon of size 10 @ (10,10)
	public Hexagon() {

		new Hexagon(10, 10, 10);
	}

	/*********************************************************
	 * Name: Hexagon() Parameters: (xPos,yPos,size) xPos = x-position of the center
	 * point of hexagon yPos = y-position of the center point of hexagon size =
	 * height & width of hexagon Called from: Hexagon() Purpose: Initializes a
	 * Polygon at center location (xPos,yPos) with a width and height of size
	 *********************************************************/
	public Hexagon(int xPos, int yPos, int size) {

		hexSize = size;

		calculateTaper(size);

		setXVertices(xPos, size);
		setYVertices(yPos, size);

		hex = new Polygon(xVertices, yVertices, SIDES);

	}

	/*********************************************************
	 * Name: getHex() Parameters: () Returns: Polygon Purpose: Returns Polygon class
	 * representation of Hexagon for drawing purposes
	 *********************************************************/

	private void calculateTaper(int size) {
		double degrees = 30.0;
		double radians = Math.toRadians(degrees);

		taper = (int) ((size / 2) * (Math.tan(radians)));
		System.out.println("taper= " + taper + '\n');
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

	public int getYCenter() {

		int i = yCenter;

		return i;
	}

	public int getTaper() {

		int i = taper;

		return i;

	}
	public int getHexSize() {
		int i = hexSize;

		return i;
	}

}