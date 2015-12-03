
package ui;

import ui.event.MenuEvent;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Görkem Çamlı
 */
public class GameWindow extends javax.swing.JFrame {

	MainMenuPanel menuPanel;
	CreditsPanel crePan;

	/**
	 * Creates new form GameWindow
	 */
	public GameWindow() {
		initComp();
	}

	private void initComp() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel wrapper;

		wrapper = new JPanel();

		menuPanel = new MainMenuPanel();
		wrapper.add(menuPanel);

		CreditsPanel credPanel = new CreditsPanel();

		JScrollPane scroller = new JScrollPane(wrapper);
		this.getContentPane().add(scroller, BorderLayout.CENTER);

		setVisible(true);
	}

	public void setMenuEventListeners(MenuEvent.Listener listener) {
		menuPanel.setMenuEventListeners(listener);
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 775, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 495, Short.MAX_VALUE)
		);

		pack();
	}

}
