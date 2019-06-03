package projet_zeldiablo;

public class Piege extends Case implements Piegee {

	public Piege(int x, int y) {
		super(x, y);
	}

	@Override
	public void activer(Entitee e) {
		e.subirDegat(1);
	}
	
}
