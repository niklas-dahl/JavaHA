package HA2;

public class Flugzeug {
	
	/**
	 * ***************************************
	 * TODO: Das, was noch auf dem Blatt steht
	 * 
	 * Der Pflug hat ja nachträglich noch was
	 * an der Aufgabe geändert, ich gucks mir
	 * vielleicht irgendwann dieses Wochenende 
	 * mal an.
	 * 
	 * TODO: Javadoc! So was wie das hier, nur
	 * dass es auch was mit dem prorammierten
	 * Code zu tun haben soll ;)
	 * ***************************************
	 */

	private boolean belegung[][] = new boolean[7][6];

	public Flugzeug() {
	}

	public void belege(String s) {
		s = s.toLowerCase();
		int x = s.charAt(0) - '1';
		int y = s.charAt(1) - 'a';
		if (x < 0 || x > 6 || y < 0 || y > 5) {
			throw new RuntimeException(); // TODO Eigene Exception werfen
		}
		if (x < 3 && y > 1 && y < 4) {
			throw new RuntimeException(); // TODO Eigene Exception werfen
		}
		belegung[x][y] = true;
	}

	public String toString() {
		String ret = "";
		for (int x = 0; x < 7; x++) {
			for (int y = 0; y < 6; y++) {
				if (!(x < 3 && y > 1 && y < 4)) {
					if (belegung[x][y]) {
						ret += "= ";
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

}
