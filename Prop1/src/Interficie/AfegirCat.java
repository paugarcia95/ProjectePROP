/*
 * 
 */
package Interficie;
import static Interficie.InterficieWiki.comp;
import static Interficie.InterficieWiki.vista;
import static Interficie.InterficieWiki.capsalera;
import java.util.ArrayList;
import static Interficie.InterficieWiki.macro;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
/**
 *
 * @author Rafa Lucena
 */
public class AfegirCat extends javax.swing.JPanel {
    String pag;
    /**
     * Creates new form AfegirCat
     */
    public AfegirCat() {
        initComponents();
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Introduccio = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        A_ModificaCateg = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        modelo3 = new DefaultListModel();
        PApuntada1 = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        modelom = new DefaultListModel();
        CApunta1 = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        modelo1 = new DefaultListModel();
        CApuntada1 = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        modelo2 = new DefaultListModel();
        PApunta1 = new javax.swing.JList();
        EliminaC1 = new javax.swing.JButton();
        EliminaC2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        AfegeixC = new javax.swing.JButton();
        AfegeixP1 = new javax.swing.JButton();
        AfegeixP2 = new javax.swing.JButton();
        AfegeixC1 = new javax.swing.JButton();
        CbuscaPag = new javax.swing.JButton();
        Cbusca2 = new javax.swing.JTextField();
        Cbusca = new javax.swing.JTextField();
        CbuscaCat = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jOptionPane1 = new javax.swing.JOptionPane();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        jLabel1.setText("Insereix el nom de la Categoria");

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IntroduccioLayout = new javax.swing.GroupLayout(Introduccio);
        Introduccio.setLayout(IntroduccioLayout);
        IntroduccioLayout.setHorizontalGroup(
            IntroduccioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IntroduccioLayout.createSequentialGroup()
                .addGroup(IntroduccioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IntroduccioLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(IntroduccioLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton1))
                    .addGroup(IntroduccioLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        IntroduccioLayout.setVerticalGroup(
            IntroduccioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IntroduccioLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        A_ModificaCateg.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_ModificaCategComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_ModificaCategComponentShown(evt);
            }
        });

        jLabel6.setText("Nom de la categoria: " + pag);

        jLabel7.setBackground(new java.awt.Color(250, 250, 250));
        jLabel7.setText("Categories a les que apunta:");

        PApuntada1.setModel(modelo3);
        PApuntada1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PApuntada1.setDragEnabled(true);
        PApuntada1.setDropMode(javax.swing.DropMode.INSERT);
        PApuntada1.setFocusable(false);
        PApuntada1.setValueIsAdjusting(true);
        jScrollPane6.setViewportView(PApuntada1);

        CApunta1.setModel(modelom);
        CApunta1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CApunta1.setDragEnabled(true);
        CApunta1.setDropMode(javax.swing.DropMode.INSERT);
        CApunta1.setFocusable(false);
        CApunta1.setValueIsAdjusting(true);
        jScrollPane7.setViewportView(CApunta1);

        jLabel8.setText("P�gines a les que apunta:");

        jLabel9.setText("Catgories que l'apunten:");

        CApuntada1.setModel(modelo1);
        CApuntada1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CApuntada1.setDragEnabled(true);
        CApuntada1.setDropMode(javax.swing.DropMode.INSERT);
        CApuntada1.setFocusable(false);
        CApuntada1.setValueIsAdjusting(true);
        jScrollPane8.setViewportView(CApuntada1);

        jLabel10.setText("P�gines que l'apunten:");

        PApunta1.setModel(modelo2);
        PApunta1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PApunta1.setDragEnabled(true);
        PApunta1.setDropMode(javax.swing.DropMode.INSERT);
        PApunta1.setFocusable(false);
        PApunta1.setValueIsAdjusting(true);
        jScrollPane9.setViewportView(PApunta1);

        EliminaC1.setText("Elimina");
        EliminaC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaC1ActionPerformed(evt);
            }
        });

        EliminaC2.setText("Elimina");
        EliminaC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaC2ActionPerformed(evt);
            }
        });

        jButton9.setText("Elimina");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Elimina");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel11.setText("Categories existents:");

        jLabel12.setText("P�gines existents");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane10.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane11.setViewportView(jList2);

        AfegeixC.setText("Afegeix");
        AfegeixC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixCActionPerformed(evt);
            }
        });

        AfegeixP1.setText("Afegeix");
        AfegeixP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixP1ActionPerformed(evt);
            }
        });

        AfegeixP2.setText("Afegeix");
        AfegeixP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixP2ActionPerformed(evt);
            }
        });

        AfegeixC1.setText("Afegeix");
        AfegeixC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixC1ActionPerformed(evt);
            }
        });

        CbuscaPag.setText("Busca");
        CbuscaPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPagActionPerformed(evt);
            }
        });

        CbuscaCat.setText("Busca");
        CbuscaCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaCatActionPerformed(evt);
            }
        });

        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_ModificaCategLayout = new javax.swing.GroupLayout(A_ModificaCateg);
        A_ModificaCateg.setLayout(A_ModificaCategLayout);
        A_ModificaCategLayout.setHorizontalGroup(
            A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EliminaC1)
                                    .addComponent(EliminaC2)
                                    .addComponent(AfegeixC)
                                    .addComponent(AfegeixC1)))
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                        .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CbuscaCat))
                                    .addComponent(jLabel11)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CbuscaPag))
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9)
                                    .addComponent(jButton10)
                                    .addComponent(AfegeixP1)
                                    .addComponent(AfegeixP2)
                                    .addComponent(jButton4))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        A_ModificaCategLayout.setVerticalGroup(
            A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addComponent(EliminaC1)
                                .addGap(18, 18, 18)
                                .addComponent(AfegeixC))))
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9)
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addGap(18, 18, 18)
                                .addComponent(AfegeixP2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addComponent(EliminaC2)
                                .addGap(18, 18, 18)
                                .addComponent(AfegeixC1))))
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addGap(18, 18, 18)
                                .addComponent(AfegeixP1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane6))))
                .addGap(18, 18, 18)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbuscaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbuscaPag))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(A_ModificaCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Introduccio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(A_ModificaCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Introduccio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eliminabut(DefaultListModel mod, JList quina){
        if(mod.getSize()>0) mod.removeElementAt(quina.getSelectedIndex());
    }
    private void EliminaC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaC1ActionPerformed
        if(CApunta1.getSelectedIndex()>=0) eliminabut(modelom,CApunta1);
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_EliminaC1ActionPerformed

    private void EliminaC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaC2ActionPerformed
        if(CApuntada1.getSelectedIndex()>=0) eliminabut(modelo1,CApuntada1);
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_EliminaC2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(PApunta1.getSelectedIndex()>=0) eliminabut(modelo2,PApunta1);
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna pagina de la llista!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(PApuntada1.getSelectedIndex()>=0) eliminabut(modelo3,PApuntada1);
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna pagina de la llista!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void AfegeixCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixCActionPerformed
        if(!modelom.contains(jList1.getSelectedValue()))modelom.addElement(jList1.getSelectedValue());
        jList1.clearSelection();
    }//GEN-LAST:event_AfegeixCActionPerformed

    private void AfegeixP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixP1ActionPerformed
        if(!modelo3.contains(jList2.getSelectedValue()))modelo3.addElement(jList2.getSelectedValue());
        jList2.clearSelection();
    }//GEN-LAST:event_AfegeixP1ActionPerformed

    private void AfegeixP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixP2ActionPerformed
        if(!modelo2.contains(jList2.getSelectedValue()))modelo2.addElement(jList2.getSelectedValue());
        jList2.clearSelection();
    }//GEN-LAST:event_AfegeixP2ActionPerformed

    private void AfegeixC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixC1ActionPerformed
        if(!modelo1.contains(jList1.getSelectedValue()))modelo1.addElement(jList1.getSelectedValue());
        jList1.clearSelection();
    }//GEN-LAST:event_AfegeixC1ActionPerformed

    private void CbuscaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPagActionPerformed
        vista.omplePaginesExistentsConcret(jList2,Cbusca2);
    }//GEN-LAST:event_CbuscaPagActionPerformed

    private void CbuscaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCatActionPerformed
        vista.ompleCategoriesExistentsConcret(jList1,Cbusca);
    }//GEN-LAST:event_CbuscaCatActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        macro.getContDades().addCateg(pag);
        ArrayList<String> categs = new ArrayList<String>();
        for(int i = 0; i < modelom.size();++i) categs.add(modelom.getElementAt(i).toString());
        macro.getContDades().addCsubC(pag, categs);
        categs = new ArrayList<String>();
        for(int i = 0; i < modelo1.size();++i) categs.add(modelo1.getElementAt(i).toString());
        macro.getContDades().addCsupC(pag, categs);
        categs = new ArrayList<String>();
        for(int i = 0; i < modelo2.size();++i) categs.add(modelo2.getElementAt(i).toString());
        macro.getContDades().addCatPC(pag, categs);
        categs = new ArrayList<String>();
        for(int i = 0; i < modelo3.size();++i) categs.add(modelo3.getElementAt(i).toString());
        macro.getContDades().addCatCP(pag, categs);
        JOptionPane.showMessageDialog(comp, "Categoria creada correctament");
        A_ModificaCateg.setVisible(false);
        Introduccio.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void A_ModificaCategComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_ModificaCategComponentHidden
        modelom.removeAllElements();
        modelo1.removeAllElements();
        modelo2.removeAllElements();
        modelo3.removeAllElements();
    }//GEN-LAST:event_A_ModificaCategComponentHidden

    private void A_ModificaCategComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_ModificaCategComponentShown
        vista.omplePaginesExistents(jList2);
        vista.ompleCategoriesExistents(jList1);
        A_ModificaCateg.setVisible(true);
       
    }//GEN-LAST:event_A_ModificaCategComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pag = jTextField1.getText();
        if(!pag.isEmpty() && !pag.contains("|") && !pag.contains("*") && !pag.contains(" ") && !macro.getContDades().getCategories().contains(pag)) {
            jLabel6.setText("Nom de la p�gina:" + pag);
            Introduccio.setVisible(false);
            A_ModificaCateg.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(comp, "Si us plau, introdueix un nom v�lid", capsalera, WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        Introduccio.setVisible(true);
        A_ModificaCateg.setVisible(false);
        jOptionPane1.setVisible(false);
    }//GEN-LAST:event_formComponentAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A_ModificaCateg;
    private javax.swing.JButton AfegeixC;
    private javax.swing.JButton AfegeixC1;
    private javax.swing.JButton AfegeixP1;
    private javax.swing.JButton AfegeixP2;
    private javax.swing.JList CApunta1;
    private DefaultListModel modelom;
    private javax.swing.JList CApuntada1;
    private DefaultListModel modelo1;
    private javax.swing.JTextField Cbusca;
    private javax.swing.JTextField Cbusca2;
    private javax.swing.JButton CbuscaCat;
    private javax.swing.JButton CbuscaPag;
    private javax.swing.JButton EliminaC1;
    private javax.swing.JButton EliminaC2;
    private javax.swing.JPanel Introduccio;
    private javax.swing.JList PApunta1;
    private DefaultListModel modelo2;
    private javax.swing.JList PApuntada1;
    private DefaultListModel modelo3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
