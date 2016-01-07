package HA13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Diese Klasse soll einen Huffman-codierten Text ¸bersetzen
 *
 * @author David Neuroth, Marius Bronner, Niklas Dahl
 *
 */
public class Huffman
{
	/**
	 * main-Methode zum Testen
	 *
	 * @param args Übergabeparameter
	 */
	public static void main(String[] args)
	{
		File f = new File("Message.txt");
		System.out.println(decode(f));
	}

	/**
	 * Diese Methode liest aus der ¸bergebenen Datei, falls diese das richtige
	 * Format hat, den verschl¸sselten Text und die Dekodier-Tabelle aus,
	 * ¸bersetzt den Text und gibt ihn zur¸ck
	 *
	 * @param f
	 *            Datei mit Text und Dekodier-Tabelle
	 * @return ‹bersetzung des Texts
	 */
	public static String decode(File f)
	{
		HashMap<String, Character> map = new HashMap<>();
		String text;
		try
		{
			Scanner sc = new Scanner(f);
			if (!sc.hasNext())
			{
				sc.close();
				throw new IllegalArgumentException("Datei ist leer.");
			}
			text = sc.nextLine();
			char c = 'A';
			while (sc.hasNextLine())
			{
				String s = sc.nextLine();
				if (s != "")
				{
					map.put(s, c);
				}
				c++;
				if (c == '[')
				{
					c = ' ';
				}
			}
			sc.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("Datei konnte nicht gefunden werden.");
			return null;
		}
		String ret = "";
		int i = 1;
		while (text.length() >= i)
		{
			String s = text.substring(0, i);
			if (map.containsKey(s))
			{
				ret += map.get(s);
				text = text.substring(i);
				i = 1;
				continue;
			}
			i++;
		}
		if (text.length() > 0)
		{
			throw new IllegalArgumentException("Datei hat nicht das richtige Format.");
		}
		return ret;
	}
}
