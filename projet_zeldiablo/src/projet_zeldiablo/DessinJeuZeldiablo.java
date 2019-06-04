package projet_zeldiablo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.DessinJeu;

/**
 * 
 * @author schuler24u
 *
 */
public class DessinJeuZeldiablo implements DessinJeu {

	public static final int TAILLE = 30;

	private JeuZeldiablo jzd;

	public DessinJeuZeldiablo(JeuZeldiablo j) {
		this.jzd = j;
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		for (Case c : this.jzd.getLab().getCase()) {
			if (c instanceof Mur) {
				g.setColor(Color.BLACK);
			} else {
				if (c instanceof Piege) {
					g.setColor(Color.MAGENTA);
				} else {
					g.setColor(Color.WHITE);
					if (c.getSortie()) {
						g.setColor(Color.CYAN);
					}
				}
			}
			g.fillRect(c.getX() * TAILLE, c.getY() * TAILLE, TAILLE, TAILLE);
		}
		for (Monstre m : this.jzd.getLab().getMonstres()) {
			if (m.getPV() > 0) {
				g.setColor(Color.RED);
				g.fillOval(m.getX() * TAILLE, m.getY() * TAILLE, TAILLE, TAILLE);
			}
		}
		g.setColor(Color.GREEN);
		if (this.jzd.getHero().getPV() == 0) {
			g.setColor(Color.GRAY);
		}
		g.fillRect(this.jzd.getHero().getX() * TAILLE, this.jzd.getHero().getY() * TAILLE, TAILLE, TAILLE);
	}	
}
