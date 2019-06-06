package projet_zeldiablo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Le Boss final du jeu.
 * 
 * @author CONTE Nunzio
 * @author CORNETTE Pierre
 * @author SCHULER Kilian
 */
public class Boss extends Monstre {

	/**
	 * Constructeur.
	 * 
	 * @param vie les pv du boss.
	 */
	public Boss(int vie) {
		super(vie);
		Sprites.chargerFeuille("Boss", "images\\Boss.png", 3, 4);

	}

	@Override
	public void dessiner(Graphics g) {
		//Barre de vie
		g.setColor(Color.RED);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20, this.getPvMax() * 7,
				10);
		g.setColor(Color.GREEN);
		g.fillRect(super.getX() * DessinJeuZeldiablo.TAILLE + 5, super.getY() * DessinJeuZeldiablo.TAILLE - 20,
				this.getPV() * 7, 10);
		
		
		//sprites
		switch (super.direction) {
		case 0:
			Sprites.dessiner(g, "Boss_0_2", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 1:
			Sprites.dessiner(g, "Boss_0_3", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 2:
			Sprites.dessiner(g, "Boss_0_0", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
		case 3:
			Sprites.dessiner(g, "Boss_0_1", super.getX() * DessinJeuZeldiablo.TAILLE, super.getY() * DessinJeuZeldiablo.TAILLE);
			break;
			
		default:
			break;
		}
	}
}
