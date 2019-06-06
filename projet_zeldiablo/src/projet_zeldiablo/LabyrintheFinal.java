package projet_zeldiablo;

/**
 * Le labyrinthe final.
 * 
 * @author CONTE Nunzio
 */
public class LabyrintheFinal extends Labyrinthe {

	/**
	 * Constructeur. Créee un mur fermé tout autour du labyrinthe.
	 */
	public LabyrintheFinal() {
		this.monstres.clear();
		this.cases.clear();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 || j == 0 || i == 9 || j == 9)
						this.cases.add(new Mur(i, j));
				else
					this.cases.add(new Chemin(i, j));
			}
		}
		Boss jaaj = new Boss(25);
		jaaj.setPos(6, 6);
		this.monstres.add(jaaj);
	}

	@Override
	public boolean getFin() {
		if (this.monstres.get(0).getPV() == 0) {
			this.fin = true;
			return fin;
		}
		return fin;
	}
}