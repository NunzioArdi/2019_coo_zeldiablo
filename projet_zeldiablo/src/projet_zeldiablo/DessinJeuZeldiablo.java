package projet_zeldiablo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import moteurJeu.sprite.Sprite;
import moteurJeu.sprite.Sprites;

import javax.imageio.ImageIO;

import moteurJeu.moteur.DessinAbstract;

/**
 * 
 * @author schuler24u
 *
 */
public class DessinJeuZeldiablo implements DessinAbstract {

	public static final int TAILLE = 60;

	private JeuZeldiablo jzd;

	public DessinJeuZeldiablo(JeuZeldiablo j) {
		this.jzd = j;
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		for (Case c : this.jzd.getEtage().getCase()) {
			c.dessiner(g);
			for (Monstre m : this.jzd.getEtage().getMonstres()) {
				if (m.getPV() > 0) {
					m.dessiner(g);
				}
			}
			this.jzd.getHero().dessiner(g);
		}
	}
}
