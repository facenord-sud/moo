package clock.util;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;

/**
 * An interface defining the layout strategy for the position manager.
 *
 * @author Andreas Ruppen
 */
public interface LayoutStrategy {

    /**
     * Adds the given frame to the layout.
     */
    public void addFrameToLayout(ArrayList<JFrame> frames, JFrame frame);

    /**
     * Removes the given frame from the layout.
     */
    public void removeFrameFromLayout(ArrayList<JFrame> frames, JFrame frame);

    /**
     * Lays out the frames in the given vector.
     */
    public void doLayout(ArrayList<JFrame> placedFrames);

    /**
     * Returns a string describing the layout strategy.
     *
     * @uml.property name="description"
     */
    public String getDescription();
}
