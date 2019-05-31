package projet_zeldiablo;

import java.util.ArrayList;

/**
 * Classe repr�sentant le labyrinthe. Il est compos� de cases et d'entit�es.
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
	 * pouvoir jou�.
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
	 * M�thode v�rifiant si une case est disponible.
	 * 
	 * @param x l'abscisse de la case cibl�.
	 * @param y l'ordonn�e de la case cibl�.
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
