package shapes;

import java.awt.Graphics;
import java.awt.Point;

public interface Shape extends java.io.Serializable {
    
    double perimeter();
    
    double area();
    
    void change();
    
    int getID();
    
    void setID(int newid);
    
    String toString();
    
    void draw(Graphics g);
    
    void move(int dx, int dy);
    
    boolean contains(Point p);
    
}