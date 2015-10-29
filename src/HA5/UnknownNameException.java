package HA5;

/**
 * Diese Exception wird geworfen, wenn im EMailAdressBuch kein Kontakt mit dem
 * angegebenen Namen vorhanden ist.
 * 
 * @author Java-Hausaufgabengruppe 21
 * 
 */

public class UnknownNameException extends RuntimeException {
	
	/**
	 * Ich kommentier das jetzt mal nicht (ups, ich habs gerade kommentiert...)
	 * @param s Kein Kommentar!!
	 */

	public UnknownNameException(String s) {
		super(s);
	}

}
