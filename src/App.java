import controller.GameController;

public class App {

	public static void main(String[] args) {

		GameController controller = new GameController();

		javax.swing.SwingUtilities.invokeLater(() -> controller.createAndShowGUI());

	}

}
