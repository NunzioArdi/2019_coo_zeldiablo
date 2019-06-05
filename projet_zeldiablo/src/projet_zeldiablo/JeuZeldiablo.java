package projet_zeldiablo;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


import exception.AventurierException;
import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class JeuZeldiablo implements JeuAbstract {

	/** La liste des labyrinthes correspondant aux diff�rents �tages */
	private ArrayList<Labyrinthe> lab;

	/** l'aventurier de la perie */
	private Aventurier hero;

	/** Indique l'�tage actuelle */
	private int etage = 0;

	/** Indique si la partie est termin�. */
	private boolean fin;

	/**
	 * Constructeur du jeu.
	 * 
	 * @throws AventurierException erreur aventurier
	 */
	public JeuZeldiablo() throws AventurierException {
		this.hero = new Aventurier(10);
		this.lab = new ArrayList<Labyrinthe>();
		for (int i = 0; i < 2; i++)
			this.lab.add(new Labyrinthe(this.hero));
	}

	@Override
	public boolean etreFini() {
		if (this.hero.getPV() == 0 || this.fin) {
			return true;
		}
		return false;
	}

	/**
	 * Retourne l'aventurier
	 * 
	 * @return le hero
	 */
	public Aventurier getHero() {
		return hero;
	}

	/**
	 * Retourne le labyrinthe de l'�tage actuelle.
	 * 
	 * @return l'�tage en cour.
	 */
	public Labyrinthe getEtage() {
		return this.lab.get(etage);
	}

	/**
	 * M�thode servant � pass� � l'�tage suivant.
	 */
	private void etageSuivant() {
		if (this.etage == this.lab.size() - 1) {
			this.fin = true;
		} else
			this.etage++;
	}

	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		if (clavier.isPressed(KeyEvent.VK_Z) || clavier.isPressed(KeyEvent.VK_UP)) {
			this.hero.seDeplacer('N', this.getEtage());
		}
		if (clavier.isPressed(KeyEvent.VK_S) || clavier.isPressed(KeyEvent.VK_DOWN)) {
			this.hero.seDeplacer('S', this.getEtage());
		}
		if (clavier.isPressed(KeyEvent.VK_Q) || clavier.isPressed(KeyEvent.VK_LEFT)) {
			this.hero.seDeplacer('W', this.getEtage());
		}
		if (clavier.isPressed(KeyEvent.VK_D) || clavier.isPressed(KeyEvent.VK_RIGHT)) {
			this.hero.seDeplacer('E', this.getEtage());
		}
		if (clavier.isPressed(KeyEvent.VK_SPACE) || souris.isPressed()) {
			switch (this.hero.direction) {
			case 0:
				this.hero.attaquer(this.hero.getX(), this.hero.getY() - 1, this.getEtage());
				break;
			case 1:
				this.hero.attaquer(this.hero.getX() + 1, this.hero.getY(), this.getEtage());
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
		}
		// permet d'allez � l'�tage suivant
		if (!fin && this.getEtage().getFin() == true) {
			this.etageSuivant();
			this.hero.setPos(0, 4);
		}
		return null;
	}
}
