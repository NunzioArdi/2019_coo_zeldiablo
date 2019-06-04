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
	public void test_seDeplacer_Chemin() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.seDeplacer('E', l);
		assertEquals("la coordonnee devrait etre 1", 1, a.getX());
		assertEquals("la coordonnee devrait etre 4", 4, a.getY());
	}
	
	@Test
	public void test_seDeplacer_Mur() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.seDeplacer('N', l);
		assertEquals("la coordonnee devrait etre 0", 0, a.getX());
		assertEquals("la coordonnee devrait etre 4", 4, a.getY());
	}
	
	@Test
	public void test_seDeplacer_Monstre() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.seDeplacer('E', l);
		a.seDeplacer('E', l);
		a.seDeplacer('E', l);
		a.seDeplacer('N', l);
		assertEquals("la coordonnee devrait etre 1", 3, a.getX());
		assertEquals("la coordonnee devrait etre 4", 4, a.getY());
	}
	
	@Test
	public void test_seDeplacer_Monstre_Traversable() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.seDeplacer('E', l);
		a.seDeplacer('E', l);
		a.seDeplacer('S', l);
		a.seDeplacer('S', l);
		a.seDeplacer('S', l);
		assertEquals("la coordonnee devrait etre 1", 2, a.getX());
		assertEquals("la coordonnee devrait etre 4", 7, a.getY());
	}
	
	@Test
	public void test_attaquer_vide() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.attaquer(2, 2, l);
		assertEquals("il devrait rester 2 pv", 7, l.getMonstres().get(0).getPV());
		assertEquals("il devrait rester 2 pv", 5, l.getMonstres().get(2).getPV());
		assertEquals("il devrait rester 2 pv", 2, l.getMonstres().get(1).getPV());
	}

	@Test
	public void test_attaquer_restepv() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.attaquer(3, 3, l);
		assertEquals("il devrait rester 2 pv", 2, l.getMonstres().get(0).getPV());
		assertEquals("il devrait rester 2 pv", 5, l.getMonstres().get(2).getPV());
		assertEquals("il devrait rester 2 pv", 2, l.getMonstres().get(1).getPV());
	}
	
	@Test
	public void test_attaquer_0pv() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.attaquer(7, 7, l);
		assertEquals("il devrait rester 2 pv", 7, l.getMonstres().get(0).getPV());
		assertEquals("il devrait rester 2 pv", 0, l.getMonstres().get(2).getPV());
		assertEquals("il devrait rester 0 pv", 2, l.getMonstres().get(1).getPV());
	}
	
	@Test
	public void test_attaquer_pvnegatif() throws AventurierException {
		Aventurier a=new Aventurier(10);
		Labyrinthe l=new Labyrinthe(a);
		a.attaquer(2, 7, l);
		assertEquals("il devrait rester 2 pv", 7, l.getMonstres().get(0).getPV());
		assertEquals("il devrait rester 2 pv", 5, l.getMonstres().get(2).getPV());
		assertEquals("il devrait rester 0 pv", 0, l.getMonstres().get(1).getPV());
	}

}
