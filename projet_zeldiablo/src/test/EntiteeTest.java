	package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import projet_zeldiablo.Aventurier;
import projet_zeldiablo.JeuZeldiablo;
import projet_zeldiablo.Labyrinthe;

public class EntiteeTest {

	
	
	@Test
	public void test_attaquer_vide() {
		JeuZeldiablo jdz = new JeuZeldiablo();
		jdz.getHero().attaquer();
		assertEquals("il devrait rester 2 pv", 2, jdz.getEtage().getMonstres().get(0).getPV());
		assertEquals("il devrait rester 7 pv", 7, jdz.getEtage().getMonstres().get(1).getPV());
		assertEquals("il devrait rester 5 pv", 5, jdz.getEtage().getMonstres().get(2).getPV());
	}
}