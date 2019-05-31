package projet_zeldiablo;

/** 
 * Classe repésentant les chmemin du labyrinthe qui sont un type de Case.
 * 
 * @author CONTE Nunzio
 */
public class Chemin extends Case implements Traversable {

	/** Constructeur de Case.
	 * 
	 * @param x abscisse.
	 * @param y ordonnée.
	 */
	public Chemin(int x, int y) {
		super(x,y);
	}
	
}
