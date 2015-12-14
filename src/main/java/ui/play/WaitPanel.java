package ui.play;

import java.awt.*;

/**
 * Created by asusss on 12.12.2015.
 */
public class WaitPanel extends PlayPanel {


    public WaitPanel(Dimension size) {
        super(size);

    }

    protected Canvas initializeCanvas() {
        return new ViewingCanvas();
    }

    protected ColorPanel initializeColorPanel(Dimension size) {
        return new DisabledColorPanel(size);
    }

    protected BrushPanel initializeBrushPanel(Dimension size) {
        return new BrushPanel(size);
    }

    protected WordPanel initializeWordPanel(Dimension size) {
        return new WaitInfoPanel(size);
    }

    protected ActionToolbar initializeActionToolbar(Dimension size) {
        ActionButton button1 = ActionButton.createGiveUpButton(new Dimension(size.width/2, size.height));
        ActionButton button2 = ActionButton.createCloseButton(new Dimension(size.width/2, size.height));
        ActionToolbar waitBar = new ActionToolbar(size, button1, null, button2, null);

        return waitBar;
    }
}
