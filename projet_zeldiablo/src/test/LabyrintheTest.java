/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.AventurierException;
import projet_zeldiablo.Aventurier;
import projet_zeldiablo.Case;
import projet_zeldiablo.Chemin;
import projet_zeldiablo.Labyrinthe;
import projet_zeldiablo.Mur;

/**
 * @author Utilisateur
 *
 */
public class LabyrintheTest {

	/**
	 * Test le constructeur avec un Aventurier null;
	 * 
	 * @throws AventurierException exception lev� si l'aventurier est null
	 */
	@Test(expected = AventurierException.class)
	public void testConstructeurNull() throws AventurierException {
		Aventurier a = null;
		Labyrinthe lab = new Labyrinthe(a);
	}

	/**
	 * Test le constructeur si les cases g�n�r�es forme bien un car� de 10*10 avec
	 * des cases de type mur entourant se carr�
	 * 
	 * @throws AventurierException exception lev� si l'aventurier est null
	 */
	@Test
	public void testConstructeurCase() throws AventurierException {
		Labyrinthe lab = new Labyrinthe(new Aventurier(1));
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 || j == 0 || i == 9 || j == 9) {
					if (i == 0 && j == 4 || i == 4 && j == 0 || i == 4 && j == 9 || i == 9 && j == 4)
						assertEquals("La case " + i + " " + j + " doit �tre un chemin", true,
								lab.getCase(i, j) instanceof Chemin);
					else
						assertEquals("La case " + i + " " + j + " doit �tre un mur", true,
								lab.getCase(i, j) instanceof Mur);

				} else
					assertEquals("La case " + i + " " + j + " doit �tre un chemin", true,
							lab.getCase(i, j) instanceof Chemin);
			}
		}
	}

	/**
	 * Test si l'aventurier �tre bien positionn�e en 1,1 au d�part.
	 * 
	 * @throws AventurierException exception lev� si l'aventurier est null
	 */
	@Test
	public void testConstructeurInitialisationAventurier() throws AventurierException {
		Aventurier a = new Aventurier(1);
		Labyrinthe lab = new Labyrinthe(a);
		assertEquals("l'abscisse devrait �tre � 1", 1, a.getX());
		assertEquals("l'ordonn�e devrait �tre � 1", 1, a.getY());
	}

	/**
	 * Test si les coordonn�e sont disponible. Test les cas suitvant : coorodnn�e <0
	 * ou >9, coordonn�e d'un mur, coordonn�e d'un chemin
	 * 
	 * @throws AventurierException exception lev� si l'aventurier est null
	 */
	public void testEstDisponible() throws AventurierException {
		Aventurier a = new Aventurier(1);
		Labyrinthe lab = new Labyrinthe(a);

		assertEquals("x=10 n'existe pas", false, lab.estDisponible(10, 2));
		assertEquals("y=10 n'existe pas", false, lab.estDisponible(2, 10));

		assertEquals("x=-1 n'existe pas", false, lab.estDisponible(-1, 2));
		assertEquals("y=-1 n'existe pas", false, lab.estDisponible(2, -1));
		

		assertEquals("le mur ne dois pas �tre accessible", false, lab.estDisponible(0, 0));
		assertEquals("le chemin d'oit �tre accessible", true, lab.estDisponible(2, 2));
	}
}
