package projet_zeldiablo;

import exception.AventurierException;
import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuZeldiablo implements Jeu {
	
	private Labyrinthe lab;
	private Aventurier hero;
	
	public JeuZeldiablo() throws AventurierException {
		this.hero=new Aventurier(10);
		this.lab=new Labyrinthe(this.hero);
	}

	@Override
	public void evoluer(Commande commandeUser) {
		if (commandeUser.haut) {
			this.hero.seDeplacer('N', this.lab);
		}
		if (commandeUser.bas) {
			this.hero.seDeplacer('S', this.lab);
		}
		if (commandeUser.gauche) {
			this.hero.seDeplacer('W', this.lab);
		}
		if (commandeUser.droite) {
			this.hero.seDeplacer('E', this.lab);
		}
		
	}

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}

	public Labyrinthe getLab() {
		return lab;
	}

	public Aventurier getHero() {
		return hero;
	}

}
