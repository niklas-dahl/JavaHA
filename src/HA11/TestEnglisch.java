package HA11;

public class TestEnglisch {

	public static void main(String[] args) {
		int[] testtabelle = { 10, 11, 12, 13, 15, 18, 20, 35, 51, 80, 103, 1067, 3010};
		for (int zahl : testtabelle) {
			try {
				ZahlwortEnglisch zahlwort = new ZahlwortEnglisch(zahl);
				System.out.println(zahlwort);
			} catch (NumberFormatException ex) {
				System.out.println(ex);
			}
		}
	}
}
