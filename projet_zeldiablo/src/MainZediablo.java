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
		m.lancerJeu(1000, 1000);
		Scanner sc=new Scanner(System.in);
		while (!jzd.etreFini()) {
			;
		}
	}

}
