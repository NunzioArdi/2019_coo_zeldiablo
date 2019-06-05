package projet_zeldiablo;

import java.awt.Graphics;

import moteurJeu.sprite.Sprites;

/**
 * Classe représentant une case piégée.
 * 
 * @author CORNETTE Pierre
 */
public class Piege extends Case implements Piegee {

	private static int count=0;
	
	/**
	 * Constructeur du piège.
	 * 
	 * @param x abscisse de la case.
	 * @param y ordonnée de la case.
	 */
	public Piege(int x, int y) {
		super(x, y);
		count++;
		Sprites.chargerImage("Piege"+count, "images\\chemin_pigee.png");
		
	}

	@Override
	public void activer(Entitee e) {
		e.subirDegat(1);
	}

	@Override
	public void dessiner(Graphics g) {
		Sprites.dessiner(g, "Piege"+count, this.getX() * DessinJeuZeldiablo.TAILLE, this.getY() * DessinJeuZeldiablo.TAILLE);
		
	}

}
