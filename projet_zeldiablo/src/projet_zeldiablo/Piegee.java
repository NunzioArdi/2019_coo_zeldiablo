package projet_zeldiablo;

/**
 * Interface perm�tant de mettre un pi�ge dans une case.
 * 
 * @author CORNETTE Pierre
 */
public interface Piegee {

	/**
	 * Methode qui permet aux pieges de faire des degats
	 * 
	 * @param e victime du piege.
	 */
	public void activer(Entitee e);
}
