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
	 * @throws AventurierException
	 *             erreur aventurier
	 */
	public JeuZeldiablo() {
		this.hero = new Aventurier(10);
		this.lab = new ArrayList<Labyrinthe>();
		for (int i = 0; i < 2; i++) {
			this.lab.add(new Labyrinthe());
		}
		this.hero.setPos(this.getEtage().getPosDepX(), this.getEtage().getPosDepY());
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

	public boolean estDisponible(int x, int y) {
		if (this.getEtage().estDisponible(x, y)) {
			for (Monstre m : this.getEtage().getMonstres()) {
				if (m.getX() == x && m.getY() == y && !m.estTraversable()) {
					return false;
				}
			}
			if (this.hero.getX() == x && this.hero.getY() == y) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		int[] coo = new int[3];
		if (clavier.isPressed(KeyEvent.VK_Z) || clavier.isPressed(KeyEvent.VK_UP)) {
			coo = this.hero.seDeplacer('N');
			if (this.estDisponible(coo[0], coo[1])) {
				this.hero.setPos(coo[0], coo[1]);
			}
		}
		if (clavier.isPressed(KeyEvent.VK_S) || clavier.isPressed(KeyEvent.VK_DOWN)) {
			coo = this.hero.seDeplacer('S');
			if (this.estDisponible(coo[0], coo[1])) {
				this.hero.setPos(coo[0], coo[1]);
			}
		}
		if (clavier.isPressed(KeyEvent.VK_Q) || clavier.isPressed(KeyEvent.VK_LEFT)) {
			coo = this.hero.seDeplacer('W');
			if (this.estDisponible(coo[0], coo[1])) {
				this.hero.setPos(coo[0], coo[1]);
			}
		}
		if (clavier.isPressed(KeyEvent.VK_D) || clavier.isPressed(KeyEvent.VK_RIGHT)) {
			coo = this.hero.seDeplacer('E');
			if (this.estDisponible(coo[0], coo[1])) {
				this.hero.setPos(coo[0], coo[1]);
			}
		}
		if (clavier.isPressed(KeyEvent.VK_SPACE) || souris.isPressed()) {
			coo = this.hero.attaquer();
			for (Monstre m : this.getEtage().getMonstres()) {
				if (m.getX() == coo[0] && m.getY() == coo[1]) {
					m.subirDegat(coo[2]);
				}
			}
		}
		for (Monstre m : this.getEtage().getMonstres()) {
			char c = m.decider();
			coo = m.seDeplacer(c);
			if (this.estDisponible(coo[0], coo[1])) {
				m.setPos(coo[0], coo[1]);
			}
			coo = m.attaquer();
			if (this.hero.getX() == coo[0] && this.hero.getY() == coo[1]) {
				this.hero.subirDegat(coo[2]);
			}
			// permet d'allez � l'�tage suivant
			if (!fin && this.getEtage().getFin() == true) {
				this.etageSuivant();
				this.hero.setPos(0, 4);
			}
		}
		return null;
	}
}
