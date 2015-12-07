package HA10;

/**
 * Der Springer. Springt immer L-förmig (2 Felder parallel zur einen Achse, 1
 * zur anderen). Mehr dazu auf Wikipedia!
 * 
 * @author mbronner
 *
 */

public class Knight extends Chessman {

	/**
	 * Auch hier wieder ein eher weniger hochauflösendes Bildchen von der
	 * Schachfigur.
	 */

	public final static String logo = "  -- \n" + " /  \\\n" + " -/ |\n" + " /  |\n" + "/---|\n";

	/**
	 * Den Konstruktor musste ich neu schreiben, weil man den von Chessman ja
	 * nicht direkt nehmen kann.
	 * 
	 * @param pos
	 *            Position
	 */

	public Knight(Position pos) {
		super(pos);
	}

	/**
	 * Hier werden die möglichen Züge mit der Hilfsfunktion teilMove berechnet.
	 * 
	 * Ein teilMove für einen L-Zug.
	 */

	@Override
	protected void refreshMoves() {
		this.teilMove(2, 1);
		this.teilMove(2, -1);
		this.teilMove(-2, 1);
		this.teilMove(-2, -1);
		this.teilMove(1, 2);
		this.teilMove(-1, 2);
		this.teilMove(1, -2);
		this.teilMove(-1, -2);
	}

	/**
	 * Wir erinnern uns (Merke :D ): 2 Felder parallel zur einen Achse, 1 zur
	 * anderen. Mehr gibts dazu eigentlich nicht zu sagen!
	 * 
	 * @param move_x
	 *            Bewegung in X-Richtung
	 * @param move_y
	 *            Bewegung in Y-Richtung
	 */

	private void teilMove(int move_x, int move_y) {
		int newx = this.getPosition().getX() + move_x;
		int newy = this.getPosition().getY() + move_y;
		if (Position.isValid(newx, newy))
			this.movepos.add(new Position(newx, newy));
	}

	/**
	 * toString() Methode. Dank Bildchen sogar mit Ästhetik.
	 */

	@Override
	public String toString() {
		return Knight.logo + "Springer\n" + this.getPosition().toString();
	}

}
