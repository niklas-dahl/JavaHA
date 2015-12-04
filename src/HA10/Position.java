package HA10;

public class Position {
	
	private int x, y;
	
	public Position(int x, int y) {
		if(!Position.isValid(x,y))
			throw new RuntimeException("Nicht im Feld!");
		this.x=x;
		this.y=y;
	}
	
	public Position(Position p) {
		this.x=p.x;
		this.y=p.y;
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public boolean equals(Position p) {
		return (this.x==p.x) && (this.y==p.y);
	}
	
	public static boolean isValid(int x, int y) {
		return !(x<0 || x>7 || y<0 || y>7);
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "/" + this.y + ")";
	}
}
