package HA2;

/**
 * Die Hauptklasse Flugzeug. Macht, was ein Flugzeug so macht - nein, war ein
 * Scherz. Fliegt nicht. Lässt Sitzreservierungen zu und gibt sie auf dem
 * Bildschirm aus.
 * 
 * @author Niklas Dahl, Marius Bronner, David Neuroth
 *
 */

public class Flugzeug {

	/**
	 * Dieses Array spiegelt die Sitzreihen des Flugzeugs wieder. Wenn der Wert
	 * true ist, dann ist der Sitz schon belegt.
	 */

	private boolean belegung[][] = new boolean[7][6];

	/**
	 * Der Konstruktor. Er wurde in der Aufgabenstellung verlangt, aber da die
	 * Datenstrukturen auch ohne besondere Befehle im Konstruktor im richtigen
	 * Format angelegt werden, ist er eigentlich unnütz (daher ist er auch leer
	 * :D )
	 */

	public Flugzeug() {
	}

	/**
	 * Hiermit kann ein Sitzplatz belegt/reserviert werden. Man sollte
	 * allerdings aufpassen, dass man nur ja einen freien und existierenden
	 * Sitzplatz erwischt, weil ansonsten direkt eine Exception geworfen wird.
	 * 
	 * @param s
	 *            Die Sitz-ID, im Format [Reihe als Zahl][Platz als Buchstabe],
	 *            also z.B. 1A
	 * @throws WrongPositionException
	 *             Wenn der Sitz nicht existiert.
	 * @throws NotAvailableException
	 *             Wenn der Sitz schon belegt ist.
	 */

	public void belege(String s) {
		s = s.toLowerCase();
		// Die Chars werden in das interne Zahlensystem für die Sitzreihen
		// umgewandelt
		int x = s.charAt(0) - '1';
		int y = s.charAt(1) - 'a';
		if (!platzGueltig(x, y))
			throw new WrongPositionException("Dieser Platz existiert nicht!");
		if (belegung[x][y])
			throw new NotAvailableException("Dieser Platz ist leider schon vergeben :(");
		belegung[x][y] = true;
	}

	/**
	 * toString-Methode. Gibt einen optisch ansprechenden ( ;) ) Sitzplan mit
	 * den Reservierungen aus.
	 * 
	 * @return Sitzplan
	 */

	public String toString() {
		// Das hier wird der am Ende ausgegebene String!
		String ret = "";
		// Geht alle Reihen durch
		for (int x = 0; x < 7; x++) {
			ret += (x + 1) + "\t";
			// Geht alle Sitze in der betreffenden Reihe durch
			for (int y = 0; y < 6; y++) {
				if (platzGueltig(x, y)) {
					if (belegung[x][y]) {
						// Belegt!
						ret += "X ";
					} else {
						// Nicht belegt!
						ret += (char) (y + 'A') + " ";
					}
				} else {
					// Gar kein richtiger Sitzplatz!
					ret += "  ";
				}
			}
			ret += "\n";
		}
		return ret;
	}

	/**
	 * Interne Funktion, die prüft, ob es an der angegebenen Reihe/Spalte -
	 * Kombination überhaupt einen Sitz gibt.
	 * 
	 * @param x
	 *            Reihe
	 * @param y
	 *            Spalte
	 * @return Sitzplatz existiert?
	 */

	private boolean platzGueltig(int x, int y) {
		if (x < 0 || x > 6 || y < 0 || y > 5) {
			return false;
		}
		if (!(x < 3 && y > 1 && y < 4)) {
			return true;
		}
		return false;
	}

	/**
	 * Prüft, in welcher Reihe noch die angegebene Anzahl an zusammenhängenden
	 * Sitzplätzen frei ist.
	 * 
	 * @param personen
	 *            Anzahl der Personen/Sitzplätze
	 * @return Boolean-Array, das für jede Reihe angibt, ob die angegebene
	 *         Anzahl an zusammenhängenden Sitzplätzen frei ist
	 */

	public boolean[] findeReihen(int personen) {
		// Ausgabe-Array
		boolean[] ret = new boolean[belegung.length + 1];
		// Gehe durch alle Reihen
		for (int x = 0; x < belegung.length; x++) {
			// Anzahl der zusammenhängenden freien Sitzplätze
			int count = 0;
			// Gehe durch jeden Platz
			for (int y = 0; y < belegung[0].length; y++) {
				if (platzGueltig(x, y)) {
					if (!belegung[x][y]) {
						// Wenn der Platz existiert und nicht belegt ist, zähle
						// count um 1 hoch
						count++;
					} else {
						// Wenn er existiert, aber belegt ist, wird die Reihe
						// dadurch abgebrochen.
						// Setze count deshalb auf 0.
						count = 0;
					}
				}
				// Wenn eine solche freie Reihe in der Sitzreihe existiert,
				// setze das Ausgabe-Array für diese Reihe auf true.
				// Das weitere Suchen für diese Sitzreihe kann damit abgebrochen
				// werden.
				if (count >= personen) {
					ret[x + 1] = true;
					break;
				}
			}
		}
		return ret;
	}

}
