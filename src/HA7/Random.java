package HA7;

/**
 * Diese Strategie entscheidet sich zufällig
 * @author ndahl
 *
 */
public class Random implements GefStrategie {
	
	@Override
	public boolean getNextDecision() {
		return (0.5 < Math.random());
	}

	@Override
	public void setOpponentsLastDecision(boolean boo) {
		// TODO Auto-generated method stub

	}

}
