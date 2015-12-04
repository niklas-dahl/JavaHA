package HA10;

import java.util.ArrayList;

public abstract class Chessman {
	
	private Position pos;
	protected MoveList movepos = new MoveList();
	
	public Chessman(Position pos) {
		this.pos=new Position(pos);
		this.refreshMoves();
	}
	
	protected abstract void refreshMoves();
	
	public Position getPosition() {
		return new Position(this.pos);
	}
	
	public void moveTo(Position pos) {
		if(!movepos.contains(pos))
			throw new RuntimeException("Dieser Zug ist nicht möglich!");
		this.pos=new Position(pos);
		this.movepos.clear();
		this.refreshMoves();
	}
	
	public ArrayList<Position> getMoveList() {
		return this.movepos.deepClone();
	}
	
	public boolean canMoveTo(Position pos) {
		return this.movepos.contains(pos);
	}
	
	@Override
	public abstract String toString();
}
