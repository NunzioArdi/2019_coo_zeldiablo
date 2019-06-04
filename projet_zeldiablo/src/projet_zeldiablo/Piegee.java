package projet_zeldiablo;

/**
 * Interface perm�tant de mettre un pi�ge dans une case.
 * 
 * @author CORNETTE Pierre
 */
public interface Piegee {

	/**
	 * Active l'effet du piege.
	 * 
	 * @param e victime du piege.
	 */
	public void activer(Entitee e);
}
