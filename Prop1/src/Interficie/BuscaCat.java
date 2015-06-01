/**
 * Panell dels noms de totes les categories existents al sistema 
 */

package Interficie;


import static Interficie.InterficieWiki.vista;

/**
 *
 * @author cristina.fontanet
 */
public class BuscaCat extends javax.swing.JPanel {
    /**
     * Creates new form BuscaCat
     */
    public BuscaCat() {
        initComponents();
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        LlistaCateg = new javax.swing.JList();
        BVisCat = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        CbuscaPag3 = new javax.swing.JButton();
        Cbusca6 = new javax.swing.JTextField();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setAutoscrolls(true);

        LlistaCateg.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));
        LlistaCateg.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LlistaCateg.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(LlistaCateg);

        BVisCat.setText("Visualitza");
        BVisCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVisCatActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(240, 240, 240));
        jTextField1.setText("Aquestes són les categories existents:");

        CbuscaPag3.setText("Busca");
        CbuscaPag3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPag3ActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Cbusca6)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaPag3)
                        .addGap(18, 18, 18)
                        .addComponent(BVisCat)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cbusca6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CbuscaPag3)
                        .addComponent(BVisCat)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /*
    * Quan es clica el boto de visualitzacio, s'obre la informacio de la categoria seleccionada
    */
    private void BVisCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisCatActionPerformed
        vista.visualitzarCategoriaDe(LlistaCateg);
        LlistaCateg.clearSelection();
    }//GEN-LAST:event_BVisCatActionPerformed
    
    /*
    * Quan es clica al boto busca, es mostren nomes les categories que contenen el conjunt de lletres
    */
    private void CbuscaPag3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPag3ActionPerformed
        vista.ompleCategoriesExistentsConcret(LlistaCateg, Cbusca6);
    }//GEN-LAST:event_CbuscaPag3ActionPerformed

    /*
    * Quan es mostra el panell, es veuen els noms de totes les categories existents
    */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       vista.ompleCategoriesExistents(LlistaCateg);
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BVisCat;
    private javax.swing.JTextField Cbusca6;
    private javax.swing.JButton CbuscaPag3;
    private javax.swing.JList LlistaCateg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
