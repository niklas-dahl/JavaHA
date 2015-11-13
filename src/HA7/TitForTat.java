package HA7;

public class TitForTat implements GefStrategie {
	
	private boolean boo;
	private boolean first = true;
	
	@Override
	public boolean getNextDecision() {
		if(first) {
			first = false;
			return coop;
		}
		
		return boo;
	}

	@Override
	public void setOpponentsLastDecision(boolean boo) {
		this.boo = boo;
	}

}
