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
        setSize(size);
        this.name = name;
        this.color = color;
        setText(name);
    }

    public void paintComponent(Graphics g){
        g.setColor(this.color);
        g.fillRect(0,0,getSize().width,getSize().height);
    }
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
