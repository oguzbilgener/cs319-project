
package drawItGUI;

/**
 *
 * @author Görkem Çamlı
 */
public class CreditsPanel extends javax.swing.JPanel {

    // Variables declaration
    private javax.swing.JLabel cemLabel;
    private javax.swing.JLabel gorkemLabel;
    private javax.swing.JLabel hilalLabel;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JLabel oguzLabel;
    private javax.swing.JLabel projectLabel;

    /**
     * Creates new form CreditsPanel
     */


    public CreditsPanel() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    private void initComponents() {

        hilalLabel = new javax.swing.JLabel();
        projectLabel = new javax.swing.JLabel();
        gorkemLabel = new javax.swing.JLabel();
        oguzLabel = new javax.swing.JLabel();
        cemLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();

        hilalLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hilalLabel.setText("Hilal Öztürk");

        projectLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        projectLabel.setText("A CS 319 Project");

        gorkemLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gorkemLabel.setText("Görkem Çamlı");

        oguzLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        oguzLabel.setText("Oğuz Bilgener");

        cemLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cemLabel.setText("Umut Cem Soyulmaz");

        mailLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mailLabel.setText("group4cs319@gmail.com");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(projectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hilalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(oguzLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(gorkemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(85, 85, 85))))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mailLabel)
                    .addComponent(cemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(projectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(gorkemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oguzLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cemLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hilalLabel)
                .addGap(119, 119, 119)
                .addComponent(mailLabel)
                .addGap(56, 56, 56))
        );
    }
   
}
