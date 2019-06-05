package projet_zeldiablo;

import java.util.ArrayList;

public class LabyrintheAleat extends Labyrinthe {
	private ArrayList<Case> cases;

	public LabyrintheAleat() {
		super();
		super.getCase().clear();

		int k = -1;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 || j == 0 || i == 9 || j == 9) {
					if (i == 0 && j == 4 || i == 9 && j == 4) {
						if (i == 9 && j == 4) {
							super.cases.add(new Chemin(i, j));
							k++;
							super.cases.get(k).setSortie(true);
						} else {
							super.cases.add(new Chemin(i, j));
							k++;
							super.posDepX = i;
							super.posDepY = j;
						}
					} else {
						super.cases.add(new Mur(i, j));
						k++;
					}
				} else {
					super.cases.add(new Chemin(i, j));
					k++;
				}
			}

		}
		this.placerPiege();
	}

	public void placerPiege() {
		int i = 0;
		while (i < 5) {
			int random_x = (int) (Math.random() * 9);
			int random_y = (int) (Math.random() * 9);
			if (super.estDisponible(random_x, random_y)) {
				super.cases.add(new Piege(random_x, random_y));
			}
//			}
			i++;
		}
	}
}
