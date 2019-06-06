package projet_zeldiablo;

import java.awt.Color;
import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Classe représentant un aventurier du labyrinthe. C'est un type d'entitée.
 * 
 * @author CORNETTE Pierre
 * @version 1.0
 *
 */
public class Aventurier extends Entitee {

	/**
	 * Constructeur.
	 * 
	 * @param pv la vie de départ
	 */
	public Aventurier(int pv) {
		super(pv);
		Sprites.chargerImage("still_up", "images\\still_up.png");
		Sprites.chargerImage("still_right", "images\\still_right.png");
		Sprites.chargerImage("still_down", "images\\still_down.png");
		Sprites.chargerImage("still_left", "images\\still_left.png");
	}

	public void dessiner(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20, 10 * 5,
				10);
		g.setColor(Color.GREEN);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20,
				this.getPV() * 5, 10);
		switch (super.direction) {
		case 0:
			Sprites.dessiner(g, "still_right", super.getX() * DessinJeuZeldiablo.TAILLE - 2,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 1:
			Sprites.dessiner(g, "still_up", super.getX() * DessinJeuZeldiablo.TAILLE - 2,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 2:
			Sprites.dessiner(g, "still_down", super.getX() * DessinJeuZeldiablo.TAILLE - 2,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 3:
			Sprites.dessiner(g, "still_left", super.getX() * DessinJeuZeldiablo.TAILLE - 2,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;

		default:
			break;
		}

	}
}
