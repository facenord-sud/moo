package clock.abstractGui;

import javax.swing.JPanel;

/**
 *
 * @author leo
 */
public abstract class AbstractClockPanel extends JPanel{
    
    protected int hour;
    protected int minute;
    protected int second;
    
    /**
     * Sets the clocks current time.
     */
    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
}
