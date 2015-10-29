package HA5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Ein E-Mail-Adressbuch. Ordnet Namen E-Mails zu (wow!).
 * 
 * @author Java-Hausaufgabengruppe 21
 *
 */

public class EMailAdressBuch {
	
	/**
	 * Hier werden die Kontaktdaten gespeichert!
	 */

	HashMap<String, String> addrs = new HashMap<>();

	/**
	 * Konstruktor. Macht gar nichts, wurde in der Aufgabenstellung aber schon
	 * wieder verlangt!
	 */

	public EMailAdressBuch() {
		// Ich schreib mal nen Kommentar hier rein, damit sich der Konstruktor
		// nicht vernachlässigt fühlt... :D
	}

	/**
	 * Fügt einen neuen Eintrag zum Adressbuch hinzu.
	 * 
	 * @param name
	 *            Name der Person
	 * @param email
	 *            E-Mail der Person
	 */

	public void einfuegen(String name, String email) {
		this.addrs.put(name, email);
	}

	/**
	 * Fragt die zu einem Namen passende E-Mail-Adresse ab. Wirft eine
	 * Exception, wenn noch gar kein Eintrag hinterlegt wurde.
	 * 
	 * @param name
	 *            Name der Person
	 * @return E-Mail der Person
	 * @throws UnknownNameException
	 *             Wenn der Eintrag nicht existiert
	 */

	public String abfrage(String name) throws UnknownNameException {
		String email = addrs.get(name);
		if (email == null)
			throw new UnknownNameException("Name \"" + name + "\" befindet sich nicht im Adressbuch!");
		return email;
	}

	/**
	 * Einfache toString-Methode. Format: {name=email, name=email, ...}
	 */

	public String toString() {
		StringBuilder ret = new StringBuilder("{");
		boolean first = true;
		for (Entry<String, String> eintrag : addrs.entrySet()) {
			if (!first)
				ret.append(", ");
			else
				first = false;
			ret.append(eintrag.getKey() + "=" + eintrag.getValue());
		}
		ret.append("}");
		return ret.toString();
	}

	/**
	 * Liest Kontaktdaten aus einer Datei im Format name;email[Neue
	 * Zeile]name;email[Neue Zeile]... ein. Wirft eine FileNotFoundException,
	 * wenn die Datei nicht gefunden werden kann.
	 * 
	 * @param dateiname
	 *            Naja, der Name ist ja schon ziemlich selbsterklärend, oder?
	 *            --RICHTIIIG!! Der Pfad zur Datei! (DING-DING-DING, der Kandidat bekommt 100 Punkte!!) 
	 * @throws FileNotFoundException
	 *             Wenn die Datei nicht gefunden werden kann
	 */

	public void einlesen(String dateiname) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(dateiname), "UTF-8");
		while (sc.hasNextLine()) {
			String[] eintrag = sc.nextLine().split(";", 2);
			addrs.put(eintrag[0], eintrag[1]);
		}
		sc.close();
	}

	/**
	 * Liest Kontaktdaten von einer Website aus. Das Format muss wieder wie bei
	 * {@link #einlesen(String)} sein.
	 * 
	 * @param url
	 *            URL zur Seite
	 * @throws IOException
	 *             Wenn die Seite nicht gefunden werden kann (Schon wieder das
	 *             Internet gelöscht?!? :/)
	 */

	public void mitarbeiterEinlesen(URL url) throws IOException {
		Scanner sc = new Scanner((InputStream) url.openConnection().getContent(), "UTF-8");
		while (sc.hasNextLine()) {
			String[] eintrag = sc.nextLine().split(";", 2);
			addrs.put(eintrag[0], eintrag[1]);
		}
		sc.close();
	}

}
