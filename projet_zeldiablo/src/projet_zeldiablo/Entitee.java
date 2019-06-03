package projet_zeldiablo;

/**
 * Classe repr�sentant les entit�s du labyrinthe. chanque entit�e poss�de des
 * points de vie et une position dans le labyrnthe.
 * 
 * @author CORNETTE Pierre
 * @version 1.0
 */
public abstract class Entitee {
	/** Les points de vie de l'entit�e. */
	private int pv;

	/** La position en abscisse. */
	protected int posX;

	/** La position en abscisse. */
	protected int posY;

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie de d�part
	 */
	public Entitee(int vie) {
		if (vie < 0) {
			this.pv = 0;
		} else {
			this.pv = vie;
		}
	}

	/**
	 * M�thode permettant � l'entit�e de se d�placer dans le labyrinthe.
	 * 
	 * @param x l'abscisse de la position d�sir�e.
	 * @param y l'ordonn�e de la position d�sir�e.
	 */
	public abstract void seDeplacer(char c, Labyrinthe l);

	/**
	 * D�finit la position de l'entit�.
	 * 
	 * @param px l'abscisse de la nouvelle position.
	 * @param py l'ordonn�e de la nouvelle position.
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
	
	public abstract void attaquer(int x, int y, Labyrinthe l);
	
	public void subirDegat(int deg) {
		this.pv-=deg;
	}
	
}
