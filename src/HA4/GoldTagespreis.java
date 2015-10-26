package HA4;

/**
 * ein Objekt dieser Klasse speichert ein Datum mit dem entsprechenden Preis
 * @author David Neuroth
 *
 */
public class GoldTagespreis
{
	private String datum;
	private double preis = -1;

	public static void main(String[] args)
	{

	}

	/**
	 * Konstruktor von GoldTagespreis, liest aus dem Stringparameter das Datum und den Preis aus
	 * @param s
	 */
	public GoldTagespreis(String s)
	{
		datum = s.substring(0, 10);
		if (!s.contains("kein Nachweis"))
		{
			preis = 1000 * Integer.parseInt(s.substring(11, 13));
			preis += Integer.parseInt(s.substring(14, 17));
			preis += Integer.parseInt(s.substring(19)) / 10;
		}
	}

	/**
	 * gibt das Datum und den Preis im selben Format wie in der Datei als String zurück
	 * @param String
	 */
	public String toString()
	{
		String s = "" + preis;
		return datum + "\t" + s.substring(0, 2) + "." + s.substring(2, 5) + "," + s.substring(6);
	}

	public String getDatum()
	{
		return datum;
	}

	public double getPreis()
	{
		return preis;
	}
}
