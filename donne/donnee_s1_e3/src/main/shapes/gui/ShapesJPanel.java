/*
 * ShapesJPanel.java
 *
 * Created on 13. septembre 2001, 12:35
 */

package shapes.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;
import shapes.Shape;

/**
 *
 * @author  fuhrer
 */
public class ShapesJPanel extends javax.swing.JPanel {
	private static final long serialVersionUID = 3256728381281482035L;
	private Vector<Shape> shapes;
        private Vector<Shape> guiShapes;
    
    /** Creates new ShapesJPanel */
    public ShapesJPanel(Vector<Shape> shapes, Vector<Shape> guiShapes) {
        super();
        this.shapes = shapes;
        this.guiShapes = guiShapes;
        this.setBackground(Color.white);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < shapes.size(); i++) {
            shapes.elementAt(i).draw(g);
        }
        for(int i = 0; i < guiShapes.size(); i++) {
            guiShapes.elementAt(i).draw(g);
        }
    }
    
}
