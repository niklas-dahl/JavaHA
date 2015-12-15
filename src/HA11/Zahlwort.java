package HA11;

public abstract class Zahlwort {
	protected int x;

	public Zahlwort(int x) {
		if (x <= 0 || x >= 10000) {
			throw new NumberFormatException("Zahl nicht im " + " Bereich zwischen 1 und 9999");
		} else {
			this.x = x;
		}
	}

	public String getZifferString() {
		return x + "";
	}

	public abstract String getWortString();

	public abstract String getSprache();

	public String toString() {
		return "Die Zahl " + x + " schreibt man auf " + getSprache() + ": " + getWortString() + ".";
	}
}
