package HA12; /**
 * Zweck: Fuer Praesenzuebung 10 zu verwendende Klasse,
 * die den Rahmen bietet, um geometrische Figuren auf dem Bildschirm anzeigen zu lassen.</br>
 * Der Rahmen besteht dabei aus den Klassen Grafik und Figur.
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Grafik {

	private JFrame frame;
	private JPanel panel;
	public ArrayList<Figur> figuren = new ArrayList<Figur>();

	/**
	 * Oeffnet ein Grafikfenster mit einer Zeichenflaeche
	 * der angegebenen Breite und Hoehe.
	 * 
	 * @param width Breite der Zeichenflaeche
	 * @param height Hoehe der Zeichenflaeche
	 */
	@SuppressWarnings("serial")
	public Grafik(int width, int height) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel() {
			public void paint(Graphics g) {
				super.paint(g);
				for (int i = 0; i < figuren.size(); i++) {
					figuren.get(i).paint(g);
				}
			}
		};
		panel.setPreferredSize(new Dimension(width, height));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Aktualisiert die Zeichenflaeche. Aenderungen werden erst sichtbar,
	 * nachdem diese Methode aufgerufen wurde. Vor der Aktualisierung wird ms Milisekunden gewartet.</br>
	 * Damit ist eine einfache Animation moeglich.
	 * 
	 * @param verzoegerung Zeit in Milisekunden, die vor der Aktualisierung gewartet wird.
	 */
	public void aktualisiere(int verzoegerung) {
		// frame.repaint();
		try {
			Thread.sleep(verzoegerung);
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					panel.paint(panel.getGraphics());
				}
			});
		} catch (InterruptedException e) {
		} catch (InvocationTargetException e) {
		}
	}

	/**
	 * Diese Methode fuegt die uebergebene Figur in die Zeichenflaeche ein.
	 * 
	 * @param f In die Zeichenflaeche einzufuegende Figur.
	 */
	public void add(Figur f) {
		figuren.add(f);
	}

	/**
	 * Mit dieser Methode wird die uebergebene Figur von der Zeichenflaeache entfernt
	 *  
	 * @param f
	 */
	public void remove(Figur f) {
		figuren.remove(f);
	}
}

class Figur {

	/** Alle Punkte einer Figur befinden sich in dieser Liste, benachbarte Punkte liegen dabei nebeneinander*/
	private ArrayList<Point> punkte = new ArrayList<Point>();
	
	/**
	 * Gibt die Liste der Punkte zurueck.
	 * @return Die Liste der Punkte der Figur
	 */
	protected ArrayList<Point> getPunktListe() {
		return punkte;
	}

	/**
	 * Diese Methode zeichnet zwischen den jeweils benachbarten Punkten der Liste
	 * eine Verbindungslinie.
	 * 
	 * @param g Graphicobjekt, auf dem die Punkte der Figur eingezeichnet werden
	 */
	public void paint(Graphics g) {
		for (int i = 0; i < punkte.size() - 1; i++) {
			g.drawLine(punkte.get(i).x, punkte.get(i).y, punkte.get(i + 1).x,
					punkte.get(i + 1).y);
		}
	}

	/**
	 * Alle Punkte der Figur werden um die angegebenen Werte verschoben.
	 * 
	 * @param x Verschiebungswert in x-Richtung
	 * @param y Verschiebungswert in y-Richtung
	 */
	public void verschiebe(int x, int y) {
		for (Point a : punkte) {
			a.translate(x, y);
		}
	}

	public String toString() {
		return "Figur:" + this.punkte.toString();
	}
}
