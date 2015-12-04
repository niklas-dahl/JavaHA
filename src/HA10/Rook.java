package HA10;

public class Rook extends Chessman {
	
	public final static String logo =
			"|-|-|\n"+
			"|   |\n"+
			"|   |\n"+
			"|   |\n"+
			"|---|\n";

	public Rook(Position pos) {
		super(pos);
	}

	@Override
	protected void refreshMoves() {
		this.movepos.clear();
		for(int x=0; x<8; x++)
			if(x!=this.getPosition().getX())
				this.movepos.add(new Position(x,this.getPosition().getY()));
		for(int y=0; y<8; y++)
			if(y!=this.getPosition().getY())
				this.movepos.add(new Position(this.getPosition().getX(), y));
	}

	@Override
	public String toString() {
		return Rook.logo + "Turm\n" +  this.getPosition().toString();
	}
	
	

}
