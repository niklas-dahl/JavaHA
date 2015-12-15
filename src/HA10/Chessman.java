package HA10;

import java.util.ArrayList;

/**
 * Eine Schachfigur! Bewegt sich nach bestimmten Regeln und schlägt andere
 * Figuren (wobei das hier nicht implementiert ist).
 * 
 * Ich weiß, ganz schön abstrakt :D
 * 
 * Anmerkung: Wir haben bewusst getMoveList() nicht abstrakt gemacht. Das hieße
 * ja, dass in dieser Methode die Bewegungs-Regeln festgelegt werden. Dadurch
 * würden die möglichen Züge ja für jeden enzelnen Befehl immer wieder neu
 * berechnet werden! Stattdessen haben wir uns entschieden, eine
 * Methode refrehsMoves() abstrakt zu machen, die die Züge-Liste dann ALS
 * ATTRIBUT berechnet. Wenn später andere Figuren mit dieser hier zusammen
 * spielen, kann man ja refreshMoves() wenn sich eine andere Figur bewegt hat
 * auch wieder aufrufen. Das ist dann immer noch effizienter.
 * 
 * @author mbronner
 *
 */

public abstract class Chessman {

	private Position pos;

	/**
	 * hier werden später die möglichen Züge gespeichert
	 */
	protected MoveList movepos = new MoveList();

	/**
	 * Normaler Konstruktor. Da er eine Position festlegt, muss er auch die
	 * möglichen Züge überdenken
	 * 
	 * @param pos
	 *            Position
	 */

	public Chessman(Position pos) {
		this.pos = new Position(pos);
		this.refreshMoves();
	}

	/**
	 * Soooooo, hier ist dann also die abstrakte Methode. In den einzelnen
	 * Implementierungen dazu noch mehr...
	 */

	protected abstract void refreshMoves();

	/**
	 * Naja, gibt die Position zurück, und das war's...
	 * 
	 * @return Position
	 */

	public Position getPosition() {
		return new Position(this.pos);
	}

	/**
	 * Bewegt die Schachfigur - wenn möglich - zu der neuen Position. Berechnet
	 * dann auch alle möglichen Züge neu.
	 * 
	 * @param pos
	 *            neue Position
	 */

	public void moveTo(Position pos) {
		if (!movepos.contains(pos))
			throw new RuntimeException("Dieser Zug ist nicht möglich!");
		this.pos = new Position(pos);
		this.movepos.clear();
		this.refreshMoves();
	}

	/**
	 * Klont die Liste mit den möglichen Zügen.
	 * 
	 * @return Mögliche Züge
	 */

	public ArrayList<Position> getMoveList() {
		return this.movepos.deepClone();
	}

	/**
	 * Kann die Schachfigur diesen Zug ausführen?
	 * 
	 * @param pos
	 *            Position
	 * @return Kann sie's?
	 */

	public boolean canMoveTo(Position pos) {
		return this.movepos.contains(pos);
	}

	/**
	 * Da jeder Schachfigurentyp einen anderen Namen und ein anderes Bildchen
	 * hat, war es praktisch auch noch toString abstrakt zu machen
	 */

	@Override
	public abstract String toString();
}
