import ui.MainFrame;

public class App {
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());

	}

	private static void createAndShowGUI() {
		//Create and set up the window.
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		frame.setTitle("Draw It!");

		frame.getContentPane();
		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}
