package HA12;

import java.awt.Point;
import java.util.ArrayList;

public class KochKurve extends Figur {

    public static ArrayList<KochKurve> lines;

    public static Grafik g;

    public static void main(String[] args) {
        g = new Grafik(1920, 1800);

        lines = new ArrayList<>();
        lines.add(new KochKurve(new Point(100, 1080/2), new Point(1920-100, 1080/2)));

        g.add(lines.get(0));

        int depth = 0;
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // interate();

            ArrayList<KochKurve> newLines = new ArrayList<>();
            kockRekur(newLines, new KochKurve(new Point(100, 1080/2), new Point(1920-100, 1080/2)), depth++);

            g.figuren = new ArrayList<>();
            // zoom(newLines);
            lines = newLines;

            g.figuren.addAll(newLines);
            g.aktualisiere(0);
            // Begrenzung auf 4 Tiefenstufen
            if(depth>4)
            	break;
        }

    }

    public static void kockRekur(ArrayList<KochKurve> lines, KochKurve line, int depth) {
        if(depth == 0) {
            // add final line to list
            lines.add(line);
            return;
        }

        // Create new lines
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

        //AC und DB
        kockRekur(lines, new KochKurve(new Point(aX, aY), new Point((int) c.getX(), (int) c.getY())), depth-1);
        kockRekur(lines, new KochKurve(new Point((int) d.getX(), (int) d.getY()), new Point(bX, bY)), depth-1);

        double vecX = ( yDiff/3 + xDiff/2 ) / 3;
        double vecY = ( -xDiff/3 + yDiff/2 ) / 3;

        //CV
        kockRekur(lines, new KochKurve(new Point((int) c.getX(), (int) c.getY()), new Point((int) (c.getX() + vecX), (int) (c.getY() + vecY) )), depth-1);
        kockRekur(lines, new KochKurve(new Point((int) (c.getX() + vecX), (int) (c.getY() + vecY) ), new Point((int) (d.getX()), (int) (d.getY()) )), depth-1);

    }

    Point a,b;


    public KochKurve(Point x1, Point x2) {
        this.a = x1;
        this.b = x2;
        getPunktListe().add(x1);
        getPunktListe().add(x2);


    }

}