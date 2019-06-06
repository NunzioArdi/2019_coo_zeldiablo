package projet_zeldiablo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.moteur.DessinAbstract;

/**
 * Classe qui permet de dessiner les elements du jeu
 * 
 * @author SCHULER Kilian
 *
 */
public class DessinJeuZeldiablo implements DessinAbstract {

	/** Taille des cases. */
	public static final int TAILLE = 60;

	/** Le jeu. */
	private JeuZeldiablo jzd;

	/**
	 * Constructeur de la classe
	 * 
	 * @param j Jeu qui prends en charge les sprites
	 */
	public DessinJeuZeldiablo(JeuZeldiablo j) {
		this.jzd = j;
	}

	/**
	 * Methode qui permet de mettre les images
	 * 
	 * @param image BufferedImage
	 */
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
