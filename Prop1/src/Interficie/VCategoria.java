/*
 * Panell que mostra les propietats de la categoria, tot podent-la modificar
 */
package Interficie;


import static Interficie.InterficieWiki.capsalera;
import static Interficie.InterficieWiki.macro;
import static Interficie.InterficieWiki.vista;
import static Interficie.ControladorVistes.CategList;
import static Interficie.InterficieWiki.comp;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author cristina.fontanet
 */
public class VCategoria extends javax.swing.JDialog {
    String cat;
    Frame pare;
    String noSelect="  No n'hi ha cap";
    static boolean admin;
    
    private void omplirDades(JList apuntaC, JList apuntadaC, JList aputaP, JList apuntadaP){
        //Categories a les que apunta
        Collection<String> auxc = macro.getContDades().getCsubC(cat);
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
        apuntaC.setListData(aux2);    
        
        //Categories que l'apunten
        auxc = macro.getContDades().getCsupC(cat);
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
        apuntadaC.setListData(aux2);
        
        //Pagines a les que apunta
        auxc = macro.getContDades().getCatCP(cat);
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
        aputaP.setListData(aux2);
        
        //Pagines que l'apunten
        auxc = macro.getContDades().getCatPC(cat);
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
        apuntadaP.setListData(aux2);
    }
    private void omplirModificacions(){
        Collection<String> auxc = macro.getContDades().getCsubC(cat);
        for(String cate: auxc)modelom.addElement(cate);
        auxc = macro.getContDades().getCsupC(cat);
        for(String cate: auxc)modelo1.addElement(cate);
        auxc = macro.getContDades().getCatCP(cat);
        for(String cate: auxc)modelo3.addElement(cate);
        auxc = macro.getContDades().getCatPC(cat);
        for(String cate: auxc)modelo2.addElement(cate);
    }
    private void visualitzaPagBut(JList quina){
        if(quina.getSelectedIndices().length>0 && !quina.getSelectedValue().toString().equals(noSelect)) {
            String hy = quina.getSelectedValue().toString();
            VPagina nova = new VPagina(pare, true, admin);
            nova.NomPag(hy);
        }
        else {
            JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna pagina de la llista!", capsalera, WARNING_MESSAGE);
        }
    }
    private void visualitzaCatBut(JList quina){
        if(quina.getSelectedIndices().length>0 && !quina.getSelectedValue().toString().equals(noSelect)) {
            String hy = quina.getSelectedValue().toString();
            VCategoria nova = new VCategoria(pare, true,admin);
            nova.NomCat(hy);
        }
        else {
            JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
        }
    }
    private void eliminabut(DefaultListModel mod, JList quina){
        if(mod.getSize()>0) mod.removeElementAt(quina.getSelectedIndex());
    }
    
    
    public void NomCat(String nomCateg) {
        cat = nomCateg;
        initComponents();
        A_VisualitzaCateg.setVisible(false);
        A_ModificaCateg.setVisible(false);
        A_VisualitzaCateg.setVisible(true);
        this.setAlwaysOnTop(false);
        this.setVisible(true);
    }
    /**
     * Creates new form VCategoria1
     */
    public VCategoria(java.awt.Frame parent, boolean modal, boolean adm) {
        super(parent, modal);
        pare = parent;
        admin = adm;
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        A_VisualitzaCateg = new javax.swing.JPanel();
        NomC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        butVisCat = new javax.swing.JButton();
        butVisuPag = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        CApunta = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        CApuntada = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        PApunta = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        PApuntada = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        butModifCat = new javax.swing.JButton();
        butElimCat = new javax.swing.JButton();
        butVisualCat = new javax.swing.JButton();
        butVisualPag = new javax.swing.JButton();
        A_ModificaCateg = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Nom = new javax.swing.JTextField();
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
        Enrere = new javax.swing.JButton();
        CbuscaPag = new javax.swing.JButton();
        Cbusca2 = new javax.swing.JTextField();
        Cbusca = new javax.swing.JTextField();
        CbuscaCat = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        A_VisualitzaCateg.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VisualitzaCategComponentShown(evt);
            }
        });

        NomC.setBackground(new java.awt.Color(255, 255, 255));
        NomC.setText(cat);
        NomC.setAutoscrolls(true);

        jLabel1.setText("Nom Categoria:");

        jLabel2.setBackground(new java.awt.Color(250, 250, 250));
        jLabel2.setText("Categories a les que apunta:");

        jLabel3.setText("Catgories que l'apunten:");

        jLabel4.setText("Pàgines a les que apunta:");

        jLabel5.setText("Pàgines que l'apunten:");

        butVisCat.setText("Visualitza Categoria");
        butVisCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butVisCatActionPerformed(evt);
            }
        });

        butVisuPag.setText("Visualitza Pàgina");
        butVisuPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butVisuPagActionPerformed(evt);
            }
        });

        CApunta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        CApunta.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(CApunta);

        CApuntada.setBorder(new javax.swing.border.MatteBorder(null));
        CApuntada.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(CApuntada);

        PApunta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PApunta.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(PApunta);

        PApuntada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PApuntada.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(PApuntada);

        butModifCat.setText("Modifica Categoria");
        butModifCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butModifCatActionPerformed(evt);
            }
        });

        butElimCat.setText("Eliminar Categoria");
        butElimCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butElimCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(butModifCat)
                .addGap(18, 18, 18)
                .addComponent(butElimCat)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(butModifCat)
                .addComponent(butElimCat))
        );

        butVisualCat.setText("Visualitzar Categoria");
        butVisualCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butVisualCatActionPerformed(evt);
            }
        });

        butVisualPag.setText("Visualitza Pagina");
        butVisualPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butVisualPagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_VisualitzaCategLayout = new javax.swing.GroupLayout(A_VisualitzaCateg);
        A_VisualitzaCateg.setLayout(A_VisualitzaCategLayout);
        A_VisualitzaCategLayout.setHorizontalGroup(
            A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(NomC, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                        .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                                .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane4)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(butVisCat, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                                        .addComponent(butVisuPag)
                                        .addGap(16, 16, 16)))))
                        .addGap(18, 18, 18)
                        .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(butVisualPag))
                            .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butVisualCat))
                            .addComponent(jLabel3))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        A_VisualitzaCategLayout.setVerticalGroup(
            A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NomC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                    .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                        .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butVisualCat)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                                .addComponent(butVisCat)
                                .addGap(148, 148, 148)
                                .addComponent(butVisuPag)))
                        .addGap(0, 196, Short.MAX_VALUE))
                    .addGroup(A_VisualitzaCategLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(A_VisualitzaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butVisualPag)
                            .addComponent(jScrollPane5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        A_ModificaCateg.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_ModificaCategComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_ModificaCategComponentShown(evt);
            }
        });

        jLabel6.setText("Nom de la categoria:");

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

        jLabel8.setText("Pàgines a les que apunta:");

        jLabel9.setText("Catgories que l'apunten:");

        CApuntada1.setModel(modelo1);
        CApuntada1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CApuntada1.setDragEnabled(true);
        CApuntada1.setDropMode(javax.swing.DropMode.INSERT);
        CApuntada1.setFocusable(false);
        CApuntada1.setValueIsAdjusting(true);
        jScrollPane8.setViewportView(CApuntada1);

        jLabel10.setText("Pàgines que l'apunten:");

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

        jLabel12.setText("Pàgines existents");

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

        Enrere.setText("Enrere");
        Enrere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnrereActionPerformed(evt);
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
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Enrere)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
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
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9)
                                    .addComponent(jButton10)
                                    .addComponent(AfegeixP1)
                                    .addComponent(AfegeixP2))))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        A_ModificaCategLayout.setVerticalGroup(
            A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_ModificaCategLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_ModificaCategLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Enrere)
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
                                .addGap(72, 72, 72)
                                .addComponent(AfegeixP1))
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
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(A_ModificaCategLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(A_VisualitzaCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(A_ModificaCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(A_VisualitzaCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(A_ModificaCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    * Es visualitza la categoria seleccionada de les categories a les que apunta
    */
    private void butVisCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butVisCatActionPerformed
        visualitzaCatBut(CApunta);
        CApunta.clearSelection();
    }//GEN-LAST:event_butVisCatActionPerformed
    /*
    * Es visualitza la pagina seleccionada de les pagines a les que apunta
    */
    private void butVisuPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butVisuPagActionPerformed
        visualitzaPagBut(PApunta);
        PApunta.clearSelection();
    }//GEN-LAST:event_butVisuPagActionPerformed
    /*
    * S'activa el panell de modificacio de la categoria actual
    */
    private void butModifCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butModifCatActionPerformed
        A_ModificaCateg.setVisible(true);
        A_VisualitzaCateg.setVisible(false);
    }//GEN-LAST:event_butModifCatActionPerformed
    /*
    * S'elimina la pagina actual de les dades
    */
    private void butElimCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butElimCatActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Segur que vols eliminar aquesta categoria?", capsalera, YES_NO_OPTION);
        if(resposta==YES_OPTION) {
            macro.getContDades().removeCateg(cat);
            vista.ompleCategoriesExistents(CategList);
            this.dispose();
        }
    }//GEN-LAST:event_butElimCatActionPerformed
    /*
    * Es visualitza la categoria seleccionada de les categories que apunten a la categoria actual
    */
    private void butVisualCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butVisualCatActionPerformed
        visualitzaCatBut(CApuntada);
        CApuntada.clearSelection();
    }//GEN-LAST:event_butVisualCatActionPerformed
    /*
    * Es visualitza la pagina seleccionada de les pagines que apunten a la categoria actual
    */
    private void butVisualPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butVisualPagActionPerformed
        visualitzaPagBut(PApuntada);
        PApuntada.clearSelection();
    }//GEN-LAST:event_butVisualPagActionPerformed
    /*
    * Es visualitza la categoria seleccionada de les categories a les que apunta
    */
    private void A_VisualitzaCategComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzaCategComponentShown
        omplirDades(CApunta ,CApuntada,PApunta,PApuntada);
    }//GEN-LAST:event_A_VisualitzaCategComponentShown
    /*
    * Elimina la categoria seleccionada de les categories a les que la categoria actual apunta
    */
    private void EliminaC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaC1ActionPerformed
        if(CApunta1.getSelectedIndex()>=0) eliminabut(modelom,CApunta1);
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_EliminaC1ActionPerformed
    /*
    * Elimina la categoria seleccionada de les categories que son apuntades per la categoria actual
    */
    private void EliminaC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaC2ActionPerformed
        if(CApuntada1.getSelectedIndex()>=0) eliminabut(modelo1,CApuntada1);
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_EliminaC2ActionPerformed
    /*
    * Elimina la pagina seleccionada de les pagines que apunten a la categoria actual
    */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(PApunta1.getSelectedIndex()>=0) eliminabut(modelo2,PApunta1);
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna pagina de la llista!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_jButton9ActionPerformed
    /*
    * Elimina la pagina seleccionada de les pagines que son apuntades per la categoria actual
    */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(PApuntada1.getSelectedIndex()>=0) eliminabut(modelo3,PApuntada1);
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna pagina de la llista!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_jButton10ActionPerformed
    /*
    * Afegeix la categoria seleccionada a les categories apuntades per a la categoria actual
    */
    private void AfegeixCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixCActionPerformed
        if(!modelom.contains(jList1.getSelectedValue()))modelom.addElement(jList1.getSelectedValue());
        jList1.clearSelection();
    }//GEN-LAST:event_AfegeixCActionPerformed
    /*
    * Afegeix la pagina seleccionada a les pagines que son apuntades per la categoria actual
    */
    private void AfegeixP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixP1ActionPerformed
        if(!modelo3.contains(jList2.getSelectedValue()))modelo3.addElement(jList2.getSelectedValue());
        jList2.clearSelection();
    }//GEN-LAST:event_AfegeixP1ActionPerformed
    /*
    * Afegeix la pagina seleccionada a les pagines apuntades per a la categoria actual
    */
    private void AfegeixP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixP2ActionPerformed
        if(!modelo2.contains(jList2.getSelectedValue()))modelo2.addElement(jList2.getSelectedValue());
        jList2.clearSelection();
    }//GEN-LAST:event_AfegeixP2ActionPerformed
    /*
    * Afegeix la categoria seleccionada a les categories a les que la categoria actual apunta
    */
    private void AfegeixC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixC1ActionPerformed
        if(!modelo1.contains(jList1.getSelectedValue()))modelo1.addElement(jList1.getSelectedValue());
        jList1.clearSelection();
    }//GEN-LAST:event_AfegeixC1ActionPerformed
    /*
    * Torna a la visualitzacio dels detalls de la categoria
    */
    private void EnrereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrereActionPerformed
        A_ModificaCateg.setVisible(false);
        A_VisualitzaCateg.setVisible(true);
    }//GEN-LAST:event_EnrereActionPerformed
    /*
    * Es restringeixen les pagines mostrades a aquelles que continguin el conjunt de lletres determinat
    */
    private void CbuscaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPagActionPerformed
        vista.omplePaginesExistentsConcret(jList2,Cbusca2);
    }//GEN-LAST:event_CbuscaPagActionPerformed
    /*
    * Es restringeixen les categories mostrades a aquelles que continguin el conjunt de lletres determinat
    */
    private void CbuscaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCatActionPerformed
        vista.ompleCategoriesExistentsConcret(jList1,Cbusca);
    }//GEN-LAST:event_CbuscaCatActionPerformed
    /*
    * Guarda els canvis de la categoria realitzats
    */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ArrayList<String> categs = new ArrayList<String>();
        for(int i = 0; i < modelom.size();++i) categs.add(modelom.getElementAt(i).toString());
        macro.getContDades().setCsubC(cat, categs);
        categs = new ArrayList<String>();
        for(int i = 0; i < modelo1.size();++i) categs.add(modelo1.getElementAt(i).toString());
        macro.getContDades().setCsupC(cat, categs);
        categs = new ArrayList<String>();
        for(int i = 0; i < modelo2.size();++i) categs.add(modelo2.getElementAt(i).toString());
        macro.getContDades().setCatPC(cat, categs);
        categs = new ArrayList<String>();
        for(int i = 0; i < modelo3.size();++i) categs.add(modelo3.getElementAt(i).toString());
        macro.getContDades().setCatCP(cat, categs);
        macro.getContDades().setNomCateg(cat, Nom.getText());
        cat = Nom.getText();
        A_VisualitzaCateg.setVisible(true);
        A_ModificaCateg.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed
    /*
    * Es fa una neteja dels components de modificacio d'una categoria
    */
    private void A_ModificaCategComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_ModificaCategComponentHidden
        modelom.removeAllElements();
        modelo1.removeAllElements();
        modelo2.removeAllElements();
        modelo3.removeAllElements();
    }//GEN-LAST:event_A_ModificaCategComponentHidden
    /*
    * Es mostren les caracteristiques de la categoria per tal de poder-les modificar
    */
    private void A_ModificaCategComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_ModificaCategComponentShown
        vista.omplePaginesExistents(jList2);
        vista.ompleCategoriesExistents(jList1);
        Nom.setText(cat);
        A_VisualitzaCateg.setVisible(false);
        omplirModificacions();
        A_ModificaCateg.setVisible(true);
    }//GEN-LAST:event_A_ModificaCategComponentShown

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
            java.util.logging.Logger.getLogger(VCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VCategoria dialog = new VCategoria(new javax.swing.JFrame(), true, admin);
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
    private javax.swing.JPanel A_ModificaCateg;
    private javax.swing.JPanel A_VisualitzaCateg;
    private javax.swing.JButton AfegeixC;
    private javax.swing.JButton AfegeixC1;
    private javax.swing.JButton AfegeixP1;
    private javax.swing.JButton AfegeixP2;
    private javax.swing.JList CApunta;
    private javax.swing.JList CApunta1;
    private DefaultListModel modelom;
    private javax.swing.JList CApuntada;
    private javax.swing.JList CApuntada1;
    private DefaultListModel modelo1;
    private javax.swing.JTextField Cbusca;
    private javax.swing.JTextField Cbusca2;
    private javax.swing.JButton CbuscaCat;
    private javax.swing.JButton CbuscaPag;
    private javax.swing.JButton EliminaC1;
    private javax.swing.JButton EliminaC2;
    private javax.swing.JButton Enrere;
    private javax.swing.JTextField Nom;
    private javax.swing.JLabel NomC;
    private javax.swing.JList PApunta;
    private javax.swing.JList PApunta1;
    private DefaultListModel modelo2;
    private javax.swing.JList PApuntada;
    private javax.swing.JList PApuntada1;
    private DefaultListModel modelo3;
    private javax.swing.JButton butElimCat;
    private javax.swing.JButton butModifCat;
    private javax.swing.JButton butVisCat;
    private javax.swing.JButton butVisuPag;
    private javax.swing.JButton butVisualCat;
    private javax.swing.JButton butVisualPag;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
