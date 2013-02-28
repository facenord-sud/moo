package shapes;

import shapes.gui.SquareDialog;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Square extends Rectangle {

    /**
     * 
     */
    private static final long serialVersionUID = 3617573803782058294L;
    private Color color;

    public Square(int x, int y, int wide, Color color, int id) {
        super(x, y, wide, wide, color, id);
        this.color = color;
    }

    public double area() {
        return java.lang.Math.pow(wide, 2);
    }

    public double perimeter() {
        return 4 * this.wide;
    }

    public String toString() {
        //return "Square with side " + this.wide;
        return "(" + getID() + ") Square: side = " + this.wide + ", perimeter = " + perimeter() + ", area = " + area();
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, wide, high);
    }

    public void change() {
        javax.swing.JDialog d = new SquareDialog(this);
        d.setVisible(true);
    }

    public void change(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.high = s;
        this.wide = s;
    }

    public boolean contains(Point p) {
        int px = (int) p.getX();
        int py = (int) p.getY();
        boolean contains = (x <= px) && (y <= py) && (px <= x + wide) && (py <= y + wide);
        return contains;
    }
}
