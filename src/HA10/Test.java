package HA10;

public class Test {

	public static void main(String[] args) {
		// Test eines Turms
		Rook rook = new Rook(new Position(4, 5));
		System.out.println(rook);
		rook.moveTo(new Position(4, 1));
		System.out.println(rook);
		System.out.println(rook.getMoveList());
		// Test eines Springers
		Knight knight = new Knight(new Position(4, 3));
		System.out.println(knight);
		knight.moveTo(new Position(5, 5)); // Mitten auf dem Feld
		System.out.println(knight);
		System.out.println(knight.getMoveList());
		knight.moveTo(new Position(7, 4)); // Am Rand des Feldes
		System.out.println(knight);
		System.out.println(knight.getMoveList());
	}

}
