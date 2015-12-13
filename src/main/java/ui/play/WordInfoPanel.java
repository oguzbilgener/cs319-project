package ui.play;

import controller.GameController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asusss on 12.12.2015.
 */
public class WordInfoPanel extends WordPanel {

    private String word;



    public WordInfoPanel(Dimension size) {
            setSize(size);
            setBackground(Color.WHITE);
            setLayout(null);

            word= GameController.game().getSession().getChosenWord();

            JLabel label= new JLabel("you are drawing...");
            add(label);
            label.setBounds(16,2,size.width-16,24);

            JLabel label2= new JLabel(word, SwingConstants.CENTER);
            add(label2);
            label2.setBounds(0, 34, size.width, 54);
            label2.setFont (label.getFont().deriveFont(48.0f));



        }



}
