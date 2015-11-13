package HA6;

import java.math.BigInteger;

public class PositiveNumber
{
	private int value;

	/**
	 * Konstruktor
	 */
	public PositiveNumber()
	{

	}

	/**
	 * Hilfsmethode, die überprüft, ob der Wert des BigIntegers im zulässigen
	 * Bereich liegt und initialisiert dann das Attribut mit diesem Wert, wirft
	 * andernfalls eine Exception
	 * 
	 * @param der
	 *            zu überprüfende BigInteger
	 */
	public void checkBigInt(BigInteger b)
	{
		if (b.signum() == -1 || b.subtract(new BigInteger("" + Integer.MAX_VALUE)).signum() == 1)
		{
			throw new NumberFormatException("Die eingegebene Zahl liegt auï¬‚erhalb des gültigen Wertebereichs!");
		}
		value = b.intValue();
	}

	/**
	 * gibt das Attribut in Binär zurück
	 * 
	 * @return Binärzahl als String
	 */
	public String getBinary()
	{
		String s = "";
		int i = this.value;
		while (i > 0)
		{
			s = i % 2 + s;
			i /= 2;
		}
		return s;
	}

	/**
	 * liest eine Binärzahl als String ein, wandelt sie in einen BigInteger um
	 * und ruft damit die Hilfsmethode checkBigInt(BigInteger b) auf
	 * 
	 * @param Binärzahl als String
	 */
	public void setBinary(String s)
	{
		BigInteger b = new BigInteger("0");
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '1')
			{
				b = b.add(new BigInteger("" + (int) Math.pow(2, s.length() - i - 1)));
			}
		}
		checkBigInt(b);
	}

	/**
	 * gibt das Attribut als Dezimalzahl zurück
	 * 
	 * @return Attribut als String
	 */
	public String getDecimal()
	{
		return "" + value;
	}

	/**
	 * liest eine Dezimalzahl als String ein, wandelt sie in einen BigInteger um
	 * und ruft damit die Hilfsmethode checkBigInt(BigInteger b) auf
	 * 
	 * @param Dezimalzahl als String
	 */
	public void setDecimal(String s)
	{
		BigInteger b = new BigInteger(s);
		checkBigInt(b);
	}

	/**
	 * gibt das Attribut in Hexadezimal zurück
	 * 
	 * @return Hexadezimalzahl als String
	 */
	public String getHexadecimal()
	{
		String s = "";
		int i = this.value;
		while (i > 0)
		{
			if (i % 16 > 9)
			{
				s = (char) (i % 16 + 'A' - 10) + s;
			} else
			{
				s = i % 16 + s;
			}
			i /= 16;
		}
		return s;
	}

	/**
	 * liest eine Hexadezimalzahl als String ein, wandelt sie in einen BigInteger um
	 * und ruft damit die Hilfsmethode checkBigInt(BigInteger b) auf
	 * 
	 * @param Hexadezimalzahl als String
	 */
	public void setHexadecimal(String s)
	{
		BigInteger b = new BigInteger("0");
		s = s.toUpperCase();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) >= 'A')
			{
				b = b.add(
						new BigInteger("" + (int) (s.charAt(i) - 'A' + 10) * (int) (Math.pow(16, s.length() - i - 1))));
			} else
			{
				b = b.add(new BigInteger("" + (int) (s.charAt(i) - '0') * (int) (Math.pow(16, s.length() - i - 1))));
			}
		}
		checkBigInt(b);
	}
}
