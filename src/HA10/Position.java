package HA10;

/**
 * Eine Position auf dem Schachfeld.
 * 
 * @author mbronner
 *
 */

public class Position {

	private int x, y;

	/**
	 * Die Position wird NUR im Konstruktor gesetzt. Theoretisch könnte ich die
	 * ints also auch final machen. Wenn die Positon nicht im Schachfeld liegt,
	 * wird eine RuntimeException geworfen.
	 * 
	 * @param x
	 *            X-Koordinate
	 * @param y
	 *            Y-Koordinate
	 * @throws RuntimeException
	 *             Wenn die Positon nicht im Schachfeld liegt
	 */

	public Position(int x, int y) {
		if (!Position.isValid(x, y))
			throw new RuntimeException("Nicht im Feld!");
		this.x = x;
		this.y = y;
	}

	/**
	 * copy-Konstruktor
	 * 
	 * @param p
	 *            Andere Position
	 */

	public Position(Position p) {
		this.x = p.x;
		this.y = p.y;
	}

	/**
	 * @return X-Koordinate
	 */

	public int getX() {
		return this.x;
	}

	/**
	 * @return Y-Koordinate
	 */

	public int getY() {
		return this.y;
	}

	/**
	 * Gleiche Position?
	 * 
	 * @param p
	 *            Andere Position
	 * @return Gleich?
	 */

	public boolean equals(Position p) {
		return (this.x == p.x) && (this.y == p.y);
	}
	
	/**
	 * Prügt, ob eine Koordinate im Schachfeld liegt.
	 * @param x
	 *            X-Koordinate
	 * @param y
	 *            Y-Koordinate
	 * @return Liegt drin?
	 */

	public static boolean isValid(int x, int y) {
		return !(x < 0 || x > 7 || y < 0 || y > 7);
	}
	
	/**
	 * Gibt die Koordinate als String aus.
	 */

	@Override
	public String toString() {
		return "(" + this.x + "/" + this.y + ")";
	}
}
