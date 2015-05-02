/**
 * 
 */
package drivers;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;








import domini.Categoria;
import domini.ControladorTraduirAlgorisme;
import domini.Criteris;
import domini.EntradaSortidaDadesGraf;
import domini.GrafDades;
import domini.Pagina;
import domini.ParaulaValor;


/**
 * @author Alr
 *
 */



public class driverTraduirAlgorisme {
	/**
	 * @param args
	 */
	 
	 
	public static void main(String[] args) {
		EntradaSortidaDadesGraf obj = new EntradaSortidaDadesGraf();
		GrafDades G = new GrafDades();
		try {
			G = obj.loadGraph("C:/Users/Alr/Downloads/cats.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Categoria c1 = new Categoria("Sanitari");
		Categoria c2 = new Categoria("Metgessa");
		G.addCategoria(c1);
		G.addCategoria(c2);
		G.addCC(c1, c2);
		Criteris cri = new Criteris();
		cri.setAlgorisme(2);
		cri.setDada(5);
		cri.setRelacionsCat(5);
		cri.setTipuCerca(2);
		ArrayList<Categoria> c = new ArrayList<Categoria>();
		ArrayList<Pagina> s = new ArrayList<Pagina>();
		cri.setSubconjCat(c);
		ParaulaValor caca = new ParaulaValor("caca", 0);
		cri.setParaulaClau(caca);
		cri.setEvitaCat(c);
		cri.setEvitaPag(s);
		cri.setSemblaNom(5);
		ControladorTraduirAlgorisme trd = new ControladorTraduirAlgorisme();
		trd.GrafDadestoGraf(G, cri);
		System.out.println("SACABOOOOO");
	}

}
