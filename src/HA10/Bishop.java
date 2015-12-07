package HA10;

/**
 * Ein L�ufer. War in der Aufgabenstellung nicht gefordert, aber als mir klar
 * wurde, dass ich Springer mit L�ufer verwechselt hatte, war es schon zu sp�t
 * <facepalm>
 * 
 * @author mbronner
 *
 */

public class Bishop extends Chessman {

	/**
	 * Das "Bildchen" f�r die Schachfigur. Gibt's gratis dazu :D
	 */

	public final static String logo = "\\---/\n" + "/   \\\n" + "|   |\n" + "|   |\n" + "|---|\n";

	/**
	 * Den Konstruktor musste ich neu schreiben, weil man den von Chessman ja
	 * nicht direkt nehmen kann.
	 * 
	 * @param pos
	 *            Position
	 */

	public Bishop(Position pos) {
		super(pos);
	}

	/**
	 * Hier werden die m�glichen Z�ge mit der Hilfsfunktion teilMove berechnet.
	 * 
	 * Beim ersten teilMove der Teil nach unten rechts (wenn der Ursprung oben
	 * links ist), dann nach unten links, usw...
	 */

	@Override
	protected void refreshMoves() {
		this.teilMove(1, 1);
		this.teilMove(-1, 1);
		this.teilMove(1, -1);
		this.teilMove(-1, -1);
	}

	/**
	 * Je nach X- und Y-Signum (hier die Bewegunsrichtung, vor/zur�ck) wird
	 * hiermit eine Bewegungsrichtung (z.B. nach unten links) abgedeckt.
	 * 
	 * @param signum_x
	 *            X-Koordinate: vor oder zur�ck?
	 * @param signum_y
	 *            Y-Koordinate: vor oder zur�ck?
	 */

	private void teilMove(int signum_x, int signum_y) {
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		while (true) {
			// In diser Schleife "geht" teilMove immer weiter in eine diagonale
			// Richtung.
			x += signum_x;
			y += signum_y;
			// Wenn die Position au�erhalb des Schachbretts liegt, war's das f�r
			// diesen teilMove.
			if (!Position.isValid(x, y))
				return;
			// Ansonsten ist das dann wieder ein m�glicher Zug.
			this.movepos.add(new Position(x, y));
		}
	}

	/**
	 * toString() Methode. Dank Bildchen sogar mit �sthetik.
	 */

	@Override
	public String toString() {
		return Bishop.logo + "L�ufer\n" + this.getPosition().toString();
	}

}
