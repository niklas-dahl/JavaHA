package HA7;

/**
 * Die Klasse die das Gefängniss Dilemma simuliert
 * @author ndahl
 *
 */
public class GefDilemma {
	
	private GefStrategie p1, p2;
	
	/**
	 * Beide spieler werden beim erstellen des Objekts übergeben
	 * @param Spieler 1
	 * @param Spieler 2
	 */
	public GefDilemma(GefStrategie p1, GefStrategie p2) {
		this.p1 = p1;
		this.p2 = p2;
		
	}
	
	/**
	 * Die Methode simuliert das spiel n mal
	 * @param Anzahl der Spiele die simuliert werden sollen
	 */
	public void spiele(int n) {
		boolean last1, last2;
		int pp1=0, pp2=0;
		
		for(int i = 0; i < n; i++) {
			last1 = p1.getNextDecision();
			last2 = p2.getNextDecision();
			
			p1.setOpponentsLastDecision(last2);
			p2.setOpponentsLastDecision(last1);
			
			if(last1 == GefStrategie.verrat && last2 == GefStrategie.verrat) {
				pp1 += 4;
				pp2 += 4;
			}if(last1 == GefStrategie.coop && last2 == GefStrategie.coop) {
				pp1 += 2;
				pp2 += 2;
			}if(last1 == GefStrategie.verrat && last2 == GefStrategie.coop) {
				pp1 += 0;
				pp2 += 5;
			}if(last1 == GefStrategie.coop && last2 == GefStrategie.verrat) {
				pp1 += 5;
				pp2 += 0;
			}
		}
		
		System.out.println("Player 1: " + pp1 + " Player 2: " + pp2);
	}
	
}
