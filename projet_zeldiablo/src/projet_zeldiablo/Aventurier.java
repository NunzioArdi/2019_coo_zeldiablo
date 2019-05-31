package projet_zeldiablo;

public class Aventurier extends Entitee {

	public Aventurier(int pv, int posX, int posY) {
		super(pv, posX, posY);
	}

	@Override
	public void seDeplacer(int x, int y) {
		Labyrinthe lb = new Labyrinthe(this);
		if (lb.estDisponible(x, y)) {
			setPos(x, y);
		}
	}
}
