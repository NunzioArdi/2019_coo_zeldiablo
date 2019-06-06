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
		switch (super.direction) {
		case 0:
			Sprites.dessiner(g, "Phantome"+count+"_0_3", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 1:
			Sprites.dessiner(g, "Phantome"+count+"_0_7", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 2:
			Sprites.dessiner(g, "Phantome"+count+"_3_4", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 3:
			Sprites.dessiner(g, "Phantome"+count+"_3_1", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
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