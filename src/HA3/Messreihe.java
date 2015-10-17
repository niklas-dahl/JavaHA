package MyPakage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Representiert eine Messreihe, die aus 20 Messwerten besteht.
 * Die Werte können direkt übergeben werden oder aus einer Datei ausgelesen werden.
 * @author Niklas Dahl, Marius Bronner
 *
 */
public class Messreihe {

	private double[] values;

	/**
	 * Der Konstruktor der die Messwerte direkt als double[] übernimmt
	 * 
	 * @param values Die Messwert als double[]
	 * @throws ArithmeticException Wird geworfen, fall nicht genau 20 Messwerte übergeben werden
	 */
	public Messreihe(double[] values) {
		if(values.length != 20) throw new ArithmeticException("Mehr als 20 Messwerte!");
		this.values = values;
	}
	
	/**
	 * Dieser Konstruktor nimmt den Namen einer Datei, aus der die Messwerte gelesen werden
	 * 
	 * @param fileName Der Name der Datei in der die Messwerte stehen
	 * @throws FileNotFoundException Falls die Datei nicht existiert
	 */
	public Messreihe(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		values = new double[20];
		int i = 0;

		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			if (line.equals("") || line.startsWith("%")) continue;
			if (i == 20) throw new ArithmeticException("Mehr als 20 Messwerte!");
			
			values[i] = Double.parseDouble(line);
			i++;
		}
		scanner.close();
		
		if (i != 20) throw new ArithmeticException("Keine 20 Messwerte!");
	}
	
	/**
	 * Gib den größten Messwert zurück
	 * @return der größten Wert
	 */
	public double getMax() {
		double ret=0;
		for(double d:values) {
			if(d>ret)
				ret=d;
		}
		return ret;
	}
	
	/**
	 * Gib den kleinsten Messwert zurück
	 * @return Der kleinsten Wert
	 */
	public double getMin() {
		double ret=values[0];
		for(int x=1; x<values.length; x++) {
			if(values[x]<ret) {
				ret=values[x];
			}
		}
		return ret;
	}
	
	/**
	 * Überprüft ob die Werteliste einheitlich ist
	 * @return Der boolesche Wert
	 */
	public boolean isEinheitlich() {
		double check=values[0];
		for(int x=1; x<values.length; x++) {
			if(values[x]!=check)
				return false;
		}
		return true;
	}
	
	/**
	 * Zählt wie viele Werte der Liste größer als ein bestimmer Wert sind
	 * @param Der Wert der überschritten werden muss
	 * @return Die Anzahl der Werte die größer sind
	 */
	public int zeahleGroessere(int lim) {
		int ret=0;
		for(double d:values) {
			if(d>lim)
				ret++;
		}
		return ret;
	}
	
	/**
	 * Gibt den Index der größten Zahl zurück
	 * @return Der Index des größten Werts
	 */
	public int getMaxIndex() {
		double max=values[0];
		int ret=0;
		for(int x=values.length-1; x>0; x--) {
			if(values[x]>max) {
				max=values[x];
				ret=x;
			}
		}
		return ret;
	}
	
	/**
	 * Gib den Bereich der Messwerte zurück
	 * @return Ein double[] mit {min, max}
	 */
	public double[] getBereich() {
		double[] ret = {getMin(), getMax()};
		return ret;
	}

	
	/**
	 * Override der toString Methode
	 * @return Die String Represantation des Objekts
	 */
	@Override
	public String toString() {
		return "Messwerte: " + Arrays.toString(values);
	}

}
