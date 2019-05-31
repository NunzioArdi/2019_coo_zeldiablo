package projet_zeldiablo;

/** Classe repésentant les cases du labyrinthe
 * 
 * @author CONTE Nunzio
 */
public class Case {
	/** Coordonnée en absisse de la case */
	private int x;
	/** Coordonnée en ordonnée de la case */
	private int y;
	
	/** Constructeur de Case.
	 * 
	 * @param x abscisse.
	 * @param y ordonnée.
	 */
	public Case(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Retourne l'abscisse de la case.
	 * 
	 * @return x
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Retourne l'ordonnée de la case.
	 * 
	 * @return y
	 */
	public int getY() {
		return this.y;
	}
}
