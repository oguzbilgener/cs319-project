package ui.play;


import controller.GameController;

import javax.swing.*;
import java.awt.*;

public class WatchInfoPanel extends WordPanel {

    public WatchInfoPanel(Dimension size) {
        setSize(size);
        setBackground(Color.WHITE);
        setLayout(null);

        String opponentName = GameController.game().getP2pManager().getOtherPlayer().getUsername();

        JLabel label2 = new JLabel(opponentName+" is drawing...");
        add(label2);
        label2.setBounds(50,50, size.width, 24);
        label2.setFont (label2.getFont ().deriveFont (20.0f));

        }

}
