package ui.play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author oguzb
 */
public class ActionToolbar extends JPanel {

    private JButton button1, button2;

    public ActionToolbar(Dimension panelSize, JButton button1, ActionListener listener1, JButton button2, ActionListener listener2){
        System.out.println(panelSize);
        setSize(panelSize);

        this.button1=button1;
        this.button2= button2;

        Color color = Color.decode("#FFFFFF");

        this.button1 = button1;
        this.button2 = button2;

        button1.addActionListener(listener1);
        add(button1);

        button2.addActionListener(listener2);
        add(button2);

    }
}
