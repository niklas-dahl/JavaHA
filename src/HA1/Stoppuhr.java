package HA1;

/**
 * Die Stoppuhr-Klasse. Tut, was eine Stoppuhr halt so tut, naja... Zeit messen!
 * 
 * @author Niklas Dahl, Marius Bronner, David Neuroth
 *
 */

public class Stoppuhr {

	/**
	 * Hier werden die Variablen deklariert.
	 * 
	 * long startValue: Hier wird der Wert von System.nanoTime() beim Start der
	 * Stoppuhr gespeichert. long stoppedTime: Für die Zeit, die von der Uhr
	 * gemessen wurde. boolean running: Läuft die Uhr schon?
	 */

	private long startValue, stoppedTime;
	private boolean running;

	/**
	 * Konstruktor der Uhr. Verlangt keine Argumente und initialisiert die
	 * Variablen mit Standard-Werten.
	 */

	public Stoppuhr() {
		startValue = 0;
		stoppedTime = 0;
		running = false;
	}

	/**
	 * Startet die Stoppuhr. "Merkt" sich dabei die derzeitigt Systemzeit mit
	 * startValue.
	 */

	public void start() {
		if (running)
			return;

		startValue = System.nanoTime();
		running = true;
	}

	/**
	 * Stoppt die Uhr. Addiert dabei die Differenz aus jetziger Systemzeit und
	 * startValue (siehe {@link #start()}), also die gestoppte Zeit, zu der in
	 * stoppedTime stehenden eventuell schon früher gestoppten Zeit.
	 */

	public void stop() {
		if (running) {
			stoppedTime += System.nanoTime() - startValue;
		}
		running = false;
	}

	/**
	 * Gibt die bisher gestoppte Zeit aus. Funktioniert nur, wenn die Uhr nicht
	 * läuft.
	 * 
	 * @return Bisher gestoppte Zeit
	 * @throws RuntimeException
	 *             Wenn die Uhr noch läuft
	 */

	public long getTime() {
		if (running)
			throw new RuntimeException("Stoppuhr laeuft noch");

		return stoppedTime;
	}

	/**
	 * Setzt die Zeit der Stoppuhr auf 0 zurück. Funktioniert nur, wenn die Uhr
	 * nicht läuft.
	 * 
	 * @throws RuntimeException
	 *             Wenn die Uhr noch läuft
	 */

	public void reset() {
		if (running)
			throw new RuntimeException("Stoppuhr laeuft noch");

		stoppedTime = 0;
	}

}
