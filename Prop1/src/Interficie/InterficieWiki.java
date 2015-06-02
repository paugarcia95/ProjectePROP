/*
 * Interficie principal del programa de la Wikipedia
 */
package Interficie;

import domini.MacroControlador;
import java.awt.Component;
import java.awt.Frame;
import java.util.PriorityQueue;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 *
 * @author cristina.fontanet
 */
public class InterficieWiki extends javax.swing.JFrame {
    /**
     * Macrocontrolador del domini
     */
    protected static domini.MacroControlador macro;
    /**
     * Controlador de vistes
     */
    protected static ControladorVistes vista;
    /**
     * Part d'interficie
     */
    protected static Interficie.ControladorRafa rafa;
    /**
     * Per poder compartir interficie
     */
    protected static javax.swing.JTabbedPane AP_Afegeix = new javax.swing.JTabbedPane();
    /**
     * Per poder compartir interficie
     */
    protected static javax.swing.JPanel A_Afegeix = new javax.swing.JPanel(); 
    /**
     * Conjunt de comunitats a eliminar (dels arbres de Visualitzacio de les cerques)
     */
    protected static PriorityQueue<Integer> comunaEliminar;
    /**
     * Identifiador de la cerca actual
     */
    protected static Integer cercaactual;
    /**
     * Variable a mostrar en els JOptionPane
     */
    protected static final String capsalera = "Wiki";
    /**
     * 
     */
    protected static String pathpdf = "./data/Practica3.pdf";
    /**
     * Variable en cas de que no hi hagi cap pagina/categoria a l'hora de mostrar
     */
    protected static String noSelect="  No n'hi ha cap"; 
    /**
     * indica si es el primer login del programa
     */
    protected Boolean primera; 
    /**
     * auxguard= 0 -> es pot crear una nova cerca sense problemes
     * auxguard= 1 -> s'ha de sobrescriure la cerca cercaactual
     * auxguard= 2 -> no es pot crear cap nova cerca, ja n'hi ha una sense guardar
     */
    protected static Integer auxguard;
    /**
     * Component des del qual es crida a la funcio
     */
    protected static Frame comp;
    /**
     * Thread on s'executa la cerca de comunitats
     */
    protected static Thread hilo;
    /**
     * indica si s'ha interrumput la cerca de comunitats o no
     */
    protected static Boolean interrumput; 
    /**
     * Indica si qui fa la creacio d'un nou usuari es l'administrador o no
     */
    protected static Boolean userAdmin;
   
///////////////////ELIMINAAAAAAAAR////////////////////////////////////////////////////////////
   private void provisional(){
        Username.setText("admin");
        Password.setText("admin");
   }
    
   protected void activaCerca(){
       AP_Client.setEnabledAt(4, true);
   }
   
   protected void activaEspera() {
       Panell = new PantallaEspera(this);
       AP_Client.setComponentAt(4, Panell);
   }
   
   protected void desactivaEspera() {
       Panell = new CreaComunitat(this,AP_Client);
       AP_Client.setComponentAt(4, Panell);
   }
   
   protected void canviarACercaGuardada(){
      AP_Cerques.remove(AP_Cerques.getSelectedIndex());
      auxguard = 0;
      AP_Client.setEnabledAt(4, true);
      AP_Cerques.setEnabledAt(0, true);
      visualitzaCercaAntiga();
   } 
   
   protected void canviaNomTaula(String nouNom){
        AP_Cerques.setTitleAt(AP_Cerques.getSelectedIndex(), nouNom);
    }
   
   protected void creaAdminNou(){
       Panell = new NouUser(this);
       AP_Client.setComponentAt(8, Panell);
   }
   
   protected void eliminaTab(Component quin){
       AP_Cerques.remove(quin);
   }
   
   protected Boolean espotvisualitzar(String nom) {
       for(int i = 1; i < AP_Cerques.getComponentCount(); ++i) {
            if(AP_Cerques.getTitleAt(i).equals(nom)) return false;
       }
       return true;
   }
   
   protected void modificaCercaGuardada(){
       AP_Client.setEnabledAt(4, true);
       auxguard = 1;
       AP_Client.setSelectedIndex(4);
   }
   
   protected void novaCerca(){
       AP_Client.setEnabledAt(4, true);
       auxguard = 0;
       AP_Client.setSelectedIndex(4);
   }
   
   protected void revalidaCerques(){
       AP_Cerques.setSelectedIndex(0);
   }
   
   protected void surtDeCerca(){
       if(macro.getContUser().isAdmin(macro.getUserActual())) AP_Client.setSelectedIndex(7);
       else AP_Client.setSelectedIndex(5);
   }
   
   protected void tornaVeureUsers(){
      Panell = new VeureUsers(this);
      AP_Client.setComponentAt(8, Panell);
    }
   
   protected void visualitzaCercaAntiga() {
       javax.swing.JPanel Panells = new VeureCercaAntiga(this, cercaactual);
       AP_Cerques.add(Panells, macro.getContUser().getNomCerca(macro.getUserActual(), cercaactual));
       AP_Cerques.setSelectedComponent(Panells);
   }  
   
   protected void visualitzaCercaNova() {
       if(auxguard!=1) {
           Panell = new VeureNovaCerca(this, cercaactual);
           AP_Cerques.add(Panell, "Sense guardar");
       }
       auxguard = 2;
       AP_Client.setSelectedIndex(5);
       AP_Cerques.setSelectedIndex(AP_Cerques.getComponentCount()-1);
       AP_Client.setEnabledAt(4, false);
   }
  
   protected void login(){
        String user, pass;
        user= Username.getText();
        pass= Password.getText();
        if(!macro.getContUser().existsUser(user)) JOptionPane.showMessageDialog(this, "L'username no existeix, torna'l a introduir o crea una nova conta.", capsalera, WARNING_MESSAGE);
        else if(macro.getContUser().login(user, pass)){
            macro.setUserActual(user);
            auxguard = 0;
            A_CerquesGuardades = new VeureCerques(this);
            AP_Cerques.add(A_CerquesGuardades, "Totes");
            AP_Cerques.setSelectedIndex(0);
            AP_Client.add(AP_Cerques, "Cerques guardades");
            Panell = new CanviaDadesUser();
            AP_Client.add(Panell, "Dades d'usuari"); 
            primera = false;
            AP_Inici.setuser(user);
            if(macro.getContUser().isAdmin(user)) {
                userAdmin = true;
                AP_Client.add(AP_Afegeix, "Afegeix");
                A_VeureUsers = new VeureUsers(this);
                AP_Client.add(A_VeureUsers, "Usuaris existents");
            }
            else userAdmin = false;
            AP_Client.setVisible(true);
            AP_Principal.setVisible(false);
            AP_Client.setSelectedIndex(0);
            Username.setText("");
            Password.setText("");
        }
        else JOptionPane.showMessageDialog(this, "La contrassenya es incorrecta.", capsalera, ERROR_MESSAGE);
    }
   
   protected void logout(){
       AP_Client.setVisible(false);
       userAdmin = false;
       AP_Principal.add(A_CreaUsuari, "Crea nou usuari");
       AP_Principal.setVisible(true);
       if(AP_Client.getComponentCount()>7) {
        AP_Client.remove(8);
        AP_Client.remove(7);
       }
       AP_Cerques.removeAll();
       AP_Client.remove(6);
       AP_Client.remove(5); 
   }
   
   /**
     * Creates new form InterficieWiki
     */
    public InterficieWiki() {
        primera=true;
        comunaEliminar = new PriorityQueue<>();
        macro = new MacroControlador();
        vista = new ControladorVistes();
        rafa = new ControladorRafa();
        comp = this;
        userAdmin = false;
        initComponents();
        this.setVisible(false);
        AP_Inici = new Inici(this);
        AP_Client.add(AP_Inici, "Inici");
        Panell = new BuscaCat();
        AP_Client.add(Panell, "Categories");
        Panell = new BuscaPag();
        AP_Client.add(Panell, "Pàgines");
        Panell = new BuscaCatPag();
        AP_Client.add(Panell, "Categories i pagines");
        Panell = new CreaComunitat(this,AP_Client);
        AP_Client.add(Panell, "Fer Cerca");
        rafa.ini();
        if(!macro.carregaDades()) JOptionPane.showMessageDialog(this, macro.getMissatgeError(), capsalera, ERROR_MESSAGE);
        
    }
    Inici AP_Inici;        
    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AP_Principal = new javax.swing.JTabbedPane();
        A_PantallaPrincipal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        Login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        A_CreaUsuari = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        NouUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        NovaPassword = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AP_Client = new javax.swing.JTabbedPane();
        Panell = new javax.swing.JPanel();
        AP_Cerques = new javax.swing.JTabbedPane();
        A_FerCerca = new javax.swing.JPanel();
        A_CerquesGuardades = new javax.swing.JPanel();
        A_VeureUsers = new javax.swing.JPanel();
        A_NouAdmin = new javax.swing.JPanel();
        A_Inici = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WIKIPEDIA");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(3500, 3500));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(1200, 900));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        A_PantallaPrincipal.setMaximumSize(new java.awt.Dimension(32000, 32000));
        A_PantallaPrincipal.setPreferredSize(new java.awt.Dimension(250, 250));

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
                        .addGap(40, 40, 40)
                        .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Login)
                            .addComponent(Exit)))
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel3))
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(1040, Short.MAX_VALUE))
        );
        A_PantallaPrincipalLayout.setVerticalGroup(
            A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Login))
                .addGap(20, 20, 20)
                .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        Username.getAccessibleContext().setAccessibleName("Username");

        AP_Principal.addTab("Iniciar Sessió", A_PantallaPrincipal);

        A_CreaUsuari.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_CreaUsuariComponentShown(evt);
            }
        });

        jLabel7.setText("Creació d'un nou usuari");

        jLabel8.setText("Username");

        jButton1.setText("Comprova Disponibilitat");
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

        jLabel5.setText("El nom d'usuari no pot contenir |, /, \\, :, *, ?, <, >, \" ni +");

        jLabel6.setText("La contrassenya no pot contenir | ni * ni +");

        javax.swing.GroupLayout A_CreaUsuariLayout = new javax.swing.GroupLayout(A_CreaUsuari);
        A_CreaUsuari.setLayout(A_CreaUsuariLayout);
        A_CreaUsuariLayout.setHorizontalGroup(
            A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addComponent(NouUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1))
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(40, 40, 40)
                        .addComponent(NovaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addComponent(jLabel6)))
                .addContainerGap(1078, Short.MAX_VALUE))
        );
        A_CreaUsuariLayout.setVerticalGroup(
            A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NouUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(NovaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9)))
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(304, Short.MAX_VALUE))
        );

        AP_Principal.addTab("Crea nou usuari", A_CreaUsuari);

        getContentPane().add(AP_Principal, "card17");
        getContentPane().add(AP_Client, "card16");

        javax.swing.GroupLayout PanellLayout = new javax.swing.GroupLayout(Panell);
        Panell.setLayout(PanellLayout);
        PanellLayout.setHorizontalGroup(
            PanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        PanellLayout.setVerticalGroup(
            PanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(Panell, "card18");

        AP_Cerques.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(AP_Cerques, "card16");

        A_FerCerca.setAlignmentX(A_PantallaPrincipal.getAlignmentX());
        A_FerCerca.setAlignmentY(A_PantallaPrincipal.getAlignmentY());

        javax.swing.GroupLayout A_FerCercaLayout = new javax.swing.GroupLayout(A_FerCerca);
        A_FerCerca.setLayout(A_FerCercaLayout);
        A_FerCercaLayout.setHorizontalGroup(
            A_FerCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_FerCercaLayout.setVerticalGroup(
            A_FerCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_FerCerca, "card3");

        javax.swing.GroupLayout A_CerquesGuardadesLayout = new javax.swing.GroupLayout(A_CerquesGuardades);
        A_CerquesGuardades.setLayout(A_CerquesGuardadesLayout);
        A_CerquesGuardadesLayout.setHorizontalGroup(
            A_CerquesGuardadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_CerquesGuardadesLayout.setVerticalGroup(
            A_CerquesGuardadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_CerquesGuardades, "card13");

        javax.swing.GroupLayout A_VeureUsersLayout = new javax.swing.GroupLayout(A_VeureUsers);
        A_VeureUsers.setLayout(A_VeureUsersLayout);
        A_VeureUsersLayout.setHorizontalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_VeureUsersLayout.setVerticalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_VeureUsers, "card10");

        javax.swing.GroupLayout A_NouAdminLayout = new javax.swing.GroupLayout(A_NouAdmin);
        A_NouAdmin.setLayout(A_NouAdminLayout);
        A_NouAdminLayout.setHorizontalGroup(
            A_NouAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_NouAdminLayout.setVerticalGroup(
            A_NouAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_NouAdmin, "card18");

        javax.swing.GroupLayout A_IniciLayout = new javax.swing.GroupLayout(A_Inici);
        A_Inici.setLayout(A_IniciLayout);
        A_IniciLayout.setHorizontalGroup(
            A_IniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_IniciLayout.setVerticalGroup(
            A_IniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_Inici, "card10");

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        login();
    }//GEN-LAST:event_LoginActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        if(!macro.guardaDades()) JOptionPane.showMessageDialog(this, macro.getMissatgeError(), capsalera, ERROR_MESSAGE);
        else System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        vista.creaUserNou(NouUsername, NovaPassword);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vista.comprovaUsername(NouUsername.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void A_CreaUsuariComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_CreaUsuariComponentShown
        NouUsername.setText("");
        NovaPassword.setText("");
    }//GEN-LAST:event_A_CreaUsuariComponentShown

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       if(!macro.guardaDades()) JOptionPane.showMessageDialog(this, macro.getMissatgeError(), capsalera, ERROR_MESSAGE);
       System.exit(0);
    }//GEN-LAST:event_formWindowClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AP_Cerques;
    private javax.swing.JTabbedPane AP_Client;
    private javax.swing.JTabbedPane AP_Principal;
    private javax.swing.JPanel A_CerquesGuardades;
    private javax.swing.JPanel A_CreaUsuari;
    private javax.swing.JPanel A_FerCerca;
    private javax.swing.JPanel A_Inici;
    private javax.swing.JPanel A_NouAdmin;
    private javax.swing.JPanel A_PantallaPrincipal;
    private javax.swing.JPanel A_VeureUsers;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Login;
    private javax.swing.JTextField NouUsername;
    private javax.swing.JTextField NovaPassword;
    private javax.swing.JPanel Panell;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}