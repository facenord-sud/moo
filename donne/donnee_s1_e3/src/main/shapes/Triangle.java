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
public class Triangle extends Polygon{
    
    public Triangle(int[] vx, int[] vy, Color color, int id) {
        super(vx, vy, color, id);
    }
    
    @Override
    public double perimeter() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void change() {
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
    
}
