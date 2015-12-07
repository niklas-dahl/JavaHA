package HA10;

/**
 * Der Turm. Kann gerade nach oben/unten/rechts/links gehen.
 * 
 * @author mbronner
 *
 */

public class Rook extends Chessman {

	/**
	 * Und noch ein Logo! Ja logo...
	 */

	public final static String logo = "|-|-|\n" + "|   |\n" + "|   |\n" + "|   |\n" + "|---|\n";

	/**
	 * Den Konstruktor musste ich neu schreiben, weil man den von Chessman ja
	 * nicht direkt nehmen kann.
	 * 
	 * @param pos
	 *            Position
	 */

	public Rook(Position pos) {
		super(pos);
	}

	/**
	 * Hier werden die möglichen Züge berechet.
	 * 
	 * Hier ganz einfach, es wird einfach die horizontale und vertikale Bahn
	 * durchgegangen. Stehenbleiben ausgeschlossen.
	 */

	@Override
	protected void refreshMoves() {
		this.movepos.clear();
		for (int x = 0; x < 8; x++)
			if (x != this.getPosition().getX()) // !Stehenbleiben
				this.movepos.add(new Position(x, this.getPosition().getY()));
		for (int y = 0; y < 8; y++)
			if (y != this.getPosition().getY()) // !Stehenbleiben
				this.movepos.add(new Position(this.getPosition().getX(), y));
	}

	/**
	 * toString()-Methode.
	 */

	@Override
	public String toString() {
		return Rook.logo + "Turm\n" + this.getPosition().toString();
	}

}
