package projet_zeldiablo;

/**
 * Classe repésentant les cases du labyrinthe
 * 
 * @author CONTE Nunzio
 * @version 1.0
 */
public class Case {
	/** Coordonnée en absisse de la case */
	private int x;

	/** Coordonnée en ordonnée de la case */
	private int y;

	/** Indique si la case est traversable*/
	protected boolean traversable;
	
	/** Indique la sortie */
	private boolean sortie;
	
	/**
	 * Constructeur de Case.
	 * 
	 * @param x abscisse.
	 * @param y ordonnée.
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
	 * Retourne l'ordonnée de la case.
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
	
	/**
	 * Verifie si la case passee en parametre possede les meme coordonnees
	 * @param c
	 * @return booleen true si les coordonnee sont les memes
	 */
	public boolean equalsTo(Case c) {
		return (c.getX()==this.x && c.getY()==y);
	}
	
	/** 
	 * Retourne l'attribut sortie
	 * @return true si l'aventurier est sortie
	 */
	public boolean getSortie() {
		return this.sortie;
	}
	
	/**
	 * Methode qui permet de changer la valeur de sortie
	 * @param b Boolean
	 */
	public void setSortie(boolean b) {
		this.sortie = b;
	}
}
