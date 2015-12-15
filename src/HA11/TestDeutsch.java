package HA11;

public class TestDeutsch {

	public static void main(String[] args) {
		 int[] testtabelle = { 1, 10, 11, 12, 16, 17, 20, 38, 69, 70, 131, 195, 2345 };
		 for (int zahl: testtabelle) {
		 try {
		 ZahlwortDeutsch zahlwort = new ZahlwortDeutsch(zahl);
		 System.out.println(zahlwort);
		 }
		 catch (NumberFormatException ex) {
		 System.out.println(ex);
		 }
		 }
	}
}
