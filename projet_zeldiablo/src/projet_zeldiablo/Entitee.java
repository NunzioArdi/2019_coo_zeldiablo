package projet_zeldiablo;

/**
 * Classe représentant les entités du labyrinthe. chanque entitée possède des
 * points de vie et une position dans le labyrnthe.
 * 
 * @author CORNETTE Pierre
 * @author CONTE Nunzio
 * @author SCHULER Killian
 */
public abstract class Entitee implements Dessinable {
	/** Les points de vie de l'entitée. */
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
	 * @param vie la vie de départ
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
	public int[] seDeplacer(char c) {
		int[] coo=new int[2];
		switch (c) {
		case 'N':
			this.direction = 0;
//			if (l.estDisponible(super.posX, super.posY - 1)) {
//				l.estPieger(posX, posY - 1, this);
//				l.estSortie(posX, posY - 1);
//				this.setPos(super.posX, super.posY - 1);
//			}
			coo[0]=this.posX;
			coo[1]=this.posY-1;
			return(coo);
		case 'S':
			this.direction = 2;
//			if (l.estDisponible(super.posX, super.posY + 1)) {
//				l.estPieger(posX, posY + 1, this);
//				l.estSortie(posX, posY + 1);
//				this.setPos(super.posX, super.posY + 1);
//			}
			coo[0]=this.posX;
			coo[1]=this.posY+1;
			return(coo);
		case 'E':
			this.direction = 1;
//			if (l.estDisponible(super.posX + 1, super.posY)) {
//				l.estPieger(posX + 1, posY, this);
//				l.estSortie(posX + 1, posY);
//				this.setPos(super.posX + 1, super.posY);
//			}
			coo[0]=this.posX+1;
			coo[1]=this.posY;
			return(coo);
		case 'W':
			this.direction = 3;
//			if (l.estDisponible(super.posX - 1, super.posY)) {
//				l.estPieger(posX - 1, posY, this);
//				l.estSortie(posX - 1, posY);
//				this.setPos(super.posX - 1, super.posY);
//			}
			coo[0]=this.posX-1;
			coo[1]=this.posY;
			return(coo);
		}
		return coo;
	}

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

	/**
	 * Returne l'abscisse de l'entité.
	 * 
	 * @return abscisse.
	 */
	public int getX() {
		return this.posX;
	}

	/**
	 * Returne l'ordonnée de l'entité.
	 * 
	 * @return ordonnée.
	 */
	public int getY() {
		return this.posY;
	}

	/**
	 * Returne les Points de vie de l'entité.
	 * 
	 * @return la vie.
	 */
	public int getPV() {
		return this.pv;
	}

	/**
	 * Indique si l'entité est traversable.
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
		int[] coo=new int[3];
		switch (this.direction) {
		case 0:
			coo[0]=this.getX();
			coo[1]=this.getY()- 1;
			break;
		case 1:
			coo[0]=this.getX()+1;
			coo[1]=this.getY();
			break;
		case 2:
			coo[0]=this.getX();
			coo[1]=this.getY()+1;
			break;
		case 3:
			coo[0]=this.getX()-1;
			coo[1]=this.getY();
			break;
		}
		coo[2]=5;
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
}
