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
	 * Test le constructeur si les cases g�n�r�es forme bien un car� de 10*10 avec
	 * des cases de type mur entourant se carr�
	 * 
	 * @throws AventurierException exception lev� si l'aventurier est null
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
//						assertEquals("La case " + i + " " + j + " doit �tre un chemin", true);
//					else
//						assertEquals("La case " + i + " " + j + " doit �tre un mur", true);
//
//				} else
//					assertEquals("La case " + i + " " + j + " doit �tre un chemin", true);
//			}
//		}
//	}

	/**
	 * Test si les coordonn�e sont disponible. Test les cas suitvant : coorodnn�e <0
	 * ou >9, coordonn�e d'un mur, coordonn�e d'un chemin, coordonn�e sur une entit�
	 * 
	 * @throws AventurierException exception lev� si l'aventurier est null
	 */
	@Test
	public void testEstDisponible(){
		Labyrinthe lab = new Labyrinthe();

		assertEquals("x=10 n'existe pas", false, lab.estDisponible(10, 2));
		assertEquals("y=10 n'existe pas", false, lab.estDisponible(2, 10));

		assertEquals("x=-1 n'existe pas", false, lab.estDisponible(-1, 2));
		assertEquals("y=-1 n'existe pas", false, lab.estDisponible(2, -1));
		

		assertEquals("le mur ne dois pas �tre accessible", false, lab.estDisponible(0, 0));
		assertEquals("le chemin d'oit �tre accessible", true, lab.estDisponible(0,4));
	}
}
