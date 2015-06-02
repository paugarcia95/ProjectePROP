/*
 * Panell dels noms de totes les pagines existents al sistema 
 */

package Interficie;

import static Interficie.InterficieWiki.vista;
import static Interficie.InterficieWiki.macro;
/**
 *
 * @author cristina.fontanet
 */
public class BuscaPag extends javax.swing.JPanel {
    
    static Integer numPagsConc;
    
        private void numPagTotals() {
            jLabel1.setText("Hi ha "+macro.getContDades().getNumPags()+" pagines");
    }
   
    private void numPagParcials(){
         jLabel1.setText("Hi ha "+numPagsConc+" pagines que continguin "+Cbusca5.getText());
    }
    
    /**
     * Creates new form BuscaPag
     */
    public BuscaPag() {
        initComponents();
        
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        BVisPag = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LlistaPag = new javax.swing.JList();
        Cbusca5 = new javax.swing.JTextField();
        CbuscaPag2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(240, 240, 240));
        jTextField2.setText("Aquestes s�n les p�gines existents:");

        BVisPag.setText("Visualitza");
        BVisPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVisPagActionPerformed(evt);
            }
        });

        LlistaPag.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));
        LlistaPag.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LlistaPag.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(LlistaPag);

        CbuscaPag2.setText("Busca");
        CbuscaPag2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPag2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cbusca5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaPag2)
                        .addGap(18, 18, 18)
                        .addComponent(BVisPag))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbusca5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbuscaPag2)
                    .addComponent(BVisPag))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    /*
    * Quan es clica el boto de visualitzacio, s'obre la informacio de la pagina seleccionada
    */
    private void BVisPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisPagActionPerformed
        vista.visualitzarPaginaDe(LlistaPag);
        LlistaPag.clearSelection();
        vista.omplePaginesExistents(LlistaPag);
    }//GEN-LAST:event_BVisPagActionPerformed
    /*
    * Quan es clica al boto busca, es mostren nomes les pagines que contenen el conjunt de lletres
    */
    private void CbuscaPag2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPag2ActionPerformed
        numPagsConc =vista.omplePaginesExistentsConcret(LlistaPag, Cbusca5);
        if(Cbusca5.getText().length()>0) numPagParcials();
        else numPagTotals();
    }//GEN-LAST:event_CbuscaPag2ActionPerformed
    /*
    * Quan es mostra el panell, es veuen els noms de totes les pagines existents
    */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        numPagTotals();
        vista.omplePaginesExistents(LlistaPag);
    }//GEN-LAST:event_formComponentShown
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BVisPag;
    private javax.swing.JTextField Cbusca5;
    private javax.swing.JButton CbuscaPag2;
    private javax.swing.JList LlistaPag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
