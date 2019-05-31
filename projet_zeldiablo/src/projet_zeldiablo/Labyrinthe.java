package projet_zeldiablo;

import java.util.ArrayList;

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
	 * pouvoir joué.
	 * 
	 * @param h l'aventurier
	 */
	public Labyrinthe(Aventurier h) {
		this.hero = h;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 || i == 9 || j == 0 || j == 9) {
					this.cases.add(new Mur(i, j));
				} else {
					this.cases.add(new Chemin(i, j));
				}
			}
		}
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
}
