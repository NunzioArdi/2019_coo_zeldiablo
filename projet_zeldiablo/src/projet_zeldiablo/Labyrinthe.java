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
		this.cases=new ArrayList<Case>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 || i == 9 || j == 0 || j == 9) {
					if (i == 0 && j == 4 || i == 4 && j == 0 || i == 4 && j == 9 || i == 9 && j == 4)
						this.cases.add(new Chemin(i, j));
					this.cases.add(new Mur(i, j));
				} else {
					this.cases.add(new Chemin(i, j));
				}
			}
		}

		// initalisation de l'aventurier
		this.hero.setLabyrinthe(this);
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
	
	public ArrayList<Case> getCase(){
		return this.cases;
	}
}
