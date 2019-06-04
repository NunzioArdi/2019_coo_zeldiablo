import java.util.Scanner;

import exception.AventurierException;
import moteurJeu.MoteurGraphique;
import projet_zeldiablo.DessinJeuZeldiablo;
import projet_zeldiablo.JeuZeldiablo;

public class MainZediablo {
	
	public static void main(String[] args) throws InterruptedException, AventurierException {
		JeuZeldiablo jzd=new JeuZeldiablo();
		DessinJeuZeldiablo djzd=new DessinJeuZeldiablo(jzd);
		MoteurGraphique m=new MoteurGraphique(jzd, djzd);
		m.lancerJeu(300, 300);
		Scanner sc=new Scanner(System.in);
		while (!jzd.etreFini()) {
			
		}
		System.out.println("Le heros est mort, l'espoir s'est etteint avec son dernier souffle, ce monde comdamne a l'anneantissement est le resultat de votre echec");
	}

}
