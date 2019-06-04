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

		Sprites.chargerImage("Wall", "images\\Wall2.png");
		Sprites.chargerImage("Chemin", "images\\chemin2.png");
		Sprites.chargerImage("Piege", "images\\chemin_pigee.png");

		Sprites.chargerFeuille("Phantome", "images\\Phantome.png", 12, 8);
		Sprites.chargerFeuille("Goblin", "images\\goblinsword.png", 11, 5);
		Sprites.chargerImage("hero", "images\\Link_de_face.png");
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		for (Case c : this.jzd.getEtage().getCase()) {
			if (c instanceof Mur) {
				Sprites.dessiner(g, "Wall", c.getX() * TAILLE, c.getY() * TAILLE);
			} else {
				if (c instanceof Piege) {
					Sprites.dessiner(g, "Piege", c.getX() * TAILLE, c.getY() * TAILLE);
				} else {
					Sprites.dessiner(g, "Chemin", c.getX() * TAILLE, c.getY() * TAILLE);
				}

			}
			for (Monstre m : this.jzd.getEtage().getMonstres()) {
				if (m.getPV() > 0) {
					g.setColor(Color.RED);
					Sprites.dessiner(g, "Goblin_0_0", m.getX() * TAILLE, m.getY() * TAILLE);
					Sprites.dessiner(g, "Phantome_0_0", m.getX() * TAILLE, m.getY() * TAILLE);
				}
			}
			if (this.jzd.getHero().getPV() == 0) {
				g.setColor(Color.GRAY);
			}
			Sprites.dessiner(g, "hero", this.jzd.getHero().getX() * TAILLE, this.jzd.getHero().getY() * TAILLE);
		}
	}
}
