package projet_zeldiablo;

/**
 * Classe repr�sentant les entit�s du labyrinthe. chanque entit�e poss�de des
 * points de vie et une position dans le labyrnthe.
 * 
 * @author CORNETTE Pierre
 * @author CONTE Nunzio
 * @author SCHULER Killian
 */
public abstract class Entitee implements Dessinable {
	/** Les points actuelle de vie de l'entit�e. */
	private int pv;

	/** Les points de vie de d�part de l'entit�e */
	private int pvMax;

	/** La position en abscisse. */
	protected int posX;

	/** La position en abscisse. */
	protected int posY;

	/** La vie maximale que les entit�e peuvent avoir. */
	private final int MAX_VIE_ENTITEE = 50;

	/**
	 * La direction vers laquelle est tournee l'entitee (0=droite,1=haut, 2=bas,
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
		if (vie < 0)
			this.pvMax = 1;
		else if (vie > MAX_VIE_ENTITEE)
			this.pvMax = MAX_VIE_ENTITEE;
		else
			this.pvMax = vie;
		this.pv = this.pvMax;
		this.traversable = false;
	}

	/**
	 * Essaye de deplacer l'entite dans une direction donnee
	 * 
	 * @param c direction vers laquelle se deplacer ('N', 'S', 'E', 'W')
	 * @param l labyrinthe ou a lieu le deplacement
	 */
	public int[] seDeplacer(char c) {
		int[] coo = new int[2];
		switch (c) {
		case 'N':
			this.direction = 1;
			coo[0] = this.posX;
			coo[1] = this.posY - 1;
			return (coo);
		case 'S':
			this.direction = 2;
			coo[0] = this.posX;
			coo[1] = this.posY + 1;
			return (coo);
		case 'E':
			this.direction = 0;
			coo[0] = this.posX + 1;
			coo[1] = this.posY;
			return (coo);
		case 'W':
			this.direction = 3;
			coo[0] = this.posX - 1;
			coo[1] = this.posY;
			return (coo);
		}
		return coo;
	}

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
	 * Returne les Points de vie de l'entit�.
	 * 
	 * @return la vie.
	 */
	public void setPV(int pv) {
		this.pv = pv;
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
	public int[] attaquer() {
		int[] coo = new int[3];
		switch (this.direction) {
		case 0:
			coo[0] = this.getX() + 1;
			coo[1] = this.getY();
			break;
		case 1:
			coo[0] = this.getX();
			coo[1] = this.getY() - 1;
			break;
		case 2:
			coo[0] = this.getX();
			coo[1] = this.getY() + 1;
			break;
		case 3:
			coo[0] = this.getX() - 1;
			coo[1] = this.getY();
			break;
		}
		coo[2] = 5;
		return coo;
	}

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

	/**
	 * Retourne la vie maximum que l'entit� a.
	 * 
	 * @return pvmax
	 */
	public int getPvMax() {
		return this.pvMax;
	}
}
