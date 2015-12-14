package ui.play;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class LetterSlot extends JPanel {

    final static char DEFAULT = '_';
    private char letter;
    private JLabel label;

    public LetterSlot(Dimension size) {
        letter = DEFAULT;
        setSize(size);
        setLayout(null);
        label = new JLabel(Character.toString(letter), SwingConstants.CENTER);
        add(label);
        label.setBounds(0, 4, size.width, 20);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.decode("#777777"));
        g.drawRect(1, 1, getSize().width-1, getSize().height-1);
        super.paintComponent(g);
    }

    public void setLetter(char letter) {
        this.letter = letter;
        label.setText(Character.toString(letter));
        repaint();
    }

    public void clear() {
        letter = DEFAULT;
        label.setText(Character.toString(letter));
    }
}
