import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SierpinskiPanel extends JPanel {
    private final int SIZE = 400;
    
    public SierpinskiPanel() {
		super.setPreferredSize(new Dimension(SIZE, SIZE));
		super.setBackground(Color.WHITE);
	}

    public void draw(Graphics g, int x, int y, int length) {
        if (length == 0) return;

        g.drawLine(x, y, x, y - length);
        g.drawLine(x, y, x - length, y);
        g.drawLine(x - length, y, x, y - length);

        final int halfLength = length / 2;

        draw(g, x + halfLength, y - halfLength, halfLength);
        draw(g, x - halfLength, y - halfLength, halfLength);
        draw(g, x - halfLength, y + halfLength, halfLength);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        
        final int halfSize = SIZE / 2; 
        draw(g, halfSize, halfSize, halfSize);
}}

public class Sierpinski {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SierpinskiPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
