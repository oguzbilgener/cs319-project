
package ui.play;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by asusss on 12.12.2015.
 */

public class LetterListener implements MouseListener {

    private int index;
    public LetterListener(int index)
    {
        this.setIndex(index);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("letter list classı içinde!");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

