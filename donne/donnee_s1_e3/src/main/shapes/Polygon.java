package shapes;

import shapes.gui.PolygonDialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Polygon extends AShape {

    /**
     *
     */
    private static final long serialVersionUID = 3257565088172095029L;
    protected int[] x;
    protected int[] y;
    private Color color;

    public Polygon() {
    }

    public Polygon(int[] x, int[] y, Color color, int id) {
        this.x = x;
        this.y = y;
        setID(id);
        this.color = color;
    }

    public double perimeter() {
        double peri = 0;
        for (int i = 0, length = this.x.length; i < length; i++) {
            int n = (i + 1) % length;
            peri += dist(this.x[i], this.y[i], this.x[n], this.y[n]);
        }
        return peri;
    }

    protected double dist(int x1, int y1, int x2, int y2) {
        double d = java.lang.Math.sqrt(java.lang.Math.pow(x2 - x1, 2) + java.lang.Math.pow(y2 - y1, 2));
        return d;
    }

    public double area() {
        // TODO Add your code for the Serie 1(1) of Genie Logiciel here!!
        return 0;
    }

    public void change() {
        javax.swing.JDialog d = new PolygonDialog(this);
        d.setVisible(true);
    }

    public void change(int[] x, int[] y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(x, y, x.length);
    }

    public String toString() {
        return "(" + getID() + ") Polygon: number of vertices = " + x.length + ", perimeter = " + perimeter() + ", area = " + area();
    }

    public void move(int dx, int dy) {
        for (int i = 0; i < this.x.length; i++) {
            this.x[i] += dx;
            this.y[i] += dy;
        }
    }

    public boolean contains(Point p) {

        //up means higher than the mouseclick y coordinate, down means lower than the mousclick y coordinate
        int up = 0;
        int down = 1;

        //eighter up or down
        int niveau;

        //initialization
        if (y[y.length - 1] > p.getY()) {
            niveau = up;
        } else {
            niveau = down;        //number of crosses left/right from the mouseclick x coordinate
        }
        int numberOfCrossesLeft = 0;
        int numberOfCrossesRight = 0;

        //if the final number of crosses left and right from the mouseclick are pair so the polygon does not contain the point, otherwise it contains the point
        //http://en.wikipedia.org/wiki/Point_in_polygon
        for (int i = 0; i < x.length; i++) {
            boolean isCrossing = false;
            if ((y[i] > p.getY()) && (niveau != up)) {
                //we got a break of line
                niveau = up;
                isCrossing = true;
            }

            if ((y[i] <= p.getY()) && (niveau != down)) {
                //we got a break of line
                niveau = down;
                isCrossing = true;
            }

            if (isCrossing) {
                int actualNode = i;
                int ancientNode = i - 1;
                if (ancientNode < 0) {
                    ancientNode = x.length - 1;
                }
                int startX = x[ancientNode];
                int startY = y[ancientNode];
                int endX = x[actualNode];
                int endY = y[actualNode];

                //we need to know when the vector (end - start) starting in point start has the same y as the mouseclick p
                //therefore we know how many times we must multiply the vector (end - start) starting in start to get the x coordinate of the same high as the mouseclick p of the vector
                //then finally we know if the click was made right or left of the mouseclick p by comparing to the calculated x

                double a = ((double) (p.y - startY)) / ((double) (endY - startY));

                double intersectionX = startX + (a * (endX - startX));

                if (intersectionX < p.getX()) {
                    numberOfCrossesLeft++;
                } else {
                    numberOfCrossesRight++;
                }
            }
        }
        if (((numberOfCrossesLeft % 2) == 1) && ((numberOfCrossesRight % 2) == 1)) {
            return true;
        } else {
            return false;
        }
    }
}