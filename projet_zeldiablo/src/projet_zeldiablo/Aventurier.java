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
		Sprites.chargerImage("still_up", "images\\still_up.png");
		Sprites.chargerImage("still_right", "images\\still_right.png");
		Sprites.chargerImage("still_down", "images\\still_down.png");
		Sprites.chargerImage("still_left", "images\\still_left.png");
	}

	public void dessiner(Graphics g) {
		
		switch (super.direction) {
		case 0:
			Sprites.dessiner(g, "still_right", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 1:
			Sprites.dessiner(g, "still_up", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 2:
			Sprites.dessiner(g, "still_down", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 3:
			Sprites.dessiner(g, "still_left", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
			
		default:
			break;
		}
		
	}
}
