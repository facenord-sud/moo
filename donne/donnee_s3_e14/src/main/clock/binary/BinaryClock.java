package clock.binary;

import clock.abstractGui.AbstractClockFrame;
import java.awt.Dimension;
import clock.timer.ClockTimer;

/**
 * A digital clock observing a clock timer.
 *
 * @author Andreas Ruppen
 */
public class BinaryClock extends AbstractClockFrame {

    private static final long serialVersionUID = 3256723966037931316L;

    /**
     * Creates a new instance of
     * <code>BinaryClock</code> that observes the given clock timer.
     */
    public BinaryClock(ClockTimer timer) {
        super(timer);
    }

    @Override
    protected void init() {
        BinaryClockPanel clockPanel = new BinaryClockPanel();
        this.clockPanel.setPreferredSize(new Dimension(200, 100));
        setTitle("Binary Clock");
    }
}