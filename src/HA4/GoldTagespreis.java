package HA4;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * ein Objekt dieser Klasse speichert ein Datum mit dem entsprechenden Preis
 * 
 * @author David Neuroth
 *
 */
public class GoldTagespreis {
	private String datum;
	private double preis;

	/**
	 * Konstruktor von GoldTagespreis, liest aus dem Stringparameter das Datum
	 * und den Preis aus
	 * 
	 * @param s
	 */
	public GoldTagespreis(String s) {
		String[] proc = s.split("\t");
		this.datum = proc[0];
		try {
			NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
			this.preis = nf.parse(proc[1]).doubleValue();
		} catch (Exception ex) {
			this.preis = -1;
		}
	}

	/**
	 * gibt das Datum und den Preis im selben Format wie in der Datei als String
	 * zurück
	 * 
	 * @param String
	 */
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
		return this.datum + "\t" + nf.format(this.preis);
	}

	public String getDatum() {
		return datum;
	}

	public double getPreis() {
		return preis;
	}
}
