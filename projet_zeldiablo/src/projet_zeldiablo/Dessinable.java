package projet_zeldiablo;

import java.awt.Graphics;

/**
 * Représente les objet affiché par le jeu.
 * 
 * @author SCHULER Killian
 */
public interface Dessinable {

	/**
	 * Affiche l'objet dans la fenettre de jeu.
	 * 
	 * @param g contexte graphique.
	 */
	public void dessiner(Graphics g);

}
