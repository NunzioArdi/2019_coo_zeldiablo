package projet_zeldiablo;

/**
 * Classe rep�sentant les cases du labyrinthe
 * 
 * @author CONTE Nunzio
 * @version 1.0
 */
public class Case {
	/** Coordonn�e en absisse de la case */
	private int x;

	/** Coordonn�e en ordonn�e de la case */
	private int y;

	/** Indique si la case est traversable*/
	protected boolean traversable;
	
	/**
	 * Constructeur de Case.
	 * 
	 * @param x abscisse.
	 * @param y ordonn�e.
	 */
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
		this.traversable=true;
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
	 * Retourne l'ordonn�e de la case.
	 * 
	 * @return y
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Retourne l'attribut traversable
	 * @return true si traversable
	 */
	public boolean estTraversable() {
		return this.traversable;
	}
}
