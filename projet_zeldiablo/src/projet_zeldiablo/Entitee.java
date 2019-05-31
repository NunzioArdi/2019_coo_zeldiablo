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
	private int posX;

	/** La position en abscisse. */
	private int posY;

	/** Le labyrinthe dans lequel se trouve l'entit�e */
	private Labyrinthe lab;

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie de d�part
	 * @param px  la position en abscisse de d�part
	 * @param py  la position en ordonn�e de d�part
	 */
	public Entitee(int vie, int px, int py) {
		if (vie < 0) {
			this.pv = 0;
		} else {
			this.pv = vie;
		}

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
	 * M�thode permettant � l'entit�e de se d�placer dans le labyrinthe.
	 * 
	 * @param x l'abscisse de la position d�sir�e.
	 * @param y l'ordonn�e de la position d�sir�e.
	 */
	public abstract void seDeplacer(int x, int y);

	/**
	 * D�finit la position de l'entit�.
	 * 
	 * @param px l'abscisse de la nouvelle position.
	 * @param py l'ordonn�e de la nouvelle position.
	 */
	public void setPos(int px, int py) {
		this.posX = px;
		this.posY = py;
	}

	/**
	 * D�finit le labyrinthe dans laquelle se trouvera l'entit�e.
	 * 
	 * @param lb le labyrinthe.
	 */
	public void setLabyrinthe(Labyrinthe lb) {
		this.lab = lb;
	}
}
