package clock.digitalNG;

import clock.abstractGui.AbstractClockFrame;
import java.awt.Dimension;
import clock.timer.ClockTimer;

/**
 * A digital clock observing a clock timer.
 *
 * @author Andreas Ruppen
 */
public class DigitalClockNG extends AbstractClockFrame {

    private static final long serialVersionUID = 3256723966037931316L;

    /**
     * Creates a new instance of
     * <code>DigitalClock</code> that observes the given clock timer.
     */
    public DigitalClockNG(ClockTimer timer) {
        super(timer);
    }

    @Override
    protected void init() {
        DigitalClockPanelNG clockPanel = new DigitalClockPanelNG();
        this.clockPanel.setPreferredSize(new Dimension(550, 150));
        setTitle("Digital Clock NG");
    }
}