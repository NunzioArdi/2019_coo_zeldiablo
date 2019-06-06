package projet_zeldiablo;

import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Classe représentant un Mur qui est un type de Case.
 * 
 * @author CONTE Nunzio
 */
public class Mur extends Case {
	
	private static int count=0;
	
	/**
	 * Constructeur du Mur.
	 * 
	 * @param x abscisse.
	 * @param y ordonnée.
	 */
	public Mur(int x, int y) {
		super(x, y);
		this.traversable=false;
		this.explosable=false;
		this.count++;
		Sprites.chargerImage("Wall"+count, "images\\Wall2.png");
	}

	/**
	 * Constructeur du Mur.
	 * 
	 * @param x abscisse.
	 * @param y ordonnée.
	 */
	public Mur(int x, int y, boolean b) {
		super(x, y);
		this.traversable=false;
		this.explosable=b;
		this.count++;
		Sprites.chargerImage("Wall"+count, "images\\Wall2.png");
	}
	
	public void setExplosable(boolean b) {
		super.explosable=b;
	}

	@Override
	public void dessiner(Graphics g) {
		Sprites.dessiner(g, "Wall"+count, this.getX() * DessinJeuZeldiablo.TAILLE, this.getY() * DessinJeuZeldiablo.TAILLE);
		
	}
}
