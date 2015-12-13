package ui.play;

import ui.GameStatePanel;
import util.TimerListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asusss on 12.12.2015.
 */
public abstract class WaitPanel extends GameStatePanel implements TimerListener {

    private Canvas canvas;
    protected JLabel timeLabel;
    private int currentTime;
    private WordInfoPanel wordBox;


    public WaitPanel(Dimension size) {
        super(size);

        canvas = initializeCanvas();
        add(canvas);
        canvas.setBounds(16, 16, 360, 360);

        /*DisabledColorPanel disColorPanel = initializeColorPanel(new Dimension(64, 320));
        add(disColorPanel);
        disColorPanel.setBounds(396, 16, disColorPanel.getSize().width, disColorPanel.getSize().height);

        DisabledBrushPanel disBrushPanel = initializeBrushPanel(new Dimension(64, 96));
        add(disBrushPanel);
        disBrushPanel.setBounds(396, 360, disBrushPanel.getSize().width, disBrushPanel.getSize().height);
        */
        //////////////////

        wordBox= new WordInfoPanel(new Dimension(350,100));
        add(wordBox);
        wordBox.setBounds(canvas.getX(),canvas.getY()+canvas.getHeight()+10, wordBox.getWidth(), wordBox.getHeight() );
        //////////////////

        timeLabel= new JLabel();
        add(timeLabel);
        timeLabel.setBounds(canvas.getX(), wordBox.getY()+wordBox.getHeight()+5, 25,25);
        timeLabel.setText("45");

        ActionToolbar toolbar = initializeActionToolbar(new Dimension(100,100));
        add(toolbar);
        toolbar.setBounds(365,470, toolbar.getSize().width, toolbar.getSize().height);
    }

    protected abstract Canvas initializeCanvas();

    protected abstract ColorPanel initializeColorPanel(Dimension size);

    protected abstract BrushPanel initializeBrushPanel(Dimension size);

    protected abstract WordPanel initializeWordPanel(Dimension size);

    protected abstract ActionToolbar initializeActionToolbar(Dimension size);

    @Override
    public void onTimeOut() {

    }

    @Override
    public void onTick(int elapsedTime)
    {

        timeLabel.setText(Integer.toString(elapsedTime));

    }
}
