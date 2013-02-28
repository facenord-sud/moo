package shapes;

import shapes.gui.RectangleDialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Polygon {

    /**
     * 
     */
    private static final long serialVersionUID = 3546638806905075509L;
    protected int x;
    protected int y;
    protected int wide;
    protected int high;
    private Color color;

    public Rectangle(int x, int y, int wide, int high, Color color, int id) {
        this.x = x;
        this.y = y;
        this.wide = wide;
        this.high = high;
        setID(id);
        this.color = color;
    }

    public double area() {
        return this.wide * this.high;
    }

    public double perimeter() {
        return 2 * this.wide + 2 * this.high;
    }

    public String toString() {
        //return "Rectangle with wide " + this.wide + " and high " + this.high;
        return "(" + getID() + ") Rectangle: side a = " + this.wide + ", side b = " + this.high + ", perimeter = " + perimeter() + ", area = " + area();
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, wide, high);
    }

    public void change() {
        javax.swing.JDialog d = new RectangleDialog(this);
        d.setVisible(true);
    }

    public void change(int x, int y, int a, int b) {
        this.x = x;
        this.y = y;
        this.wide = a;
        this.high = b;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public boolean contains(Point p) {
        int px = (int) p.getX();
        int py = (int) p.getY();
        boolean containsVertical = (x <= px) && (px <= x + wide);
        boolean containsHorizontal = (y <= py) && (py <= y + high);
        return containsVertical && containsHorizontal;
    }
}