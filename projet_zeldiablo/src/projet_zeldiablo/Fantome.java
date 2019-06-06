package projet_zeldiablo;

import java.awt.Color;
import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Monstre de type fantome. Il est traversable.
 * 
 * @author CONTE Nunzio
 */
public class Fantome extends Monstre {

	private static int count = 0;

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie du fantome.
	 */
	public Fantome(int vie) {
		super(vie);
		this.traversable = true;
		count++;
		Sprites.chargerFeuille("Phantome" + count, "images\\Phantome.png", 12, 8);
	}

	@Override
	public void dessiner(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20, 2 * 25,
				10);
		g.setColor(Color.GREEN);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20,
				this.getPV() * 25, 10);

		switch (super.direction) {
		case 0:
			Sprites.dessiner(g, "Phantome" + count + "_0_3", super.getX() * DessinJeuZeldiablo.TAILLE + 15,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 1:
			Sprites.dessiner(g, "Phantome" + count + "_0_7", super.getX() * DessinJeuZeldiablo.TAILLE + 15,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 2:
			Sprites.dessiner(g, "Phantome" + count + "_3_4", super.getX() * DessinJeuZeldiablo.TAILLE + 15,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 3:
			Sprites.dessiner(g, "Phantome" + count + "_3_1", super.getX() * DessinJeuZeldiablo.TAILLE + 15,
					super.getY() * DessinJeuZeldiablo.TAILLE);
			break;

		default:
			break;
		}

	}

	@Override
	public int[] attaquer() {
		int[] coo = super.attaquer();
		coo[2] = 2;
		return coo;
	}
}