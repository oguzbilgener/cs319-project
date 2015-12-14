package ui.play;

import ui.GameStatePanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class StatsPanel extends GameStatePanel {
    public StatsPanel(Dimension size) {
        super(size);
        setLayout(null);

        JLabel title = new JLabel("Stats", SwingConstants.CENTER);
        add(title);
        title.setBounds(0, 20, size.width, 30);
    }
}
