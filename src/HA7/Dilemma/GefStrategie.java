package Dilemma;

/**
 * Das Interface das alle Spielstrategien implementieren müssen
 * @author ndahl
 *
 */
public interface GefStrategie {
	public static boolean verrat = true;
	public static boolean coop = false;
	
	
	public boolean getNextDecision();
	public void setOpponentsLastDecision(boolean boo);
}
