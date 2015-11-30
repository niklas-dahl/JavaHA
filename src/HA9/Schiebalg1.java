package HA9;

/**
 * implementiert einen Lösungsalgorithmus, in dem so lange zufällige Felder
 * verschoben werden, bis die 1 oben links ist
 * 
 * @author Matse
 *
 */
public class Schiebalg1 implements Loesungsalgorithmus
{

	/**
	 * verschiebt solange zufällige Felder im übergebenen Schiebepuzzle-Objekt,
	 * bis die 1 oben links ist
	 * 
	 * @param Schiebepuzzle
	 *            das zu lösende Schiebepuzzle-Objekt
	 */
	@Override
	public void loese(Schiebepuzzle p)
	{
		int x = 0;
		int y = 0;
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (p.getPuzzle()[i][j] == 0)
				{
					x = i;
					y = j;
					break;
				}
			}
		}
		while (p.getPuzzle()[0][0] != 1)
		{
			try
			{
				switch ((int) (Math.random() * 4))
				{
				case 0:
					p.schiebe(p.getPuzzle()[x + 1][y]);
					x += 1;
					break;
				case 1:
					p.schiebe(p.getPuzzle()[x][y + 1]);
					y += 1;
					break;
				case 2:
					p.schiebe(p.getPuzzle()[x - 1][y]);
					x -= 1;
					break;
				case 3:
					p.schiebe(p.getPuzzle()[x][y - 1]);
					y -= 1;
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e)
			{

			}
		}
	}
}
