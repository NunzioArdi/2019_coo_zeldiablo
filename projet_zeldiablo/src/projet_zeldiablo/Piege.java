package projet_zeldiablo;

/**
 * Classe repr�sentant une case pi�g�e.
 * 
 * @author CORNETTE Pierre
 */
public class Piege extends Case implements Piegee {

	/**
	 * Constructeur du pi�ge.
	 * 
	 * @param x abscisse de la case.
	 * @param y ordonn�e de la case.
	 */
	public Piege(int x, int y) {
		super(x, y);
	}

	@Override
	public void activer(Entitee e) {
		e.subirDegat(1);
	}

}
