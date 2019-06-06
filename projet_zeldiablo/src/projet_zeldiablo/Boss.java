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
		g.setColor(Color.RED);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20, 7 * 7,
				10);
		g.setColor(Color.GREEN);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20,
				this.getPV() * 7, 10);
		
		g.setColor(Color.PINK);
		g.fillOval(super.getX()*DessinJeuZeldiablo.TAILLE, super.getY()*DessinJeuZeldiablo.TAILLE, (int)Math.random()*10, (int)Math.random()*10);
	}
}
