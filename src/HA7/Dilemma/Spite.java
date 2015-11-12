package Dilemma;

/**
 * Diese Strategie Kooperiert so lange bis der Gegenspieler einmal verrät, danach verrät sie nur.
 * @author ndahl
 *
 */
public class Spite implements GefStrategie {
		
	boolean feundlich = true;
	
	@Override
	public boolean getNextDecision() {
		return feundlich;
	}

	@Override
	public void setOpponentsLastDecision(boolean boo) {
		if(!boo) feundlich = false;
	}

}
