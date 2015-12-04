package ui.play;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class ColorSwatch extends JPanel {

	protected Color color;
	protected String name;

	public ColorSwatch(Color color, String name) {
		this.color = color;
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.color);
		// TODO: fill the cell with this color
	}
}
