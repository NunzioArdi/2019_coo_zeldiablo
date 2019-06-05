package projet_zeldiablo;

import java.util.ArrayList;

import exception.AventurierException;

/**
 * Classe représentant le labyrinthe. Il est composé de cases et d'entitées.
 * 
 * @author SCHULER Killian
 * @author CONTE Nunzio
 * @author CORNETTE PIERRE
 */
public class Labyrinthe {


	/** la liste des cases composant le labyrinthe. */
	private ArrayList<Case> cases;

	/** La liste des monstres du jeu */
	private ArrayList<Monstre> monstres;
	
	private int posDepX, posDepY;
	
	
	/** indique si le labyrinthe est terminer */
	private boolean fin;

	/**
	 * Constructeur du labyrinthe. Il doit y avoir un aventurier dans celui-ci pour
	 * pouvoir joué. Le labyrinthe est entouré d'un mur sauf aux 4 points cardinaux.
	 * 
	 * @param h l'aventurier
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
						this.posDepX=i;
						this.posDepY=j;
						k++;
					} else {
						if (i == 9 && j == 4) {
							this.cases.add(new Chemin(i, j));
							k++;
							this.cases.get(k).setSortie(true);
						} else {
							this.cases.add(new Mur(i, j));
							k++;
						}
					}
				} else {
					if (1 <= i && i <= 2 && 2 <= j && j <= 3 || i == 2 && 5<= j  && j <= 9 
						|| 4 <= i && i <= 5 && 2 <= j && j <= 3 || i == 3 && 5 <= j && j <= 6
						|| i == 5 && 4 <= j && j <= 6 || i == 6 && 7 <= j && j <= 9 
						|| i == 8 && 5 <= j && j <= 7 || i == 7 && 2 <= j && j <= 5) {
						this.cases.add(new Mur(i,j));
						k++;
					} else if (i == 2 && j == 1) {
						this.cases.add(new Piege(i, j));
						k++;
					} else {
						this.cases.add(new Chemin(i, j));
						k++;
					}
				}
			}
		}

		// initialisation des monstres (3 monstres placé pour l'instant arbitrairement)
		this.monstres = new ArrayList<Monstre>();
		Goblin g1 = new Goblin(7);
		g1.setPos(1, 8);
		Goblin g2 = new Goblin(5);
		g2.setPos(8, 8);
		Fantome f1 = new Fantome(2);
		f1.setPos(2, 7);
		// this.monstres.add(g1);
		this.monstres.add(f1);
		f1.setPos(1, 7);
		this.monstres.add(g1);
		this.monstres.add(g2);
	}

	/**
	 * Méthode vérifiant si une case est disponible.
	 * 
	 * @param x l'abscisse de la case ciblé.
	 * @param y l'ordonnée de la case ciblé.
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
	 * Méthode testant si l'entité est sur une piège. Si c'est le cas, le piège
	 * s'active sur l'entité.
	 * 
	 * @param x abscisse de la case à tester.
	 * @param y ordonnée de la case à tester.
	 * 
	 * @param e l'entité qui est sur la case à tester.
	 */
	public void estPieger(int x, int y, Entitee e) {
		for (Case c : this.cases) {
			if (c.getX() == x && c.getY() == y && c instanceof Piegee) {
				Piege p = (Piege) c;
				p.activer(e);
			}
		}
	}

	/**
	 * Méthode testant si l'aventurier peut sortir du labyrinthe. Il doit avoir tué
	 * tous les monstres et on test si l'aventurier est sur la case de sortie.
	 * 
	 * @param x l'absicsse de la case à tester.
	 * @param y l'ordonnée de la case à tester.
	 */
	public void estSortie(int x, int y) {
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
				}
			}
		}
	}

	/**
	 * Retourne si se labyrinthe est terminer.
	 * 
	 * @return true si terminer.
	 */
	public boolean getFin() {
		return this.fin;
	}

	public int getPosDepX() {
		return posDepX;
	}

	public int getPosDepY() {
		return posDepY;
	}
}
