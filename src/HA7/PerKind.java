package HA7;

/**
 * Eine Strategie die immer 2 mal Kooperiert und dann Verrät
 * @author ndahl
 *
 */
public class PerKind implements GefStrategie {
	
	private int i = 0;
	
	@Override
	public boolean getNextDecision() {
		i++;
		return i%3==0;
	}

	@Override
	public void setOpponentsLastDecision(boolean boo) {
		
	}

}
