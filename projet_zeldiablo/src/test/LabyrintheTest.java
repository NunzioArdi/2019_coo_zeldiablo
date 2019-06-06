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
	
	@Test
	public void testEstDisponible(){
		Labyrinthe lab = new Labyrinthe();

		assertEquals("x=10 n'existe pas", false, lab.estDisponible(10, 2));
		assertEquals("y=10 n'existe pas", false, lab.estDisponible(2, 10));

		assertEquals("x=-1 n'existe pas", false, lab.estDisponible(-1, 2));
		assertEquals("y=-1 n'existe pas", false, lab.estDisponible(2, -1));
		

		assertEquals("le mur ne dois pas être accessible", false, lab.estDisponible(0, 0));
		assertEquals("le chemin d'oit être accessible", true, lab.estDisponible(0,4));
	}
	
	@Test
	public void testEstPiegeMauvaiseCase(){
		Labyrinthe lab = new Labyrinthe();
		Aventurier a=new Aventurier(10);
		a.setPos(10,  10);
		lab.getCase().add(new Piege(10, 10));
		assertEquals(false, lab.estPieger(9, 10, a));
	}
	
	@Test
	public void testEstPiege(){
		Labyrinthe lab = new Labyrinthe();
		Aventurier a=new Aventurier(10);
		a.setPos(10,  10);
		lab.getCase().add(new Piege(10, 10));
		assertEquals(true, lab.estPieger(10, 10, a));
	}
	
	@Test
	public void testExploserMur(){
		Labyrinthe lab = new Labyrinthe();
		assertEquals(true, lab.exploserMur(2, 2));
			
	}
	
	@Test
	public void testExploserMurDeBord(){
		Labyrinthe lab = new Labyrinthe();
		lab.getCase().add(new Mur(10, 10));
		assertEquals(false, lab.exploserMur(10, 10));
	}
	
	@Test
	public void testExploserChemin(){
		Labyrinthe lab = new Labyrinthe();
		lab.getCase().add(new Chemin(10, 10));
		assertEquals(false, lab.exploserMur(10, 10));
	}
}
