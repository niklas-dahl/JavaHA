package HA10;

import java.util.ArrayList;

/**
 * Eine Liste f�r m�gliche Positionen. Erweitert eine ArrayList<Position>. Ich
 * brauchte aber noch ein paar "spezielle" Methoden dazu, also hab ich das hier
 * gemacht.
 * 
 * @author mbronner
 *
 */

public class MoveList extends ArrayList<Position> {

	private static final long serialVersionUID = 323280615923054403L;

	/**
	 * deepClone() Wie der Name schon sagt, werden hier zur Ausgabe die
	 * Positionen geklont. Wenn die Positionen aus irgendeinem Grund Setter
	 * bekommen, k�nnte man ja sonst beschei�en, und das will ja keiner,
	 * oooooder?!?
	 * 
	 * @return Geklonte MoveList
	 */

	public MoveList deepClone() {
		MoveList ret = new MoveList();
		for (Position pos : this)
			ret.add(new Position(pos));
		return ret;
	}

	/**
	 * Das contains() von ArrayList hat nicht funktioniert, da hab ich das hier
	 * geschrieben.
	 * 
	 * @param check
	 *            Die zu checkende Position.
	 * @return Position drin?
	 */
	public boolean contains(Position check) {
		for (Position pos : this)
			if (pos.equals(check))
				return true;
		return false;
	}

}
