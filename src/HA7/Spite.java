package HA7;

/**
 * Diese Strategie Kooperiert so lange bis der Gegenspieler einmal verrät,
 * danach verrät sie nur.
 * 
 * @author ndahl
 *
 */
public class Spite implements GefStrategie {

	boolean verraten = false;

	@Override
	public boolean getNextDecision() {
		return verraten;
	}

	@Override
	public void setOpponentsLastDecision(boolean boo) {
		if (boo)
			verraten = true;
	}

}
