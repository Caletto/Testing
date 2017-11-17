import javax.swing.*;

import java.awt.*;
import java.util.Enumeration;

public class MainGame {
	private MainGame() {
		
	
		createFrame();
	}

	public static void main(String[] args) {
		// createFrame();
		// add hexagons to frame

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainGame();
			}
		});

	}

	// Creates the Window
	private void createFrame() {
		DrawingPanel panel = new DrawingPanel();
		JFrame mainWindow = new JFrame("Terraforming Mars");
		Container content = mainWindow.getContentPane();
		content.add(panel);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();

		mainWindow.setSize(dim);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.add(new DrawingPanel());

		mainWindow.setVisible(true);

	}

	class DrawingPanel extends JPanel {

		public DrawingPanel() {

		}

		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			super.paintComponent(g2);
			Toolkit tk = Toolkit.getDefaultToolkit();

			Hexgrid test = new Hexgrid(10, 10);

			
			
			for (int i = 0; i < test.getGridRows(); i++) {

				for (int j = 0; j < test.getGridColumns(); j++) {
					
				g2.drawPolygon(test.grid[i][j].hex);

				}
			}

		}
	}
}