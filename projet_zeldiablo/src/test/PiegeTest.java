package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.AventurierException;
import projet_zeldiablo.Aventurier;
import projet_zeldiablo.Case;
import projet_zeldiablo.Labyrinthe;
import projet_zeldiablo.Piege;

public class PiegeTest {

	@Test
	public void testPiegeActivee() throws AventurierException {
		int pv = 2;
		int x = 2;
		int y = 2;
		Aventurier a = new Aventurier(pv);
		Labyrinthe l = new Labyrinthe(a);
		Piege p = new Piege(x, y);
		l.estPieger(x, y, a);
		p.activer(a);
		assertEquals("Il devrai rester 1 pv", 1, pv);
	}

}

