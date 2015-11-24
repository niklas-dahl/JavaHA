package HA8;

import java.util.Comparator;

/**
 * Diese Testklasse wurde vom AB übernommen.
 */

public class Test {

	private static void werteAus(Blatt b1, Blatt b2, Comparator<Blatt> cb) {
		int vergleich = cb.compare(b1, b2);
		String ergebnis = "";
		if (vergleich < 0) {
			ergebnis = "\nverliert gegen\n";
		} else if (vergleich == 0) {
			ergebnis = "\nist gleichwertig mit\n";
		} else {
			ergebnis = "\nschlaegt\n";
		}
		System.out.println(b1.toString() + ergebnis + b2.toString() + "\n");
	}

	public static void main(String[] args) {
		Blatt drillingNiedrig = new Blatt(new int[] { 1, 1, 1 });
		Blatt drillingHoch = new Blatt(new int[] { 9, 9, 9 });
		Blatt paarNiedrig = new Blatt(new int[] { 1, 1, 2 });
		Blatt paarHoch = new Blatt(new int[] { 1, 5, 5 });
		Blatt paarHoch2 = new Blatt(new int[] { 10, 5, 5 });
		Blatt einfachNiedrig = new Blatt(new int[] { 1, 2, 8 });
		Blatt einfachHoch = new Blatt(new int[] { 3, 4, 5 });
		BlattVergleich bv = new BlattVergleich();
		werteAus(paarHoch, drillingNiedrig, bv);
		werteAus(paarNiedrig, einfachNiedrig, bv);
		werteAus(drillingHoch, drillingNiedrig, bv);
		werteAus(paarHoch, paarNiedrig, bv);
		werteAus(paarHoch, paarHoch2, bv);
		werteAus(einfachNiedrig, einfachHoch, bv);
	}

}
