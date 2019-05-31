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
	 * @param pv  la vie de départ
	 * @param posX la position en abscisse de départ
	 * @param posY la position en ordonnée de départ
	 */
	public Aventurier(int pv, int posX, int posY) {
		super(pv, posX, posY);
	}

	@Override
	public void seDeplacer(int x, int y) {
		Labyrinthe lb = new Labyrinthe(this);
		if (lb.estDisponible(x, y)) {
			setPos(x, y);
		}
	}
}
