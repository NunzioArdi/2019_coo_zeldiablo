package projet_zeldiablo;

import java.util.ArrayList;

public class Labyrinthe {
	
	private Aventurier hero;
	private ArrayList<Case> cases;
	
	public Labyrinthe(Aventurier h) {
		this.hero=h;
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				if (i==0 || i==9 || j==0 || j==9) {
					this.cases.add(new Mur(i, j));
				} else {
					this.cases.add(new Chemin(i, j));
				}
			}
		}
		this.hero.setLabyrinthe(this);
		this.hero.setPos(1, 1);
	}
	
	public boolean estDisponible(int x, int y) {
		for (Case c : this.cases) {
			if (c.getX()==x && c.getY()==y && c instanceof Traversable) {
				return true;
			}
		}
		return false;
	}

}
