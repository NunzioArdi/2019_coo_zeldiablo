package projet_zeldiablo;

/**
 * Monstre de type fantome. Il est traversable.
 * 
 * @author CONTE Nunzio
 */
public class Fantome extends Monstre {

	/**
	 * Constructeur.
	 * 
	 * @param vie la vie du fantome.
	 */
	public Fantome(int vie) {
		super(vie);
		this.traversable = true;
	}
}