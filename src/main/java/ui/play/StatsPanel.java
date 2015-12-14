package ui.play;

import controller.GameController;
import model.Player;
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

        Player ownPlayer = GameController.game().getP2pManager().getOwnPlayer();
        Player otherPlayer = GameController.game().getP2pManager().getOtherPlayer();

        JLabel title = new JLabel("Stats", SwingConstants.CENTER);
        add(title);
        title.setBounds(0, 20, size.width, 30);

        JLabel you = new JLabel("You: "+ownPlayer.getScore(), SwingConstants.CENTER);
        add(you);
        you.setBounds(0, 50, size.width, 30);

        JLabel other = new JLabel(otherPlayer.getUsername()+": "+otherPlayer.getScore(), SwingConstants.CENTER);
        add(other);
        other.setBounds(0, 80, size.width, 30);
    }
}
