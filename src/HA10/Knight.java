package HA10;

public class Knight extends Chessman {
	
	public final static String logo =
			"  -- \n"+
			" /  \\\n"+
			" -/ |\n"+
			" /  |\n"+
			"/---|\n";

	public Knight(Position pos) {
		super(pos);
	}

	@Override
	protected void refreshMoves() {
		this.teilMove(2,1);
		this.teilMove(2, -1);
		this.teilMove(-2,1);
		this.teilMove(-2, -1);
		this.teilMove(1, 2);
		this.teilMove(-1, 2);
		this.teilMove(1, -2);
		this.teilMove(-1, -2);
	}
	
	private void teilMove(int move_x, int move_y) {
		int newx=this.getPosition().getX()+move_x;
		int newy=this.getPosition().getY()+move_y;
		if(Position.isValid(newx, newy))
			this.movepos.add(new Position(newx, newy));
	}

	@Override
	public String toString() {
		return Knight.logo + "Springer\n" +  this.getPosition().toString();
	}
	
	

}
