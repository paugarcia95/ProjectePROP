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
		ArrayList<String> sub = new ArrayList<String>();
		ArrayList<String> evitaCategoria = new ArrayList<String>();
		ArrayList<String> evitaPagina = new ArrayList<String>();
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
	
	public void testSetNom() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<String> sub = new ArrayList<String>();
		ArrayList<String> evitaCategoria = new ArrayList<String>();
		ArrayList<String> evitaPagina = new ArrayList<String>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		Date ara = new Date();
		CercaComunitats ce = new CercaComunitats("Nom", ara, c, "username", ara, "coment", new ArrayList<Comunitat>());
		ce.setNom("cerca");
		assertTrue("No ha canviat nom", ce.getNom().equals("cerca"));
	}
	
	public void testSetDataCreacio() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<String> sub = new ArrayList<String>();
		ArrayList<String> evitaCategoria = new ArrayList<String>();
		ArrayList<String> evitaPagina = new ArrayList<String>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		Date ara = new Date();
		CercaComunitats ce = new CercaComunitats("Nom", ara, c, "username", ara, "coment", new ArrayList<Comunitat>());
		Date despres = new Date();
		ce.setDataCreacio(despres);
		assertTrue("No ha canviat dataCreacio", ce.getDataCreacio() == despres);
	}
	
	public void testSetCriterisSeleccio() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<String> sub = new ArrayList<String>();
		ArrayList<String> evitaCategoria = new ArrayList<String>();
		ArrayList<String> evitaPagina = new ArrayList<String>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		Date ara = new Date();
		CercaComunitats ce = new CercaComunitats("Nom", ara, c, "username", ara, "coment", new ArrayList<Comunitat>());
		Criteris crit = new Criteris();
		ce.setCriterisSeleccio(crit);
		assertTrue("No ha canviat criterisSeleccio", ce.getCriterisSeleccio() == crit);
	}
	
	public void testSetComentari() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<String> sub = new ArrayList<String>();
		ArrayList<String> evitaCategoria = new ArrayList<String>();
		ArrayList<String> evitaPagina = new ArrayList<String>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		Date ara = new Date();
		CercaComunitats ce = new CercaComunitats("Nom", ara, c, "username", ara, "coment", new ArrayList<Comunitat>());
		ce.setComentari("NewComent");
		assertTrue("No ha canviat comentari", ce.getComentari().equals("NewComent"));
	}
	
	public void testSetUsuari() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<String> sub = new ArrayList<String>();
		ArrayList<String> evitaCategoria = new ArrayList<String>();
		ArrayList<String> evitaPagina = new ArrayList<String>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		Date ara = new Date();
		CercaComunitats ce = new CercaComunitats("Nom", ara, c, "username", ara, "coment", new ArrayList<Comunitat>());
		ce.setUsuari("NewUsername");
		assertTrue("No ha canviat usuari", ce.getUsuari().equals("NewUsername"));
	}
	
	public void testSetDataModificacio() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<String> sub = new ArrayList<String>();
		ArrayList<String> evitaCategoria = new ArrayList<String>();
		ArrayList<String> evitaPagina = new ArrayList<String>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		Date ara = new Date();
		CercaComunitats ce = new CercaComunitats("Nom", ara, c, "username", ara, "coment", new ArrayList<Comunitat>());
		Date despres = new Date();
		ce.setDataModificacio(despres);
		assertTrue("No ha canviat dataCreacio", ce.getDataModificacio() == despres);
	}
	
	public void testSetComunitats() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<String> sub = new ArrayList<String>();
		ArrayList<String> evitaCategoria = new ArrayList<String>();
		ArrayList<String> evitaPagina = new ArrayList<String>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		Date ara = new Date();
		CercaComunitats ce = new CercaComunitats("Nom", ara, c, "username", ara, "coment", new ArrayList<Comunitat>());
		ArrayList<Comunitat> co = new ArrayList<Comunitat>();
		Comunitat aux = new Comunitat();
		co.add(aux);
		ce.setComunitats(co);
		assertTrue("No ha canviat comunitats", ce.getNumComunitats() == 1);
		assertNotNull("No ha canviat comunitats", ce.getComunitat(0));
		//EXTRA remove
		ce.removeComunitat(0);
		//assertTrue("No ha canviat comunitats al fer remove", ce.getComunitat(0) == aux);
		//assertNull("No ha esborrat comunitat", ce.getComunitat(0));
		assertTrue("No ha esborrat comunitats", ce.getNumComunitats() == 0);
	}
	
}
