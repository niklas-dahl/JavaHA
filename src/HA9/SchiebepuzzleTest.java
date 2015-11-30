package HA9;

/**
 * Testklasse zum testen der Klassen Schiebepuzzle und Lösungsalgorithmus
 * 
 * @author Matse
 *
 */
public class SchiebepuzzleTest
{
	public static void main(String[] args)
	{
		Schiebepuzzle p = new Schiebepuzzle();
		p.mischen();
		System.out.println("Nach dem Mischen:" + "\n");
		System.out.println(p.toString());
		Schiebalg1 a = new Schiebalg1();
		a.loese(p);
		System.out.println("\n" + "Nach dem Loesen:" + "\n");
		System.out.println(p.toString());
	}
}
