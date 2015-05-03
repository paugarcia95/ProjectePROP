package drivers;

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

	/*@Test
	public void testGetUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumCerques() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCerca() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCerca() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveCercaCercaComunitats() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveCercaInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsAdmin() {
		fail("Not yet implemented");
	}*/

}
