package projet_zeldiablo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Classe repr�sentant un aventurier du labyrinthe. C'est un type d'entit�e.
 * 
 * @author CORNETTE Pierre
 * @author CONTE Nunzio
 * @author SCHULER Kilian
 *
 */
public class Aventurier extends Entitee {

	/** le nombre de bombes que poss�de l'aventurier. */
	private int bombes;

	/** nombre de hero (pour les test) */
	private static int count = 0;

	/**
	 * Constructeur.
	 * 
	 * @param pv la vie de d�part
	 */
	public Aventurier(int pv) {
		super(pv);
		this.bombes = 99;
		count++;
		Sprites.chargerImage("still_up" + count, "images\\still_up.png");
		Sprites.chargerImage("still_right" + count, "images\\still_right.png");
		Sprites.chargerImage("still_down" + count, "images\\still_down.png");
		Sprites.chargerImage("still_left" + count, "images\\still_left.png");
		Sprites.chargerImage("Bomb", "images\\Bomb.png");
	}

	@Override
	public void dessiner(Graphics g) {
		String nbBombe = "" + this.bombes;

		g.setColor(Color.RED);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20,
				this.getPvMax() * 7, 10);
		g.setColor(Color.GREEN);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20,
				this.getPV() * 7, 10);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString(nbBombe, 0 + 60, 0 + 45);

		if (this.getPV() == 0) {
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 80));
			g.drawString("GAME OVER", getX() + 50, getY() + 300);
		}

		Sprites.dessiner(g, "Bomb", 0 + 5, 0);

		switch (super.direction) {
		case 0:
			Sprites.dessiner(g, "still_right" + count, super.getX() * DessinJeuZeldiablo.TAILLE - 2,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 1:
			Sprites.dessiner(g, "still_up" + count, super.getX() * DessinJeuZeldiablo.TAILLE - 2,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 2:
			Sprites.dessiner(g, "still_down" + count, super.getX() * DessinJeuZeldiablo.TAILLE - 2,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 3:
			Sprites.dessiner(g, "still_left" + count, super.getX() * DessinJeuZeldiablo.TAILLE - 2,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;

		default:
			break;
		}

	}

	/**
	 * m�thode qui pose une bombe en fonction de la direction du personnage
	 * 
	 * @return tableau d'entier indiquand les coordonn�es de la bombe et si elle a
	 *         �t� pos� (0=non 1=oui)
	 */
	public int[] poserBombe() {
		int[] coo = new int[3];
		if (this.bombes > 0) {
			switch (this.direction) {
			case 0:
				coo[0] = this.getX() + 1;
				coo[1] = this.getY();
				break;
			case 1:
				coo[0] = this.getX();
				coo[1] = this.getY() - 1;
				break;
			case 2:
				coo[0] = this.getX();
				coo[1] = this.getY() + 1;
				break;
			case 3:
				coo[0] = this.getX() - 1;
				coo[1] = this.getY();
				break;
			}
			coo[2] = 1;
			this.bombes--;
		} else {
			coo[2] = 0;
		}
		return coo;
	}

	/**
	 * D�finit le nombre de bombes de l'aventurier (pour les test).
	 * 
	 * @param i le nombre de bombes.
	 */
	public void setBombe(int i) {
		this.bombes = i;
	}
}
