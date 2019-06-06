import moteurJeu.moteur.MoteurGraphique;
import projet_zeldiablo.DessinJeuZeldiablo;
import projet_zeldiablo.JeuZeldiablo;

public class MainZediablo {

	public static void main(String[] args) throws InterruptedException {
		JeuZeldiablo jzd = new JeuZeldiablo();
		DessinJeuZeldiablo djzd = new DessinJeuZeldiablo(jzd);
		MoteurGraphique m = new MoteurGraphique(jzd, djzd);
		System.out.println("\"Clique droit\" pour attaquer");
		System.out.println("\"Espace\" pour utiliser des bombes");
		System.out.println("\"F\" pour tuer tout les monstres de l'étage");
		m.lancerJeu(600, 600, 10);
		while (!jzd.etreFini()) {

		}
		if (jzd.getHero().getPV() == 0) {
			System.out.println(
					"Le heros est mort, l'espoir s'est etteint avec son dernier souffle, ce monde comdamne a l'anneantissement est le resultat de votre echec");
		} else {
			System.out.println("Felicitations! Vous avez vaincu tout les monstres et triomphez du labyrinthe!");
		}
	}

}