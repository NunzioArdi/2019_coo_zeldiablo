/**
 * 
 */
package projet_zeldiablo;

/**
 * Monstre de type Goblin
 * 
 * @author Conte Nunzio
 *
 */
public class Goblin extends Monstre {

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie du goblin
	 */
	public Goblin(int vie) {
		super(vie);
	}

	@Override
	public void seDeplacer(char c, Labyrinthe l) {
		//TODO ne se deplace pour l'instant pas
	}

}
