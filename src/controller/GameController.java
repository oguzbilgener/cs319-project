package controller;

import ui.GameWindow;

import javax.swing.*;

/**
 * Created by oguzb on 03/12/15.
 */
public class GameController {

	public static void createAndShowGUI() {
		//Create and set up the window.
		GameWindow frame = new GameWindow();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Draw It!");

		frame.getContentPane();
		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}
