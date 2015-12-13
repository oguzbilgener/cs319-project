package ui.play;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class ColorSwatch extends JPanel {

	protected Color color;
    protected Color grayscaleColor;
	protected String name;
	private boolean disabled;

	protected ColorSwatch(Dimension size, Color color, String name) {
		this.color = color;
        int gval = (color.getRed() + color.getGreen() + color.getBlue())/3;
        this.grayscaleColor = new Color(gval, gval, gval);
		this.name = name;
		this.disabled = false;
		setSize(size);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	public Color getColor() {
		return color;
	}

    @Override
    public String getName() {
        return name;
    }

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        if(isDisabled()) {
            g.setColor(grayscaleColor);
        }
        else {
            g.setColor(color);
        }
		g.fillRect(0,0,getSize().width,getSize().height);
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
			case 2:
				return new ColorSwatch(size, Color.decode("#C1C1C1"), "Light Gray");
			case 3:
				return new ColorSwatch(size, Color.decode("#6F6F6F"), "Dark Gray");
			case 4:
				return new ColorSwatch(size, Color.decode("#B77D57"), "Brown");
			case 5:
				return new ColorSwatch(size, Color.decode("#8C0010"), "Bordo");
			case 6:
				return new ColorSwatch(size, Color.decode("#FDACC8"), "Pink");
			case 7:
				return new ColorSwatch(size, Color.decode("#F11717"), "Red");
			case 8:
				return new ColorSwatch(size, Color.decode("#FCCA00"), "Light Orange");
			case 9:
				return new ColorSwatch(size, Color.decode("#FF8006"), "Orange");
			case 10:
				return new ColorSwatch(size, Color.decode("#EDE3AD"), "Light Yellow");
			case 11:
				return new ColorSwatch(size, Color.decode("#FEF500"), "Yellow");
			case 12:
				return new ColorSwatch(size, Color.decode("#B6E900"), "Light Green");
			case 13:
				return new ColorSwatch(size, Color.decode("#12B348"), "Green");
			case 14:
				return new ColorSwatch(size, Color.decode("#BFDAE4"), "Light Blue");
			case 15:
				return new ColorSwatch(size, Color.decode("#00A0EC"), "Blue");
			case 16:
				return new ColorSwatch(size, Color.decode("#708FC4"), "Dark Blue");
			case 17:
				return new ColorSwatch(size, Color.decode("#3E41D0"), "Indigo");
			case 18:
				return new ColorSwatch(size, Color.decode("#C7BEEB"), "Lilac");
			case 19:
				return new ColorSwatch(size, Color.decode("#A743A9"), "Purple");
			default:
				return new ColorSwatch(size, Color.decode("#000000"), "");
		}
	}
}
