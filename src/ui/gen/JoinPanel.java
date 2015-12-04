
package ui.gen;

/**
 * @author Görkem Çamlı
 */
public class JoinPanel extends javax.swing.JPanel {


	// Variables declaration
	private javax.swing.JButton connectButton;
	private javax.swing.JLabel enterNameLabel;
	private javax.swing.JTextField enterNameText;
	private javax.swing.JLabel joinLabel;

	/**
	 * Creates new form JoinPanel
	 */
	public JoinPanel() {
		initComponents();
	}


	@SuppressWarnings("unchecked")
	private void initComponents() {

		joinLabel = new javax.swing.JLabel();
		enterNameLabel = new javax.swing.JLabel();
		enterNameText = new javax.swing.JTextField();
		connectButton = new javax.swing.JButton();

		joinLabel.setFont(new java.awt.Font("Tahoma", 0, 36));
		joinLabel.setText("Join Game");

		enterNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
		enterNameLabel.setText("Enter your buddy's username:");

		enterNameText.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enterNameTextActionPerformed(evt);
			}
		});

		connectButton.setText("Connect");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(186, 186, 186)
								.addComponent(joinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addGap(93, 93, 93))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(151, 151, 151)
												.addComponent(enterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGap(137, 137, 137)
												.addComponent(enterNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGap(210, 210, 210)
												.addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(44, 44, 44)
								.addComponent(joinLabel)
								.addGap(36, 36, 36)
								.addComponent(enterNameLabel)
								.addGap(34, 34, 34)
								.addComponent(enterNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(73, 73, 73)
								.addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(113, Short.MAX_VALUE))
		);
	}

	private void enterNameTextActionPerformed(java.awt.event.ActionEvent evt) {

	}


}
