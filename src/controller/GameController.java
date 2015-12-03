package controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.GameWindow;
import ui.event.MenuEvent;

import javax.swing.*;

/**
 * @author oguzb
 */
public class GameController {

	private GameWindow window;

	public void createAndShowGUI() {
		//Create and set up the window.
		window = new GameWindow();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setTitle("Draw It!");

		window.getContentPane();
		//Display the window.
		window.pack();
		window.setVisible(true);

		MenuEvent.Listener menuListener = itemType -> {
			switch (itemType) {
				case host:
					showHostScreen();
					break;
				case join:
					showJoinScreen();
					break;
				case credits:
					showCreditsScreen();
					break;
				case login:
					throw new NotImplementedException();
				case logout:
					throw new NotImplementedException();
			}
		};

		window.showMainMenu(menuListener);
	}

	private void showHostScreen() {
		window.showHostPanel();
	}

	private void showJoinScreen() {
		window.showJoinPanel();
	}

	private void showCreditsScreen() {
		window.showCreditsPanel();
	}
}
