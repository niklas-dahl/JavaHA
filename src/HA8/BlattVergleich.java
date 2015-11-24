package HA8;

import java.util.Comparator;

/**
 * Die eigentliche Aufgabe: Die Klasse, die entscheidet, wer das Spiel gewinnt
 * und wer es verliert. Wie SPANNEND!!!
 * 
 * @author Java-HA-Gruppe 21
 *
 */

public class BlattVergleich implements Comparator<Blatt> {

	@Override
	public int compare(Blatt arg0, Blatt arg1) {
		// Diese Arrays speichern (a) den "Kartenrang" (Drilling, Paar, "Niete")
		// und (b) die für diesen Rang relevante Punktezahl (beim Paar ist das
		// z.B. die Summe der Paarkarten)
		int[] rank0 = getRank(arg0);
		int[] rank1 = getRank(arg1);
		// Wenn die Ränge ungleich sind, gewinnt das Blatt mit höherem Rang.
		if (rank0[0] != rank1[0])
			return rank0[0] - rank1[0];
		else if (rank0[0] == 1) { // Beide Blätter haben ein Paar
			if (rank0[1] != rank1[1]) // Paar-Punktzahl ungleich
				return rank0[1] - rank1[1];
			else // Paar-Punktzahl gleich --> Wir nehmen die Gesamt-Punktzahl
				return getSum(arg0) - getSum(arg1);
		} else // Beide Blätter sind entweder Nieten oder Drillinge --> Wir
				// vergleichen die Gesamtpunktzahl der Blätter
			return rank0[1] - rank1[1];
	}

	/**
	 * Prüft, ob das Blatt ein Drilling ist. Wenn ja, gibt es die
	 * Gesamtpunktzahl zurück.
	 * 
	 * @param arg
	 *            Blatt
	 * @return Gesamtpunktzahl oder 0 bei keinem Drilling
	 */

	private int isDrilling(Blatt arg) {
		int[] array = arg.getArray();
		if (array[0] == array[1] && array[1] == array[2])
			return array[0] + array[1] + array[2];
		return 0;
	}

	/**
	 * Prüft, ob das Blatt ein Paar enthält. Wenn ja, gibt es die Paar-Punktzahl
	 * zurück.
	 * 
	 * @param arg
	 *            Blatt
	 * @return Paar-Punktzahl oder 0 bei keinem Paar
	 */

	private int isPaar(Blatt arg) {
		int[] array = arg.getArray();
		for (int x = 0; x < 2; x++)
			for (int y = x + 1; y < 3; y++)
				if (array[x] == array[y])
					return array[x] + array[y];
		return 0;
	}

	/**
	 * Bestimmt Rang und die für diesen Rang relevante Punktzahl eines Blatts
	 * (siehe Array-Erklärung bei {@link #compare(Blatt, Blatt)}).
	 * 
	 * @param arg
	 *            Blatt
	 * @return Rang-Array
	 */

	private int[] getRank(Blatt arg) {
		int[] ret = new int[2];
		if ((ret[1] = isDrilling(arg)) != 0)
			ret[0] = 2;
		else if ((ret[1] = isPaar(arg)) != 0)
			ret[0] = 1;
		else {
			ret[1] = getSum(arg);
		}
		return ret;
	}

	/**
	 * Berechnet die Summe des Blatts
	 * 
	 * @param arg
	 *            Blatt
	 * @return Summe
	 */

	private int getSum(Blatt arg) {
		int[] array = arg.getArray();
		return array[0] + array[1] + array[2];
	}

}
