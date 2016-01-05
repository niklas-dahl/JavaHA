package HA12;

import java.awt.Point;
import java.util.ArrayList;

/**
*   Beschreibt eine Koch Kurve, die von Figur erbt
*
*/
public class KochKurve extends Figur {

    // Die Liste aus Linien aus der die Koch Kurve besteht
    public static ArrayList<KochKurve> lines;

    // Referenz zu einen Grafik Objekt, damit die Kurve auf den Bildschirm gemalt werden kann
    public static Grafik g;

    public static void main(String[] args) {
        // Grafik Objekt initialisierung
        g = new Grafik(1920, 1800);

        lines = new ArrayList<>();
        // Eine erste Linie wird der Liste hinzugefügt, aus dieser Linie entsteht rekursiv die ganze Kurve
        lines.add(new KochKurve(new Point(100, 1080/2), new Point(1920-100, 1080/2)));
        g.add(lines.get(0));

        // Variable die beschreibt wie tief die Rekursion gehen soll
        int depth = 0;
        while(true) {
            // Die Liste an neuen Linien
            ArrayList<KochKurve> newLines = new ArrayList<>();
            // start der Rekursion
            kockRekur(newLines, new KochKurve(new Point(100, 1080/2), new Point(1920-100, 1080/2)), depth++);

            // Die alten Linien löschen
            g.figuren = new ArrayList<>();
            // Die neuen Linien speichern
            lines = newLines;

            // Die neuen Linien malen
            g.figuren.addAll(newLines);
            g.aktualisiere(0);
            
            // Begrenzung auf 4 Tiefenstufen
            if(depth>4) {
                break;
            }

            // 1 Sekunde warten
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // Eine rekursive Funktion die eine Kockkurve Schritt für Schritt erstellt
    public static void kockRekur(ArrayList<KochKurve> lines, KochKurve line, int depth) {
        if(depth == 0) {
            // Die letzte Gerade die nicht geteilt wird, wird der liste hinzugefügt
            lines.add(line);
            return;
        }

        // Hier werden die neuen Linien berechnet
        Point a = line.a;
        Point b = line.b;

        int aX = (int) a.getX();
        int aY = (int) a.getY();
        int bX = (int) b.getX();
        int bY = (int) b.getY();

        double xDiff = b.getX() - a.getX();
        double yDiff = b.getY() - a.getY();
        Point c = new Point((int) (aX + xDiff/3), (int) (aY + yDiff/3));
        Point d = new Point((int) (aX + 2*xDiff/3), (int) (aY + 2*yDiff/3));

        // Die Funktion wird rekursiv für die erstellten Linien aufgerufen
        kockRekur(lines, new KochKurve(new Point(aX, aY), new Point((int) c.getX(), (int) c.getY())), depth-1);
        kockRekur(lines, new KochKurve(new Point((int) d.getX(), (int) d.getY()), new Point(bX, bY)), depth-1);

        double vecX = ( yDiff/3 + xDiff/2 ) / 3;
        double vecY = ( -xDiff/3 + yDiff/2 ) / 3;

        // Die Funktion wird rekursiv für die erstellten Linien aufgerufen
        kockRekur(lines, new KochKurve(new Point((int) c.getX(), (int) c.getY()), new Point((int) (c.getX() + vecX), (int) (c.getY() + vecY) )), depth-1);
        kockRekur(lines, new KochKurve(new Point((int) (c.getX() + vecX), (int) (c.getY() + vecY) ), new Point((int) (d.getX()), (int) (d.getY()) )), depth-1);

    }

    // Die Punkte aus der die Linie besteht
    Point a,b;

    // Beschreibt eigendlich nur eine Linie der Koch Kurve, nicht die Koch Kurve selbst
    public KochKurve(Point x1, Point x2) {
        this.a = x1;
        this.b = x2;
        getPunktListe().add(x1);
        getPunktListe().add(x2);


    }

}