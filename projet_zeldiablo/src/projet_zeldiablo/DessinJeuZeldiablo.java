package projet_zeldiablo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.DessinJeu;

public class DessinJeuZeldiablo implements DessinJeu {
	
	public static final int TAILLE=100;
	
	private JeuZeldiablo jzd;
	
	public DessinJeuZeldiablo(JeuZeldiablo j) {
		this.jzd=j;
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g=(Graphics2D) image.getGraphics();
		for (Case c : this.jzd.getLab().getCase()) {
			if (c instanceof Mur) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.WHITE);
			}
			g.fillRect(c.getX()*TAILLE, c.getY()*TAILLE, TAILLE, TAILLE);
		}
		g.setColor(Color.GREEN);
		g.fillRect(this.jzd.getHero().getX()*TAILLE, this.jzd.getHero().getY()*TAILLE, TAILLE, TAILLE);
	}

}
