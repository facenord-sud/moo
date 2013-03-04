package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void change(int x, int y, int radius) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void move(int dx, int dy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contains(Point p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void change() {
        throw new UnsupportedOperationException("Not supported yet.");
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
