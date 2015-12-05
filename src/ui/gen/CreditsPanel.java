
package ui.gen;

/**
 *
 * @author Görkem Çamlı
 */
public class CreditsPanel extends GameStatePanel {

    // Variables declaration 
    private javax.swing.JLabel cemLabel;
    private javax.swing.JLabel gorkemLabel;
    private javax.swing.JLabel hilalLabel;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JLabel oguzLabel;
    private javax.swing.JLabel projectLabel;

    /**
     * Creates new form CreditsPAnel
     */
    public CreditsPanel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        projectLabel = new javax.swing.JLabel();
        gorkemLabel = new javax.swing.JLabel();
        oguzLabel = new javax.swing.JLabel();
        cemLabel = new javax.swing.JLabel();
        hilalLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(480, 576));

        projectLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); 
        projectLabel.setText("A CS 319 Project");

        gorkemLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        gorkemLabel.setText("Görkem Çamlı");

        oguzLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        oguzLabel.setText("Oğuz Bilgener");

        cemLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        cemLabel.setText("Umut Cem Soyulmaz");

        hilalLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        hilalLabel.setText("Hilal Öztürk");

        mailLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        mailLabel.setText("group4cs319@gmail.com");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mailLabel)
                    .addComponent(hilalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gorkemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oguzLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(projectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(gorkemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oguzLabel)
                .addGap(12, 12, 12)
                .addComponent(cemLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hilalLabel)
                .addGap(120, 120, 120)
                .addComponent(mailLabel)
                .addGap(55, 55, 55))
        );
    }

   
}
