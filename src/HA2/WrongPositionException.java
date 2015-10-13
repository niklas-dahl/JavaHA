package HA2;

/**
 * WrongPositionException. Wird geworfen, wenn an der angegebenen Stelle gar kein
 * Sitzplatz existiert.
 * 
 * @author Niklas Dahl, Marius Bronner, David Neuroth
 *
 */

public class WrongPositionException extends RuntimeException {
	
	/**
	 * Der Standard-Konstruktor f�r Exceptions.
	 * @param s Die Nachricht, die mit der Exception ausgegeben werden soll.
	 */
	
	public WrongPositionException(String s) {
		super(s);
	}

}
