package HA5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Testklasse. Siehe Hausaufgabenblatt...
 * 
 * @author Java-Hausaufgabengruppe 21
 *
 */

public class Test {

	public static void main(String[] args) {
		EMailAdressBuch rwth = new EMailAdressBuch();
		try {
			rwth.mitarbeiterEinlesen(new URL(
					"https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_intern.txt?version=1&modificationDate=1413971200000&api=v2"));
			rwth.mitarbeiterEinlesen(new URL(
					"https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_extern.txt?version=1&modificationDate=1413971214000&api=v2"));
		} catch (MalformedURLException e) {
			System.out.println("Irgendwie sind das keine gültigen URLs....");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Download der E-Mail-Listen fehlgeschlagen! Internet an?");
			e.printStackTrace();
		}
		System.out.println(rwth);
		EMailAdressBuch testfile = new EMailAdressBuch();
		try {
			testfile.einlesen("res/emails.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Die Datei mit den E-Mails wurde leider nicht gefunden!!");
			e.printStackTrace();
		}
		System.out.println(testfile);
		System.out.println("Die E-Mail-Adresse von \"Jemand\" ist: " + testfile.abfrage("Jemand"));
	}

}
