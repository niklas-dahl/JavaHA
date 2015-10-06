package HA1;

/**
 * Testet, was die Stoppuhr so drauf hat!
 * 
 * @author Niklas Dahl, Marius Bronner, David Neuroth
 *
 */

public class StopwatchTest {

	/**
	 * Die eigentliche Testfunktion. Macht das, was im AB steht.
	 * 
	 * @param args
	 *            Die Parameter werden nicht berücksichtigt
	 */

	public static void main(String[] args) {
		try {
			Stoppuhr uhr = new Stoppuhr();
			uhr.start();
			uhr.start();
			uhr.stop();
			System.out.println("Gestoppte Zeit: " + uhr.getTime() + " ns");
			uhr.start();
			uhr.stop();
			uhr.stop();
			System.out.println("Gestoppte Zeit: " + uhr.getTime() + " ns");
			uhr.reset();
			System.out.println("Gestoppte Zeit: " + uhr.getTime() + " ns");
			uhr.start();
			System.out.println("Gestoppte Zeit: " + uhr.getTime() + " ns");
		} catch (Exception e) {
			System.out.println("Die Stoppuhr wurde noch nicht gestoppt!");
		}
	}

}
