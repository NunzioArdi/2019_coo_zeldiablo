package projet_zeldiablo;

import java.util.Random;

/**
 * Classe représentant les monstres.
 * 
 * @author CONTE Nunzio
 * @author SCHULER Killian
 */
public abstract class Monstre extends Entitee {

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie du monstre.
	 */
	public Monstre(int vie) {
		super(vie);
	}

	/**
	 * Méthode permétant de choisir aléatoirement la direction d'un monstre.
	 * 
	 * @return la direction ou rien(ne se déplace pas).
	 */
	public char decider() {
		char[] tab = new char[] { 'N', 'S', 'E', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
		Random r = new Random();
		int i = r.nextInt(12);
		return tab[i];
	}
}
