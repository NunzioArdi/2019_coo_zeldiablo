package test;

import static org.junit.Assert.*;
import org.junit.Test;
import projet_zeldiablo.Aventurier;
import projet_zeldiablo.Case;
import projet_zeldiablo.Labyrinthe;
import projet_zeldiablo.Piege;

public class PiegeTest {

	@Test
	public void testPiegeActivee(){
		Aventurier a = new Aventurier(2);
		Piege p = new Piege(0, 0);
		p.activer(a);
		assertEquals("Il devrai rester 1 pv", 1, a.getPV());
	}
}

