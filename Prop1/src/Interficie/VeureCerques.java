/*
 * Panell que mostra els noms de les cerques guardades per l'usuari
 */
package Interficie;

import static Interficie.InterficieWiki.macro;
import static Interficie.InterficieWiki.capsalera;
import static Interficie.InterficieWiki.vista;
import static Interficie.InterficieWiki.cercaactual;
import static Interficie.InterficieWiki.comp;
import javax.swing.DefaultListModel;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 *
 * @author cristina.fontanet
 */
public class VeureCerques extends javax.swing.JPanel {
	

    private final InterficieWiki pare;

    /**
     * Creates new form VeureCerques
     * 
     * @param par 
     */
    public VeureCerques(JFrame par) {
        initComponents();
        pare = (InterficieWiki)par;
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane12 = new javax.swing.JScrollPane();
        modcerques = new DefaultListModel();
        LlistaCerques = new javax.swing.JList();
        BVisCat2 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        jScrollPane12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane12.setAutoscrolls(true);

        LlistaCerques.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));
        LlistaCerques.setModel(modcerques);
        LlistaCerques.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane12.setViewportView(LlistaCerques);

        BVisCat2.setText("Visualitza");
        BVisCat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVisCat2ActionPerformed(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(240, 240, 240));
        jTextField7.setText("Cerques realitzades:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BVisCat2))
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BVisCat2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /*
    * En clicar el boto de visualitzar, es comproba si la cerca seleccionada ja està oberta o alguna amb el mateix nom i si es pot, s'obre la cerca
    */
    private void BVisCat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisCat2ActionPerformed
        if(LlistaCerques.getSelectedIndex()>=0) {
            cercaactual = macro.getContUser().getNumCerca(macro.getUserActual(), LlistaCerques.getSelectedValue().toString());
            if(pare.espotvisualitzar(LlistaCerques.getSelectedValue().toString()))pare.visualitzaCercaAntiga();
            else JOptionPane.showMessageDialog(comp, "No es poden visualitzar dos cerques amb el mateix nom", capsalera, WARNING_MESSAGE);
        }
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar a quina cerca vols visualitzar!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_BVisCat2ActionPerformed
    /*
    * En mostrar-se el panell, es carreguen les cerques realitzades per l'usuari actual
    */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        System.out.println("COMPONENT SHOWN user: "+macro.getUserActual());
        vista.carregaCerquesFetes(jTextField7, LlistaCerques);  
    }//GEN-LAST:event_formComponentShown
    /*
    * En iniciar-se el programa, es carreguen les cerques realitzades anteriorment per l'usuari actual
    */
    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        System.out.println("COMPONENT ADDED user: "+macro.getUserActual());
        vista.carregaCerquesFetes(jTextField7, LlistaCerques);  
    }//GEN-LAST:event_formComponentAdded

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BVisCat2;
    private javax.swing.JList LlistaCerques;
    private DefaultListModel modcerques;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
