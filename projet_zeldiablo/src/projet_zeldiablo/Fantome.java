package projet_zeldiablo;

import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Monstre de type fantome. Il est traversable.
 * 
 * @author CONTE Nunzio
 */
public class Fantome extends Monstre {
	
	private static int count=0;

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie du fantome.
	 */
	public Fantome(int vie) {
		super(vie);
		this.traversable = true;
		count++;
		Sprites.chargerFeuille("Phantome"+count, "images\\Phantome.png", 12, 8);
	}

	@Override
	public void dessiner(Graphics g) {
		Sprites.dessiner(g, "Phantome"+count+"_0_0", this.getX() * DessinJeuZeldiablo.TAILLE, this.getY() * DessinJeuZeldiablo.TAILLE);
		
	}
}