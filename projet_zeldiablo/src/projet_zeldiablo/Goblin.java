/**
 * 
 */
package projet_zeldiablo;

import java.awt.Color;
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
		
		g.setColor(Color.RED);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20, this.getPvMax() * 7,
				10);
		g.setColor(Color.GREEN);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20,
				this.getPV() * 7, 10);
		
		switch (super.direction) {
		case 0:
			Sprites.dessiner(g, "Goblin"+count+"_0_1", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 1:
			Sprites.dessiner(g, "Goblin"+count+"_0_2", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 2:
			Sprites.dessiner(g, "Goblin"+count+"_0_0", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 3:
			Sprites.dessiner(g, "Goblin"+count+"_0_3", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
			
		default:
			break;
		}
		
	}
	
	@Override
	public int[] attaquer() {
		int[] coo=super.attaquer();
		coo[2]=2;
		return coo;
	}
}