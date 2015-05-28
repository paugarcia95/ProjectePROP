/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

import static Interficie.InterficiaProva1.macro;
import static Interficie.InterficiaProva1.vista;
import static Interficie.ControladorVistes1.PagList;
import static Interficie.InterficiaProva1.capsalera;
import static Interficie.InterficiaProva1.comp;
import static Interficie.VCategoria1.admin;
import domini.Pagina;
import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author Cristina
 */
public class VPagina1 extends javax.swing.JDialog {
 String pag;
    Frame pare;
    String noSelect="  No n'hi ha cap";
    //DefaultListModel modelo;
    //static domini.MacroControlador macro;
    static boolean admin;
    
    
    
    private void omplirDades(JList CApunta, JList CApuntada){
        //Categories a les que apunta
        Collection<String> auxc = macro.getContAdUs().getPagPC(pag);
        Object[] aux2;
        if(auxc.size()>0) {
            aux2 = new Object[auxc.size()];
            int cont = 0;
            Iterator<String> it = auxc.iterator();
            while(it.hasNext()) {
               aux2[cont] = it.next();
               ++cont;
            }
        }
        else {
            aux2 = new Object[1];
            aux2[0] =noSelect;
        }
        CApunta.setListData(aux2);    
        
        //Categories que l'apunten
        auxc = macro.getContAdUs().getPagCP(pag);
        if(auxc.size()>0) {
            aux2 = new Object[auxc.size()];
            int cont = 0;
            Iterator<String> it = auxc.iterator();
            while(it.hasNext()) {
               aux2[cont] = it.next();
               ++cont;
            }
        }
        else {
            aux2 = new Object[1];
            aux2[0] = noSelect;
        }
        CApuntada.setListData(aux2);
    }
    
    private void omplirModificacions(){
        Collection<String> aux = macro.getContAdUs().getPagPC(pag);
        System.out.println("PC: "+aux);
        for(String pag: aux) modelom.addElement(pag);
        Collection<String> auxi = macro.getContAdUs().getPagCP(pag);
        System.out.println("CP: "+auxi);
        for(String pag: auxi) modelo1.addElement(pag);
    }
    public void NomPag(String nomPag) {
        pag = nomPag;
        initComponents();
        A_VeurePag.setVisible(false);
        this.setAlwaysOnTop(false);
        A_ModificaPag.setVisible(false);
        A_VeurePag.setVisible(true);
        this.setVisible(true);
    }
    /**
     * Creates new form VPagina1
     */
    public VPagina1(java.awt.Frame parent, boolean modalitat, Boolean adm) {
        super(parent, modalitat);
        pare=parent;
        admin = adm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        A_VeurePag = new javax.swing.JPanel();
        NomC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CApunta = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        CApuntada = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        A_ModificaPag = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        modelom = new DefaultListModel();
        CApunta1 = new javax.swing.JList();
        AfegeixC = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Nom = new javax.swing.JTextField();
        AfegeixC1 = new javax.swing.JButton();
        Enrere = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Cbusca = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        modelo1 = new DefaultListModel();
        CApuntada1 = new javax.swing.JList();
        CbuscaCat = new javax.swing.JButton();
        EliminaC1 = new javax.swing.JButton();
        EliminaC2 = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        A_VeurePag.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VeurePagComponentShown(evt);
            }
        });

        NomC.setBackground(new java.awt.Color(255, 255, 255));
        NomC.setText(pag);
        NomC.setAutoscrolls(true);

        jLabel1.setText("Nom P�gina:");

        jLabel2.setBackground(new java.awt.Color(250, 250, 250));
        jLabel2.setText("Comunitats a les que apunta:");

        jLabel3.setText("Catgories que l'apunten:");

        jButton1.setText("Visualitza Categoria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CApunta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        CApunta.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(CApunta);

        CApuntada.setBorder(new javax.swing.border.MatteBorder(null));
        CApuntada.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(CApuntada);

        jButton3.setText("Modifica P�gina");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar P�gina");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton3)
                .addComponent(jButton5))
        );

        javax.swing.GroupLayout A_VeurePagLayout = new javax.swing.GroupLayout(A_VeurePag);
        A_VeurePag.setLayout(A_VeurePagLayout);
        A_VeurePagLayout.setHorizontalGroup(
            A_VeurePagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VeurePagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VeurePagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(A_VeurePagLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(NomC, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_VeurePagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VeurePagLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGroup(A_VeurePagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_VeurePagLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_VeurePagLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(A_VeurePagLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        A_VeurePagLayout.setVerticalGroup(
            A_VeurePagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VeurePagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VeurePagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(A_VeurePagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(NomC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(A_VeurePagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VeurePagLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(A_VeurePagLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3)
                        .addGroup(A_VeurePagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_VeurePagLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jButton1)
                                .addGap(0, 243, Short.MAX_VALUE))
                            .addGroup(A_VeurePagLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2)))))
                .addContainerGap())
        );

        A_ModificaPag.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_ModificaPagComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_ModificaPagComponentShown(evt);
            }
        });

        jLabel11.setText("Categories existents:");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane10.setViewportView(jList1);

        jLabel7.setBackground(new java.awt.Color(250, 250, 250));
        jLabel7.setText("Categories a les que apunta:");

        CApunta1.setModel(modelom);
        CApunta1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CApunta1.setDragEnabled(true);
        CApunta1.setDropMode(javax.swing.DropMode.INSERT);
        CApunta1.setFocusable(false);
        CApunta1.setValueIsAdjusting(true);
        jScrollPane7.setViewportView(CApunta1);

        AfegeixC.setText("Afegeix");
        AfegeixC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixCActionPerformed(evt);
            }
        });

        jLabel6.setText("Nom de la p�gina:");

        AfegeixC1.setText("Afegeix");
        AfegeixC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixC1ActionPerformed(evt);
            }
        });

        Enrere.setText("Enrere");
        Enrere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnrereActionPerformed(evt);
            }
        });

        jLabel9.setText("Catgories que l'apunten:");

        CApuntada1.setModel(modelo1);
        CApuntada1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CApuntada1.setDragEnabled(true);
        CApuntada1.setDropMode(javax.swing.DropMode.INSERT);
        CApuntada1.setFocusable(false);
        CApuntada1.setValueIsAdjusting(true);
        jScrollPane8.setViewportView(CApuntada1);

        CbuscaCat.setText("Busca");
        CbuscaCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaCatActionPerformed(evt);
            }
        });

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

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_ModificaPagLayout = new javax.swing.GroupLayout(A_ModificaPag);
        A_ModificaPag.setLayout(A_ModificaPagLayout);
        A_ModificaPagLayout.setHorizontalGroup(
            A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_ModificaPagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(A_ModificaPagLayout.createSequentialGroup()
                        .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EliminaC1)
                            .addComponent(EliminaC2)
                            .addComponent(AfegeixC)
                            .addComponent(AfegeixC1)))
                    .addGroup(A_ModificaPagLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_ModificaPagLayout.createSequentialGroup()
                                .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbuscaCat))
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(A_ModificaPagLayout.createSequentialGroup()
                        .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_ModificaPagLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Enrere)
                            .addComponent(Guardar))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        A_ModificaPagLayout.setVerticalGroup(
            A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_ModificaPagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Guardar))
                .addGap(18, 18, 18)
                .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Enrere))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(A_ModificaPagLayout.createSequentialGroup()
                        .addComponent(EliminaC1)
                        .addGap(18, 18, 18)
                        .addComponent(AfegeixC)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(A_ModificaPagLayout.createSequentialGroup()
                        .addComponent(EliminaC2)
                        .addGap(18, 18, 18)
                        .addComponent(AfegeixC1)))
                .addGap(18, 18, 18)
                .addGroup(A_ModificaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbuscaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(A_VeurePag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(A_ModificaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(A_VeurePag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(A_ModificaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* VCategoria nova;

        if(CApunta.getSelectedIndices().length>0 && !CApunta.getSelectedValue().toString().equals(noSelect)) {
            String hy = CApunta.getSelectedValue().toString();
            nova = new VCategoria(pare, true,admin);
            nova.NomCat(macro.getGraf().getCategoria(hy));
        }
        else if(CApuntada.getSelectedIndices().length>0 && !CApuntada.getSelectedValue().toString().equals(noSelect)) {
            String hy = CApuntada.getSelectedValue().toString();
            nova = new VCategoria(pare, true,admin);
            nova.NomCat(macro.getGraf().getCategoria(hy));
        }
        else {
            JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
        }*/

        VCategoria1 nova;
        if(CApunta.getSelectedIndices().length>0 && !CApunta.getSelectedValue().toString().equals(noSelect)) {
            String hy = CApunta.getSelectedValue().toString();
            nova = new VCategoria1(pare, true,admin);
            nova.NomCat(hy);
            nova.setAlwaysOnTop(true);
            nova.setFocusable(true);
        }
        else if(CApuntada.getSelectedIndices().length>0 && !CApuntada.getSelectedValue().toString().equals(noSelect)) {
            String hy = CApuntada.getSelectedValue().toString();
            nova = new VCategoria1(pare, true,admin);
            nova.NomCat(hy);
            nova.setAlwaysOnTop(true);
            nova.setFocusable(true);
        }
        else {
            JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        A_ModificaPag.setVisible(true);
        A_VeurePag.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Segur que vols eliminar aquesta p�gina?", capsalera, YES_NO_OPTION);
        if(resposta==YES_OPTION) {
            macro.getContAdUs().removePag(pag);
            vista.omplePaginesExistents(PagList);
            this.dispose();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void A_VeurePagComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VeurePagComponentShown
        omplirDades(CApunta,CApuntada);
    }//GEN-LAST:event_A_VeurePagComponentShown

    private void AfegeixCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixCActionPerformed
        modelom.addElement(jList1.getSelectedValue());
        jList1.clearSelection();
    }//GEN-LAST:event_AfegeixCActionPerformed

    private void AfegeixC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixC1ActionPerformed
        modelo1.addElement(jList1.getSelectedValue());
        jList1.clearSelection();
    }//GEN-LAST:event_AfegeixC1ActionPerformed

    private void EnrereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrereActionPerformed
        A_ModificaPag.setVisible(false);
        A_VeurePag.setVisible(true);
    }//GEN-LAST:event_EnrereActionPerformed

    private void CbuscaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCatActionPerformed
        ControladorVistes aux = new ControladorVistes();
        aux.ompleCategoriesExistentsConcret(jList1,Cbusca);
    }//GEN-LAST:event_CbuscaCatActionPerformed

    private void EliminaC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaC1ActionPerformed
        if(modelom.getSize()>0){
            int n = CApunta1.getSelectedIndex();
            modelom.remove(n);
        }
        CApunta1.clearSelection();
    }//GEN-LAST:event_EliminaC1ActionPerformed

    private void EliminaC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaC2ActionPerformed
        if(modelo1.getSize()>0){
            int n = CApuntada1.getSelectedIndex();
            modelo1.remove(n);
        }
        CApuntada1.clearSelection();
    }//GEN-LAST:event_EliminaC2ActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        ArrayList<String> aux = new ArrayList<String>();
        int mida = modelom.getSize();
        for(int i = 0; i < mida; ++i)aux.add(modelom.getElementAt(i).toString());
        macro.getContAdUs().setPagCP(pag, aux);
        aux = new ArrayList<String>();
        mida = modelo1.getSize();
        for(int i = 0; i < mida; ++i) aux.add(modelo1.getElementAt(i).toString());
        macro.getContAdUs().setPagPC(pag, aux);
        macro.getContAdUs().setNomPagina(pag, Nom.getText());
        pag = Nom.getText();
        A_VeurePag.setVisible(true);
        A_ModificaPag.setVisible(false);

    }//GEN-LAST:event_GuardarActionPerformed

    private void A_ModificaPagComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_ModificaPagComponentHidden
        modelom.removeAllElements();
        modelo1.removeAllElements();
    }//GEN-LAST:event_A_ModificaPagComponentHidden

    private void A_ModificaPagComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_ModificaPagComponentShown
        vista.ompleCategoriesExistents(jList1);
        Nom.setText(pag);
        A_VeurePag.setVisible(false);
        omplirModificacions();
        A_ModificaPag.setVisible(true);
    }//GEN-LAST:event_A_ModificaPagComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VPagina1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPagina1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPagina1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPagina1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VPagina1 dialog = new VPagina1(new javax.swing.JFrame(), true, admin);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A_ModificaPag;
    private javax.swing.JPanel A_VeurePag;
    private javax.swing.JButton AfegeixC;
    private javax.swing.JButton AfegeixC1;
    private javax.swing.JList CApunta;
    private javax.swing.JList CApunta1;
    private DefaultListModel modelom;
    private javax.swing.JList CApuntada;
    private javax.swing.JList CApuntada1;
    private DefaultListModel modelo1;
    private javax.swing.JTextField Cbusca;
    private javax.swing.JButton CbuscaCat;
    private javax.swing.JButton EliminaC1;
    private javax.swing.JButton EliminaC2;
    private javax.swing.JButton Enrere;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField Nom;
    private javax.swing.JLabel NomC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    // End of variables declaration//GEN-END:variables
}