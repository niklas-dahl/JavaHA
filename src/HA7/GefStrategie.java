package HA7;

/**
 * Das Interface das alle Spielstrategien implementieren m�ssen
 * 
 * @author ndahl
 *
 */
public interface GefStrategie {
	public static boolean verrat = true;
	public static boolean coop = false;

	/**
	 * Gibt die n�chste Entscheidung des Spielers nach der gew�hlten
	 * Spielstrategie aus.
	 * 
	 * @return Entscheidung
	 */
	public boolean getNextDecision();

	/**
	 * "Informiert" die Strategie �ber die letzte Entscheidung des Gegners.
	 * 
	 * @param boo
	 *            Letzte Entscheidung des Gegners
	 */
	public void setOpponentsLastDecision(boolean boo);
}
