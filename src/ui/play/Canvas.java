package ui.play;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public abstract class Canvas extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.green);
		g.drawLine(50, 50, 150, 150);
	}
}
