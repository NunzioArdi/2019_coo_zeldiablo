package projet_zeldiablo;

public abstract class Entitee {
	private int pv;
	private int posX;
	private int posY;
	private Labyrinthe lab;

	public Entitee(int vie, int px, int py) {
		if (vie < 0) {
			this.pv = 0;
		} else {
			this.pv = vie;
		}

		if (px < 0) {
			this.posX = 1;
		} else {
			this.posX = px;
		}

		if (py < 0) {
			this.posY = 1;
		} else {
			this.posY = px;
		}
	}

	public abstract boolean seDeplacer(int x, int y);

	public void setPos(int posX) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setLabyrinthe(Labyrinthe lb) {
		this.lab = lb;
	}
	
}
