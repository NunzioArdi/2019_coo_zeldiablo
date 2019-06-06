package projet_zeldiablo;

import java.awt.Graphics;

/**
 * Classe rep�sentant les cases du labyrinthe
 * 
 * @author CONTE Nunzio
 * @version 1.0
 */
public abstract class Case implements Dessinable {
	/** Coordonn�e en absisse de la case */
	private int x;

	/** Coordonn�e en ordonn�e de la case */
	private int y;

	/** Indique si la case est traversable */
	protected boolean traversable;

	/** Indique la sortie */
	private boolean sortie;

	/** Indique si la case peut �tre explosable par une bombe. */
	private boolean explosable;

	/**
	 * Constructeur de Case.
	 * 
	 * @param x abscisse.
	 * @param y ordonn�e.
	 */
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
		this.traversable = true;
		this.setExplosable(false);
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
	 * 
	 * @return true si traversable
	 */
	public boolean estTraversable() {
		return this.traversable;
	}

	/**
	 * Verifie si la case passee en parametre possede les meme coordonnees
	 * 
	 * @param c
	 * @return booleen true si les coordonnee sont les memes
	 */
	public boolean equalsTo(Case c) {
		return (c.getX() == this.x && c.getY() == y);
	}

	/**
	 * Retourne l'attribut sortie
	 * 
	 * @return true si l'aventurier est sortie
	 */
	public boolean getSortie() {
		return this.sortie;
	}

	/**
	 * Methode qui permet de changer la valeur de sortie
	 * 
	 * @param b Boolean
	 */
	public void setSortie(boolean b) {
		this.sortie = b;
	}

	@Override
	public abstract void dessiner(Graphics g);

	/**
	 * Indique si une case est explosable.
	 * 
	 * @return true si explosable
	 */
	public boolean isExplosable() {
		return explosable;
	}

	/**
	 * Fixe si une case est explosable.
	 * 
	 * @param explosable true pour �tre explosable
	 */
	public void setExplosable(boolean explosable) {
		this.explosable = explosable;
	}
}
