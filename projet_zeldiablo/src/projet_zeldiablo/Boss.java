package projet_zeldiablo;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Le Boss final du jeuej
 * 
 * @author YTP
 */
public class Boss extends Monstre {

	/**
	 * Constructeur.
	 * 
	 * @param vie les pv du boss.
	 */
	public Boss(int vie) {
		super(vie);
	}

	@Override
	public void dessiner(Graphics g) {
		g.setColor(Color.PINK);
		g.fillOval(super.getX()*DessinJeuZeldiablo.TAILLE, super.getY()*DessinJeuZeldiablo.TAILLE, 42, 42);
	}
}
