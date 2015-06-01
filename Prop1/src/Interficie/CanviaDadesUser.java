/*
 * Panell de modidicacio de les dades de l'usuari actual
 */
package Interficie;

import static Interficie.InterficieWiki.macro;
import static Interficie.InterficieWiki.vista;
/**
 *
 * @author cristina.fontanet
 */
public class CanviaDadesUser extends javax.swing.JPanel {

    /**
     * Creates new form CanviaDadesUser
     */
    public CanviaDadesUser() {
        initComponents();
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel29 = new javax.swing.JLabel();
        NovaPassword1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        ButComproba = new javax.swing.JButton();
        ButModifica = new javax.swing.JButton();
        NouUsername1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel29.setText("Username");

        jLabel28.setText("Password");

        ButComproba.setText("Comproba Disponibilitat");
        ButComproba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButComprobaActionPerformed(evt);
            }
        });

        ButModifica.setText("Modifica");
        ButModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButModificaActionPerformed(evt);
            }
        });

        jLabel27.setText("Si us plau, introdueixi les noves dades d'usuari desitjades:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NouUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButComproba))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ButModifica)
                                    .addComponent(NovaPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NouUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(ButComproba))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(NovaPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButModifica)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    /*
    * En clicar el boto de Comprovar Disponibilitat, es comprova si ja existeix algun usuari amb aquest nom.
    */
    private void ButComprobaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButComprobaActionPerformed
        vista.comprovaUsername(NouUsername1.getText());
    }//GEN-LAST:event_ButComprobaActionPerformed
    /*
    * En clicar el boto de Modifica, es guarden els canvis realitzats
    */
    private void ButModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButModificaActionPerformed
        vista.canviaDadesUser(NouUsername1, NovaPassword1);
    }//GEN-LAST:event_ButModificaActionPerformed
    /*
    * Es mostra el nom actual de l'usuari actual
    */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        NouUsername1.setText(macro.getUserActual());
        NovaPassword1.setText("");
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButComproba;
    private javax.swing.JButton ButModifica;
    private javax.swing.JTextField NouUsername1;
    private javax.swing.JTextField NovaPassword1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    // End of variables declaration//GEN-END:variables
}
