/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author leo
 */
public class Triangle extends Polygon {

    public Triangle(int[] vx, int[] vy, Color color, int id) {
        super(vx, vy, color, id);
    }

    @Override
    public double perimeter() {
        return super.perimeter();
    }

    @Override
    public double area() {
        return super.area();
    }

    @Override
    public void change() {
        
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }

    @Override
    public boolean contains(Point p) {
        return super.contains(p);
    }
}
