package HA2;

/**
 * NotAvailableException. Wird geworfen, wenn der Sitzplatz schon belegt ist.
 * 
 * @author Niklas Dahl, Marius Bronner, David Neuroth
 *
 */

public class NotAvailableException extends RuntimeException {
	
	/**
	 * Der Standard-Konstruktor für Exceptions.
	 * @param s Die Nachricht, die mit der Exception ausgegeben werden soll.
	 */

	public NotAvailableException(String s) {
		super(s);
	}

}
