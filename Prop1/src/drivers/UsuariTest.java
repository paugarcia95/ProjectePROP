package drivers;

import domini.CercaComunitats;
import domini.Usuari;
import junit.framework.TestCase;

/**
 * @author Dani
 *
 */

public class UsuariTest extends TestCase{

	
	public UsuariTest() {
		super("UsuariTest");
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testConstructorAtributs() {
		Usuari u = new Usuari("Dani", "wiki", Boolean.TRUE);
		assertNotNull("No ha creat un objecte", u);
		assertTrue("Ha posat malament el nom", u.getUsername() == "Dani");
		assertTrue("Ha posat malament la password", u.getPassword() == "wiki");
		assertTrue("Ha posat admin a false i ha de ser true", u.esAdmin() == Boolean.TRUE);
		assertTrue("No ha inicialitzat les cerquesFetes", u.getNumCerques() == 0);
		assertNull("Retorna una referencia no nula quan hauria de ser nula", u.getCerca(5));
		assertNull("Retorna una referencia no nula quan hauria de ser nula", u.getCerca("Medicina"));
		assertTrue("No retorna -1 quan no existeix la cerca", u.getPosCerca("Medicina") == -1);
		assertTrue("No ha inicialitzat les cerquesFetes o no retorna false quan no existeix una cerca", u.existsCerca("Medicina") == Boolean.FALSE);
	}
	
	public void testConstructorBuit() {
		Usuari u = new Usuari();
		assertNotNull("No ha creat un objecte", u);
		assertTrue("Ha inicialitzat malament el nom", u.getUsername() == "NoIndicat");
		assertNull("Retorna una referencia no nula quan hauria de ser nula", u.getPassword());
		assertTrue("Ha inicialitzat admin a true quan és false", u.esAdmin() == Boolean.FALSE);
		assertTrue("No ha inicialitzat les cerquesFetes", u.getNumCerques() == 0);
		assertNull("Retorna una referencia no nula quan hauria de ser nula", u.getCerca(5));
		assertNull("Retorna una referencia no nula quan hauria de ser nula", u.getCerca("Medicina"));
		assertTrue("No retorna -1 quan no existeix la cerca", u.getPosCerca("Medicina") == -1);
		assertTrue("No ha inicialitzat les cerquesFetes o no retorna false quan no existeix una cerca", u.existsCerca("Medicina") == Boolean.FALSE);	
	}

	public void testFerAdmin() {
		Usuari u = new Usuari("Dani", "wiki", Boolean.FALSE);
		Usuari u2 = new Usuari("Dani", "wiki", Boolean.TRUE);
		u.ferAdmin();
		u2.ferAdmin();
		assertTrue("Ha posat admin a false quan ja estava true", u.esAdmin() == Boolean.TRUE);
		assertTrue("No ha posat admin a true", u2.esAdmin() == Boolean.TRUE);
	}

	public void testSetUsername() {
		Usuari u = new Usuari("Dani", "wiki", Boolean.FALSE);
		u.setUsername("Oscar");
		assertTrue("No ha canviat el nom", u.getUsername() == "Oscar");
	}

	public void testSetPassword() {
		Usuari u = new Usuari("Dani", "wiki", Boolean.FALSE);
		u.setPassword("entrega");
		assertTrue("No ha canviat la password", u.getPassword() == "entrega");
	}

	public void testAddCerca() {
		Usuari u = new Usuari();
		CercaComunitats a = new CercaComunitats("Primera"); 
		u.addCerca(a);
		assertTrue("No ha retornat el mateix objecte que s'ha guardat", u.getCerca("Primera") == a);
		assertTrue("No ha retornat el mateix objecte que s'ha guardat o no l'ha guardat a la posició corresponent", u.getCerca(0) == a);
	}

	public void testRemoveCercaTresTipus() {
		Usuari u = new Usuari();
		CercaComunitats a = new CercaComunitats("Primera"); 
		u.addCerca(a);
		u.removeCerca(a);
		
		u.addCerca(a);
		u.removeCerca(0);
		assertNull("No ha eliminat la cerca", u.getCerca("Primera"));
		
		u.addCerca(a);
		u.removeCerca("Primera");
		assertNull("No ha eliminat la cerca", u.getCerca("Primera"));
	}

}
