package projet_zeldiablo;

import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Classe repr�sentant un aventurier du labyrinthe. C'est un type d'entit�e.
 * 
 * @author CORNETTE Pierre
 * @version 1.0
 *
 */
public class Aventurier extends Entitee {

	/**
	 * Constructeur.
	 * 
	 * @param pv la vie de d�part
	 */
	public Aventurier(int pv) {
		super(pv);
		Sprites.chargerImage("hero", "images\\Link_de_face.png");
	}

	
	public void dessiner(Graphics g) {
		Sprites.dessiner(g, "hero", super.getX()* DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
	}
}
