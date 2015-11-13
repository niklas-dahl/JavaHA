package HA7;

public class TitForTat implements GefStrategie {

	private boolean boo = coop;

	@Override
	public boolean getNextDecision() {
		return boo;
	}

	@Override
	public void setOpponentsLastDecision(boolean boo) {
		this.boo = boo;
	}

}
