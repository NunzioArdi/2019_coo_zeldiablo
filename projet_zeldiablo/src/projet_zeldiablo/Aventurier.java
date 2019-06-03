package projet_zeldiablo;

/**
 * Classe représentant un aventurier du labyrinthe. C'est un type d'entitée.
 * 
 * @author CORNETTE Pierre
 * @version 1.0
 *
 */
public class Aventurier extends Entitee {

	/**
	 * Constructeur.
	 * 
	 * @param pv
	 *            la vie de départ
	 */
	public Aventurier(int pv) {
		super(pv);
	}

	@Override
	public void seDeplacer(char c, Labyrinthe l) {
		switch (c) {
		case 'N':
			this.direction=0;
			if (l.estDisponible(super.posX, super.posY - 1)) {
				l.estPieger(posX, posY-1, this);
				this.setPos(super.posX, super.posY - 1);
			}
			break;
		case 'S':
			this.direction=2;
			if (l.estDisponible(super.posX, super.posY + 1)) {
				l.estPieger(posX, posY+1, this);
				this.setPos(super.posX, super.posY + 1);	
			}
			break;
		case 'E':
			this.direction=1;
			if (l.estDisponible(super.posX + 1, super.posY)) {
				l.estPieger(posX+1, posY, this);
				this.setPos(super.posX + 1, super.posY);	
			}
			break;
		case 'W':
			this.direction=3;
			if (l.estDisponible(super.posX - 1, super.posY)) {
				l.estPieger(posX-1, posY, this);
				this.setPos(super.posX - 1, super.posY);	
			}
			break;
		}
	}

	@Override
	public void attaquer(int x, int y, Labyrinthe l) {
		for (Monstre m : l.getMonstres()) {
			if (m.getX()==x && m.getY()==y) {
				m.subirDegat(5);
			}
		}
	}
}
