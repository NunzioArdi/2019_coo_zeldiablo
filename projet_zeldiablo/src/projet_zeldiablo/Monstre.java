package projet_zeldiablo;

import java.util.Random;

/**
 * Classe représentant les monstres.
 * 
 * @author CONTE Nunzio
 *
 */
public abstract class Monstre extends Entitee {

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie du monstre.
	 */
	public Monstre(int vie) {
		super(vie);
	}
	
	public char decider() {
		char[] tab=new char[]{'N', 'S', 'E', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		Random r=new Random();
		int i= r.nextInt(12);
		return tab[i];
	}
	
	@Override
	public void seDeplacer(char c, Labyrinthe l) {
		switch (c) {
		case 'N':
			this.direction=0;
			if (l.estDisponible(super.posX, super.posY - 1)) {
				this.setPos(super.posX, super.posY - 1);
			}
			break;
		case 'S':
			this.direction=2;
			if (l.estDisponible(super.posX, super.posY + 1)) {
				this.setPos(super.posX, super.posY + 1);	
			}
			break;
		case 'E':
			this.direction=1;
			if (l.estDisponible(super.posX + 1, super.posY)) {
				this.setPos(super.posX + 1, super.posY);	
			}
			break;
		case 'W':
			this.direction=3;
			if (l.estDisponible(super.posX - 1, super.posY)) {
				this.setPos(super.posX - 1, super.posY);	
			}
			break;
		}
	}
	
	@Override
	public void attaquer(int x, int y, Labyrinthe l) {
		if (l.getHero().getX()==x && l.getHero().getY()==y) {
			l.getHero().subirDegat(1);
		}
	}
}
