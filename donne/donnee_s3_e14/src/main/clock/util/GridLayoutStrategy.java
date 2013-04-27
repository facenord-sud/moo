/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clock.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author leo
 */
public class GridLayoutStrategy implements LayoutStrategy {

    private Point defaultFramePosition;
    private Point currentFramePosition;
    private int x, y;

    public GridLayoutStrategy() {
        x = 0;
        y = 0;
        defaultFramePosition = new Point(x, y);
        currentFramePosition = new Point(defaultFramePosition);
    }

    @Override
    public void addFrameToLayout(ArrayList<JFrame> frames, JFrame frame) {
        Dimension scrennSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (currentFramePosition.x + frame.getWidth() >= scrennSize.getWidth()) {
            y += frame.getHeight();
            if (y + frame.getHeight() >= scrennSize.getHeight()) {
                y = 0;
                x += 20;
            }
            currentFramePosition = new Point(x, y);
        } else {
            currentFramePosition.translate(frame.getWidth(), y);
        }
        frame.setLocation(currentFramePosition);
    }

    @Override
    public void removeFrameFromLayout(ArrayList<JFrame> frames, JFrame frame) {
    }

    @Override
    public void doLayout(ArrayList<JFrame> placedFrames) {
        currentFramePosition = new Point(defaultFramePosition);
        for (JFrame frame : placedFrames) {
            addFrameToLayout(placedFrames, frame);
        }
    }

    @Override
    public String getDescription() {
        return "Grid Layout";
    }
}
