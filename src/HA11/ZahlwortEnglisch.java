package HA11;

public class ZahlwortEnglisch extends Zahlwort {

	private String[] einer = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private String[] zehner = { "teen", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	public ZahlwortEnglisch(int x) {
		super(x);
	}

	@Override
	public String getWortString() {
		String s = "";
		boolean und = false;
		if (x / 1000 > 0) {
			s += einer[x / 1000 - 1] + " thousand";
			und = true;
		}
		int rest = x % 1000;
		if (rest / 100 > 0) {
			s += einer[rest / 100 - 1] + " hundred";
			und = true;
		}
		rest = x % 100;
		if (rest > 0 && und) {
			s += " and ";
		}
		if (rest == 10) {
			return s + "ten";
		}
		if (rest == 11) {
			return s + "eleven";
		} else if (rest == 12) {
			return s + "tweleve";
		}
		boolean temp = false;
		if (rest / 10 > 0) {
			int i = rest / 10 - 1;
			if (i == 0 && x % 10 > 0) {
				s += einer[x % 10 - 1];
				s += zehner[i];

				// Ausnahmen
				s = s.replace("threeteen", "thirteen");
				s = s.replace("fiveteen", "fifteen");
				return s;
			}
			s += zehner[rest / 10 - 1];
			temp = true;
		}

		if (x % 10 > 0) {
			int i = x % 10 - 1;
			if (temp) {
				s += "-";
			}
			s += einer[i];
		}
		return s;
	}

	@Override
	public String getSprache() {
		return "Englisch";
	}

}
