package HA7;

/**
 * Das Interface das alle Spielstrategien implementieren müssen
 * 
 * @author ndahl
 *
 */
public interface GefStrategie {
	public static boolean verrat = true;
	public static boolean coop = false;

	/**
	 * Gibt die nächste Entscheidung des Spielers nach der gewählten
	 * Spielstrategie aus.
	 * 
	 * @return Entscheidung
	 */
	public boolean getNextDecision();

	/**
	 * "Informiert" die Strategie über die letzte Entscheidung des Gegners.
	 * 
	 * @param boo
	 *            Letzte Entscheidung des Gegners
	 */
	public void setOpponentsLastDecision(boolean boo);
}
