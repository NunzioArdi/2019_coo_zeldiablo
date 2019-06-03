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
			if (l.estDisponible(super.posX, super.posY - 1)) {
				this.setPos(super.posX, super.posY - 1);
			}
			break;
		case 'S':
			if (l.estDisponible(super.posX, super.posY + 1)) {
				this.setPos(super.posX, super.posY + 1);
			}
			break;
		case 'E':
			if (l.estDisponible(super.posX + 1, super.posY)) {
				this.setPos(super.posX + 1, super.posY);
			}
			break;
		case 'W':
			if (l.estDisponible(super.posX - 1, super.posY)) {
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
