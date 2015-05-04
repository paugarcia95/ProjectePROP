package drivers;

import domini.Categoria;
import domini.CercaComunitats;
import domini.Comunitat;
import domini.Criteris;
import domini.Pagina;
import domini.ParaulaValor;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

/**
 * @author Dani
 *
 */

public class CercaComunitatsTest extends TestCase{
	
	public CercaComunitatsTest() {
		super("CercaComunitatsTest");
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testConstructorAtributs() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		Date ara = new Date();
		CercaComunitats ce = new CercaComunitats("Nom", ara, c, "username", ara, "coment", new ArrayList<Comunitat>());
		assertNotNull("No ha creat un objecte", ce);
		assertTrue("Ha posat malament nom", ce.getNom().equals("Nom"));
		assertTrue("Ha posat malament dataCreacio", ce.getDataCreacio() == ara);
		assertTrue("Ha posat malament criterisSeleccio", ce.getCriterisSeleccio() == c);
		assertTrue("Ha posat malament comentari", ce.getComentari().equals("coment"));
		assertTrue("Ha posat malament usuari", ce.getUsuari().equals("username"));
		assertTrue("Ha posat malament dataModificacio", ce.getDataModificacio() == ara);
		assertNull("Ha posat malament comunitats", ce.getComunitat(0));
		assertTrue("Ha posat malament nComunitats", ce.getNumComunitats() == 0);
	}
	
	public void testConstructorString() {
		CercaComunitats ce = new CercaComunitats("Nom");
		assertNotNull("No ha creat un objecte", ce);
		assertTrue("Ha posat malament nom", ce.getNom().equals("Nom"));
		assertNotNull("No ha inicialitzat dataCreacio", ce.getDataCreacio());
		assertNull("Ha inicialitzat criteris", ce.getCriterisSeleccio());
		assertNull("Ha inicialitzat comentari", ce.getComentari());
		assertNull("Ha inicialitzat usuari", ce.getUsuari());
		assertNull("Ha inicialitzat dataModificacio", ce.getDataModificacio());
		assertTrue("Ha posat malament dataModificacio", ce.getNumComunitats() == 0);
	}
	
	public void testConstructorBuit() {
		CercaComunitats ce = new CercaComunitats();
		assertNotNull("No ha creat un objecte", ce);
		assertNull("Ha inicialitzat nom", ce.getNom());
		assertNotNull("No ha inicialitzat dataCreacio", ce.getDataCreacio());
		assertNull("Ha inicialitzat criteris", ce.getCriterisSeleccio());
		assertNull("Ha inicialitzat comentari", ce.getComentari());
		assertNull("Ha inicialitzat usuari", ce.getUsuari());
		assertNull("Ha inicialitzat dataModificacio", ce.getDataModificacio());
		assertTrue("Ha posat malament dataModificacio", ce.getNumComunitats() == 0);
	}
}
