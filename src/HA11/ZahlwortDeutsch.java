package HA11;

public class ZahlwortDeutsch extends Zahlwort {

	private String[] einer = { "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun" };
	private String[] zehner = { "zehn", "zwanzig", "dreißig", "vierzig", "fuenfzig", "sechszig", "siebzig", "achtzig",
			"neunzig" };

	public ZahlwortDeutsch(int x) {
		super(x);
	}

	@Override
	public String getWortString() {
		String s = "";
		if (x / 1000 > 0) {
			s += einer[x / 1000 - 1] + "tausend";
		}
		int rest = x % 1000;
		if (rest / 100 > 0) {
			s += einer[rest / 100 - 1] + "hundert";
		}
		rest = x % 100;

		// Ausnahmen
		if (rest == 11) {
			return s + "elf";
		} else if (rest == 12) {
			return s + "zwoelf";
		}
		boolean und = false;
		if (x % 10 > 0) {
			int i = x % 10 - 1;
			if (i > 0) {
				und = true;
			}
			s += einer[i];

		}

		if (rest / 10 > 0) {
			int i = rest / 10 - 1;
			if (i == 0) {
				und = false;
			}
			if (und) {
				s += "und";
			}
			s += zehner[rest / 10 - 1];
		}
		
		// Ausnahmen
		if (s.substring(s.length() - 3).equals("ein")) {
			s += "s";
		}

		s = s.replace("siebenzehn", "siebzehn");
		s = s.replace("sechszehn", "sechzehn");

		return s;
	}

	@Override
	public String getSprache() {
		return "Deutsch";
	}

}
