package HA4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ein Objekt dieser Klasse speichert sämtliche Daten aus einer eingelesenen Datei in einer Arraylist aus Objekten von GoldTagespreis
 * @author David Neuroth
 *
 */
public class GoldPreis
{
	private ArrayList<GoldTagespreis> list = new ArrayList<>();

	public static void main(String[] args)
	{

	}

	/**
	 * Konstruktor von GoldPreis, erhält Namen der einzulesenden Datei
	 * 
	 * @param datei
	 * @throws FileNotFoundException
	 */
	public GoldPreis(String datei) throws FileNotFoundException
	{
		File f = new File(datei);
		Scanner sc = new Scanner(f, "UTF-8");
		while (sc.hasNextLine())
		{
			list.add(new GoldTagespreis(sc.nextLine()));
		}
		sc.close();
	}

	/**
	 * gibt den Preis an einem bestimmten Datum zurück, wirft eine Exception, wenn das Datum ungültig ist
	 * @param datum
	 * @return preis
	 */
	public double getPreis(String datum)
	{
		for (GoldTagespreis g : list)
		{
			if (g.getDatum().equals(datum))
			{
				return g.getPreis();
			}
		}
		throw new NumberFormatException("Tag konnte nicht gefunden werden.");
	}

	/**
	 * gibt alle Tage mit dem minimalem und alle Tage mit dem maximalen Preis aus, verwendet die Methode getMinMax()
	 */
	public void printMinMax()
	{
		double[] minmax = getMinMax();
		System.out.println("Den niedrigsten Goldpreis von " + minmax[0] + " gab es an folgenden Tagen:");
		for (GoldTagespreis g : list)
		{
			if (g.getPreis() == minmax[0])
			{
				System.out.println(g.getDatum());
			}
		}
		System.out.println("Den höchsten Goldpreis von " + minmax[1] + " gab es an folgenden Tagen:");
		for (GoldTagespreis g : list)
		{
			if (g.getPreis() == minmax[1])
			{
				System.out.println(g.getDatum());
			}
		}
	}

	/**
	 * Hilfsmethode, berechnet des minimalen und den maximalen Preis und gibt beides in einem double-array zurück
	 * @return minmax
	 */
	public double[] getMinMax()
	{
		double d = list.get(0).getPreis();
		double[] minmax = { d, d };
		for (GoldTagespreis g : list)
		{
			if (g.getPreis() < minmax[0] && g.getPreis() > 0)
			{
				minmax[0] = g.getPreis();
				continue;
			}
			if (g.getPreis() > minmax[1])
			{
				minmax[1] = g.getPreis();
			}
		}
		return minmax;
	}
}
