/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

import javax.swing.JTabbedPane;
import static Interficie.InterficiaProva1.AP_Afegeix;
import static Interficie.InterficiaProva1.A_Afegeix;
/**
 *
 * @author Cristina
 */
public class ControladorRafa {
    
    public void ini(){
                
                A_Afegeix = new Afegeix();
                AP_Afegeix.add(A_Afegeix,"Burro");
    }
    
    public void canviaAASFADFG(){
        AP_Afegeix.setSelectedIndex(0);
    }
    
    
    
    
    
}