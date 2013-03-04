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
public class Ellipse extends Circle{
    
    protected int high;
    
    public Ellipse(int x, int y, int a, int b, Color color, int id) {
        super(x, y, a, color, id);
        this.high = b;
    }

    @Override
    public double perimeter() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void change(int x, int y, int a, int b) {
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
    
}
