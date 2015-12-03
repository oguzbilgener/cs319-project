import controller.GameController;
import ui.GameWindow;

public class App {

	public static void main(String[] args) {

		GameController controller = new GameController();

		javax.swing.SwingUtilities.invokeLater(() -> controller.createAndShowGUI());

	}


}
