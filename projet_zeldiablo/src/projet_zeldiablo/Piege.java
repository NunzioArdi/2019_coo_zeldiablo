package projet_zeldiablo;

/**
 * Classe représentant une case piégée.
 * 
 * @author CORNETTE Pierre
 */
public class Piege extends Case implements Piegee {

	/**
	 * Constructeur du piège.
	 * 
	 * @param x abscisse de la case.
	 * @param y ordonnée de la case.
	 */
	public Piege(int x, int y) {
		super(x, y);
	}

	@Override
	public void activer(Entitee e) {
		e.subirDegat(1);
	}

}
