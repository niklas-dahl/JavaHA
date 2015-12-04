package HA10;

import java.util.ArrayList;

public class MoveList extends ArrayList<Position> {
	
	private static final long serialVersionUID = 323280615923054403L;

	public MoveList deepClone() {
		MoveList ret = new MoveList();
		for(Position pos : this)
			ret.add(new Position(pos));
		return ret;
	}
	
	public boolean contains(Position check) {
		for(Position pos : this)
			if(pos.equals(check))
				return true;
		return false;
	}

}
