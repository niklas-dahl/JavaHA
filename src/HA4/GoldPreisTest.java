package HA4;

import java.io.FileNotFoundException;

/**
 * diese Klasse testet einige der Methoden von einem GoldPreis-Objekt
 * 
 * @author Matse
 *
 */
public class GoldPreisTest {
	public static void main(String[] args) {
		try {
			GoldPreis test = new GoldPreis("gold.txt");
			System.out.println(test.getPreis("2009-10-20"));
			System.out.println(test.getPreis("2009-02-07"));
			test.printMinMax();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden!");
		}
	}
}
