package projet_zeldiablo;

import exception.AventurierException;
import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuZeldiablo implements Jeu {

	private Labyrinthe lab;
	private Aventurier hero;

	public JeuZeldiablo() throws AventurierException {
		this.hero = new Aventurier(10);
		this.lab = new Labyrinthe(this.hero);
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
		if (commandeUser.attaque) {
			switch (this.lab.getHero().direction) {
			case 0:
				this.lab.getHero().attaquer(this.lab.getHero().getX(), this.lab.getHero().getY() - 1, this.lab);
				break;
			case 1:
				this.lab.getHero().attaquer(this.lab.getHero().getX() + 1, this.lab.getHero().getY(), this.lab);
				break;
			case 2:
				this.lab.getHero().attaquer(this.lab.getHero().getX(), this.lab.getHero().getY() + 1, this.lab);
				break;
			case 3:
				this.lab.getHero().attaquer(this.lab.getHero().getX() - 1, this.lab.getHero().getY(), this.lab);
				break;
			}
		}
		for (Monstre m : this.lab.getMonstres()) {
			char c=m.decider();
			m.seDeplacer(c, this.lab);
			switch (m.direction) {
			case 0:
				m.attaquer(m.getX(), m.getY() - 1, this.lab);
				break;
			case 1:
				m.attaquer(m.getX() + 1, m.getY(), this.lab);
				break;
			case 2:
				m.attaquer(m.getX(), m.getY() + 1, this.lab);
				break;
			case 3:
				m.attaquer(m.getX() - 1, m.getY(), this.lab);
				break;
			}
		}
	}

	@Override
	public boolean etreFini() {
		if (this.hero.getPV() == 0) {
			return true;
		}
		return false;
	}

	public Labyrinthe getLab() {
		return lab;
	}

	public Aventurier getHero() {
		return hero;
	}

}
