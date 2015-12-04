package HA10;

public class Bishop extends Chessman {
	
	public final static String logo =
			"\\---/\n"+
			"/   \\\n"+
			"|   |\n"+
			"|   |\n"+
			"|---|\n";

	public Bishop(Position pos) {
		super(pos);
	}

	@Override
	protected void refreshMoves() {
		this.teilMove(1,1);
		this.teilMove(-1, 1);
		this.teilMove(1, -1);
		this.teilMove(-1, -1);
	}
	
	private void teilMove(int signum_x, int signum_y) {
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		while(true) {
			x+=signum_x;
			y+=signum_y;
			if(!Position.isValid(x, y))
				return;
			this.movepos.add(new Position(x,y));
		}
	}

	@Override
	public String toString() {
		return Bishop.logo + "Läufer\n" +  this.getPosition().toString();
	}
	
	

}
