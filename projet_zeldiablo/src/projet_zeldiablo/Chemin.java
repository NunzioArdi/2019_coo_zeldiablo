package projet_zeldiablo;

import java.awt.Graphics;
import moteurJeu.sprite.Sprites;

/**
 * Classe représentant les chemins du labyrinthe qui sont un type de Case.
 * 
 * @author CONTE Nunzio
 * @author SCHULER Kilian
 */
public class Chemin extends Case {
	
	private static int count=0;

	/**
	 * Constructeur de Case.
	 * 
	 * @param x abscisse.
	 * @param y ordonnée.
	 */
	public Chemin(int x, int y) {
		super(x, y);
		count++;
		Sprites.chargerImage("Chemin"+count, "images\\chemin2.png");
		
	}

	@Override
	public void dessiner(Graphics g) {
		Sprites.dessiner(g, "Chemin"+count, this.getX() * DessinJeuZeldiablo.TAILLE, this.getY() * DessinJeuZeldiablo.TAILLE);
		
	}
}