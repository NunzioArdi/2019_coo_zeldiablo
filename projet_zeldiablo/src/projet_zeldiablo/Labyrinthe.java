package projet_zeldiablo;

import java.util.ArrayList;

/**
 * Classe repr�sentant le labyrinthe. Il est compos� de cases et d'entit�es.
 * 
 * @author SCHULER Killian
 * @author CONTE Nunzio
 * @author CORNETTE PIERRE
 */
public class Labyrinthe {

	/** la liste des cases composant le labyrinthe. */
	protected ArrayList<Case> cases;

	/** La liste des monstres du jeu */
	protected ArrayList<Monstre> monstres;

	/** La position en abscisse de d�part de l'aventurier dans le labyrinthe. */
	protected int posDepX;

	/** La position en ordonn�e de d�part de l'aventurier dans le labyrinthe. */
	protected int posDepY;

	/** indique si le labyrinthe est terminer */
	protected boolean fin;

	/**
	 * Constructeur du labyrinthe. Il doit y avoir un aventurier dans celui-ci pour
	 * pouvoir jou�. Le labyrinthe est entour� d'un mur sauf aux 4 points cardinaux.
	 */
	public Labyrinthe() {

		int k = -1;

		// construction labyrinthe
		this.cases = new ArrayList<Case>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 || i == 9 || j == 0 || j == 9) {
					if (i == 0 && j == 4) {
						this.cases.add(new Chemin(i, j));
						this.posDepX = i;
						this.posDepY = j;
						k++;
					} else {
						if (i == 9 && j == 4) {
							this.cases.add(new Chemin(i, j));
							k++;
							this.cases.get(k).setSortie(true);
						} else {
							this.cases.add(new Mur(i, j, false));
							k++;
						}
					}
				} else {
					// Creation des murs dans le Labyrinthe
					if (1 <= i && i <= 2 && 2 <= j && j <= 3 || i == 2 && 5 <= j && j <= 9
							|| 4 <= i && i <= 5 && 2 <= j && j <= 3 || i == 3 && 5 <= j && j <= 6
							|| i == 5 && 4 <= j && j <= 6 || i == 6 && 7 <= j && j <= 9 || i == 8 && 5 <= j && j <= 7
							|| i == 7 && 2 <= j && j <= 5) {
						this.cases.add(new Mur(i, j, true));
						k++;
					} else {
						this.cases.add(new Chemin(i, j));
						k++;
					}
				}
			}
		}

		// initialisation des monstres (3 monstres plac� pour l'instant arbitrairement)
		this.monstres = new ArrayList<Monstre>();
		Goblin g1 = new Goblin(7);
		g1.setPos(1, 8);
		Goblin g2 = new Goblin(10);
		g2.setPos(8, 8);
		Fantome f1 = new Fantome(2);
		f1.setPos(3, 7);
		this.monstres.add(f1);
		// this.monstres.add(g1);
		this.monstres.add(g2);
	}

	/**
	 * M�thode v�rifiant si une case est disponible.
	 * 
	 * @param x l'abscisse de la case cibl�.
	 * @param y l'ordonn�e de la case cibl�.
	 * @return true si la case est disponible.
	 */
	public boolean estDisponible(int x, int y) {
		for (Case c : this.cases) {
			if (c.getX() == x && c.getY() == y && c.estTraversable()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retourne la liste des cases du labyrinthe.
	 * 
	 * @return toute les cases du labyrinthe.
	 */
	public ArrayList<Case> getCase() {
		return this.cases;
	}

	/**
	 * Retourne la liste des monstres du labyrinthe.
	 * 
	 * @return le labyrinthe
	 */
	public ArrayList<Monstre> getMonstres() {
		return this.monstres;
	}

	/**
	 * M�thode testant si l'entit� est sur une pi�ge. Si c'est le cas, le pi�ge
	 * s'active sur l'entit�.
	 * 
	 * @param x abscisse de la case � tester.
	 * @param y ordonn�e de la case � tester.
	 * @param e l'entit� qui est sur la case � tester.
	 * 
	 * @return boolean indiquant si la case est un piege
	 */
	public boolean estPieger(int x, int y, Entitee e) {
		for (Case c : this.cases) {
			if (c.getX() == x && c.getY() == y && c instanceof Piegee) {
				Piege p = (Piege) c;
				p.activer(e);
				return true;
			}
		}
		return false;
	}

	/**
	 * M�thode testant si l'aventurier peut sortir du labyrinthe. Il doit avoir tu�
	 * tous les monstres et on test si l'aventurier est sur la case de sortie.
	 * 
	 * @param x l'absicsse de la case � tester.
	 * @param y l'ordonn�e de la case � tester.
	 * 
	 * @return boolean indiquant si la case a bien �t� exploser
	 */
	public boolean estSortie(int x, int y) {
		boolean vide = true;
		for (Monstre m : this.monstres) {
			if (m.getPV() > 0) {
				vide = false;
			}
		}
		if (vide) {
			for (Case c : this.cases) {
				if (c.equalsTo(new Chemin(x, y)) && c.getSortie() == true) {
					fin = true;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Methode permettant de placer les pieges
	 * 
	 * @param x l'absicsse de la case � tester.
	 * @param y l'ordonn�e de la case � tester.
	 */
	public void placerPiege(int x, int y) {
		int i = 0;
		while (i < 5) {
			int random_x = (int) (Math.random() * 9);
			int random_y = (int) (Math.random() * 9);
			for (Case c : this.cases) {
				if (this.estDisponible(c.getX(), c.getY()) == true) {
					this.cases.add(new Piege(random_x, random_y));
				}
			}
			i++;
		}
	}

	/**
	 * Si les coordonn�es pass�es en param�tres contiennent un mur explosable,
	 * celui-ci est d�truit
	 * 
	 * @param x abscisse de l'explosion
	 * @param y ordonn�e de l'explosion
	 * 
	 * @return boolean indiquant si la case a bien �t� exploser
	 */
	public boolean exploserMur(int x, int y) {
		for (int i = 0; i < this.cases.size() - 1; i++) {
			if (this.cases.get(i).getX() == x && this.cases.get(i).getY() == y && this.cases.get(i).isExplosable()) {
				this.cases.remove(i);
				this.cases.add(new Chemin(x, y));
				return true;
			}
		}
		return false;
	}

	/**
	 * Retourne si se labyrinthe est terminer.
	 * 
	 * @return true si terminer.
	 */
	public boolean getFin() {
		return this.fin;
	}

	/**
	 * Retourne la position en abscisse de d�part de l'aventurier.
	 * 
	 * @return depart X
	 */
	public int getPosDepX() {
		return posDepX;
	}

	/**
	 * Retourne la position en ordonn�e de d�part de l'aventurier.
	 * 
	 * @return depart Y
	 */
	public int getPosDepY() {
		return posDepY;
	}
}
