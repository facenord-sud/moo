package clock.bargraph;

import clock.abstractGui.AbstractClockFrame;
import java.awt.Dimension;
import clock.timer.ClockTimer;

/**
 * A digital clock observing a clock timer.
 *
 * @author Andreas Ruppen
 */
public class BarGraphClock extends AbstractClockFrame {

    private static final long serialVersionUID = 3256723966037931316L;

    /**
     * Creates a new instance of
     * <code>DigitalClock</code> that observes the given clock timer.
     */
    public BarGraphClock(ClockTimer timer) {
        super(timer);
    }

   
    @Override
    protected void init() {
        setTitle("Bars Clock");
        this.clockPanel = new BarGraphClockPanel();
        this.clockPanel.setPreferredSize(new Dimension(200, 180));
    }
}