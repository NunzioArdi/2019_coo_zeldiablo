	package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import projet_zeldiablo.Goblin;
import projet_zeldiablo.JeuZeldiablo;

public class EntiteeTest {

	
	/**
	 * Test de la methode attaquer
	 */
	@Test
	public void test_attaquer() {
		JeuZeldiablo jdz = new JeuZeldiablo();
		int[] coo=jdz.getHero().attaquer();
		assertEquals(1, coo[0]);
		assertEquals(4, coo[1]);
		assertEquals(5, coo[2]);
	}
	
	/**
	 * Test de la methode se deplacer si on se deplace vers le nord
	 */
	@Test
	public void test_seDeplacerNord() {
		JeuZeldiablo jdz = new JeuZeldiablo();
		jdz.getEtage().getMonstres().add(new Goblin(10));
		int[] coo=jdz.getHero().seDeplacer('N');
		assertEquals(0, coo[0]);
		assertEquals(3, coo[1]);
	}
	
	/**
	 * Test de la methode se deplacer si on se deplace vers l'est
	 */
	@Test
	public void test_seDeplacerEst() {
		JeuZeldiablo jdz = new JeuZeldiablo();
		jdz.getEtage().getMonstres().add(new Goblin(10));
		int[] coo=jdz.getHero().seDeplacer('E');
		assertEquals(1, coo[0]);
		assertEquals(4, coo[1]);
	}
	
	/**
	 * Test de la methode se deplacer si on se deplace vers le sud
	 */
	@Test
	public void test_seDeplacerSud() {
		JeuZeldiablo jdz = new JeuZeldiablo();
		jdz.getEtage().getMonstres().add(new Goblin(10));
		jdz.getHero().setPos(1, 3);
		int[] coo=jdz.getHero().seDeplacer('S');
		assertEquals(1, coo[0]);
		assertEquals(4, coo[1]);
	}
	
	/**
	 * Test de la methode se deplacer si on se deplace vers l'ouest
	 */
	@Test
	public void test_seDeplacerWest() {
		JeuZeldiablo jdz = new JeuZeldiablo();
		jdz.getEtage().getMonstres().add(new Goblin(10));
		jdz.getHero().setPos(1, 4);
		int[] coo=jdz.getHero().seDeplacer('W');
		assertEquals(0, coo[0]);
		assertEquals(4, coo[1]);
	}
	
	/**
	 * Test de la methode poserBombe si il reste des bombes au héro
	 */
	@Test
	public void test_poserBombeResteBombe() {
		JeuZeldiablo jdz = new JeuZeldiablo();
		int[] coo=jdz.getHero().poserBombe();
		assertEquals(1, coo[0]);
		assertEquals(4, coo[1]);
		assertEquals(1, coo[2]);
	}
	
	/**
	 * Test de la methode poserBombe si il ne reste pas des bombes au héro
	 */
	@Test
	public void test_poserBombePlusDeBombe() {
		JeuZeldiablo jdz = new JeuZeldiablo();	
		jdz.getHero().setBombe(0);
		int[] coo=jdz.getHero().poserBombe();
		assertEquals(0, coo[2]);
	}
	

}