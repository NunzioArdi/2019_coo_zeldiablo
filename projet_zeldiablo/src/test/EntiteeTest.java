package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import exception.AventurierException;
import projet_zeldiablo.Aventurier;
import projet_zeldiablo.Labyrinthe;

public class EntiteeTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_attaquer_restepv() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.attaquer(3, 3, l);
		assertEquals("il devrait rester 2 pv", 2, l.getMonstres().get(0).getPV());
	}
	
	@Test
	public void test_attaquer_0pv() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.attaquer(7, 7, l);
		assertEquals("il devrait rester 0 pv", 0, l.getMonstres().get(2).getPV());
	}
	
	@Test
	public void test_attaquer_pvnegatif() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.attaquer(2, 7, l);
		assertEquals("il devrait rester 0 pv", 0, l.getMonstres().get(1).getPV());
		
	}

}
