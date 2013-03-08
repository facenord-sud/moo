/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.PI;
import shapes.gui.EllipseDialog;

/**
 *
 * @author leo
 */
public class Ellipse extends Circle {

    protected int high;

    public Ellipse(int x, int y, int a, int b, Color color, int id) {
        super(x, y, a, color, id);
        this.high = b;
    }

    @Override
    public double perimeter() {
        return PI * Math.sqrt(
                ((2 * (Math.pow(this.high, 2) + Math.pow(this.wide, 2))) - (Math.pow(this.high - this.wide, 2))) / 2);
    }

    @Override
    public double area() {
        return PI * this.wide * this.high;
    }

    public void change(int x, int y, int a, int b) {
        this.x = x;
        this.y = y;
        this.wide = a;
        this.high = b;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, wide, high);
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public boolean contains(Point p) {
        if ((Math.pow((p.x - this.x) / this.wide, 2) + Math.pow((p.y - this.y) / this.high, 2)) <= 1) {
            return true;
        }
        return false;
    }

    @Override
    public void change() {
        javax.swing.JDialog d = new EllipseDialog(this);
        d.setVisible(true);
    }
}
