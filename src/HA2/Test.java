package HA2;

public class Test {

	public static void main(String[] args) {
		Flugzeug f = new Flugzeug();
		f.belege("1A");
		f.belege("2B"); // Reihe 2 hat dann keine 3 Plätze mehr
		f.belege("3E"); // Reihe 3 hat dann keine 3 Plätze mehr
		f.belege("4C"); // Reihe 4 hat dann keine 3 Plätze mehr
		f.belege("4D");
		f.belege("7C");
		f.belege("7D"); // Reihe 7 hat dann keine 3 Plätze mehr
		System.out.println(f);
		int gesucht = 3;
		boolean[] frei = f.findeReihen(gesucht);
		System.out.println("Moegliche Reihen: ");
		for (int i = 0; i < frei.length; i++) {
			if (frei[i]) {
				System.out.println(i);
			}
		}
	}

}
