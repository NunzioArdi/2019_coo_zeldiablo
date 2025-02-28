package projet_zeldiablo;

import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Classe repr�sentant un Mur qui est un type de Case.
 * 
 * @author CONTE Nunzio
 * 
 */
public class Mur extends Case {

	/** Nombre de mur */
	private static int count = 0;

	/**
	 * Constructeur du Mur.
	 * 
	 * @param x abscisse.
	 * @param y ordonn�e.
	 */
	public Mur(int x, int y) {
		super(x, y);
		this.traversable = false;
		this.setExplosable(false);
		this.count++;
		Sprites.chargerImage("Wall" + count, "images\\Wall2.png");
	}

	/**
	 * Constructeur du Mur.
	 * 
	 * @param x abscisse.
	 * @param y ordonn�e.
	 * @param b indique si explosable
	 */
	public Mur(int x, int y, boolean b) {
		super(x, y);
		this.traversable = false;
		this.setExplosable(b);
		this.count++;
		Sprites.chargerImage("Wall" + count, "images\\Wall2.png");
	}

	@Override
	public void dessiner(Graphics g) {
		Sprites.dessiner(g, "Wall" + count, this.getX() * DessinJeuZeldiablo.TAILLE,
				this.getY() * DessinJeuZeldiablo.TAILLE);

	}
}
