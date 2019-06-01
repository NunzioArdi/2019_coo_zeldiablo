package projet_zeldiablo;

/**
 * Classe représentant les entités du labyrinthe. chanque entitée possède des
 * points de vie et une position dans le labyrnthe.
 * 
 * @author CORNETTE Pierre
 * @version 1.0
 */
public abstract class Entitee {
	/** Les points de vie de l'entitée. */
	private int pv;

	/** La position en abscisse. */
	private int posX;

	/** La position en abscisse. */
	private int posY;

	/** Le labyrinthe dans lequel se trouve l'entitée */
	private Labyrinthe lab;

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie de départ
	 */
	public Entitee(int vie) {
		if (vie < 0) {
			this.pv = 0;
		} else {
			this.pv = vie;
		}
	}

	/**
	 * Méthode permettant à l'entitée de se déplacer dans le labyrinthe.
	 * 
	 * @param x l'abscisse de la position désirée.
	 * @param y l'ordonnée de la position désirée.
	 */
	public abstract void seDeplacer(int x, int y);

	/**
	 * Définit la position de l'entité.
	 * 
	 * @param px l'abscisse de la nouvelle position.
	 * @param py l'ordonnée de la nouvelle position.
	 */
	public void setPos(int px, int py) {
		if (px < 0) {
			this.posX = 1;
		} else {
			this.posX = px;
		}

		if (py < 0) {
			this.posY = 1;
		} else {
			this.posY = px;
		}
	}

	/**
	 * Définit le labyrinthe dans laquelle se trouvera l'entitée.
	 * 
	 * @param lb le labyrinthe.
	 */
	public void setLabyrinthe(Labyrinthe lb) {
		this.lab = lb;
	}
}
