package HA9;

/**
 * implementiert ein Schiebepuzzlespiel
 * 
 * @author Matse
 *
 */
public class Schiebepuzzle
{
	private int[][] puzzle;

	/**
	 * Konstruktor, initialisiert das Array
	 */
	public Schiebepuzzle()
	{
		puzzle = new int[4][4];
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				puzzle[i][j] = i * 4 + j + 1;
			}
		}
		puzzle[3][3] = 0;
	}

	/**
	 * verschiebt das Feld mit der übergebenen Zahl, wenn dies nach den
	 * Spielregeln möglich ist
	 * 
	 * @param int
	 *            das Spielfeld, dass verschoben werden soll
	 * @throws WrongNumbrException
	 *             wenn die Zahl nicht zwischen 1 und 15 liegt
	 * @throws WrongMoveException
	 *             wenn das gewählte Feld nicht verschoben werden darf
	 */
	public void schiebe(int i)
	{
		if (i < 1 || i > 15)
		{
			throw new WrongNumberException("Zahl liegt nicht zwischen 1 und 15!");
		}
		int[] x = new int[4];
		for (int j = 0; j < 4; j++)
		{
			for (int k = 0; k < 4; k++)
			{
				if (puzzle[j][k] == i)
				{
					x[0] = j;
					x[1] = k;
				}
				if (puzzle[j][k] == 0)
				{
					x[2] = j;
					x[3] = k;
				}
			}
		}
		if (Math.abs(x[0] - x[2]) + Math.abs(x[1] - x[3]) == 1)
		{
			puzzle[x[0]][x[1]] = 0;
			puzzle[x[2]][x[3]] = i;
			return;
		}
		throw new WrongMoveException("Zug ist nicht möglich!");
	}

	/**
	 * verschiebt 100 mal ein zufälliges Feld mit der schiebe-Methode, ungültige
	 * Züge werden abgebrochen
	 */
	public void mischen()
	{
		int x = 3;
		int y = 3;
		for (int i = 0; i < 100; i++)
		{
			try
			{
				switch ((int) (Math.random() * 4))
				{
				case 0:
					schiebe(puzzle[x + 1][y]);
					x += 1;
					break;
				case 1:
					schiebe(puzzle[x][y + 1]);
					y += 1;
					break;
				case 2:
					schiebe(puzzle[x - 1][y]);
					x -= 1;
					break;
				case 3:
					schiebe(puzzle[x][y - 1]);
					y -= 1;
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e)
			{
				i--;
				continue;
			}
		}
	}

	/**
	 * gibt das Array, das das Schiebepuzzle darstellt, zurück
	 * 
	 * @return int[][]
	 */
	public int[][] getPuzzle()
	{
		return puzzle;
	}

	/**
	 * gibt das Schiebepuzzle als optisch ansprechenden String zurück
	 * 
	 * @return String
	 */
	public String toString()
	{
		String s = "";
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (puzzle[i][j] != 0)
				{
					s += String.format("|%2s", puzzle[i][j]);
				} else
				{
					s += "|  ";
				}
			}
			s += "|\n-------------\n";
		}
		return s;
	}
}
