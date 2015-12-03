package controller;

import ui.GameWindow;
import ui.event.MenuEvent;

import javax.swing.*;

/**
 * @author oguzb
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

		frame.setMenuEventListeners(itemType -> {
			switch(itemType) {
				case host:
					System.out.println("host clicked");
					break;
				case join:
					System.out.println("join clicked");
					break;
				case credits:
					System.out.println("credits clicked");
					break;
				case login:
					System.out.println("login clicked");
					break;
				case logout:
					System.out.println("logout clicked");
			}
		});
	}
}
