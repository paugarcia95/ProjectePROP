/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import static cercaComunitats.AlgorismeNewmanGirvan.arestes;
import static cercaComunitats.AlgorismeNewmanGirvan.iterador;
import domini.Categoria;
import domini.GrafDades;
import domini.MacroControlador;
import domini.Pagina;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.PriorityQueue;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Cristina
 */
public class InterficiaProva extends javax.swing.JFrame {
    static domini.MacroControlador macro;
    static Integer cercaactual;
    String algorisme;
    static Integer guardada;
    static String capsalera = "Wiki";
    //guardada=0 -> nova cerca sense guardar, crearla
    //guardada=1  -> cerca no guardada, preguntar si la volen guardar
    //guardada=2 -> cerca guardada
    //guardada=3 -> volem sobreescriue una cerca ja guardada
    Boolean primera; //variable per evitar excepcions en els pannels que tenen accions en amagar
    static ControladorVistes vista;
    static Frame comp;
    //private ProgressMonitor progressMonitor;
   private Thread hilo;
   private Timer timer;
   public static Boolean userAdmin;
   public static PriorityQueue<Integer> comunaEliminar;
   
    
    
    
    
   private void provisional(){
        Username.setText("admin");
        Password.setText("admin");
       
        macro.getContUser().addUser("admin", "admin");
	macro.getContUser().addUser("client", "client");
	macro.getContUser().addAdmin("admin");
        vista.jocProves1();
   }
   /**
     * Creates new form InterficiaProva
     */

    public InterficiaProva() {
        //macro = new domini.MacroControlador();
        primera=true;
        comunaEliminar = new PriorityQueue<>();
        macro = new MacroControlador();
        initComponents();
        A_BuscaCat.setVisible(false);
        A_BuscaCatPag.setVisible(false);
        A_BuscaPag.setVisible(false);
        A_CreaComunitat.setVisible(false);
        A_CreaUsuari.setVisible(false);
        A_GuardaCerca.setVisible(false);
        A_OpcionsAdmin.setVisible(false);
        A_OpcionsClient.setVisible(false);
        A_VeureUsers.setVisible(false);
        A_VisualitzaCerques.setVisible(false);
        A_VisualitzaNovaCerca.setVisible(false);
        this.setVisible(false);
        A_PantallaPrincipal.setVisible(false);
        jPanel1 = new Afegeix();
        jPanel1.setVisible(false);
        add(jPanel1);
        comp = this;
        vista = new ControladorVistes();
        userAdmin=false;
        provisional();
        
    }
    
    private void addAfegeix(){
        
    }
     public void login(){
        String user, pass;
        user= Username.getText();
        pass= Password.getText();
        if(!macro.getContUser().existsUser(user)) {
            JOptionPane.showMessageDialog(this, "L'username no existeix, torna'l a introduir o crea una nova conta.", capsalera, WARNING_MESSAGE);
        }
        else if(macro.getContUser().login(user, pass)){
            A_PantallaPrincipal.setVisible(false);
            macro.setUserActual(user);
            if(macro.getContUser().isAdmin(user)) A_OpcionsAdmin.setVisible(true);
            else A_OpcionsClient.setVisible(true);
            
        }
        else {
            JOptionPane.showMessageDialog(this, "La contrassenya es incorrecta.", capsalera, ERROR_MESSAGE);
        }
    }       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        A_PantallaPrincipal = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        Login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        A_CreaComunitat = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Cpc = new javax.swing.JTextField();
        Crelacio = new javax.swing.JSlider();
        Cbusca = new javax.swing.JTextField();
        Cafegeix1 = new javax.swing.JButton();
        CbuscaCat = new javax.swing.JButton();
        Csembla = new javax.swing.JSlider();
        CpcImp = new javax.swing.JSlider();
        EliminaCsub = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        LCTotes = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        modelo = new DefaultListModel();
        Lsub = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        LPTotes = new javax.swing.JList();
        Enrere2 = new javax.swing.JButton();
        Cbusca1 = new javax.swing.JTextField();
        Cafegeix2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        Cbusca2 = new javax.swing.JTextField();
        CbuscaPag = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        Cafegeix3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Cafegeix4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        modelo1 = new DefaultListModel();
        Lsub1 = new javax.swing.JList();
        modelo2 = new DefaultListModel();
        Lsub2 = new javax.swing.JList();
        CercaB = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Algorismes = new javax.swing.JTree();
        Cdada = new javax.swing.JSpinner();
        A_CreaUsuari = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        NouUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        NovaPassword = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Enrere1 = new javax.swing.JButton();
        A_OpcionsClient = new javax.swing.JPanel();
        Enrere3 = new javax.swing.JButton();
        BuscaCategories = new javax.swing.JButton();
        BuscaPagines = new javax.swing.JButton();
        BuscaCatPag = new javax.swing.JButton();
        CreaCerca = new javax.swing.JButton();
        VisualitzaCerquesFetes = new javax.swing.JButton();
        CanviaDadesUser = new javax.swing.JButton();
        AfegeixFitxer = new javax.swing.JButton();
        A_OpcionsAdmin = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        Enrere4 = new javax.swing.JButton();
        BuscaPagines1 = new javax.swing.JButton();
        BuscaCategories1 = new javax.swing.JButton();
        BuscaCatPag1 = new javax.swing.JButton();
        CreaCerca1 = new javax.swing.JButton();
        VisualitzaCerquesFetes1 = new javax.swing.JButton();
        CanviaDadesUser1 = new javax.swing.JButton();
        AfegeixFitxer1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        A_BuscaCat = new javax.swing.JPanel();
        Enrere5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        BVisCat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LlistaCateg = new javax.swing.JList();
        Cbusca6 = new javax.swing.JTextField();
        CbuscaPag3 = new javax.swing.JButton();
        A_BuscaPag = new javax.swing.JPanel();
        Enrere6 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        BVisPag = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LlistaPag = new javax.swing.JList();
        Cbusca5 = new javax.swing.JTextField();
        CbuscaPag2 = new javax.swing.JButton();
        A_BuscaCatPag = new javax.swing.JPanel();
        BVisPag1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        BVisCat1 = new javax.swing.JButton();
        Enrere7 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        LlistaCateg1 = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        LlistaPag1 = new javax.swing.JList();
        CbuscaCat1 = new javax.swing.JButton();
        Cbusca3 = new javax.swing.JTextField();
        Cbusca4 = new javax.swing.JTextField();
        CbuscaPag1 = new javax.swing.JButton();
        A_VeureUsers = new javax.swing.JPanel();
        Enrere8 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        modusers = new DefaultListModel();
        UsersAct = new javax.swing.JList();
        jButton19 = new javax.swing.JButton();
        A_VisualitzaNovaCerca = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Resultat = new javax.swing.JTree();
        Enrere9 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        CriterisNovaCerca = new javax.swing.JTextArea();
        jButton13 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        modelos = new DefaultListModel();
        Penjades = new javax.swing.JList();
        jButton20 = new javax.swing.JButton();
        A_GuardaCerca = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        Enrere10 = new javax.swing.JButton();
        A_VisualitzaCerques = new javax.swing.JPanel();
        Enrere = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        BVisCat2 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        LlistaCerques = new javax.swing.JList();
        A_VisualitzacioCercaAntiga = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        CriterisNovaCerca1 = new javax.swing.JTextArea();
        Enrere11 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        Resultat1 = new javax.swing.JTree();
        Enrere12 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        modelos1 = new DefaultListModel();
        Penjades1 = new javax.swing.JList();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        A_CanviaDadesUser = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        NouUsername1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        Enrere13 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        NovaPassword1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WIKIPEDIA");
        setLocationByPlatform(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jButton4.setText("Crea un nou usuari");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Benvingut al programa de la wikipedia");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jLabel1.setText("Si us plau, entra les teves dades. Si encara no tens cap usuari assignat, pots Crear-ne un de nou :)");

        jLabel2.setText("Username:");

        jLabel4.setText("Password:");

        javax.swing.GroupLayout A_PantallaPrincipalLayout = new javax.swing.GroupLayout(A_PantallaPrincipal);
        A_PantallaPrincipal.setLayout(A_PantallaPrincipalLayout);
        A_PantallaPrincipalLayout.setHorizontalGroup(
            A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel3))
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(Login))
                            .addComponent(jLabel1)
                            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                                        .addGap(263, 263, 263)
                                        .addComponent(Exit))
                                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        A_PantallaPrincipalLayout.setVerticalGroup(
            A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel3)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71)
                        .addComponent(Login)))
                .addGap(45, 45, 45)
                .addComponent(jButton4)
                .addGap(2, 2, 2)
                .addComponent(Exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Username.getAccessibleContext().setAccessibleName("Username");

        getContentPane().add(A_PantallaPrincipal, "card2");

        A_CreaComunitat.setAlignmentX(A_PantallaPrincipal.getAlignmentX());
        A_CreaComunitat.setAlignmentY(A_PantallaPrincipal.getAlignmentY());

        jLabel5.setText("Benvingut a la creació d'una nova Cerca de Comunitats!");

        jLabel6.setText("Si us plau, omple totes les dades amb un * i tingues en compte les restriccions de les altres");

        jLabel10.setText("Indica amb un numero del 0 al 10 la importància que li vols dnar a la relació entre categopries.");

        jLabel11.setText("0 només premia a les relacions amb les pàgines, un 5 premia igual les relacions cat-cat que les cat-pag i un 10 només premia les relacions cat-cat");

        jLabel12.setText("Indica amb un número del 0 al 10 la importància que li vols donar  a la semblança entre els noms de les categories");

        jLabel13.setText("Indica una paraula clau que vols que es tingui en compte i la seva importància:");

        jLabel14.setText("Un 0 si no en vols cap, un 5 per tal de que les categories que es tinguin en compte tinguin com a mínim la meitat d'aquesta paraula o 10 si l'han de contenir en la seva totalitat");

        jLabel15.setText("Selecciona unes quantes categories entre les quals vols que es faci la cerca");

        jLabel16.setText("Selecciona la categoria pare a partir de la qual es tenen en compte tots els seus fills");

        jLabel18.setText("Selecciona unes quantes categories i/o pàgines les quals vols ignorar");

        Crelacio.setForeground(new java.awt.Color(0, 0, 153));
        Crelacio.setMajorTickSpacing(1);
        Crelacio.setMaximum(10);
        Crelacio.setMinorTickSpacing(1);
        Crelacio.setPaintLabels(true);
        Crelacio.setPaintTicks(true);
        Crelacio.setSnapToTicks(true);
        Crelacio.setValue(5);
        Crelacio.setAutoscrolls(true);
        Crelacio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Crelacio.setInheritsPopupMenu(true);
        Crelacio.setValueIsAdjusting(true);

        Cafegeix1.setText("Afegeix");
        Cafegeix1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix1ActionPerformed(evt);
            }
        });

        CbuscaCat.setText("Busca");
        CbuscaCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaCatActionPerformed(evt);
            }
        });

        Csembla.setForeground(new java.awt.Color(0, 0, 153));
        Csembla.setMajorTickSpacing(1);
        Csembla.setMaximum(10);
        Csembla.setMinorTickSpacing(1);
        Csembla.setPaintLabels(true);
        Csembla.setPaintTicks(true);
        Csembla.setSnapToTicks(true);
        Csembla.setValue(5);
        Csembla.setAutoscrolls(true);
        Csembla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Csembla.setInheritsPopupMenu(true);
        Csembla.setValueIsAdjusting(true);

        CpcImp.setForeground(new java.awt.Color(0, 0, 153));
        CpcImp.setMajorTickSpacing(5);
        CpcImp.setMaximum(10);
        CpcImp.setMinorTickSpacing(5);
        CpcImp.setPaintLabels(true);
        CpcImp.setPaintTicks(true);
        CpcImp.setSnapToTicks(true);
        CpcImp.setValue(0);
        CpcImp.setAutoscrolls(true);
        CpcImp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CpcImp.setInheritsPopupMenu(true);
        CpcImp.setValueIsAdjusting(true);

        EliminaCsub.setText("Elimina");
        EliminaCsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaCsubActionPerformed(evt);
            }
        });

        LCTotes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(LCTotes);

        Lsub.setModel(modelo);
        Lsub.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lsub.setDragEnabled(true);
        Lsub.setDropMode(javax.swing.DropMode.INSERT);
        Lsub.setFocusable(false);
        Lsub.setValueIsAdjusting(true);
        jScrollPane6.setViewportView(Lsub);

        LPTotes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(LPTotes);

        Enrere2.setText("Enrere");
        Enrere2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere2ActionPerformed(evt);
            }
        });

        Cafegeix2.setText("Afegeix");
        Cafegeix2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix2ActionPerformed(evt);
            }
        });

        jLabel19.setText("Categories");

        CbuscaPag.setText("Busca");
        CbuscaPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPagActionPerformed(evt);
            }
        });

        jLabel20.setText("Pagines");

        Cafegeix3.setText("Afegeix");
        Cafegeix3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix3ActionPerformed(evt);
            }
        });

        jButton9.setText("Elimina");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel21.setText("Categories");

        jLabel22.setText("Pagines");

        Cafegeix4.setText("Afegeix");
        Cafegeix4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix4ActionPerformed(evt);
            }
        });

        jButton11.setText("Elimina");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        Lsub1.setModel(modelo1);
        Lsub1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lsub1.setDragEnabled(true);
        Lsub1.setDropMode(javax.swing.DropMode.INSERT);
        Lsub1.setFocusable(false);
        Lsub1.setValueIsAdjusting(true);

        Lsub2.setModel(modelo2);
        Lsub2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lsub2.setDragEnabled(true);
        Lsub2.setDropMode(javax.swing.DropMode.INSERT);
        Lsub2.setFocusable(false);
        Lsub2.setValueIsAdjusting(true);

        CercaB.setText("Fer Cerca!");
        CercaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CercaBActionPerformed(evt);
            }
        });

        jLabel23.setText("Algorisme:");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Algorismes");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Louvain");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Newman-Girvan");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Numero Categories");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Maxima Between");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Cliqué");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        Algorismes.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Algorismes.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                AlgorismesValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(Algorismes);

        Cdada.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout A_CreaComunitatLayout = new javax.swing.GroupLayout(A_CreaComunitat);
        A_CreaComunitat.setLayout(A_CreaComunitatLayout);
        A_CreaComunitatLayout.setHorizontalGroup(
            A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                .addGap(383, 383, 383)
                                .addComponent(jLabel5))
                            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(CercaB)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Enrere2)
                        .addGap(170, 170, 170))
                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CpcImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                        .addComponent(Cpc, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Cdada, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Crelacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10)
                                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(Cbusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Cafegeix2))
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel14))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(Csembla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cafegeix1)
                            .addComponent(EliminaCsub)))
                    .addComponent(jLabel15)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_CreaComunitatLayout.createSequentialGroup()
                        .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaCat))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_CreaComunitatLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7)
                            .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaPag)))
                .addGap(22, 22, 22))
            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lsub1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cafegeix3)
                    .addComponent(jButton9))
                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22))
                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Lsub2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cafegeix4)
                            .addComponent(jButton11))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        A_CreaComunitatLayout.setVerticalGroup(
            A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(CercaB))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(Crelacio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23)
                                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(Csembla, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Cpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addComponent(CpcImp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(Cbusca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Cafegeix2)))
                                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Cdada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18))
                                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel19)))))
                            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(Enrere2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                        .addComponent(Cafegeix1)
                                        .addGap(31, 31, 31)
                                        .addComponent(EliminaCsub))
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(CbuscaPag))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(CbuscaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_CreaComunitatLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cafegeix3)
                    .addComponent(Lsub1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lsub2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cafegeix4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9)
                        .addComponent(jLabel21))
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(A_CreaComunitat, "card3");

        jLabel7.setText("Creació d'un nou usuari");

        NouUsername.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                NouUsernameComponentShown(evt);
            }
        });

        jLabel8.setText("Username");

        jButton1.setText("Comproba Disponibilitat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Password");

        jButton2.setText("Crea");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Enrere1.setText("Enrere");
        Enrere1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_CreaUsuariLayout = new javax.swing.GroupLayout(A_CreaUsuari);
        A_CreaUsuari.setLayout(A_CreaUsuariLayout);
        A_CreaUsuariLayout.setHorizontalGroup(
            A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel7))
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(jButton2))
                                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(38, 38, 38)
                                        .addComponent(NouUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addComponent(jButton1))
                            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(40, 40, 40)
                                .addComponent(NovaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(Enrere1)))))
                .addContainerGap(1061, Short.MAX_VALUE))
        );
        A_CreaUsuariLayout.setVerticalGroup(
            A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NouUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_CreaUsuariLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(NovaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Enrere1)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)))
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(A_CreaUsuari, "card4");

        Enrere3.setText("Enrere");
        Enrere3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere3ActionPerformed(evt);
            }
        });

        BuscaCategories.setText("Busca entre les Categories");
        BuscaCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaCategoriesActionPerformed(evt);
            }
        });

        BuscaPagines.setText("Busca entre les Pàgines");
        BuscaPagines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaPaginesActionPerformed(evt);
            }
        });

        BuscaCatPag.setText("Busca entre les Categories i Pàgines");
        BuscaCatPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaCatPagActionPerformed(evt);
            }
        });

        CreaCerca.setText("Crea una nova Cerca de Comunitats ");
        CreaCerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreaCercaActionPerformed(evt);
            }
        });

        VisualitzaCerquesFetes.setText("Visualitza Cerques realitzades anteriorment");
        VisualitzaCerquesFetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualitzaCerquesFetesActionPerformed(evt);
            }
        });

        CanviaDadesUser.setText("Canvia les dades d'usuari");
        CanviaDadesUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanviaDadesUserActionPerformed(evt);
            }
        });

        AfegeixFitxer.setText("Afegeix fitxer");
        AfegeixFitxer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixFitxerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_OpcionsClientLayout = new javax.swing.GroupLayout(A_OpcionsClient);
        A_OpcionsClient.setLayout(A_OpcionsClientLayout);
        A_OpcionsClientLayout.setHorizontalGroup(
            A_OpcionsClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_OpcionsClientLayout.createSequentialGroup()
                .addComponent(AfegeixFitxer)
                .addGap(0, 1433, Short.MAX_VALUE))
            .addGroup(A_OpcionsClientLayout.createSequentialGroup()
                .addGroup(A_OpcionsClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BuscaCatPag, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(A_OpcionsClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BuscaPagines, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BuscaCategories, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CreaCerca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VisualitzaCerquesFetes, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                        .addComponent(CanviaDadesUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(150, 150, 150)
                .addComponent(Enrere3)
                .addContainerGap(816, Short.MAX_VALUE))
        );
        A_OpcionsClientLayout.setVerticalGroup(
            A_OpcionsClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_OpcionsClientLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(AfegeixFitxer)
                .addGap(18, 18, 18)
                .addComponent(BuscaCategories)
                .addGroup(A_OpcionsClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_OpcionsClientLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BuscaPagines))
                    .addGroup(A_OpcionsClientLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(Enrere3)))
                .addGap(18, 18, 18)
                .addComponent(BuscaCatPag)
                .addGap(21, 21, 21)
                .addComponent(CreaCerca)
                .addGap(18, 18, 18)
                .addComponent(VisualitzaCerquesFetes)
                .addGap(18, 18, 18)
                .addComponent(CanviaDadesUser)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        getContentPane().add(A_OpcionsClient, "card5");

        jButton8.setText("Visualitza Users");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        Enrere4.setText("Enrere");
        Enrere4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere4ActionPerformed(evt);
            }
        });

        BuscaPagines1.setText("Busca entre les Pàgines");
        BuscaPagines1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaPagines1ActionPerformed(evt);
            }
        });

        BuscaCategories1.setText("Busca entre les Categories");
        BuscaCategories1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaCategories1ActionPerformed(evt);
            }
        });

        BuscaCatPag1.setText("Busca entre les Categories i Pàgines");
        BuscaCatPag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaCatPag1ActionPerformed(evt);
            }
        });

        CreaCerca1.setText("Crea una nova Cerca de Comunitats ");
        CreaCerca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreaCerca1ActionPerformed(evt);
            }
        });

        VisualitzaCerquesFetes1.setText("Visualitza Cerques realitzades anteriorment");
        VisualitzaCerquesFetes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualitzaCerquesFetes1ActionPerformed(evt);
            }
        });

        CanviaDadesUser1.setText("Canvia les dades d'usuari");
        CanviaDadesUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanviaDadesUser1ActionPerformed(evt);
            }
        });

        AfegeixFitxer1.setText("Afegeix fitxer");
        AfegeixFitxer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfegeixFitxer1ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar dades");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton16.setText("Afegeix dades");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_OpcionsAdminLayout = new javax.swing.GroupLayout(A_OpcionsAdmin);
        A_OpcionsAdmin.setLayout(A_OpcionsAdminLayout);
        A_OpcionsAdminLayout.setHorizontalGroup(
            A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AfegeixFitxer1)
                    .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                        .addGroup(A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BuscaCatPag1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(BuscaPagines1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BuscaCategories1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CreaCerca1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VisualitzaCerquesFetes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CanviaDadesUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Enrere4))
                    .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        A_OpcionsAdminLayout.setVerticalGroup(
            A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton5)
                    .addComponent(jButton16))
                .addGap(18, 18, 18)
                .addComponent(AfegeixFitxer1)
                .addGroup(A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BuscaCategories1))
                    .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(Enrere4)))
                .addGap(18, 18, 18)
                .addComponent(BuscaPagines1)
                .addGap(33, 33, 33)
                .addComponent(BuscaCatPag1)
                .addGap(21, 21, 21)
                .addComponent(CreaCerca1)
                .addGap(18, 18, 18)
                .addComponent(VisualitzaCerquesFetes1)
                .addGap(18, 18, 18)
                .addComponent(CanviaDadesUser1)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        getContentPane().add(A_OpcionsAdmin, "card6");

        A_BuscaCat.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_BuscaCatComponentShown(evt);
            }
        });

        Enrere5.setText("Enrere");
        Enrere5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere5ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(240, 240, 240));
        jTextField1.setText("Aquestes són les categories existents:");

        BVisCat.setText("Visualitza");
        BVisCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVisCatActionPerformed(evt);
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

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTextField1, org.jdesktop.beansbinding.ObjectProperty.create(), LlistaCateg, org.jdesktop.beansbinding.BeanProperty.create("elements"));
        binding.setSourceNullValue(null);
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(LlistaCateg);
        LlistaCateg.getAccessibleContext().setAccessibleName("LlistaCateg");

        Cbusca6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbusca6ActionPerformed(evt);
            }
        });

        CbuscaPag3.setText("Busca");
        CbuscaPag3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPag3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_BuscaCatLayout = new javax.swing.GroupLayout(A_BuscaCat);
        A_BuscaCat.setLayout(A_BuscaCatLayout);
        A_BuscaCatLayout.setHorizontalGroup(
            A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaCatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaCatLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Enrere5))
                    .addGroup(A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(A_BuscaCatLayout.createSequentialGroup()
                            .addComponent(Cbusca6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CbuscaPag3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BVisCat))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        A_BuscaCatLayout.setVerticalGroup(
            A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaCatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Enrere5))
                .addGap(23, 23, 23)
                .addGroup(A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cbusca6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CbuscaPag3)
                        .addComponent(BVisCat)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        getContentPane().add(A_BuscaCat, "card7");

        A_BuscaPag.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_BuscaPagComponentShown(evt);
            }
        });

        Enrere6.setText("Enrere");
        Enrere6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere6ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(240, 240, 240));
        jTextField2.setText("Aquestes són les pàgines existents:");

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
        LlistaPag.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                LlistaPagComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(LlistaPag);

        Cbusca5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbusca5ActionPerformed(evt);
            }
        });

        CbuscaPag2.setText("Busca");
        CbuscaPag2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPag2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_BuscaPagLayout = new javax.swing.GroupLayout(A_BuscaPag);
        A_BuscaPag.setLayout(A_BuscaPagLayout);
        A_BuscaPagLayout.setHorizontalGroup(
            A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaPagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(A_BuscaPagLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Enrere6))
                    .addGroup(A_BuscaPagLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BVisPag))
                    .addGroup(A_BuscaPagLayout.createSequentialGroup()
                        .addComponent(Cbusca5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaPag2)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        A_BuscaPagLayout.setVerticalGroup(
            A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaPagLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cbusca5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbuscaPag2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Enrere6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BVisPag)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        getContentPane().add(A_BuscaPag, "card8");

        A_BuscaCatPag.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_BuscaCatPagComponentShown(evt);
            }
        });

        BVisPag1.setText("Visualitza");
        BVisPag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVisPag1ActionPerformed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(240, 240, 240));
        jTextField3.setText("Aquestes són les pàgines existents:");

        BVisCat1.setText("Visualitza");
        BVisCat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVisCat1ActionPerformed(evt);
            }
        });

        Enrere7.setText("Enrere");
        Enrere7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere7ActionPerformed(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(240, 240, 240));
        jTextField4.setText("Aquestes són les categories existents:");

        LlistaCateg1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));
        LlistaCateg1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LlistaCateg1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(LlistaCateg1);

        LlistaPag1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));
        LlistaPag1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LlistaPag1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(LlistaPag1);

        CbuscaCat1.setText("Busca");
        CbuscaCat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaCat1ActionPerformed(evt);
            }
        });

        Cbusca4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbusca4ActionPerformed(evt);
            }
        });

        CbuscaPag1.setText("Busca");
        CbuscaPag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPag1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_BuscaCatPagLayout = new javax.swing.GroupLayout(A_BuscaCatPag);
        A_BuscaCatPag.setLayout(A_BuscaCatPagLayout);
        A_BuscaCatPagLayout.setHorizontalGroup(
            A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addComponent(Cbusca3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaCat1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(BVisCat1)))
                .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(BVisPag1))
                            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                                .addComponent(Enrere7)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(Cbusca4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaPag1)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        A_BuscaCatPagLayout.setVerticalGroup(
            A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cbusca4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbuscaPag1)))
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cbusca3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbuscaCat1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BVisPag1))
                            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(Enrere7))
                            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BVisCat1)))))
                .addGap(387, 387, 387))
        );

        getContentPane().add(A_BuscaCatPag, "card9");

        A_VeureUsers.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_VeureUsersComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VeureUsersComponentShown(evt);
            }
        });

        Enrere8.setText("Enrere");
        Enrere8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere8ActionPerformed(evt);
            }
        });

        jLabel17.setText("Aquests són els usuaris actuals:");

        jButton17.setText("Elimina");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Fer Admin");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        UsersAct.setModel(modusers);
        UsersAct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        UsersAct.setDragEnabled(true);
        UsersAct.setDropMode(javax.swing.DropMode.INSERT);
        UsersAct.setFocusable(false);
        UsersAct.setValueIsAdjusting(true);

        jButton19.setText("Crea un nou usuari Administrador");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_VeureUsersLayout = new javax.swing.GroupLayout(A_VeureUsers);
        A_VeureUsers.setLayout(A_VeureUsersLayout);
        A_VeureUsersLayout.setHorizontalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addComponent(UsersAct, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton17))
                            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton19)
                                    .addComponent(Enrere8)
                                    .addComponent(jButton18))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(93, 93, 93))))
        );
        A_VeureUsersLayout.setVerticalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGroup(A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(UsersAct, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Enrere8)
                        .addContainerGap(50, Short.MAX_VALUE))))
        );

        getContentPane().add(A_VeureUsers, "card10");

        A_VisualitzaNovaCerca.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_VisualitzaNovaCercaComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VisualitzaNovaCercaComponentShown(evt);
            }
        });

        Resultat.setAutoscrolls(true);
        Resultat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Resultat.setLargeModel(true);
        Resultat.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                ResultatMouseDragged(evt);
            }
        });
        jScrollPane9.setViewportView(Resultat);

        Enrere9.setText("Modificar Criteris");
        Enrere9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere9ActionPerformed(evt);
            }
        });

        CriterisNovaCerca.setBackground(new java.awt.Color(240, 240, 240));
        CriterisNovaCerca.setColumns(20);
        CriterisNovaCerca.setRows(5);
        jScrollPane11.setViewportView(CriterisNovaCerca);

        jButton13.setText("Guardar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton10.setText("<<<<");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setText(">>>>");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        Penjades.setModel(modelos);
        Penjades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Penjades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Penjades.setDragEnabled(true);
        Penjades.setDropMode(javax.swing.DropMode.INSERT);
        Penjades.setFocusable(false);
        Penjades.setValueIsAdjusting(true);

        jButton20.setText("Afegir Comunitat");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_VisualitzaNovaCercaLayout = new javax.swing.GroupLayout(A_VisualitzaNovaCerca);
        A_VisualitzaNovaCerca.setLayout(A_VisualitzaNovaCercaLayout);
        A_VisualitzaNovaCercaLayout.setHorizontalGroup(
            A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                        .addComponent(Enrere9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13))
                    .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10)
                            .addComponent(jButton12)
                            .addComponent(jButton20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Penjades, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(517, Short.MAX_VALUE))
        );
        A_VisualitzaNovaCercaLayout.setVerticalGroup(
            A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                        .addGroup(A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Enrere9)
                            .addComponent(jButton13))
                        .addGroup(A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jButton10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20))
                            .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Penjades, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(A_VisualitzaNovaCerca, "card11");

        A_GuardaCerca.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_GuardaCercaComponentShown(evt);
            }
        });

        jLabel24.setText("Si us plau, introdueixi les seguents dades:");

        jLabel25.setText("Nom:");

        jLabel26.setText("Comentari:");

        jButton14.setText("Guardar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        Enrere10.setText("Enrere");
        Enrere10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_GuardaCercaLayout = new javax.swing.GroupLayout(A_GuardaCerca);
        A_GuardaCerca.setLayout(A_GuardaCercaLayout);
        A_GuardaCercaLayout.setHorizontalGroup(
            A_GuardaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_GuardaCercaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Enrere10)
                .addGap(46, 46, 46))
            .addGroup(A_GuardaCercaLayout.createSequentialGroup()
                .addGroup(A_GuardaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_GuardaCercaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(A_GuardaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_GuardaCercaLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(A_GuardaCercaLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(24, 24, 24)
                                .addGroup(A_GuardaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)))))
                    .addGroup(A_GuardaCercaLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButton14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        A_GuardaCercaLayout.setVerticalGroup(
            A_GuardaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_GuardaCercaLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(A_GuardaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(A_GuardaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(Enrere10)
                .addGap(7, 7, 7)
                .addComponent(jButton14)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        getContentPane().add(A_GuardaCerca, "card12");

        A_VisualitzaCerques.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_VisualitzaCerquesComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VisualitzaCerquesComponentShown(evt);
            }
        });

        Enrere.setText("Enrere");
        Enrere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnrereActionPerformed(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(240, 240, 240));
        jTextField7.setText("Cerques realitzades:");

        BVisCat2.setText("Visualitza");
        BVisCat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVisCat2ActionPerformed(evt);
            }
        });

        jScrollPane12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane12.setAutoscrolls(true);

        LlistaCerques.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));
        LlistaCerques.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LlistaCerques.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane12.setViewportView(LlistaCerques);

        javax.swing.GroupLayout A_VisualitzaCerquesLayout = new javax.swing.GroupLayout(A_VisualitzaCerques);
        A_VisualitzaCerques.setLayout(A_VisualitzaCerquesLayout);
        A_VisualitzaCerquesLayout.setHorizontalGroup(
            A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzaCerquesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BVisCat2)
                    .addComponent(Enrere))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        A_VisualitzaCerquesLayout.setVerticalGroup(
            A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzaCerquesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzaCerquesLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(BVisCat2)
                        .addGap(18, 18, 18)
                        .addComponent(Enrere))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_VisualitzaCerquesLayout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(A_VisualitzaCerques, "card13");

        A_VisualitzacioCercaAntiga.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_VisualitzacioCercaAntigaComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VisualitzacioCercaAntigaComponentShown(evt);
            }
        });

        CriterisNovaCerca1.setBackground(new java.awt.Color(240, 240, 240));
        CriterisNovaCerca1.setColumns(20);
        CriterisNovaCerca1.setRows(5);
        jScrollPane13.setViewportView(CriterisNovaCerca1);

        Enrere11.setText("Modificar Criteris");
        Enrere11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere11ActionPerformed(evt);
            }
        });

        jButton15.setText("Modificar Nom");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        Resultat1.setAutoscrolls(true);
        Resultat1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Resultat1.setLargeModel(true);
        jScrollPane14.setViewportView(Resultat1);

        Enrere12.setText("Enrere");
        Enrere12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere12ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar Comentari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton21.setText("Afegir Comunitat");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        Penjades1.setModel(modelos1);
        Penjades1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Penjades1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Penjades1.setDragEnabled(true);
        Penjades1.setDropMode(javax.swing.DropMode.INSERT);
        Penjades1.setFocusable(false);
        Penjades1.setValueIsAdjusting(true);

        jButton22.setText("<<<<");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText(">>>>");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_VisualitzacioCercaAntigaLayout = new javax.swing.GroupLayout(A_VisualitzacioCercaAntiga);
        A_VisualitzacioCercaAntiga.setLayout(A_VisualitzacioCercaAntigaLayout);
        A_VisualitzacioCercaAntigaLayout.setHorizontalGroup(
            A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                        .addComponent(Enrere11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(Enrere12))
                    .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                        .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton22)
                            .addComponent(jButton23)
                            .addComponent(jButton21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Penjades1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        A_VisualitzacioCercaAntigaLayout.setVerticalGroup(
            A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                        .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Enrere11)
                            .addComponent(jButton15)
                            .addComponent(jButton3)
                            .addComponent(Enrere12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane13)
                            .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                                .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(jButton22)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton23)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton21))
                                    .addComponent(Penjades1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(A_VisualitzacioCercaAntiga, "card14");

        A_CanviaDadesUser.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_CanviaDadesUserComponentShown(evt);
            }
        });

        jLabel27.setText("Si us plau, introdueixi les noves dades d'usuari desitjades:");

        jButton6.setText("Canvia");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        Enrere13.setText("Enrere");
        Enrere13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere13ActionPerformed(evt);
            }
        });

        jLabel28.setText("Password");

        jLabel29.setText("Username");

        jButton7.setText("Comproba Disponibilitat");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_CanviaDadesUserLayout = new javax.swing.GroupLayout(A_CanviaDadesUser);
        A_CanviaDadesUser.setLayout(A_CanviaDadesUserLayout);
        A_CanviaDadesUserLayout.setHorizontalGroup(
            A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CanviaDadesUserLayout.createSequentialGroup()
                .addGroup(A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_CanviaDadesUserLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel27))
                    .addGroup(A_CanviaDadesUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_CanviaDadesUserLayout.createSequentialGroup()
                                .addGroup(A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_CanviaDadesUserLayout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(jButton6))
                                    .addGroup(A_CanviaDadesUserLayout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(38, 38, 38)
                                        .addComponent(NouUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addComponent(jButton7))
                            .addGroup(A_CanviaDadesUserLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(40, 40, 40)
                                .addComponent(NovaPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(Enrere13)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        A_CanviaDadesUserLayout.setVerticalGroup(
            A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CanviaDadesUserLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel27)
                .addGap(28, 28, 28)
                .addGroup(A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NouUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jButton7))
                .addGroup(A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_CanviaDadesUserLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(NovaPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(A_CanviaDadesUserLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Enrere13)
                            .addComponent(jLabel28))
                        .addGap(26, 26, 26)))
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(A_CanviaDadesUser, "card15");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, "card16");

        getAccessibleContext().setAccessibleDescription("");

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        login();
    }//GEN-LAST:event_LoginActionPerformed
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        A_PantallaPrincipal.setVisible(false);
        A_CreaUsuari.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed
    private void Enrere3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere3ActionPerformed
        A_PantallaPrincipal.setVisible(true);
        A_OpcionsClient.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_Enrere3ActionPerformed
    private void BuscaCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaCategoriesActionPerformed
        A_OpcionsClient.setVisible(false);
        A_BuscaCat.setVisible(true); 
    }//GEN-LAST:event_BuscaCategoriesActionPerformed
    private void BuscaCatPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaCatPagActionPerformed
        A_OpcionsClient.setVisible(false);
        A_BuscaCatPag.setVisible(true);
    }//GEN-LAST:event_BuscaCatPagActionPerformed
    private void Enrere5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere5ActionPerformed
       A_BuscaCat.setVisible(false);
       if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
        else A_OpcionsClient.setVisible(true);
    }//GEN-LAST:event_Enrere5ActionPerformed
    private void BVisCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisCatActionPerformed
        vista.visualitzarCategoriaDe(LlistaCateg);
        LlistaCateg.clearSelection();
    }//GEN-LAST:event_BVisCatActionPerformed
    private void BuscaPaginesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaPaginesActionPerformed
       A_OpcionsClient.setVisible(false);
       A_BuscaPag.setVisible(true);
    }//GEN-LAST:event_BuscaPaginesActionPerformed
    private void Enrere6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere6ActionPerformed
       A_BuscaPag.setVisible(false);
       if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
        else A_OpcionsClient.setVisible(true);
    }//GEN-LAST:event_Enrere6ActionPerformed
    private void BVisPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisPagActionPerformed
        vista.visualitzarPaginaDe(LlistaPag);
        LlistaPag.clearSelection();
    }//GEN-LAST:event_BVisPagActionPerformed
    private void BVisPag1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisPag1ActionPerformed
       vista.visualitzarPaginaDe(LlistaPag1);
       LlistaPag1.clearSelection();
    }//GEN-LAST:event_BVisPag1ActionPerformed
    private void BVisCat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisCat1ActionPerformed
        vista.visualitzarCategoriaDe(LlistaCateg1);
        LlistaCateg1.clearSelection();
    }//GEN-LAST:event_BVisCat1ActionPerformed
    private void Enrere7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere7ActionPerformed
        A_BuscaCatPag.setVisible(false);
        if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
        else A_OpcionsClient.setVisible(true);
    }//GEN-LAST:event_Enrere7ActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vista.comprovaUsername(NouUsername);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void Enrere1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere1ActionPerformed
        A_CreaUsuari.setVisible(false);
        A_PantallaPrincipal.setVisible(true);
    }//GEN-LAST:event_Enrere1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        vista.creaUserNou(NouUsername, NovaPassword);
        if(userAdmin) {
                userAdmin=false;
                A_OpcionsAdmin.setVisible(true);
        }
        else A_PantallaPrincipal.setVisible(true);
        A_CreaUsuari.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void CreaCercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreaCercaActionPerformed
        vista.preaparaCreacioNovaCerca(false, LCTotes, LPTotes, Algorismes, Lsub, Lsub2, Lsub1, Cbusca1, Cpc, CpcImp, Csembla, Crelacio, Cdada);
        if(macro.getContAdUs().getNumCats()> 0) A_CreaComunitat.setVisible(true);
        A_OpcionsClient.setVisible(false);
    }//GEN-LAST:event_CreaCercaActionPerformed

    private void CanviaDadesUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanviaDadesUserActionPerformed
        A_CanviaDadesUser.setVisible(true);
        A_OpcionsClient.setVisible(false);
    }//GEN-LAST:event_CanviaDadesUserActionPerformed
    private void CbuscaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCatActionPerformed
        ControladorVistes aux = new ControladorVistes();
        aux.ompleCategoriesExistentsConcret(LCTotes,Cbusca);
    }//GEN-LAST:event_CbuscaCatActionPerformed
    private void Cafegeix1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix1ActionPerformed
     	if(LCTotes.getSelectedIndex()>=0) {
            if(!modelo.contains(LCTotes.getSelectedValue())) modelo.addElement(LCTotes.getSelectedValue());
            LCTotes.clearSelection();
        }
        else {
            JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista de categories!", capsalera, WARNING_MESSAGE);
        }
        //System.out.println(LCTotes.getSelectedValue());
    }//GEN-LAST:event_Cafegeix1ActionPerformed
    private void EliminaCsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaCsubActionPerformed
          if(modelo.getSize()>0){
              int n = Lsub.getSelectedIndex();
              modelo.removeElementAt(n);
          }
          Lsub.clearSelection();
    }//GEN-LAST:event_EliminaCsubActionPerformed
    private void AfegeixFitxerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixFitxerActionPerformed
        vista.afegirFitxer();
    }//GEN-LAST:event_AfegeixFitxerActionPerformed
    private void Enrere2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere2ActionPerformed
        if(guardada==1){
           int resposta = JOptionPane.showConfirmDialog(this, "Vols guardar la cerca actual?", capsalera, YES_NO_OPTION);
           if(YES_OPTION ==resposta) {
               A_CreaComunitat.setVisible(false);
               A_GuardaCerca.setVisible(true);
           }
           else {
               A_CreaComunitat.setVisible(false);
               macro.getContUser().removeCerca(macro.getUserActual(), cercaactual);
               if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
               else A_OpcionsClient.setVisible(true);
           }
        }
        else {
            A_CreaComunitat.setVisible(false);
            if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
            else A_OpcionsClient.setVisible(true);
        }
    }//GEN-LAST:event_Enrere2ActionPerformed
    private void CbuscaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPagActionPerformed
        ControladorVistes aux = new ControladorVistes();
        aux.omplePaginesExistentsConcret(LPTotes,Cbusca2);
    }//GEN-LAST:event_CbuscaPagActionPerformed
    private void Cafegeix2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix2ActionPerformed
       Cbusca1.setText(LCTotes.getSelectedValue().toString());
    }//GEN-LAST:event_Cafegeix2ActionPerformed
    private void Cafegeix3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix3ActionPerformed
        if(!modelo1.contains(LCTotes.getSelectedValue())) modelo1.addElement(LCTotes.getSelectedValue());
        LCTotes.clearSelection();
    }//GEN-LAST:event_Cafegeix3ActionPerformed
    private void Cafegeix4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix4ActionPerformed
        if(!modelo2.contains(LPTotes.getSelectedValue()))modelo2.addElement(LPTotes.getSelectedValue());
        LPTotes.clearSelection();
    }//GEN-LAST:event_Cafegeix4ActionPerformed
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(modelo1.getSize()>0){
              int n = Lsub1.getSelectedIndex();
              modelo1.removeElementAt(n);
          }
        Lsub1.clearSelection();
    }//GEN-LAST:event_jButton9ActionPerformed
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(modelo2.getSize()>0){
              int n = Lsub2.getSelectedIndex();
              modelo2.removeElementAt(n);
          }
        Lsub2.clearSelection();
    }//GEN-LAST:event_jButton11ActionPerformed
class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            if (/*progressMonitor.isCanceled() ||*/ !hilo.isAlive()) {
                //progressMonitor.close();
                //hilo.interrupt();
                Toolkit.getDefaultToolkit().beep();
                timer.stop();
            
           } /* else {
                progressMonitor.setNote(iterador.toString());
                progressMonitor.setProgress(iterador);
                //taskOutput.append(task.getMessage() + newline);
               // taskOutput.setCaretPosition(taskOutput.getDocument().getLength());
            }*/
        }
    }
    private void CercaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CercaBActionPerformed
        Runnable cerca = new Runnable() {
        public void run() {
          try{
           if(vista.ferCerca(Algorismes, Cdada, Lsub, Lsub2, Lsub1, CpcImp, Cpc, Csembla, Crelacio, Cbusca1)) {
            System.out.println("Hi vaig x el codi normal");
            Crelacio.setEnabled(true);
            Csembla.setEnabled(true);
            Cpc.setEnabled(true);
            CpcImp.setEnabled(true);
            Cafegeix1.setEnabled(true);
            Cafegeix2.setEnabled(true);
            Cafegeix3.setEnabled(true);
            Cafegeix4.setEnabled(true);
            CercaB.setEnabled(true);
                
            if(A_CreaComunitat.isVisible()) {
                vista.visualitzaCerca(false,Resultat, CriterisNovaCerca);
                A_CreaComunitat.setVisible(false);
                if(guardada==3) A_VisualitzacioCercaAntiga.setVisible(true);
                else {
                    guardada=1;
                        A_VisualitzaNovaCerca.setVisible(true);
                        }
            }
            else {
                int resposta = JOptionPane.showConfirmDialog(comp, "La cerca ja ha acabat. vols visualitzar-la ara?", capsalera, YES_NO_OPTION);
             if(YES_OPTION ==resposta) {
                 guardada=1;
                vista.visualitzaCerca(false,Resultat, CriterisNovaCerca);
                A_BuscaCat.setVisible(false);
                A_BuscaCatPag.setVisible(false);
                A_BuscaPag.setVisible(false);
                A_CreaComunitat.setVisible(false);
                A_CreaUsuari.setVisible(false);
                A_GuardaCerca.setVisible(false);
                A_OpcionsAdmin.setVisible(false);
                A_OpcionsClient.setVisible(false);
                A_VeureUsers.setVisible(false);
                A_VisualitzaCerques.setVisible(false);
                A_VisualitzaNovaCerca.setVisible(true);
                //System.out.println("ETS PUTU SUBNORMAL NETBEANS");
               }
             else {
                 //System.out.println("Ha clicat que no la vol veure ara");
                 String[] options = {"OK"};
                JPanel panel = new NomCercaPanel();
                JLabel lbl = new JLabel("Quin nom li vols posar?: ");
                JTextField txt = new JTextField(10);
                panel.add(lbl);
                panel.add(txt);
                int selectedOption = JOptionPane.showOptionDialog(null, panel, capsalera, JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);

                String nouNom = txt.getText();
                
               //String nouComen =JOptionPane.showInputDialog(comp,"Escriu el nom de la nova cerca",QUESTION_MESSAGE);
              guardada=2;
               macro.getContUser().addNomCerca(macro.getUserActual(), cercaactual, nouNom);
           }
            }
            }
            }catch (Exception e){
                e.printStackTrace();
           }
        }
        };
        hilo = new Thread(cerca);
        hilo.start();
        timer = new Timer(1000, new TimerListener());
        //progressMonitor = new ProgressMonitor(this,"Estem realitzant la cerca de comunitats, si us plau, tingues paciència","",0,arestes);
        timer.start();
        //progressMonitor.setProgress(0);
        //progressMonitor.setMillisToDecideToPopup(2*1000);
        CercaB.setEnabled(false);
        Crelacio.setEnabled(false);
        Csembla.setEnabled(false);
        Cpc.setEnabled(false);
        CpcImp.setEnabled(false);
        Cafegeix1.setEnabled(false);
        Cafegeix2.setEnabled(false);
        Cafegeix3.setEnabled(false);
        Cafegeix4.setEnabled(false);
       /* Espera sp = new Espera();
        sp.setVisible(true);*/
    }//GEN-LAST:event_CercaBActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        A_OpcionsAdmin.setVisible(false);
        A_VeureUsers.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed
    private void Enrere8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere8ActionPerformed
        A_VeureUsers.setVisible(false);
        A_OpcionsAdmin.setVisible(true);
    }//GEN-LAST:event_Enrere8ActionPerformed
    private void Enrere9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere9ActionPerformed
        A_VisualitzaNovaCerca.setVisible(false);
        A_CreaComunitat.setVisible(true);
    }//GEN-LAST:event_Enrere9ActionPerformed
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        A_VisualitzaNovaCerca.setVisible(false);
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)Resultat.getModel().getRoot();
        Enumeration e = root.preorderEnumeration();
        while(e.hasMoreElements()){
        System.out.println(e.nextElement());
        }
        A_GuardaCerca.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed
    private void Enrere10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere10ActionPerformed
        A_GuardaCerca.setVisible(false);
        A_VisualitzaNovaCerca.setVisible(true);
    }//GEN-LAST:event_Enrere10ActionPerformed
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if(!macro.getContUser().isAdmin(macro.getUserActual()))A_OpcionsClient.setVisible(true);
        else A_OpcionsAdmin.setVisible(true);A_GuardaCerca.setVisible(false);
        macro.getContUser().addNomCerca(macro.getUserActual(), cercaactual, jTextField5.getText());
        macro.getContUser().addComentariCerca(macro.getUserActual(), cercaactual, jTextField6.getText());
        //A_PantallaPrincipal.setVisible(false);
        JOptionPane.showMessageDialog(this, "Felicitats, Cerca guardada!", capsalera, WARNING_MESSAGE);
       /* Error aux = new Error(this,false);
        aux.ompletext("Felicitats, Cerca guardada!", "Continua");
        aux.setVisible(true);*/
        guardada=2;
        if(!macro.getContUser().isAdmin(macro.getUserActual()))A_OpcionsClient.setVisible(true);
        else A_OpcionsAdmin.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed
    private void Enrere4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere4ActionPerformed
        A_OpcionsAdmin.setVisible(false);
        A_PantallaPrincipal.setVisible(true);
    }//GEN-LAST:event_Enrere4ActionPerformed
    private void BVisCat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisCat2ActionPerformed
        if(LlistaCerques.getSelectedIndex()>=0) {
        cercaactual = macro.getContUser().getNumCerca(macro.getUserActual(), LlistaCerques.getSelectedValue().toString());
        vista.visualitzaCerca(true,Resultat1, CriterisNovaCerca1);
        A_VisualitzaCerques.setVisible(false);
        A_VisualitzacioCercaAntiga.setVisible(true);
        }
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar a quina cerca vols visualitzar!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_BVisCat2ActionPerformed
    private void EnrereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrereActionPerformed
        A_VisualitzaCerques.setVisible(false);
        if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
        else A_OpcionsClient.setVisible(true);
    }//GEN-LAST:event_EnrereActionPerformed
    private void VisualitzaCerquesFetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualitzaCerquesFetesActionPerformed
       A_OpcionsClient.setVisible(false);
       A_VisualitzaCerques.setVisible(true);
    }//GEN-LAST:event_VisualitzaCerquesFetesActionPerformed
    private void Enrere11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere11ActionPerformed
        int resposta = JOptionPane.showOptionDialog(this,"Vols crear una nova cerca o sobreescriure aquesta?", capsalera,YES_NO_CANCEL_OPTION,QUESTION_MESSAGE,null,new Object[]{"Conserva aquesta","Modifica aquesta","Cancelar"},"i tu?");
        if(resposta==0) {
            guardada=0;
            vista.preaparaCreacioNovaCerca(true, LCTotes, LPTotes, Algorismes, Lsub, Lsub2, Lsub1, Cbusca1, Cpc, CpcImp, Csembla, Crelacio, Cdada);
            A_VisualitzacioCercaAntiga.setVisible(false);
            A_CreaComunitat.setVisible(true);
        }
        else if (resposta==1){
            System.out.println("Es marca la 2");
            guardada=3;
            vista.preaparaCreacioNovaCerca(true, LCTotes, LPTotes, Algorismes, Lsub, Lsub2, Lsub1, Cbusca1, Cpc, CpcImp, Csembla, Crelacio, Cdada);
            A_VisualitzacioCercaAntiga.setVisible(false);
            A_CreaComunitat.setVisible(true);
        }
    }//GEN-LAST:event_Enrere11ActionPerformed
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String nouNom =JOptionPane.showInputDialog(this,"Escriu el nou nom",QUESTION_MESSAGE);
        macro.getContUser().addNomCerca(macro.getUserActual(), cercaactual, nouNom);
        vista.visualitzaCerca(true,Resultat1,CriterisNovaCerca1);
    }//GEN-LAST:event_jButton15ActionPerformed
    private void Enrere12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere12ActionPerformed
        A_VisualitzacioCercaAntiga.setVisible(false);
        A_VisualitzaCerques.setVisible(true);
    }//GEN-LAST:event_Enrere12ActionPerformed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nouComen =JOptionPane.showInputDialog(this,"Escriu el nou nom",QUESTION_MESSAGE);
        macro.getContUser().addComentariCerca(macro.getUserActual(), cercaactual, nouComen);
        vista.visualitzaCerca(true,Resultat1,CriterisNovaCerca1);
    }//GEN-LAST:event_jButton3ActionPerformed
    private void A_GuardaCercaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_GuardaCercaComponentShown
       jTextField5.setText("");
       jTextField6.setText("");
    }//GEN-LAST:event_A_GuardaCercaComponentShown
    private void NouUsernameComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_NouUsernameComponentShown
        NouUsername.setText("");
        NovaPassword.setText("");
    }//GEN-LAST:event_NouUsernameComponentShown
    private void A_VeureUsersComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VeureUsersComponentShown
        vista.carregaUsers(modusers);
        
    }//GEN-LAST:event_A_VeureUsersComponentShown
    private void LlistaPagComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_LlistaPagComponentShown
        ControladorVistes aux = new ControladorVistes();
        aux.omplePaginesExistents(LlistaPag);
    }//GEN-LAST:event_LlistaPagComponentShown
    private void A_BuscaCatPagComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_BuscaCatPagComponentShown
        ControladorVistes aux = new ControladorVistes();
        aux.omplePaginesExistents(LlistaPag1);
        aux.ompleCategoriesExistents(LlistaCateg1);
    }//GEN-LAST:event_A_BuscaCatPagComponentShown
    private void A_VisualitzaCerquesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzaCerquesComponentShown
        vista.carregaCerquesFetes(jTextField7, LlistaCerques);      
    }//GEN-LAST:event_A_VisualitzaCerquesComponentShown

    private void A_VisualitzaCerquesComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzaCerquesComponentHidden
        try {
            cercaactual= macro.getContUser().getNumCerca(macro.getUserActual(), LlistaCerques.getSelectedValue().toString());
        }
        catch(Exception prime){
            
        }
    }//GEN-LAST:event_A_VisualitzaCerquesComponentHidden
    private void BuscaPagines1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaPagines1ActionPerformed
       A_OpcionsAdmin.setVisible(false);
       A_BuscaPag.setVisible(true);
    }//GEN-LAST:event_BuscaPagines1ActionPerformed
    private void BuscaCategories1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaCategories1ActionPerformed
        A_OpcionsAdmin.setVisible(false);
        A_BuscaCat.setVisible(true);
    }//GEN-LAST:event_BuscaCategories1ActionPerformed
    private void BuscaCatPag1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaCatPag1ActionPerformed
       A_OpcionsAdmin.setVisible(false);
        A_BuscaCatPag.setVisible(true);
    }//GEN-LAST:event_BuscaCatPag1ActionPerformed
    private void CreaCerca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreaCerca1ActionPerformed
        vista.preaparaCreacioNovaCerca(false, LCTotes, LPTotes, Algorismes, Lsub, Lsub2, Lsub1, Cbusca1, Cpc, CpcImp, Csembla, Crelacio, Cdada);
        A_CreaComunitat.setVisible(true);
        A_OpcionsAdmin.setVisible(false);
    }//GEN-LAST:event_CreaCerca1ActionPerformed

    private void VisualitzaCerquesFetes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualitzaCerquesFetes1ActionPerformed
       A_OpcionsAdmin.setVisible(false);
       A_VisualitzaCerques.setVisible(true);
    }//GEN-LAST:event_VisualitzaCerquesFetes1ActionPerformed

    private void CanviaDadesUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanviaDadesUser1ActionPerformed
        A_CanviaDadesUser.setVisible(true);
        A_OpcionsAdmin.setVisible(false);
    }//GEN-LAST:event_CanviaDadesUser1ActionPerformed
    private void AfegeixFitxer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixFitxer1ActionPerformed
        vista.afegirFitxer();
    }//GEN-LAST:event_AfegeixFitxer1ActionPerformed
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        vista.canviaDadesUser(NouUsername1, NovaPassword1);
    }//GEN-LAST:event_jButton6ActionPerformed
    private void Enrere13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere13ActionPerformed
        A_CanviaDadesUser.setVisible(false);
        if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
        else A_OpcionsClient.setVisible(true);
    }//GEN-LAST:event_Enrere13ActionPerformed
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        vista.comprovaUsername(NouUsername1);
    }//GEN-LAST:event_jButton7ActionPerformed
    private void A_CanviaDadesUserComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_CanviaDadesUserComponentShown
        NouUsername1.setText(macro.getUserActual());
        NovaPassword1.setText("");
    }//GEN-LAST:event_A_CanviaDadesUserComponentShown
    private void A_BuscaPagComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_BuscaPagComponentShown
        vista.omplePaginesExistents(LlistaPag);
    }//GEN-LAST:event_A_BuscaPagComponentShown
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Segur que vols eliminar totes les dades?", capsalera, YES_NO_OPTION);
        if(resposta==YES_OPTION) {
            macro.getContAdUs().eliminarDades();
            System.out.println("He eliminat les dades");
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    private void A_BuscaCatComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_BuscaCatComponentShown
        vista.ompleCategoriesExistents(LlistaCateg);
    }//GEN-LAST:event_A_BuscaCatComponentShown
    private void ResultatMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultatMouseDragged
        ///MOUSE MOTION DRAG
    }//GEN-LAST:event_ResultatMouseDragged
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
    vista.treuCatComun(Resultat,modelos);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
       A_OpcionsAdmin.setVisible(false);
       jPanel1.setVisible(true);
       //Afegeix nou = new Afegeix();
       //nou.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed
    private void AlgorismesValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_AlgorismesValueChanged

    }//GEN-LAST:event_AlgorismesValueChanged
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if(UsersAct.getSelectedIndices().length>0) {
            Boolean segueix = true;
            if(UsersAct.getSelectedValue().toString().equals("admin")) JOptionPane.showMessageDialog(this, "Aquest usuari no es pot eliminar", capsalera, WARNING_MESSAGE);
            else {
            if(UsersAct.getSelectedValue().toString().equals(macro.getUserActual())) {
                int resposta = JOptionPane.showConfirmDialog(this, "Segur que vols eliminar-te a tu mateix?", capsalera, YES_NO_OPTION);
                if(resposta==YES_OPTION) {
                    A_PantallaPrincipal.setVisible(true);
                    A_VeureUsers.setVisible(false);
                }
                else  segueix = false;
            }
            if(segueix) {
            macro.getContUser().removeUser(UsersAct.getSelectedValue().toString());
            modusers.removeElement(UsersAct.getSelectedValue().toString());
            }
            }
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar quin usuari vols eliminar!", capsalera, WARNING_MESSAGE);

    }//GEN-LAST:event_jButton17ActionPerformed
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if(UsersAct.getSelectedIndices().length>0) {
            macro.getContUser().addAdmin(UsersAct.getSelectedValue().toString());
            JOptionPane.showMessageDialog(this, "Felicitats, aquest usuari ja és admin!", capsalera, WARNING_MESSAGE);
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar quin usuari vols fer admninistrador!", capsalera, WARNING_MESSAGE);

    }//GEN-LAST:event_jButton18ActionPerformed
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        userAdmin = true;
        A_CreaUsuari.setVisible(true);
        A_VeureUsers.setVisible(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void A_VeureUsersComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VeureUsersComponentHidden
        modusers.removeAllElements();
    }//GEN-LAST:event_A_VeureUsersComponentHidden
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        vista.afegeixCatComun(Resultat,modelos, Penjades);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        Integer quina = macro.getContUser().addComunitatCerca(macro.getUserActual(), cercaactual)+1;
        System.out.println("Afegeico la comunitat: "+quina);
        DefaultTreeModel arb = (DefaultTreeModel)Resultat.getModel();
        
        DefaultMutableTreeNode act = (DefaultMutableTreeNode)arb.getRoot();

        arb.insertNodeInto(new DefaultMutableTreeNode("Comunitat "+quina), act, act.getChildCount());
        comunaEliminar.add(quina-1);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void A_VisualitzaNovaCercaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzaNovaCercaComponentShown
        comunaEliminar = new PriorityQueue<>(1, Collections.reverseOrder());
    }//GEN-LAST:event_A_VisualitzaNovaCercaComponentShown

    private void A_VisualitzaNovaCercaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzaNovaCercaComponentHidden
       System.out.print("Elimino les comunitats:");
        while(!comunaEliminar.isEmpty()) {
            System.out.print(" "+comunaEliminar.peek());
            macro.getContUser().removeComunitatCerca(macro.getUserActual(),cercaactual,comunaEliminar.poll());
        }
        System.out.println();
    }//GEN-LAST:event_A_VisualitzaNovaCercaComponentHidden

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        Integer quina = macro.getContUser().addComunitatCerca(macro.getUserActual(), cercaactual)+1;
        System.out.println("Afegeico la comunitat: "+quina);
        DefaultTreeModel arb = (DefaultTreeModel)Resultat1.getModel();
        
        DefaultMutableTreeNode act = (DefaultMutableTreeNode)arb.getRoot();

        arb.insertNodeInto(new DefaultMutableTreeNode("Comunitat "+quina), act, act.getChildCount());
        comunaEliminar.add(quina-1);
    }//GEN-LAST:event_jButton21ActionPerformed
    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        vista.afegeixCatComun(Resultat1,modelos1, Penjades1);
    }//GEN-LAST:event_jButton22ActionPerformed
    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        vista.treuCatComun(Resultat1,modelos1);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void A_VisualitzacioCercaAntigaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzacioCercaAntigaComponentShown
        comunaEliminar = new PriorityQueue<>(1, Collections.reverseOrder());
    }//GEN-LAST:event_A_VisualitzacioCercaAntigaComponentShown

    private void A_VisualitzacioCercaAntigaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzacioCercaAntigaComponentHidden
        System.out.print("Elimino les comunitats:");
        while(!comunaEliminar.isEmpty()) {
            System.out.print(" "+comunaEliminar.peek());
            macro.getContUser().removeComunitatCerca(macro.getUserActual(),cercaactual,comunaEliminar.poll());
        }
        System.out.println();
    }//GEN-LAST:event_A_VisualitzacioCercaAntigaComponentHidden

    private void CbuscaCat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCat1ActionPerformed
       vista.ompleCategoriesExistentsConcret(LlistaCateg1, Cbusca3);
    }//GEN-LAST:event_CbuscaCat1ActionPerformed

    private void CbuscaPag1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPag1ActionPerformed
        vista.omplePaginesExistentsConcret(LlistaPag1, Cbusca4);
    }//GEN-LAST:event_CbuscaPag1ActionPerformed

    private void Cbusca4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbusca4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbusca4ActionPerformed

    private void Cbusca5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbusca5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbusca5ActionPerformed

    private void CbuscaPag2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPag2ActionPerformed
        vista.omplePaginesExistentsConcret(LlistaPag, Cbusca5);
    }//GEN-LAST:event_CbuscaPag2ActionPerformed

    private void Cbusca6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbusca6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbusca6ActionPerformed

    private void CbuscaPag3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPag3ActionPerformed
        vista.ompleCategoriesExistentsConcret(LlistaCateg, Cbusca6);
    }//GEN-LAST:event_CbuscaPag3ActionPerformed

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
            java.util.logging.Logger.getLogger(InterficiaProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterficiaProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterficiaProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterficiaProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterficiaProva()/*.setVisible(true)*/;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A_BuscaCat;
    private javax.swing.JPanel A_BuscaCatPag;
    private javax.swing.JPanel A_BuscaPag;
    private javax.swing.JPanel A_CanviaDadesUser;
    private javax.swing.JPanel A_CreaComunitat;
    private javax.swing.JPanel A_CreaUsuari;
    private javax.swing.JPanel A_GuardaCerca;
    private javax.swing.JPanel A_OpcionsAdmin;
    private javax.swing.JPanel A_OpcionsClient;
    private javax.swing.JPanel A_PantallaPrincipal;
    private javax.swing.JPanel A_VeureUsers;
    private javax.swing.JPanel A_VisualitzaCerques;
    private javax.swing.JPanel A_VisualitzaNovaCerca;
    private javax.swing.JPanel A_VisualitzacioCercaAntiga;
    private javax.swing.JButton AfegeixFitxer;
    private javax.swing.JButton AfegeixFitxer1;
    private javax.swing.JTree Algorismes;
    private javax.swing.JButton BVisCat;
    private javax.swing.JButton BVisCat1;
    private javax.swing.JButton BVisCat2;
    private javax.swing.JButton BVisPag;
    private javax.swing.JButton BVisPag1;
    private javax.swing.JButton BuscaCatPag;
    private javax.swing.JButton BuscaCatPag1;
    private javax.swing.JButton BuscaCategories;
    private javax.swing.JButton BuscaCategories1;
    private javax.swing.JButton BuscaPagines;
    private javax.swing.JButton BuscaPagines1;
    private javax.swing.JButton Cafegeix1;
    private javax.swing.JButton Cafegeix2;
    private javax.swing.JButton Cafegeix3;
    private javax.swing.JButton Cafegeix4;
    private javax.swing.JButton CanviaDadesUser;
    private javax.swing.JButton CanviaDadesUser1;
    private javax.swing.JTextField Cbusca;
    private javax.swing.JTextField Cbusca1;
    private javax.swing.JTextField Cbusca2;
    private javax.swing.JTextField Cbusca3;
    private javax.swing.JTextField Cbusca4;
    private javax.swing.JTextField Cbusca5;
    private javax.swing.JTextField Cbusca6;
    private javax.swing.JButton CbuscaCat;
    private javax.swing.JButton CbuscaCat1;
    private javax.swing.JButton CbuscaPag;
    private javax.swing.JButton CbuscaPag1;
    private javax.swing.JButton CbuscaPag2;
    private javax.swing.JButton CbuscaPag3;
    private javax.swing.JSpinner Cdada;
    private javax.swing.JButton CercaB;
    private javax.swing.JTextField Cpc;
    private javax.swing.JSlider CpcImp;
    private javax.swing.JButton CreaCerca;
    private javax.swing.JButton CreaCerca1;
    private javax.swing.JSlider Crelacio;
    private javax.swing.JTextArea CriterisNovaCerca;
    private javax.swing.JTextArea CriterisNovaCerca1;
    private javax.swing.JSlider Csembla;
    private javax.swing.JButton EliminaCsub;
    private javax.swing.JButton Enrere;
    private javax.swing.JButton Enrere1;
    private javax.swing.JButton Enrere10;
    private javax.swing.JButton Enrere11;
    private javax.swing.JButton Enrere12;
    private javax.swing.JButton Enrere13;
    private javax.swing.JButton Enrere2;
    private javax.swing.JButton Enrere3;
    private javax.swing.JButton Enrere4;
    private javax.swing.JButton Enrere5;
    private javax.swing.JButton Enrere6;
    private javax.swing.JButton Enrere7;
    private javax.swing.JButton Enrere8;
    private javax.swing.JButton Enrere9;
    private javax.swing.JButton Exit;
    private javax.swing.JList LCTotes;
    private javax.swing.JList LPTotes;
    private javax.swing.JList LlistaCateg;
    private javax.swing.JList LlistaCateg1;
    private javax.swing.JList LlistaCerques;
    private javax.swing.JList LlistaPag;
    private javax.swing.JList LlistaPag1;
    private javax.swing.JButton Login;
    private javax.swing.JList Lsub;
    private DefaultListModel modelo;
    private javax.swing.JList Lsub1;
    private DefaultListModel modelo1;
    private javax.swing.JList Lsub2;
    private DefaultListModel modelo2;
    private javax.swing.JTextField NouUsername;
    private javax.swing.JTextField NouUsername1;
    private javax.swing.JTextField NovaPassword;
    private javax.swing.JTextField NovaPassword1;
    private javax.swing.JTextField Password;
    private javax.swing.JList Penjades;
    private DefaultListModel modelos;
    private javax.swing.JList Penjades1;
    private DefaultListModel modelos1;
    private javax.swing.JTree Resultat;
    private javax.swing.JTree Resultat1;
    private javax.swing.JTextField Username;
    private javax.swing.JList UsersAct;
    private DefaultListModel modusers;
    private javax.swing.JButton VisualitzaCerquesFetes;
    private javax.swing.JButton VisualitzaCerquesFetes1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}