/**
 * 
 */
package projet_zeldiablo;

import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Monstre de type Goblin
 * 
 * @author Conte Nunzio
 */
public class Goblin extends Monstre {
	
	private static int count=0;

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie du goblin
	 */
	public Goblin(int vie) {
		super(vie);
		count++;
		Sprites.chargerFeuille("Goblin"+count, "images\\goblinsword.png", 11, 5);
	}

	@Override
	public void dessiner(Graphics g) {
		Sprites.dessiner(g, "Goblin"+count+"_0_0", this.getX() * DessinJeuZeldiablo.TAILLE, this.getY() * DessinJeuZeldiablo.TAILLE);
		
	}
}