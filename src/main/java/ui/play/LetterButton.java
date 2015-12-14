package ui.play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author oguzb
 */
public class LetterButton extends JPanel implements MouseListener {

    private char letter;
    private int index;
    private JLabel label;
    private LetterButtonClickListener listener;
    private boolean enabled = true;

    public LetterButton(Dimension size, char letter, int index) {
        setSize(size);
        this.letter = letter;
        this.index = index;
        setLayout(null);
        label = new JLabel(Character.toString(letter), SwingConstants.CENTER);
        add(label);
        label.setBounds(0, 4, size.width, 20);
        setBackground(Color.decode("#CCCCCC"));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(this);
    }

    public void disableButton() {
        enabled = false;
        setBackground(Color.decode("#777777"));
        label.setForeground(Color.decode("#444444"));
    }

    public void enableButton() {
        enabled = true;
        setBackground(Color.decode("#CCCCCC"));
        label.setForeground(Color.black);
    }

    public void setListener(LetterButtonClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(enabled) {
            if (listener != null) {
                listener.onLetterButtonClick(letter, index);
            }
            setBackground(Color.decode("#AAAAAA"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(enabled) {
            setBackground(Color.decode("#CCCCCC"));
        }
        else {
            setBackground(Color.decode("#777777"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(enabled) {
            setBackground(Color.decode("#DDDDDD"));
        }
        else {
            setBackground(Color.decode("#777777"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(enabled) {
            setBackground(Color.decode("#CCCCCC"));
        }
        else {
            setBackground(Color.decode("#777777"));
        }
    }

    public interface LetterButtonClickListener {
        void onLetterButtonClick(char letter, int index);
        void onClear();
    }
}
