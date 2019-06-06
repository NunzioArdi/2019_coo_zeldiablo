/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import projet_zeldiablo.Aventurier;
import projet_zeldiablo.Chemin;
import projet_zeldiablo.Labyrinthe;
import projet_zeldiablo.Mur;
import projet_zeldiablo.Piege;

/**
 * @author Utilisateur
 *
 */
public class LabyrintheTest {
	
	/**
	 * Test la methode est disponible dans le cas d'une case inexistente
	 */
	@Test
	public void testEstDisponibleExistePas(){
		Labyrinthe lab = new Labyrinthe();
		assertEquals("x=10 n'existe pas", false, lab.estDisponible(10, 2));
	}
	
	/**
	 * Test la methode est disponible dans le cas d'un mur
	 */
	@Test
	public void testEstDisponibleMur(){
		Labyrinthe lab = new Labyrinthe();
		assertEquals("le mur ne dois pas �tre accessible", false, lab.estDisponible(0, 0));
		assertEquals("le chemin d'oit �tre accessible", true, lab.estDisponible(0,4));
	}
	
	/**
	 * Test la methode est disponible dans le cas d'un chemin
	 */
	@Test
	public void testEstDisponible(){
		Labyrinthe lab = new Labyrinthe();
		assertEquals("le chemin d'oit �tre accessible", true, lab.estDisponible(0,4));
	}
	
	/**
	 * Test la methode estpiege si les coordonn�es ne sont pas pi�g�e
	 */
	@Test
	public void testEstPiegeMauvaiseCase(){
		Labyrinthe lab = new Labyrinthe();
		Aventurier a=new Aventurier(10);
		a.setPos(10,  10);
		lab.getCase().add(new Piege(10, 10));
		assertEquals(false, lab.estPieger(9, 10, a));
	}
	
	/**
	 * Test la methode estpiege si les coordonn�es sont pi�g�e
	 */
	@Test
	public void testEstPiege(){
		Labyrinthe lab = new Labyrinthe();
		Aventurier a=new Aventurier(10);
		a.setPos(10,  10);
		lab.getCase().add(new Piege(10, 10));
		assertEquals(true, lab.estPieger(10, 10, a));
	}
	
	/**
	 * Test la methode exploserMur si les coordonn�es correspondent � un mur explosable
	 */
	@Test
	public void testExploserMur(){
		Labyrinthe lab = new Labyrinthe();
		assertEquals(true, lab.exploserMur(2, 2));
			
	}
	
	/**
	 * Test la methode exploserMur si les coordonn�es ne correspondent pas � un mur explosable
	 */
	@Test
	public void testExploserMurDeBord(){
		Labyrinthe lab = new Labyrinthe();
		lab.getCase().add(new Mur(10, 10));
		assertEquals(false, lab.exploserMur(10, 10));
	}
	
	/**
	 * Test la methode exploserMur si les coordonn�es correspondent � un chemin
	 */
	@Test
	public void testExploserChemin(){
		Labyrinthe lab = new Labyrinthe();
		lab.getCase().add(new Chemin(10, 10));
		assertEquals(false, lab.exploserMur(10, 10));
	}
}
