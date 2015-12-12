package ui.play;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by asusss on 12.12.2015.
 */
public class WordInfoPanel extends WordPanel {

    private String word;



    public WordInfoPanel(Dimension size)
        {
            setSize(size);
            setBackground(Color.WHITE);
            setLayout(null);

            word= GameController.game().getSession().getChosenWord();

            JLabel label= new JLabel("you are drawing...");
            add(label);
            label.setBounds(16,16,label.getWidth(),label.getHeight());

            JLabel label2= new JLabel(word);
            add(label2);
            label2.setBounds(50,50,label2.getWidth(),label2.getHeight());
            label2.setFont (label.getFont ().deriveFont (64.0f));



        }



}
