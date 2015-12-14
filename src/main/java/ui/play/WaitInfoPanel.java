package ui.play;

import controller.GameController;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class WaitInfoPanel extends WordPanel {

    public WaitInfoPanel(Dimension size) {
        setSize(size);
        setBackground(Color.WHITE);
        setLayout(null);

        String opponentName = GameController.game().getP2pManager().getOtherPlayer().getUsername();

        JLabel label2 = new JLabel(opponentName+" is guessing...", SwingConstants.CENTER);
        add(label2);
        label2.setBounds(0,40, size.width, 24);
        label2.setFont (label2.getFont ().deriveFont (20.0f));

    }
}
