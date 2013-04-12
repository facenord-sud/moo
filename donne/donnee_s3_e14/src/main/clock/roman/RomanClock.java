package clock.roman;

import clock.abstractGui.AbstractClockFrame;
import java.awt.Dimension;
import clock.timer.ClockTimer;

/**
 * An roman digital clock observing a clock timer.
 *
 * @author Julien Thomet, adapted by Andreas Ruppen
 */
public class RomanClock extends AbstractClockFrame {

    private static final long serialVersionUID = 3258408447900069937L;

    /**
     * Creates a new instance of
     * <code>RomanClock</code> that observes the given clock timer.
     */
    public RomanClock(ClockTimer timer) {
        super(timer);
    }

    @Override
    protected void init() {
        this.clockPanel = new RomanClockPanel();
        this.clockPanel.setPreferredSize(new Dimension(200, 80));
        setTitle("Roman Clock");
    }
}
