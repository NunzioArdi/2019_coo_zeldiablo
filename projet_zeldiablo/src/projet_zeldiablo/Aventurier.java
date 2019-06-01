package projet_zeldiablo;

/**
 * Classe repr�sentant un aventurier du labyrinthe. C'est un type d'entit�e.
 * 
 * @author CORNETTE Pierre
 * @version 1.0
 *
 */
public class Aventurier extends Entitee {

	/**
	 * Constructeur.
	 * 
	 * @param pv  la vie de d�part
	 */
	public Aventurier(int pv) {
		super(pv);
	}

	@Override
	public void seDeplacer(int x, int y) {
		Labyrinthe lb = new Labyrinthe(this);
		if (lb.estDisponible(x, y)) {
			setPos(x, y);
		}
	}
}
