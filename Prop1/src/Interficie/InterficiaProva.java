/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

import java.awt.Component;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

import domini.Categoria;
import domini.GrafDades;
import domini.Pagina;
import domini.Usuari;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Set;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Cristina
 */
public class InterficiaProva extends javax.swing.JFrame {
    static domini.MacroControlador macro;
    Integer cercaactual;
    String algorisme;
    Integer guardada;
    static String capsalera = "Wiki";
    //guardada=0 -> nova cerca sense guardar, crearla
    //guardada=1  -> cerca no guardada
    //guardada=2 -> cerca guardada

   
   private void jocProves1(){
       Categoria aux1 = new Categoria("sexualitat"); // Prova Sexualitat
	Categoria aux2 = new Categoria("asexual");
	GrafDades G = macro.getGraf();
	G.addCC(aux1,aux2);
	Categoria aux3 = new Categoria("heterosexual");
	G.addCC(aux1,aux3);
	Categoria aux4 = new Categoria("homosexual");
	G.addCC(aux1, aux4);
	Categoria aux5 = new Categoria("sexe");
	G.addCC(aux1,aux5);
	Categoria aux6 = new Categoria("embaras");
	G.addCC(aux3,aux6);
	G.addCC(aux5, aux6);
	Categoria aux7 = new Categoria("infertil");
	G.addCC(aux4, aux7);
	G.addCC(aux2, aux7);
	G.addCC(aux3,aux4);
	Pagina aux0 = new Pagina("esteril");
	G.addPagina(aux0);
        G.addCP(aux7, aux0);
        G.addPC(aux0, aux6);
        Pagina aux8 = new Pagina("eril");
        Categoria aux9 = new Categoria("aillat1");
        Categoria aux10 = new Categoria("aillat2");
        G.addCC(aux9,aux10);
	G.addPagina(aux8);
   } 
   private void jocProves2(){
       GrafDades G = macro.getGraf();
       Categoria aux1 = new Categoria("sanitat"); // PROVA METGES
			Categoria aux2 = new Categoria("metge");
			G.addCC(aux1, aux2);
			Categoria aux4 = new Categoria("metgessa");
			G.addCC(aux1, aux4);
			Categoria aux6 = new Categoria("uroleg");
			G.addCC(aux2, aux6);
			Pagina aux7 = new Pagina("agulla");
			G.addCP(aux2, aux7);
			G.addCP(aux4, aux7);
			Categoria aux8 = new Categoria("ginecoleg");
			G.addCC(aux4, aux8);
			Categoria aux9 = new Categoria("traumatoleg");
			G.addCC(aux4, aux9);
			G.addCC(aux2, aux9);
			Categoria aux10 = new Categoria("metgos");
			G.addCC(aux2, aux10);
			G.addCC(aux2, aux4);
   }
   private void jocProves3() {
       GrafDades G = macro.getGraf();
       Categoria aux1 = new Categoria("familia"); // Prova familia
			Categoria aux2 = new Categoria("pare");
			G.addCC(aux1,aux2);
			Categoria aux3 = new Categoria("mare");
			G.addCC(aux1,aux3);
			Categoria aux4 = new Categoria("fill");
			G.addCC(aux2,aux4);
			G.addCC(aux3,aux4);
   }
    
   /**
     * Creates new form InterficiaProva
     */
    public void passaMacro(domini.MacroControlador mc){
        macro = mc;
        macro.getContUser().addUser("admin", "admin");
	macro.getContUser().addUser("client", "client");
	macro.getContUser().addAdmin("admin");
        jocProves1();
    }
    public InterficiaProva() {
        //macro = new domini.MacroControlador();
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
        A_PantallaPrincipal.setVisible(true);
       
    }

    private void login(){
        String user, pass;
        user= Username.getText();
        pass= Password.getText();
        if(!macro.getContUser().existsUser(user)) {
            JOptionPane.showMessageDialog(this, "L'username no existeix, torna'l a introduir o crea una nova conta.", capsalera, WARNING_MESSAGE);
           /* Error aux = new Error(this,true);
            aux.ompletext("L'username no existeix, torna'l a introduir o crea una nova conta.", "Ok");
            aux.setVisible(true);*/
        }
        else if(macro.getContUser().login(user, pass)){
            A_PantallaPrincipal.setVisible(false);
            macro.setUserActual(user);
            if(macro.getContUser().isAdmin(user)) A_OpcionsAdmin.setVisible(true);
            else A_OpcionsClient.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "L'username no existeix, torna'l a introduir o crea una nova conta.", capsalera, ERROR_MESSAGE);
           /* Error aux = new Error(this,true);
            aux.ompletext("Password incorrecte, si us plau, torna a introduir les dades.", "Ok");
            aux.setVisible(true);*/
        }
    }
    private void ompleCategoriesExistents(JList quina){         //es pot millorar eficiència (que vagi carregant a mida q es va fent scroll)
        Collection<String> auxc = macro.getContAdUs().getCategories();
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        quina.setListData(aux2);
    }
    private void ompleCategoriesExistentsConcret(JList quina, JTextField don){
        String busca = don.getText();
        Collection<String> aux = macro.getContAdUs().getCategories();
        Iterator<String> it = aux.iterator();
        Object[] csub= new Object[aux.size()];
        int cont = 0;
        while(it.hasNext()){
            String nom =it.next();
            if(nom.contains(busca)) {
                csub[cont] = nom;
                ++cont;
            }
        }
        quina.setListData(csub);
    }
    private void omplePaginesExistents(JList quina){
        Collection<String> auxc = macro.getContAdUs().getPagines();
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        quina.setListData(aux2);
    }
    private void omplePaginesExistentsConcret(JList quina, JTextField don){
        String busca = don.getText();
        Collection<String> aux = macro.getContAdUs().getPagines();
        Iterator<String> it = aux.iterator();
        Object[] csub= new Object[aux.size()];
        int cont = 0;
        while(it.hasNext()){
            String nom =it.next();
            if(nom.contains(busca)) {
                csub[cont] = nom;
                ++cont;
            }
        }
        quina.setListData(csub);
    }
    private void visualitzarCategoriaDe(JList quina){
        if(quina.getSelectedIndices().length>0) {
            String hy = quina.getSelectedValue().toString();
            VCategoria aux = new VCategoria(this,true);
            Categoria auxi = macro.getGraf().getCategoria(hy);
            aux.NomCat(auxi);
        }
        else {
            JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista!", capsalera, WARNING_MESSAGE);
          /*  Error despistat = new Error(this,true);
            despistat.ompletext("Has de seleccionar algun element de la llista!", "Ok");
            despistat.setVisible(true);*/
        }
    }
    private void visualitzarPaginaDe(JList quina){
        if(quina.getSelectedIndices().length>0) {
            String hy = quina.getSelectedValue().toString();
            VPagina aux = new VPagina(this,true);
            Pagina auxi = macro.getGraf().getPagina(hy);
            aux.NomPag(auxi);
        }
        else {
            JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista!", capsalera, WARNING_MESSAGE);
          /*  Error despistat = new Error(this,true);
            despistat.ompletext("Has de seleccionar algun element de la llista!", "Ok");
            despistat.setVisible(true);*/
        }
    }
    private void comprovaUsername(){
        if(macro.getContUser().existsUser(NouUsername.getText())) JOptionPane.showMessageDialog(this, "Aquest nom d'usuari ja existeix, si us plau, tria'n un altre", capsalera, PLAIN_MESSAGE);
        else JOptionPane.showMessageDialog(this, "Aquest nom d'usuari està lliure, endavant", capsalera, PLAIN_MESSAGE);
        /*
        Error aux = new Error(this, true);
        String resultat;
        if(macro.getContUser().existsUser(NouUsername.getText())) resultat = "Aquest nom d'usuari ja existeix, si us plau, tria'n un altre";
        else  resultat = "Aquest nom d'usuari està lliure, endavant";
        aux.ompletext(resultat, "Ok");
        aux.setVisible(true);*/
    }
    private void creaUserNou(){
        if(macro.getContUser().existsUser(NouUsername.getText())) {
            JOptionPane.showMessageDialog(this, "Aquest nom d'usuari ja existeix, si us plau, tria'n un altre", capsalera, WARNING_MESSAGE);
         /* Error aux = new Error(this, true);
          aux.ompletext("Aquest nom d'usuari ja existeix, si us plau, tria'n un altre", "Ok");
          aux.setVisible(true);*/
        }
        else if(NovaPassword.getText().length()==0) {
            JOptionPane.showMessageDialog(this, "Escriu una contrassenya siusplau", capsalera, WARNING_MESSAGE);
         /* Error aux = new Error(this, true);
          aux.ompletext("Escriu una contrassenya siusplau", "Ok");
          aux.setVisible(true);*/
        }
        else {
            macro.getContUser().addUser(NouUsername.getText(), NovaPassword.getText());
            JOptionPane.showMessageDialog(this, "Felicitats, conta creada!", capsalera, WARNING_MESSAGE);
     /*       Error aux = new Error(this, true);
          aux.ompletext("Felicitats, conta cread!", "Ok");
          aux.setVisible(true);*/
        }
    }
    private void preaparaCreacioNovaCerca(Boolean modificacio){
        if(macro.getContAdUs().getNumCats()<= 0) {
            JOptionPane.showMessageDialog(this, "No es pot fer cap cerca ja que no hi ha Categories", capsalera, WARNING_MESSAGE);
        }
        else {
        Collection<String> aux = macro.getContAdUs().getCategories();
        Iterator<String> it = aux.iterator();
        Object[] csub= new Object[aux.size()];
        int cont = 0;
        while(it.hasNext()){
            csub[cont] = it.next();
            ++cont;
        }
        LCTotes.setListData(csub);
        
        Collection<String> auxc = macro.getContAdUs().getPagines();
        Object[] aux2 = new Object[auxc.size()];
        cont = 0;
        Iterator<String> it2 = auxc.iterator();
        while(it2.hasNext()) {
            aux2[cont] = it2.next();
            ++cont;
        }
        LPTotes.setListData(aux2);
        guardada=0;
        Algorismes.expandRow(1);
        Algorismes.expandRow(3);
        Algorismes.expandRow(7);
        Algorismes.setSelectionRow(5);
        if(modificacio) {
            Collection<String> auxs = macro.getContUser().getSubCerca(macro.getUserActual(),cercaactual);
            Object[] aux3 = new Object[auxs.size()];
            cont = 0;
            Iterator<String> it3 = auxs.iterator();
            while(it3.hasNext()) {
                aux3[cont] = it3.next();
                ++cont;
            }
            Lsub.setListData(aux3);
            
            Collection<String> auxs2 = macro.getContUser().getEvitaPagCerca(macro.getUserActual(),cercaactual);
            Object[] aux5 = new Object[auxs2.size()];
            cont = 0;
            Iterator<String> it5 = auxs2.iterator();
            while(it5.hasNext()) {
                aux5[cont] = it5.next();
                ++cont;
            }
            Lsub2.setListData(aux3);
            
            Collection<String> auxs1 = macro.getContUser().getEvitaCatCerca(macro.getUserActual(),cercaactual);
            Object[] aux4 = new Object[auxs1.size()];
            cont = 0;
            Iterator<String> it4 = auxs1.iterator();
            while(it4.hasNext()) {
                aux4[cont] = it4.next();
                ++cont;
            }
            Lsub1.setListData(aux3);
            
            Cbusca1.setText(macro.getContUser().getPareCerca(macro.getUserActual(),cercaactual));
            Cpc.setText(macro.getContUser().getParaulaClauCerca(macro.getUserActual(),cercaactual));
            CpcImp.setValue(macro.getContUser().getParaulaImpCerca(macro.getUserActual(),cercaactual));
            Csembla.setValue(macro.getContUser().getSembCerca(macro.getUserActual(),cercaactual));
            Crelacio.setValue(macro.getContUser().getRelacioCerca(macro.getUserActual(),cercaactual));
            Cdada.setValue(macro.getContUser().getAlgDadaCerca(macro.getUserActual(),cercaactual));
            Integer alg = macro.getContUser().getAlgCerca(macro.getUserActual(),cercaactual);
            if(alg==1) Algorismes.setSelectionRow(2);
            else if(alg==2) {
                Integer tipus= macro.getContUser().getAlgTipuCerca(macro.getUserActual(),cercaactual);
                if(tipus==0) Algorismes.setSelectionRow(4);
                else if(tipus==1)Algorismes.setSelectionRow(5);
                else Algorismes.setSelectionRow(3);
            }
            else Algorismes.setSelectionRow(8);
        }
        else {
            Lsub.removeAll();
            Lsub1.removeAll();
            Lsub2.removeAll();
            Cbusca1.removeAll();
            Cpc.removeAll();
            CpcImp.setValue(0);
            Csembla.setValue(5);
            Crelacio.setValue(5);
            Cdada.setValue(0);
        }
        A_CreaComunitat.setVisible(true);
        }
    }
    private void afegirFitxer(){
        AfegirFitxer aux = new AfegirFitxer(this,true);
        aux.passarmacro(macro);
        aux.setVisible(true);
    }
    private void visualitzaCerca(Boolean guardada,JTree arbre, JTextArea on) {
        //PREPAREM LA VISUALITZACIO D'AQUESTA CERCA
    //ARBRE
        DefaultMutableTreeNode arrel = new DefaultMutableTreeNode("Comunitats Obtingudes");
        DefaultTreeModel Model = new DefaultTreeModel(arrel);
       // Resultat.setModel(treeModel);
        Integer numcom =  macro.getContUser().getNumComunitatsCerca(macro.getUserActual(), cercaactual);
	//System.out.println("Hi ha "+numcom+ " comunitats: ");
	for(Integer i = 1; i <= numcom; ++i) {
           // System.out.println("	A la " + i+ " comunitat hi ha les categories: ");
            DefaultMutableTreeNode prim = new DefaultMutableTreeNode("Comunitat "+i);
            arrel.add(prim);
            Set<String> auxm = macro.getContUser().getCatCerca(macro.getUserActual(), cercaactual, i-1);
            Iterator<String> it4 = auxm.iterator();
            while(it4.hasNext()) {
                String nom = it4.next();
                DefaultMutableTreeNode seg = new DefaultMutableTreeNode(nom);
                prim.add(seg);
            }
	}
        arbre.setModel(Model);
        
        for (int i = 0; i < arbre.getRowCount(); i++) arbre.expandRow(i);

    //TEXT AREA
        //Preparem els strings en cada cas

        int algo = macro.getContUser().getAlgCerca(macro.getUserActual(), cercaactual);
        if(algo==1) algorisme = "Louvain";
        else if(algo==2) algorisme = "Girvan-Newman";
        else algorisme = "Clique";
        String tipu;
        algo = macro.getContUser().getAlgTipuCerca(macro.getUserActual(), cercaactual);
        if(algo==1) tipu= "Dispersio";
        else if(algo==2) tipu="Num Comunitats";
        else tipu="Max Betw";
        //Preparem les categories seleccionades
        int cont = 0;
        ArrayList<String> aux = macro.getContUser().getSubCerca(macro.getUserActual(), cercaactual);
        StringBuilder sb = new StringBuilder();
        for(String nom:aux) {
            sb.append("\n   "+(cont+1)+". "+nom);
            ++cont;
        }
        String subcat = sb.toString();
        //Preparem les categories a evitar
        cont = 0;
        ArrayList<String> aux2 = macro.getContUser().getEvitaCatCerca(macro.getUserActual(), cercaactual);
        StringBuilder sb2 = new StringBuilder();
        for(String nom:aux2) {
            sb2.append("\n   "+(cont+1)+". "+nom);
            ++cont;
        }
        String evita = sb2.toString();
        //Preparem les pagines a evitar
        cont = 0;
        ArrayList<String> aux3 = macro.getContUser().getEvitaPagCerca(macro.getUserActual(), cercaactual);
        StringBuilder sb3 = new StringBuilder();
        for(String nom:aux3) {
            sb3.append("\n   "+(cont+1)+". "+nom);
            ++cont;
        }
        String ignora = sb3.toString();
        //Imprimim
        String guard = "";
        if(guardada)  {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Nom: "+macro.getContUser().getNomCerca(macro.getUserActual(), cercaactual));
            sb4.append("\nComentari: "+macro.getContUser().getComentariCerca(macro.getUserActual(), cercaactual)+"\n");
            guard=sb4.toString();
        }
        on.setText(guard+"Algorisme: "+algorisme+"\nTipus de valor: "+tipu+"\nAmb la dada: "+macro.getContUser().getAlgDadaCerca(macro.getUserActual(), cercaactual)+
                "\nImportancia realció: "+macro.getContUser().getRelacioCerca(macro.getUserActual(), cercaactual)+
                "\nImportancia semblança de noms: "+macro.getContUser().getSembCerca(macro.getUserActual(), cercaactual)+
                "\nParaula clau: "+macro.getContUser().getParaulaClauCerca(macro.getUserActual(), cercaactual)+
                "\n     Amb importància: "+macro.getContUser().getParaulaImpCerca(macro.getUserActual(), cercaactual)+
                "\nCategoria pare:"+macro.getContUser().getPareCerca(macro.getUserActual(), cercaactual)+
                "\nConjunt de categories seleccionades:"+subcat+
                "\nConjunt de categories ignorades:"+evita+
                "\nConjunt de pàgines a ignorar:"+ignora);
    }
    private void ferCerca(){
        long t1,t2;
 //FEM LA CERCA       
        Integer quina = macro.getContUser().addNovaCerca(macro.getUserActual());
        cercaactual = quina;
        Integer quin, tipus;
       t1= System.currentTimeMillis();
        TreePath arbre =Algorismes.getSelectionModel().getSelectionPath();
       // System.out.println(arbre.toString());
        if(arbre.equals(null)) {
            JOptionPane.showMessageDialog(this, "Has de seleccionar un algorisme i tipus de cerca", capsalera, WARNING_MESSAGE);
         /*   Error err = new Error(this,true);
            err.ompletext("Has de seleccionar un algorisme i tipus de cerca", "OK");
            err.setVisible(true);*/
        }
       // System.out.println("ruta: "+arbre);
        
        if(arbre.getPathComponent(1).toString().equals("Louvain")) {
            quin=1;
            tipus=0;
         //   System.out.println("Louvain: quin 1 i tipus 0");
        }
        else if(arbre.getPathComponent(1).toString().equals("Newman-Girvan")) {
            quin=2;
            if(arbre.getPathComponent(2).toString().equals("Dispersio")) tipus=1;
            else if(arbre.getPathComponent(2).toString().equals("Numero Categories")) tipus=2;
            else tipus =3;
        //    System.out.println("Newman-Girvan: quin 2 i tipus "+tipus);
        }
        else {
            quin=3;
            tipus=0;
         //   System.out.println("Newman-Girvan: quin "+quin+" i tipus "+tipus);
        }
        Integer num =(Integer)Cdada.getValue();
        ListModel m = Lsub.getModel();
        ListModel m2 = Lsub1.getModel();
        ListModel m3 = Lsub2.getModel();
        int mida = m.getSize();
      //  System.out.println("Has seleccionat "+mida+" i es: "+ m.toString());
        int cont = 0;
        ArrayList<String> auxx1 = new ArrayList<String>();
        ArrayList<String> auxx2 = new ArrayList<String>();
        ArrayList<String> auxx3 = new ArrayList<String>();
        while (cont < mida) {
            auxx1.add(m.getElementAt(cont).toString());
            ++cont;
        }
       // System.out.println("mida aux1: "+mida);
       // mida = aux2.length-1;
        cont = 0;
        mida = m2.getSize();
        while (cont < mida) {
            auxx2.add(m2.getElementAt(cont).toString());
            ++cont;
        }
     //   System.out.println("mida aux2: "+mida);
      //   mida = aux3.length-1;
        cont = 0;
        mida = m3.getSize();
        while (cont < mida) {
            auxx3.add(m3.getElementAt(cont).toString());
            ++cont;
        }
       // System.out.println("mida aux3: "+mida);
        if(CpcImp.getValue()==0) Cpc.setText(new String());
        System.out.println("Fem la cerca amb "+macro.getContAdUs().getNumCats()+" categories i "+macro.getContAdUs().getNumPags()+" pàgines.");
        System.out.println("Alg: "+quin+", tipus: "+tipus+", user: "+macro.getUserActual()+ ", cerca num: "+quina+", numDada: "+num+", paraula clau: "+ Cpc.getText()+", importancia pc: "+ CpcImp.getValue()+", imp relacio: "+ Crelacio.getValue()+", imp sembla: "+  Csembla.getValue()+", lsub: "+ auxx1+", lsub1: " +auxx2+", lsub2: "+auxx3+", cbusca1: "+ Cbusca1.getText());
        macro.getContUser().addCriterisCerca(false, macro.getUserActual(), quina, Cpc.getText(), CpcImp.getValue(), Crelacio.getValue(), Csembla.getValue(), quin, tipus, num, auxx1, auxx2, auxx3, Cbusca1.getText());
       // System.out.println("he arribat aqui");
        macro.getContUser().ferCerca(macro.getUserActual(), quina);
       // System.out.println("i he fet la cerca!");
       t2= System.currentTimeMillis();
       System.out.println("Temps total cerca: "+ (t2-t1));
        guardada=1;
    }
    private void carregaCerquesFetes(){
        jTextField7.setText("Tens "+macro.getContUser().getCerquesComunitats(macro.getUserActual()).size()+" cerques fetes");
        Collection<String> auxc = macro.getContUser().getCerquesComunitats(macro.getUserActual());
        System.out.println("Les cerques son: "+auxc);
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        LlistaCerques.setListData(aux2);
    }
    private void carregaUsers() {
        ArrayList<String> auxc = macro.getContUser().getUsers();;
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        UsersAct.setListData(aux2);
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
        A_BuscaCat = new javax.swing.JPanel();
        Enrere5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        BVisCat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LlistaCateg = new javax.swing.JList();
        A_BuscaPag = new javax.swing.JPanel();
        Enrere6 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        BVisPag = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LlistaPag = new javax.swing.JList();
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
        A_VeureUsers = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        UsersAct = new javax.swing.JList();
        Enrere8 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        A_VisualitzaNovaCerca = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Resultat = new javax.swing.JTree();
        Enrere9 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        CriterisNovaCerca = new javax.swing.JTextArea();
        jButton13 = new javax.swing.JButton();
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

        Username.setText("client");

        jLabel2.setText("Username:");

        jLabel4.setText("Password:");

        Password.setText("client");

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
                            .addGroup(A_CreaComunitatLayout.createSequentialGroup()
                                .addGroup(A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane7)
                                    .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(CbuscaPag))
                            .addComponent(jLabel20)))
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGroup(A_OpcionsClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AfegeixFitxer)
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
                        .addComponent(Enrere3)))
                .addGap(0, 816, Short.MAX_VALUE))
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

        javax.swing.GroupLayout A_OpcionsAdminLayout = new javax.swing.GroupLayout(A_OpcionsAdmin);
        A_OpcionsAdmin.setLayout(A_OpcionsAdminLayout);
        A_OpcionsAdminLayout.setHorizontalGroup(
            A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addGap(261, 261, 261)
                .addComponent(Enrere4)
                .addContainerGap(1089, Short.MAX_VALUE))
        );
        A_OpcionsAdminLayout.setVerticalGroup(
            A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                .addGroup(A_OpcionsAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton8))
                    .addGroup(A_OpcionsAdminLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(Enrere4)))
                .addContainerGap(464, Short.MAX_VALUE))
        );

        getContentPane().add(A_OpcionsAdmin, "card6");

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

        javax.swing.GroupLayout A_BuscaCatLayout = new javax.swing.GroupLayout(A_BuscaCat);
        A_BuscaCat.setLayout(A_BuscaCatLayout);
        A_BuscaCatLayout.setHorizontalGroup(
            A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaCatLayout.createSequentialGroup()
                .addGroup(A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaCatLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(Enrere5))
                    .addGroup(A_BuscaCatLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(BVisCat)))
                .addContainerGap(1021, Short.MAX_VALUE))
        );
        A_BuscaCatLayout.setVerticalGroup(
            A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaCatLayout.createSequentialGroup()
                .addGroup(A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaCatLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Enrere5))
                    .addGroup(A_BuscaCatLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaCatLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(BVisCat)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_BuscaCatLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))))
        );

        getContentPane().add(A_BuscaCat, "card7");

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
        jScrollPane2.setViewportView(LlistaPag);

        javax.swing.GroupLayout A_BuscaPagLayout = new javax.swing.GroupLayout(A_BuscaPag);
        A_BuscaPag.setLayout(A_BuscaPagLayout);
        A_BuscaPagLayout.setHorizontalGroup(
            A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaPagLayout.createSequentialGroup()
                .addGroup(A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, A_BuscaPagLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BVisPag)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, A_BuscaPagLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(Enrere6)))
                .addContainerGap(1062, Short.MAX_VALUE))
        );
        A_BuscaPagLayout.setVerticalGroup(
            A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaPagLayout.createSequentialGroup()
                .addGroup(A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaPagLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Enrere6))
                    .addGroup(A_BuscaPagLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(BVisPag)
                .addGap(71, 71, 71))
        );

        getContentPane().add(A_BuscaPag, "card8");

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

        javax.swing.GroupLayout A_BuscaCatPagLayout = new javax.swing.GroupLayout(A_BuscaCatPag);
        A_BuscaCatPag.setLayout(A_BuscaCatPagLayout);
        A_BuscaCatPagLayout.setHorizontalGroup(
            A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(BVisCat1)))
                .addGap(18, 18, 18)
                .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addComponent(Enrere7)
                        .addGap(18, 18, 18)
                        .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(BVisPag1)))
                .addContainerGap(828, Short.MAX_VALUE))
        );
        A_BuscaCatPagLayout.setVerticalGroup(
            A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BVisCat1)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_BuscaCatPagLayout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4)
                                .addGap(18, 18, 18)
                                .addComponent(BVisPag1))
                            .addGroup(A_BuscaCatPagLayout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(Enrere7)))))
                .addContainerGap())
        );

        getContentPane().add(A_BuscaCatPag, "card9");

        UsersAct.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane10.setViewportView(UsersAct);

        Enrere8.setText("Enrere");
        Enrere8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere8ActionPerformed(evt);
            }
        });

        jLabel17.setText("Aquests són els usuaris actuals:");

        javax.swing.GroupLayout A_VeureUsersLayout = new javax.swing.GroupLayout(A_VeureUsers);
        A_VeureUsers.setLayout(A_VeureUsersLayout);
        A_VeureUsersLayout.setHorizontalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                .addGroup(A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(Enrere8))
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel17)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        A_VeureUsersLayout.setVerticalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel17)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(Enrere8)
                .addGap(51, 51, 51))
        );

        getContentPane().add(A_VeureUsers, "card10");

        Resultat.setAutoscrolls(true);
        Resultat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Resultat.setLargeModel(true);
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

        javax.swing.GroupLayout A_VisualitzaNovaCercaLayout = new javax.swing.GroupLayout(A_VisualitzaNovaCerca);
        A_VisualitzaNovaCerca.setLayout(A_VisualitzaNovaCercaLayout);
        A_VisualitzaNovaCercaLayout.setHorizontalGroup(
            A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(Enrere9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_VisualitzaNovaCercaLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(877, Short.MAX_VALUE))
        );
        A_VisualitzaNovaCercaLayout.setVerticalGroup(
            A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                        .addGroup(A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Enrere9)
                            .addGroup(A_VisualitzaNovaCercaLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton13)))
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane11))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(A_VisualitzaNovaCerca, "card11");

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
                            .addComponent(jLabel24))))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_GuardaCercaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Enrere10)
                .addGap(46, 46, 46))
            .addGroup(A_GuardaCercaLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jButton14)
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
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BVisCat2)
                    .addComponent(Enrere))
                .addGap(146, 146, 146))
        );
        A_VisualitzaCerquesLayout.setVerticalGroup(
            A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_VisualitzaCerquesLayout.createSequentialGroup()
                .addGroup(A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzaCerquesLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(Enrere)
                        .addGap(107, 107, 107)
                        .addComponent(BVisCat2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_VisualitzaCerquesLayout.createSequentialGroup()
                        .addContainerGap(83, Short.MAX_VALUE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
        );

        getContentPane().add(A_VisualitzaCerques, "card13");

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

        javax.swing.GroupLayout A_VisualitzacioCercaAntigaLayout = new javax.swing.GroupLayout(A_VisualitzacioCercaAntiga);
        A_VisualitzacioCercaAntiga.setLayout(A_VisualitzacioCercaAntigaLayout);
        A_VisualitzacioCercaAntigaLayout.setHorizontalGroup(
            A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(Enrere11)
                        .addGap(123, 123, 123)
                        .addComponent(Enrere12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15)
                    .addComponent(jButton3))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        A_VisualitzacioCercaAntigaLayout.setVerticalGroup(
            A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Enrere11)
                            .addComponent(Enrere12))
                        .addGroup(A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane13))
                            .addGroup(A_VisualitzacioCercaAntigaLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton15)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(A_VisualitzacioCercaAntiga, "card14");

        getAccessibleContext().setAccessibleName("WIKIPEDIA");
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
        ompleCategoriesExistents(LlistaCateg);
    }//GEN-LAST:event_BuscaCategoriesActionPerformed
    private void BuscaCatPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaCatPagActionPerformed
        A_OpcionsClient.setVisible(false);
        A_BuscaCatPag.setVisible(true);
        ompleCategoriesExistents(LlistaPag1);
        omplePaginesExistents(LlistaCateg1);
    }//GEN-LAST:event_BuscaCatPagActionPerformed
    private void Enrere5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere5ActionPerformed
        A_OpcionsClient.setVisible(true);// TODO add your handling code here:
        A_BuscaCat.setVisible(false);
    }//GEN-LAST:event_Enrere5ActionPerformed
    private void BVisCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisCatActionPerformed
        visualitzarCategoriaDe(LlistaCateg);
    }//GEN-LAST:event_BVisCatActionPerformed
    private void BuscaPaginesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaPaginesActionPerformed
       A_OpcionsClient.setVisible(false);
       A_BuscaPag.setVisible(true);
        omplePaginesExistents(LlistaPag);
    }//GEN-LAST:event_BuscaPaginesActionPerformed
    private void Enrere6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere6ActionPerformed
       A_OpcionsClient.setVisible(true);// TODO add your handling code here:
       A_BuscaPag.setVisible(false);
    }//GEN-LAST:event_Enrere6ActionPerformed
    private void BVisPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisPagActionPerformed
        visualitzarPaginaDe(LlistaPag);
    }//GEN-LAST:event_BVisPagActionPerformed
    private void BVisPag1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisPag1ActionPerformed
       visualitzarPaginaDe(LlistaPag1);
    }//GEN-LAST:event_BVisPag1ActionPerformed
    private void BVisCat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVisCat1ActionPerformed
        visualitzarCategoriaDe(LlistaCateg1);
    }//GEN-LAST:event_BVisCat1ActionPerformed
    private void Enrere7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere7ActionPerformed
        A_BuscaCatPag.setVisible(false);
        A_OpcionsClient.setVisible(true);
    }//GEN-LAST:event_Enrere7ActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        comprovaUsername();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void Enrere1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere1ActionPerformed
        A_CreaUsuari.setVisible(false);
        A_PantallaPrincipal.setVisible(true);
    }//GEN-LAST:event_Enrere1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        creaUserNou();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void CreaCercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreaCercaActionPerformed
        preaparaCreacioNovaCerca(false);
        A_OpcionsClient.setVisible(false);
    }//GEN-LAST:event_CreaCercaActionPerformed

    private void CanviaDadesUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanviaDadesUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CanviaDadesUserActionPerformed
    private void CbuscaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCatActionPerformed
        ompleCategoriesExistentsConcret(LCTotes,Cbusca);
    }//GEN-LAST:event_CbuscaCatActionPerformed
    private void Cafegeix1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix1ActionPerformed
     	modelo.addElement(LCTotes.getSelectedValue());
        System.out.println(LCTotes.getSelectedValue());
    }//GEN-LAST:event_Cafegeix1ActionPerformed
    private void EliminaCsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaCsubActionPerformed
          if(modelo.getSize()>0){
              int n = Lsub.getSelectedIndex();
              modelo.removeElementAt(n);
          }
    }//GEN-LAST:event_EliminaCsubActionPerformed
    private void AfegeixFitxerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfegeixFitxerActionPerformed
        afegirFitxer();
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
          /*  Error err = new Error(this,true);
            err.ompletext("Atenció, si cliques a continuar, la cerca no es guardarà!(cal afegir la opcio de guardar aqui tambe)", "OK");
            err.setVisible(true);*/
        }
         //   A_CreaComunitat.setVisible(false);
         //   A_OpcionsClient.setVisible(true);
    }//GEN-LAST:event_Enrere2ActionPerformed
    private void CbuscaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPagActionPerformed
        omplePaginesExistentsConcret(LPTotes,Cbusca2);
    }//GEN-LAST:event_CbuscaPagActionPerformed
    private void Cafegeix2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix2ActionPerformed
       Cbusca1.setText(LCTotes.getSelectedValue().toString());
    }//GEN-LAST:event_Cafegeix2ActionPerformed
    private void Cafegeix3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix3ActionPerformed
        modelo1.addElement(LCTotes.getSelectedValue());
    }//GEN-LAST:event_Cafegeix3ActionPerformed
    private void Cafegeix4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix4ActionPerformed
        modelo2.addElement(LPTotes.getSelectedValue());
    }//GEN-LAST:event_Cafegeix4ActionPerformed
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(modelo1.getSize()>0){
              int n = Lsub1.getSelectedIndex();
              modelo1.removeElementAt(n);
          }
    }//GEN-LAST:event_jButton9ActionPerformed
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(modelo2.getSize()>0){
              int n = Lsub2.getSelectedIndex();
              modelo2.removeElementAt(n);
          }
    }//GEN-LAST:event_jButton11ActionPerformed
    private void CercaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CercaBActionPerformed
        ferCerca();
        visualitzaCerca(false,Resultat, CriterisNovaCerca);
        A_CreaComunitat.setVisible(false);
        A_VisualitzaNovaCerca.setVisible(true);
    }//GEN-LAST:event_CercaBActionPerformed
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        carregaUsers();
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
        cercaactual = macro.getContUser().getNumCerca(macro.getUserActual(), LlistaCerques.getSelectedValue().toString());
        visualitzaCerca(true,Resultat1, CriterisNovaCerca1);
        A_VisualitzaCerques.setVisible(false);
        A_VisualitzacioCercaAntiga.setVisible(true);
    }//GEN-LAST:event_BVisCat2ActionPerformed
    private void EnrereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrereActionPerformed
        A_VisualitzaCerques.setVisible(false);
        if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
        else A_OpcionsClient.setVisible(true);
    }//GEN-LAST:event_EnrereActionPerformed

    private void VisualitzaCerquesFetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualitzaCerquesFetesActionPerformed
       A_OpcionsClient.setVisible(false);
       A_VisualitzaCerques.setVisible(true);
       carregaCerquesFetes();
    }//GEN-LAST:event_VisualitzaCerquesFetesActionPerformed

    private void Enrere11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere11ActionPerformed
        int resposta = JOptionPane.showOptionDialog(this,"Vols crear una nova cerca o sobreescriure aquesta?", capsalera,YES_NO_CANCEL_OPTION,QUESTION_MESSAGE,null,new Object[]{"Conserva aquesta","Modifica aquesta","Cancelar"},"i tu?");
        if(resposta==0) {
            cercaactual = macro.getContUser().getNumCerca(macro.getUserActual(), LlistaCerques.getSelectedValue().toString());
            preaparaCreacioNovaCerca(true);
        }
        else if (resposta==1){
            System.out.println("Es marca la 2");
        }
    }//GEN-LAST:event_Enrere11ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String nouNom =JOptionPane.showInputDialog(this,"Escriu el nou nom",QUESTION_MESSAGE);
        macro.getContUser().addNomCerca(macro.getUserActual(), cercaactual, nouNom);
        visualitzaCerca(true,Resultat1,CriterisNovaCerca1);
    }//GEN-LAST:event_jButton15ActionPerformed
    private void Enrere12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere12ActionPerformed
        A_VisualitzacioCercaAntiga.setVisible(false);
        A_VisualitzaCerques.setVisible(true);
    }//GEN-LAST:event_Enrere12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nouComen =JOptionPane.showInputDialog(this,"Escriu el nou nom",QUESTION_MESSAGE);
        macro.getContUser().addComentariCerca(macro.getUserActual(), cercaactual, nouComen);
        visualitzaCerca(true,Resultat1,CriterisNovaCerca1);
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JTree Algorismes;
    private javax.swing.JButton BVisCat;
    private javax.swing.JButton BVisCat1;
    private javax.swing.JButton BVisCat2;
    private javax.swing.JButton BVisPag;
    private javax.swing.JButton BVisPag1;
    private javax.swing.JButton BuscaCatPag;
    private javax.swing.JButton BuscaCategories;
    private javax.swing.JButton BuscaPagines;
    private javax.swing.JButton Cafegeix1;
    private javax.swing.JButton Cafegeix2;
    private javax.swing.JButton Cafegeix3;
    private javax.swing.JButton Cafegeix4;
    private javax.swing.JButton CanviaDadesUser;
    private javax.swing.JTextField Cbusca;
    private javax.swing.JTextField Cbusca1;
    private javax.swing.JTextField Cbusca2;
    private javax.swing.JButton CbuscaCat;
    private javax.swing.JButton CbuscaPag;
    private javax.swing.JSpinner Cdada;
    private javax.swing.JButton CercaB;
    private javax.swing.JTextField Cpc;
    private javax.swing.JSlider CpcImp;
    private javax.swing.JButton CreaCerca;
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
    private javax.swing.JTextField NovaPassword;
    private javax.swing.JTextField Password;
    private javax.swing.JTree Resultat;
    private javax.swing.JTree Resultat1;
    private javax.swing.JTextField Username;
    private javax.swing.JList UsersAct;
    private javax.swing.JButton VisualitzaCerquesFetes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
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