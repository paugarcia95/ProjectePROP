/*
 * 
 */
package Interficie;
import static Interficie.InterficieWiki.capsalera;
import static Interficie.InterficieWiki.comp;
import static Interficie.InterficieWiki.vista;
import java.util.ArrayList;
import static Interficie.InterficieWiki.macro;
import java.awt.Frame;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
/**
 *
 * @author Rafa Lucena
 */
public class AfegirEnll extends javax.swing.JPanel {
    String cat;
    Frame pare;
    String noSelect="  No n'hi ha cap";
    static boolean admin;
    /**
     * Creates new form AfegirEnll
     */
    public AfegirEnll() {
        initComponents();
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        A_ModificaCateg = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        AfegeixP1 = new javax.swing.JButton();
        AfegeixC1 = new javax.swing.JButton();
        CbuscaPag = new javax.swing.JButton();
        Cbusca2 = new javax.swing.JTextField();
        Cbusca = new javax.swing.JTextField();
        CbuscaCat = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        AfegeixC2 = new javax.swing.JButton();
        AfegeixP2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jOptionPane1 = new javax.swing.JOptionPane();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        A_ModificaCateg.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_ModificaCategComponentShown(evt);
            }
        });

        jLabel6.setText("Creant enlla�");

        jLabel8.setText("Pagina");

        jLabel9.setText("Categoria");

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
        jList2.setFixedCellHeight(15);
        jList2.setFixedCellWidth(15);
        jScrollPane11.setViewportView(jList2);

        AfegeixP1.setText("Afegeix");
        AfegeixP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixP1ActionPerformed(evt);
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

        jButton1.setText("Crear Enlla� Cat->Pag");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        AfegeixC2.setText("Afegeix");
        AfegeixC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixC2ActionPerformed(evt);
            }
        });

        AfegeixP2.setText("Afegeix");
        AfegeixP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixP2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Categoria 2");

        jLabel13.setText("Categoria 1");

        jButton2.setText("Crear Enlla� Pag->Cat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Crear Enlla� C1->C2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Crear Enlla� C2->C1");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.setFocusable(false);

        jTextField2.setFocusable(false);

        jTextField3.setFocusable(false);

        jTextField4.setFocusable(false);

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Eliminar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_ModificaCategLayout = new javax.swing.GroupLayout(A_ModificaCateg);
        A_ModificaCateg.setLayout(A_ModificaCategLayout);
        A_ModificaCategLayout.setHorizontalGroup(
            A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                        .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CbuscaCat))
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                        .addComponent(AfegeixC2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel13)
                                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                        .addComponent(AfegeixC1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton7))
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14)
                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                        .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CbuscaPag))
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                                .addComponent(AfegeixP1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton8))
                                            .addComponent(jLabel8)
                                            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                                                .addComponent(AfegeixP2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton6)))
                                        .addGap(33, 33, 33)
                                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1)
                                            .addComponent(jButton3))
                                        .addGap(18, 18, 18)
                                        .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton4)
                                            .addComponent(jButton2)))
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        A_ModificaCategLayout.setVerticalGroup(
            A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AfegeixP2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(AfegeixC2)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(9, 9, 9)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AfegeixP1)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(AfegeixC1)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(77, 77, 77)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbuscaPag)
                    .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbuscaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane11)
                    .addComponent(jScrollPane10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jOptionPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jOptionPane1ComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(A_ModificaCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 270, Short.MAX_VALUE)
                    .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 270, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(A_ModificaCateg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 196, Short.MAX_VALUE)
                    .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 196, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eliminabut(DefaultListModel mod, JList quina){
        if(mod.getSize()>0) mod.removeElementAt(quina.getSelectedIndex());
    }
    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        vista.omplePaginesExistentsConcret(jList2,Cbusca2);
        vista.ompleCategoriesExistentsConcret(jList1,Cbusca);
        jOptionPane1.setVisible(false);
        A_ModificaCateg.setVisible(true);
    }//GEN-LAST:event_formComponentAdded

    private void jOptionPane1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jOptionPane1ComponentHidden
        vista.omplePaginesExistents(jList2);
        vista.ompleCategoriesExistents(jList1);
    }//GEN-LAST:event_jOptionPane1ComponentHidden

    private void A_ModificaCategComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_ModificaCategComponentShown
        vista.omplePaginesExistents(jList2);
        vista.ompleCategoriesExistents(jList1);
    }//GEN-LAST:event_A_ModificaCategComponentShown

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       String aux1 = jTextField3.getText();
       String aux2 = jTextField1.getText();
       if (aux1.isEmpty()) JOptionPane.showMessageDialog(comp, "No hi pot haver una categoria buida!", capsalera, WARNING_MESSAGE); 
       else if (aux2.isEmpty()) JOptionPane.showMessageDialog(comp, "No hi pot haver una categoria buida!", capsalera, WARNING_MESSAGE);
       else if(!aux1.equals(aux2)){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(aux2);
            macro.getContDades().addCsubC(aux1, temp);
       }
       else JOptionPane.showMessageDialog(comp, "No poden ser la mateixa categoria!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String aux1 = jTextField1.getText();
        String aux2 = jTextField3.getText();
        if (aux1.isEmpty()) JOptionPane.showMessageDialog(comp, "No hi pot haver una categoria buida!", capsalera, WARNING_MESSAGE);
        else if (aux2.isEmpty()) JOptionPane.showMessageDialog(comp, "No hi pot haver una categoria buida!", capsalera, WARNING_MESSAGE);
        else if(!aux1.equals(aux2)){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(aux2);
            macro.getContDades().addCsubC(aux1, temp);
        }
        else JOptionPane.showMessageDialog(comp, "No poden ser la mateixa categoria!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String aux1 = jTextField4.getText();
        String aux2 = jTextField2.getText();
        if (aux1.isEmpty()) JOptionPane.showMessageDialog(comp, "La P�gina no pot estar buida!", capsalera, WARNING_MESSAGE);
        else if (aux2.isEmpty()) JOptionPane.showMessageDialog(comp, "La Categoria no pot estar buida!", capsalera, WARNING_MESSAGE);
        else {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(aux2);
            macro.getContDades().addPagPC(aux1, temp);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AfegeixP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixP2ActionPerformed
        if(jList1.isSelectionEmpty())JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
        else if(!jTextField3.equals(jList1.getSelectedValue().toString()))jTextField3.setText(jList1.getSelectedValue().toString());
        jList1.clearSelection();
    }//GEN-LAST:event_AfegeixP2ActionPerformed

    private void AfegeixC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixC2ActionPerformed
        if(jList1.isSelectionEmpty())JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
        else if(!jTextField1.equals(jList1.getSelectedValue().toString()))jTextField1.setText(jList1.getSelectedValue().toString());
        jList1.clearSelection();
    }//GEN-LAST:event_AfegeixC2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String aux1 = jTextField2.getText();
        String aux2 = jTextField4.getText();
        if (aux1.isEmpty()) JOptionPane.showMessageDialog(comp, "La Categoria no pot estar buida!", capsalera, WARNING_MESSAGE);
        else if (aux2.isEmpty()) JOptionPane.showMessageDialog(comp, "La P�gina no pot estar buida!", capsalera, WARNING_MESSAGE);
        else {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(aux2);
            macro.getContDades().addCatCP(aux1, temp);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CbuscaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCatActionPerformed
        vista.ompleCategoriesExistentsConcret(jList1,Cbusca);
    }//GEN-LAST:event_CbuscaCatActionPerformed

    private void CbuscaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPagActionPerformed
        vista.omplePaginesExistentsConcret(jList2,Cbusca2);
    }//GEN-LAST:event_CbuscaPagActionPerformed

    private void AfegeixC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixC1ActionPerformed
        if(jList1.isSelectionEmpty())JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
        else if(!jTextField2.equals(jList1.getSelectedValue().toString()))jTextField2.setText(jList1.getSelectedValue().toString());
        jList1.clearSelection();
    }//GEN-LAST:event_AfegeixC1ActionPerformed

    private void AfegeixP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixP1ActionPerformed
        if(jList2.isSelectionEmpty())JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna p�gina de la llista!", capsalera, WARNING_MESSAGE);
        else if(!jTextField4.equals(jList2.getSelectedValue().toString()))jTextField4.setText(jList2.getSelectedValue().toString());
        jList2.clearSelection();
    }//GEN-LAST:event_AfegeixP1ActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
       Integer aux = vista.omplePaginesExistentsConcret(jList2,Cbusca2);
        aux= vista.ompleCategoriesExistentsConcret(jList1,Cbusca);
    }//GEN-LAST:event_formComponentHidden

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        vista.omplePaginesExistentsConcret(jList2,Cbusca2);
        vista.ompleCategoriesExistentsConcret(jList1,Cbusca);
    }//GEN-LAST:event_formComponentShown

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTextField1.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTextField2.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextField3.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jTextField4.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A_ModificaCateg;
    private javax.swing.JButton AfegeixC1;
    private javax.swing.JButton AfegeixC2;
    private javax.swing.JButton AfegeixP1;
    private javax.swing.JButton AfegeixP2;
    private javax.swing.JTextField Cbusca;
    private javax.swing.JTextField Cbusca2;
    private javax.swing.JButton CbuscaCat;
    private javax.swing.JButton CbuscaPag;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
