package HA3;

import java.util.Arrays;

public class MessreiheTest {

	/**
	 * Die Methode testet die Messreihe Klasse
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Messreihe reihe = new Messreihe("C:/Users/mbronner/Documents/messwerte.txt");
			System.out.println("Maximalwert: " + reihe.getMax());
			System.out.println("Minimalwert: " + reihe.getMin());
			System.out.println("Einheitliche Werte: " + reihe.isEinheitlich());
			System.out.println("Anzahl Werte groﬂer 50: " + reihe.zeahleGroessere(50));
			System.out.println("Index Maximalwert: " + reihe.getMaxIndex());
			System.out.println("Wertebereich: " + Arrays.toString(reihe.getBereich()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
