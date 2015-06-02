/*
 * Panell dels noms de totes les categories i pagines existents al sistema 
 */

package Interficie;

import static Interficie.InterficieWiki.vista;
import static Interficie.InterficieWiki.macro;

/**
 *
 * @author cristina.fontanet
 */
public class BuscaCatPag extends javax.swing.JPanel {
    static Integer numPagsConc;
     static Integer numCategsConc;
    /**
     * Creates new form BuscaCatPag
     */
    public BuscaCatPag() {
        initComponents();
    }

    private void numCatTotals() {
            jLabel1.setText("Hi ha "+macro.getContDades().getNumCats()+" categories");
    }
    private void numPagTotals() {
            jLabel2.setText("Hi ha "+macro.getContDades().getNumPags()+" pagines");
    }
    private void numsTotals() {  
        numCatTotals();
        numPagTotals();
    }
    
    private void numCatParcials() {
        jLabel1.setText("Hi ha "+numCategsConc+" categories que continguin "+Cbusca3.getText());
    }
    private void numPagParcials(){
         jLabel2.setText("Hi ha "+numPagsConc+" pagines que continguin "+Cbusca4.getText());
    }
    
    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CbuscaCat1 = new javax.swing.JButton();
        Cbusca3 = new javax.swing.JTextField();
        Cbusca4 = new javax.swing.JTextField();
        CbuscaPag1 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        LlistaPag1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        LlistaCateg1 = new javax.swing.JList();
        ButVisualitzaCat = new javax.swing.JButton();
        ButVisualitzaPag = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        CbuscaCat1.setText("Busca");
        CbuscaCat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaCat1ActionPerformed(evt);
            }
        });

        CbuscaPag1.setText("Busca");
        CbuscaPag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPag1ActionPerformed(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(240, 240, 240));
        jTextField4.setText("Aquestes són les categories existents:");

        jTextField3.setBackground(new java.awt.Color(240, 240, 240));
        jTextField3.setText("Aquestes són les pàgines existents:");

        LlistaPag1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));
        LlistaPag1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LlistaPag1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(LlistaPag1);

        LlistaCateg1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));
        LlistaCateg1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LlistaCateg1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(LlistaCateg1);

        ButVisualitzaCat.setText("Visualitza");
        ButVisualitzaCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButVisualitzaCatActionPerformed(evt);
            }
        });

        ButVisualitzaPag.setText("Visualitza");
        ButVisualitzaPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButVisualitzaPagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cbusca3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbuscaCat1)
                                .addGap(18, 18, 18)
                                .addComponent(ButVisualitzaCat)))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cbusca4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbuscaPag1)
                                .addGap(18, 18, 18)
                                .addComponent(ButVisualitzaPag))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbusca3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbuscaCat1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButVisualitzaCat)
                    .addComponent(Cbusca4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbuscaPag1)
                    .addComponent(ButVisualitzaPag))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Panel");
    }// </editor-fold>//GEN-END:initComponents
    /*
    * Quan es clica al boto busca de les categories, es mostren nomes les categories que contenen el conjunt de lletres
    */
    private void CbuscaCat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCat1ActionPerformed
        numCategsConc =vista.ompleCategoriesExistentsConcret(LlistaCateg1, Cbusca3);
        if(Cbusca3.getText().length()>0) numCatParcials();
        else numCatTotals();
    }//GEN-LAST:event_CbuscaCat1ActionPerformed
    /*
    * Quan es clica al boto busca de les pagines, es mostren nomes les pagines que contenen el conjunt de lletres
    */
    private void CbuscaPag1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPag1ActionPerformed
        numPagsConc = vista.omplePaginesExistentsConcret(LlistaPag1, Cbusca4);
        if(Cbusca4.getText().length()>0) numPagParcials();
        else numPagTotals();
    }//GEN-LAST:event_CbuscaPag1ActionPerformed
    /*
    * Quan es mostra el panell, es veuen els noms de totes les categories i pagines existents
    */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        numsTotals();
        vista.omplePaginesExistents(LlistaPag1);
        vista.ompleCategoriesExistents(LlistaCateg1);
    }//GEN-LAST:event_formComponentShown
    /*
    * Quan es clica el boto de visualitzacio d'una categoria, s'obre la informacio de la categoria seleccionada
    */
    private void ButVisualitzaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButVisualitzaCatActionPerformed
        vista.visualitzarCategoriaDe(LlistaCateg1);
        LlistaCateg1.clearSelection();
        vista.ompleCategoriesExistents(LlistaCateg1);
    }//GEN-LAST:event_ButVisualitzaCatActionPerformed
    /*
    * Quan es clica el boto de visualitzacio d'una pagina, s'obre la informacio de la pagina seleccionada
    */
    private void ButVisualitzaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButVisualitzaPagActionPerformed
        vista.visualitzarPaginaDe(LlistaPag1);
        LlistaPag1.clearSelection();
        vista.omplePaginesExistents(LlistaPag1);
    }//GEN-LAST:event_ButVisualitzaPagActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButVisualitzaCat;
    private javax.swing.JButton ButVisualitzaPag;
    private javax.swing.JTextField Cbusca3;
    private javax.swing.JTextField Cbusca4;
    private javax.swing.JButton CbuscaCat1;
    private javax.swing.JButton CbuscaPag1;
    private javax.swing.JList LlistaCateg1;
    private javax.swing.JList LlistaPag1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
