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
	protected int posX;

	/** La position en abscisse. */
	protected int posY;
	
	/** La direction vers laquelle est tournee l'entitee (0=haut, 1=droite, 2=bas, 3=gauche) */
	protected int direction;
	
	protected boolean traversable;

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
		this.traversable=false;
	}

	/**
	 * Méthode permettant à l'entitée de se déplacer dans le labyrinthe.
	 * 
	 * @param x l'abscisse de la position désirée.
	 * @param y l'ordonnée de la position désirée.
	 */
	public abstract void seDeplacer(char c, Labyrinthe l);

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
			this.posY = py;
		}
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public int getPV() {
		return this.pv;
	}
	
	public boolean estTraversable() {
		return this.traversable;
	}
	
	public abstract void attaquer(int x, int y, Labyrinthe l);
	
	public void subirDegat(int deg) {
		this.pv-=deg;
		if (this.pv<=0) {
			this.pv=0;
			this.traversable=true;
		}
	}
	
}
