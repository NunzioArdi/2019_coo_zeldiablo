package projet_zeldiablo;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

/**
 * Classe qui permet la creation du jeu
 * 
 * @author SCHULER Killian
 * @author CONTE Nunzio
 * @author CORNETTE PIERRE
 * @author SALLERIN Theo
 */
public class JeuZeldiablo implements JeuAbstract {

	/** La liste des labyrinthes correspondant aux differents etages */
	private ArrayList<Labyrinthe> lab;

	/** l'aventurier de la perie */
	private Aventurier hero;

	/** Indique l'etage actuelle */
	private int etage = 0;

	/** Indique si la partie est terminee. */
	private boolean fin;

	/**
	 * Constructeur du jeu.
	 */
	public JeuZeldiablo() {
		this.hero = new Aventurier(15);
		this.lab = new ArrayList<Labyrinthe>();
		this.lab.add(new Labyrinthe());
		this.lab.add(new LabyrintheAleat());
		this.lab.add(new LabyrintheFinal());
		this.hero.setPos(this.getEtage().getPosDepX(), this.getEtage().getPosDepY());
	}

	/**
	 * Methode determinant si la partie est fini
	 * 
	 * @return true si la partie est fini
	 */
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
	 * @return l'�tage en cours.
	 */

	public Labyrinthe getEtage() {
		return this.lab.get(etage);
	}

	/**
	 * Methode servant � passer � l'�tage suivant.
	 */
	private void etageSuivant() {
		if (this.etage == this.lab.size() - 1) {
			this.fin = true;
		} else {
			this.hero.donneeVie(10);
			this.etage++;
		}
	}

	/**
	 * Verifie si la case souhaiter n'est pas occuper par un monstre non
	 * traversable. Appelle estDisponible du labyrinthe en cours.
	 * 
	 * @param x
	 *            abcisse de la case.
	 * @param y
	 *            ordonn�e de la case.
	 * 
	 * @return true si disponible.
	 */
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
		boolean b = false;
		if (clavier.isPressed(KeyEvent.VK_Z) || clavier.isPressed(KeyEvent.VK_UP)) {
			coo = this.hero.seDeplacer('N');
			b = true;
		}
		if (clavier.isPressed(KeyEvent.VK_S) || clavier.isPressed(KeyEvent.VK_DOWN)) {
			coo = this.hero.seDeplacer('S');
			b = true;
		}
		if (clavier.isPressed(KeyEvent.VK_Q) || clavier.isPressed(KeyEvent.VK_LEFT)) {
			coo = this.hero.seDeplacer('W');
			b = true;
		}
		if (clavier.isPressed(KeyEvent.VK_D) || clavier.isPressed(KeyEvent.VK_RIGHT)) {
			coo = this.hero.seDeplacer('E');
			b = true;
		}
		if (clavier.isPressed(KeyEvent.VK_F)) {
			for (Monstre m : this.getEtage().getMonstres()) {
				m.subirDegat(10000);
			}
		}
		if (b) {
			if (this.estDisponible(coo[0], coo[1])) {
				this.getEtage().estSortie(coo[0], coo[1]);
				this.getEtage().estPieger(coo[0], coo[1], this.hero);
				this.hero.setPos(coo[0], coo[1]);
			}
		}
		if (souris.isPressed()) {
			coo = this.hero.attaquer();
			for (Monstre m : this.getEtage().getMonstres()) {
				if (m.getX() == coo[0] && m.getY() == coo[1]) {
					m.subirDegat(coo[2]);
				}
			}
		}
		if (clavier.isPressed(KeyEvent.VK_SPACE)) {
			coo = this.hero.poserBombe();
			if (coo[2] == 1) {
				this.getEtage().exploserMur(coo[0], coo[1]);
			}

		}

		// attaque des mosntres
		for (Monstre m : this.getEtage().getMonstres()) {
			if (m.getPV() > 0) {
				char c = m.decider();
				coo = m.seDeplacer(c);
				if (this.estDisponible(coo[0], coo[1])) {
					m.setPos(coo[0], coo[1]);
				}
				coo = m.attaquer();
				if (this.hero.getX() == coo[0] && this.hero.getY() == coo[1]) {
					this.hero.subirDegat(coo[2]);
				}
			}
		}

		// permet d'allez a l'etage suivant
		if (!fin && this.getEtage().getFin() == true) {
			this.etageSuivant();
			if (!fin) {
				if (this.lab.size() - 1 == this.etage) {
					this.hero.setPos(1, 4);
				} else {
					this.hero.setPos(0, 4);
				}
			}
		}
		return null;
	}
}
