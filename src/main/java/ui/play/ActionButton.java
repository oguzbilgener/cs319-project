package ui.play;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class ActionButton extends JButton {
    private String name;
    private Color color;

    private ActionButton(Dimension size, String name, Color color){
        setSize(size);
        this.name = name;
        this.color = color;
        setText(name);
    }
    // creating black boxes
    public static ActionButton createCheckButton(Dimension panelSize){
        return new ActionButton(panelSize, "\u2713", Color.decode("#12B348"));
    }
    public static ActionButton createGiveUpButton(Dimension panelSize){
        return new ActionButton(panelSize, "?", Color.decode("#FCCA00"));
    }
    public static ActionButton createCloseButton(Dimension panelSize){
        return new ActionButton(panelSize, "X", Color.decode("#F11717"));
    }
}
