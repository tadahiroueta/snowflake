import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void drawStar(Graphics g, int x, int y, int lineLength) {
		if (lineLength < 4) return;
		
		for (double radians = 0; radians < Math.PI * 2; radians += Math.PI / 3) {
			int xFinal = x + (int) (Math.cos(radians) * lineLength);
			int yFinal = y + (int) (Math.sin(radians) * lineLength);

			g.drawLine(x, y, xFinal, yFinal);

			drawStar(g, xFinal, yFinal, (int) (lineLength * 0.3));
	}}

	private int getRandomInt(int max) { return (int) (Math.random() * max); }

	private int getRandomByte() { return getRandomInt(256); }

	public void drawBlizzard(Graphics g) {
		g.setColor(new Color(getRandomByte(), getRandomByte(), getRandomByte()));

		int width = getWidth();
		drawStar(g, getRandomInt(width), getRandomInt(getHeight()), getRandomInt(width / 16));
		
		if (Math.random() < Math.pow(0.5, 1.0 / 30)) drawBlizzard(g); 
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		/*
		 * DRAWING CODE BELOW
		 */
		drawBlizzard(g);
	}
}

public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
