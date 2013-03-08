package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import shapes.gui.CircleDialog;

/**
 *
 * @author leo
 */
public class Circle extends AShape {

    protected int x, y, wide;
    protected Color color;

    public Circle(int x, int y, int a, Color color, int id) {
        this.x = x;
        this.y = y;
        this.wide = a;
        this.color = color;
        this.setID(id);
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*Math.pow(this.wide, 2);
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(this.wide, 2);
    }

    public void change(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.wide = radius;
    }
    
    @Override
    public void change() {
        javax.swing.JDialog  jd = new CircleDialog(this);
        jd.setVisible(true);
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(this.x, this.y, this.wide, this.wide);
    }

    @Override
    public void move(int dx, int dy) {
        this.x+=dx;
        this.y+=dy;
    }

    @Override
    public boolean contains(Point p) {
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWide() {
        return wide;
    }

}
