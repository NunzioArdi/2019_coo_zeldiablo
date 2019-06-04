package projet_zeldiablo;

import java.util.ArrayList;
import java.util.List;

import exception.AventurierException;
import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuZeldiablo implements Jeu {

	private ArrayList<Labyrinthe> lab;
	private Aventurier hero;
	private int etage = 0;
	private boolean fin;

	public JeuZeldiablo() throws AventurierException {
		this.hero = new Aventurier(10);
		this.lab = new ArrayList<Labyrinthe>();
		for (int i = 0; i < 2; i++)
			this.lab.add(new Labyrinthe(this.hero));
	}

	@Override
	public void evoluer(Commande commandeUser) {
		if (commandeUser.haut) {
			this.hero.seDeplacer('N', this.getEtage());
		}
		if (commandeUser.bas) {
			this.hero.seDeplacer('S', this.getEtage());
		}
		if (commandeUser.gauche) {
			this.hero.seDeplacer('W', this.getEtage());
		}
		if (commandeUser.droite) {
			this.hero.seDeplacer('E', this.getEtage());
		}
		if (commandeUser.attaque) {
			switch (this.getEtage().getHero().direction) {
			case 0:
				this.hero.attaquer(this.hero.getX(), this.hero.getY() - 1, this.getEtage());
				break;
			case 1:
				this.hero.attaquer(this.hero.getX() + 1, this.getEtage().getHero().getY(), this.getEtage());
				break;
			case 2:
				this.hero.attaquer(this.hero.getX(), this.hero.getY() + 1, this.getEtage());
				break;
			case 3:
				this.hero.attaquer(this.hero.getX() - 1, this.hero.getY(), this.getEtage());
				break;
			}
		}
		for (Monstre m : this.getEtage().getMonstres()) {
			char c = m.decider();
			m.seDeplacer(c, this.getEtage());
			switch (m.direction) {
			case 0:
				m.attaquer(m.getX(), m.getY() - 1, this.getEtage());
				break;
			case 1:
				m.attaquer(m.getX() + 1, m.getY(), this.getEtage());
				break;
			case 2:
				m.attaquer(m.getX(), m.getY() + 1, this.getEtage());
				break;
			case 3:
				m.attaquer(m.getX() - 1, m.getY(), this.getEtage());
				break;
			}
		}

		if (!fin && this.getEtage().getFin() == true) {
			this.etageSuivant();
			this.hero.setPos(0, 4);
		}
	}

	@Override
	public boolean etreFini() {
		if (this.hero.getPV() == 0 || this.fin) {
			return true;
		}
		return false;
	}

	public Aventurier getHero() {
		return hero;
	}

	public Labyrinthe getEtage() {
		return this.lab.get(etage);
	}

	private void etageSuivant() {
		if (this.etage == this.lab.size()-1) {
			this.fin = true;
		} else
			this.etage++;
	}
}
