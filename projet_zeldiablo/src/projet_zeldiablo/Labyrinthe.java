package projet_zeldiablo;

import java.util.ArrayList;

import exception.AventurierException;

/**
 * Classe représentant le labyrinthe. Il est composé de cases et d'entitées.
 * 
 * @author SCHULLER Killian
 * @version 1.0
 *
 */
public class Labyrinthe {

	/** L'aventurier du labyrinthe. */
	private Aventurier hero;

	/** la liste des cases composant le labyrinthe. */
	private ArrayList<Case> cases;

	private ArrayList<Monstre> monstres;

	/**
	 * Constructeur du labyrinthe. Il doit y avoir un aventurier dans celui-ci pour
	 * pouvoir joué. Le labyrinthe est entouré d'un mur sauf aux 4 points cardinaux.
	 * 
	 * @param h l'aventurier
	 */
	public Labyrinthe(Aventurier h) throws AventurierException {
		// test aventurier
		if (h == null) {
			throw new AventurierException("Aventurier null");
		}
		this.hero = h;

		// construction labyrinthe
		this.cases = new ArrayList<Case>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 || i == 9 || j == 0 || j == 9) {
					if (i == 0 && j == 4 || i == 4 && j == 0 || i == 4 && j == 9 || i == 9 && j == 4) {
						this.cases.add(new Chemin(i, j));
					} else {
						this.cases.add(new Mur(i, j));
					}
				} else {
					this.cases.add(new Chemin(i, j));
				}
			}
		}

		// initialisation des monstres (2 monstres placé pour l'instant arbitrairement)
		this.monstres = new ArrayList<Monstre>();
		Goblin g1 = new Goblin(5);
		g1.setPos(3, 3);
		Goblin g2 = new Goblin(2);
		g2.setPos(7, 7);
		this.monstres.add(g1);
		this.monstres.add(g2);

		// initalisation de l'aventurier
		this.hero.setPos(1, 1);
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
			if (c.getX() == x && c.getY() == y && c instanceof Traversable) {
				for (Monstre m : this.monstres) {
					if(m.getX() == x && m.getY() == y) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Retourne la case du labyrinthe au coordonnée donnée.
	 * 
	 * @param x l'abscisse de la case
	 * @param y l'ordonnée de la case
	 * @return la case
	 */
	public Case getCase(int x, int y) {
		for (Case tmp : this.cases) {
			if (tmp.getX() == x && tmp.getY() == y)
				return tmp;
		}
		return null;
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
	 * Retourne l'aventurier du labyrinthe
	 * 
	 * @return l'aventurier
	 */
	public Aventurier getHero() {
		return this.hero;
	}

	/**
	 * Retourne la liste des monstres du labyrinthe.
	 * 
	 * @return le labyrinthe
	 */
	public ArrayList<Monstre> getMonstres() {
		return this.monstres;
	}

	public void estPiger(int x, int y, Entitee e) {
		for(Case c: this.cases ) {
			if(c.getX() == x && c.getY() == y && c instanceof Piegee) {
				Piege p = (Piege) c;
				p.activer(e);
			}
		}
	}
	
	public void verifierMort() {
		int i=0;
		for (Monstre m : this.monstres) {
			if (m.getPV()<=0) {
				this.monstres.remove(i);
			} else {
				i++;
			}
		}
	}
}
