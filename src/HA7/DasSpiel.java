package Dilemma;

public class DasSpiel {
	
	/**
	 * Die Test Klasse !
	 * @param args
	 */
	public static void main(String[] args) {
		
		GefDilemma gd = new GefDilemma(new TitForTat(), new PerKind());
		gd.spiele(100);
		
	}
	
}
