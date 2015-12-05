package ui.play;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class ColorSwatch extends JPanel {

	protected Color color;
	protected String name;
	private Dimension size;

	protected ColorSwatch(Dimension size, Color color, String name) {
		this.color = color;
		this.name = name;
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.color);
		g.fillRect(0,0,size.width,size.height);
	}

	/**
	 * Creates a predefined color instance with given index
	 * @param index the color index, currently between 0 and 19.
	 * @return a new ColorSwatch instance with Color and name
	 */
	public static ColorSwatch create(int index, Dimension size) {
		switch (index) {
			case 0:
				return new ColorSwatch(size, Color.decode("#FFFFFF"), "White");
			case 1:
				return new ColorSwatch(size, Color.decode("#000000"), "Black");
			// TODO: Define the rest of the colors
			default:
				return new ColorSwatch(size, Color.decode("#000000"), "");
		}
	}
}
