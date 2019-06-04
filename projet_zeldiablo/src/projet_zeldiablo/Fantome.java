package projet_zeldiablo;

/**
 * Monstre de type fantome. Il est traversable.
 * @author Utilisateur
 *
 */
public class Fantome extends Monstre {

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie du fantome.
	 */
	public Fantome(int vie) {
		super(vie);
		this.traversable=true;
	}

	@Override
	public void attaquer(int x, int y, Labyrinthe l) {
		//TODO ne peut pas attaquer pour l'instant
	}
}
