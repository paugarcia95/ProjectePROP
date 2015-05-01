package domini;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuariTest {

	@Test
	public void testConstructor() {
		Usuari u = new Usuari("Dani", "wiki", Boolean.TRUE);
		assertNotNull("No ha creat un objecte", u);
	}

	@Test
	public void testFerAdmin() {
		Usuari u = new Usuari("Dani", "wiki", Boolean.FALSE);
		Usuari u2 = new Usuari("Dani", "wiki", Boolean.TRUE);
		u.ferAdmin();
		u2.ferAdmin();
		assertTrue("Ha posat admin a false quan ja estava true", u.esAdmin() == Boolean.TRUE);
		assertTrue("No ha posat admin a true", u2.esAdmin() == Boolean.TRUE);
	}

	@Test
	public void testSetUsername() {
		Usuari u = new Usuari("Dani", "wiki", Boolean.FALSE);
		u.setUsername("Oscar");
		assertTrue("No ha canviat el nom", u.getUsername() == "Oscar");
	}

	@Test
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
