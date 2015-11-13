package HA7;

/**
 * Eine Strategie die immer 2 mal Kooperiert und dann Verrät
 * @author ndahl
 *
 */
public class PerKind implements GefStrategie {

	private boolean[] strat = new boolean[] {coop, coop, verrat};
	private int i = -1;
	
	@Override
	public boolean getNextDecision() {
		i++;
		return strat[i % 3];
	}

	@Override
	public void setOpponentsLastDecision(boolean boo) {
		
	}

}
