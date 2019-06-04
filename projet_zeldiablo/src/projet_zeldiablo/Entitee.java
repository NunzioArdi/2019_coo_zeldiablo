package projet_zeldiablo;

/**
 * Classe repr�sentant les entit�s du labyrinthe. chanque entit�e poss�de des
 * points de vie et une position dans le labyrnthe.
 * 
 * @author CORNETTE Pierre
 * @author CONTE Nunzio
 * @author SCHULER Killian
 */
public abstract class Entitee {
	/** Les points de vie de l'entit�e. */
	private int pv;

	/** La position en abscisse. */
	protected int posX;

	/** La position en abscisse. */
	protected int posY;

	/**
	 * La direction vers laquelle est tournee l'entitee (0=haut, 1=droite, 2=bas,
	 * 3=gauche)
	 */
	protected int direction;

	/** Indique si l'entitee peut etre traverser par d'autres entitees */
	protected boolean traversable;

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
		this.traversable = false;
	}

	/**
	 * Essaye de deplacer l'entite dans une direction donnee
	 * 
	 * @param c direction vers laquelle se deplacer ('N', 'S', 'E', 'W')
	 * @param l labyrinthe ou a lieu le deplacement
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

	/**
	 * Returne l'abscisse de l'entit�.
	 * 
	 * @return abscisse.
	 */
	public int getX() {
		return this.posX;
	}

	/**
	 * Returne l'ordonn�e de l'entit�.
	 * 
	 * @return ordonn�e.
	 */
	public int getY() {
		return this.posY;
	}

	/**
	 * Returne les Points de vie de l'entit�.
	 * 
	 * @return la vie.
	 */
	public int getPV() {
		return this.pv;
	}

	/**
	 * Indique si l'entit� est traversable.
	 * 
	 * @return true si traversable
	 */
	public boolean estTraversable() {
		return this.traversable;
	}

	/**
	 * Attaque la case aux coordonnees passee en parametre
	 * 
	 * @param x abscisse de l'attaque
	 * @param y ordonnee de l'attaque
	 * @param l labyrinthe ou a lieu l'attaque
	 */
	public abstract void attaquer(int x, int y, Labyrinthe l);

	/**
	 * Inflige des degats a l'entitee
	 * 
	 * @param deg entier indiquant le nombre de pv a deduire
	 */
	public void subirDegat(int deg) {
		this.pv -= deg;
		if (this.pv <= 0) {
			this.pv = 0;
			this.traversable = true;
		}
	}
}
