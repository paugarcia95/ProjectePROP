/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

import javax.swing.JTabbedPane;
import static Interficie.InterficieWiki.AP_Afegeix;
import static Interficie.InterficieWiki.A_Afegeix;
/**
 *
 * @author Rafa Lucena
 */
public class ControladorRafa {
    
    public void ini(){
                A_Afegeix = new Afegeix();
                AP_Afegeix.add(A_Afegeix,"Afegir des de fitxer");
                A_Afegeix = new AfegirCat();
                AP_Afegeix.add(A_Afegeix,"Afegir Categoria");
                A_Afegeix = new AfegirPag();
                AP_Afegeix.add(A_Afegeix,"Afegir P�gina");
                A_Afegeix = new AfegirEnll();
                AP_Afegeix.add(A_Afegeix,"Afegir Enlla�");
                A_Afegeix = new EliminarDades();
                AP_Afegeix.add(A_Afegeix,"Eliminaci� de dades");
    }
    
}
