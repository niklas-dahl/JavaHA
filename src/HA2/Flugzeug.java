package HA2;

public class Flugzeug {

	private boolean belegung[][] = new boolean[7][6];

	public Flugzeug() {
	}

	public void belege(String s) {
		s = s.toLowerCase();
		int x = s.charAt(0) - '1';
		int y = s.charAt(1) - 'a';
		if (!platzGueltig(x, y))
			throw new WrongPositionException("Dieser Platz existiert nicht!");
		if(belegung[x][y])
			throw new NotAvailableException("Dieser Platz ist leider schon vergeben :(");
		belegung[x][y] = true;
	}

	public String toString() {
		String ret = "";
		for (int x = 0; x < 7; x++) {
			for (int y = 0; y < 6; y++) {
				if (platzGueltig(x, y)) {
					if (belegung[x][y]) {
						ret += "X ";
					} else {
						ret += (char) (y + 'A') + " ";
					}
				} else {
					ret += "  ";
				}
			}
			ret += "\n";
		}
		return ret;
	}

	private boolean platzGueltig(int x, int y) {
		if (x < 0 || x > 6 || y < 0 || y > 5) {
			return false;
		}
		if (!(x < 3 && y > 1 && y < 4)) {
			return true;
		}
		return false;
	}

	public boolean[] findeReihen(int personen) {
		boolean[] ret = new boolean[belegung.length + 1]; // So kann man am Ende
															// leichter Reihen
															// hinzufügen.
		for (int x = 0; x < belegung.length; x++) {
			int count = 0;
			for (int y = 0; y < belegung[0].length; y++) {
				if (platzGueltig(x, y)) {
					if (!belegung[x][y]) {
						count++;
					} else {
						count = 0;
					}
				}
				if (count >= personen) {
					ret[x + 1] = true;
					break;
				}
			}
		}
		return ret;
	}

}
