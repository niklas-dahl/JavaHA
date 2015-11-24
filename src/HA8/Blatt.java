package HA8;

import java.util.Arrays;

/**
 * Die Klasse Blatt. Speichert einfach nur drei Karten und gibt sie (optisch
 * ansprechend) wieder aus.
 * 
 * @author Java-HA-Gruppe 21
 *
 */

public class Blatt {

	private int[] karten;

	/**
	 * Konstruktor, der ein Karten-(int-)Array annimmt und es speichert, wenn es
	 * im richtigen Format vorliegt.
	 * 
	 * @param karten
	 *            Karten-Array (int[])
	 * @throws RuntimeException
	 *             Wenn (a) nicht genau drei Karten angegeben werden oder (b)
	 *             mindestens eine Karte nicht im 1-14-Bereich liegt.
	 */

	public Blatt(int[] karten) {
		if (karten.length != 3)
			throw new RuntimeException("Es müssen drei Karten angegeben werden!");
		for (int x : karten)
			if (x < 1 || x > 14)
				throw new RuntimeException("Jede Karte muss einen Wert zwischen 1 und 14 haben!");
		this.karten = karten;
	}

	/**
	 * toString-Methode
	 */

	@Override
	public String toString() {
		return String.format("---- ---- ----\n|%2d| |%2d| |%2d|\n---- ---- ----", karten[0], karten[1], karten[2]);
	}

	/**
	 * Gibt eine Kopie des Karten-Arrays aus. Ich war mir nicht sicher, ob ich
	 * das Array-Attribut protected machen durfte, deshalb hab ich das hier
	 * gemacht.
	 * 
	 * @return Karten-Array
	 */

	public int[] getArray() {
		return Arrays.copyOf(karten, 3);
	}

}
