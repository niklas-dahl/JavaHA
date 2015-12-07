package HA10;

import java.util.ArrayList;

/**
 * Eine Schachfigur! Bewegt sich nach bestimmten Regeln und schl�gt andere
 * Figuren (wobei das hier nicht implementiert ist).
 * 
 * Ich wei�, ganz sch�n abstrakt :D
 * 
 * Anmerkung: Wir haben bewusst getMoveList() nicht abstrakt gemacht. Das hie�e
 * ja, dass in dieser Methode die Bewegungs-Regeln festgelegt werden. Dadurch
 * w�rden die m�glichen Z�ge ja f�r jeden enzelnen Befehl immer wieder neu
 * berechnet werden! Stattdessen haben wir uns entschieden, eine private
 * Funktion refrehsMoves() abstrakt zu machen, die die Z�ge-Liste dann ALS
 * ATTRIBUT berechnet. Wenn sp�ter andere Figuren mit dieser hier zusammen
 * spielen, kann man ja refreshMoves() wenn sich eine andere Figur bewegt hat
 * auch wieder aufrufen. Das ist dann immer noch effizienter.
 * 
 * @author mbronner
 *
 */

public abstract class Chessman {

	private Position pos;

	/**
	 * hier werden sp�ter die m�glichen Z�ge gespeichert
	 */
	protected MoveList movepos = new MoveList();

	/**
	 * Normaler Konstruktor. Da er eine Position festlegt, muss er auch die
	 * m�glichen Z�ge �berdenken
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
	 * Naja, gibt die Position zur�ck, und das war's...
	 * 
	 * @return Position
	 */

	public Position getPosition() {
		return new Position(this.pos);
	}

	/**
	 * Bewegt die Schachfigur - wenn m�glich - zu der neuen Position. Berechnet
	 * dann auch alle m�glichen Z�ge neu.
	 * 
	 * @param pos
	 *            neue Position
	 */

	public void moveTo(Position pos) {
		if (!movepos.contains(pos))
			throw new RuntimeException("Dieser Zug ist nicht m�glich!");
		this.pos = new Position(pos);
		this.movepos.clear();
		this.refreshMoves();
	}

	/**
	 * Klont die Liste mit den m�glichen Z�gen.
	 * 
	 * @return M�gliche Z�ge
	 */

	public ArrayList<Position> getMoveList() {
		return this.movepos.deepClone();
	}

	/**
	 * Kann die Schachfigur diesen Zug ausf�hren?
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
