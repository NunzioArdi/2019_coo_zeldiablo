/**
 * 
 */
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import projet_zeldiablo.Aventurier;
import projet_zeldiablo.Case;
import projet_zeldiablo.Chemin;
import projet_zeldiablo.JeuZeldiablo;
import projet_zeldiablo.Labyrinthe;
import projet_zeldiablo.Mur;

/**
 * @author Utilisateur
 *
 */
public class LabyrintheTest {


	/**
	 * Test le constructeur si les cases générées forme bien un caré de 10*10 avec
	 * des cases de type mur entourant se carré
	 * 
	 * @throws AventurierException exception levé si l'aventurier est null
	 *
	 */
	//TODO
//	@Test
//	public void testConstructeurCase() {
//		Labyrinthe lab = new Labyrinthe();
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				if (i == 0 || j == 0 || i == 9 || j == 9) {
//					if (i == 0 && j == 4 || i == 9 && j == 4)
//						assertEquals("La case " + i + " " + j + " doit être un chemin", true);
//					else
//						assertEquals("La case " + i + " " + j + " doit être un mur", true);
//
//				} else
//					assertEquals("La case " + i + " " + j + " doit être un chemin", true);
//			}
//		}
//	}

	/**
	 * Test si les coordonnée sont disponible. Test les cas suitvant : coorodnnée <0
	 * ou >9, coordonnée d'un mur, coordonnée d'un chemin, coordonnée sur une entité
	 * 
	 * @throws AventurierException exception levé si l'aventurier est null
	 */
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
}
