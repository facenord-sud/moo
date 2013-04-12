package clock.analog;

import clock.abstractGui.AbstractClockFrame;
import clock.observer.Observer;
import clock.timer.ClockTimer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import clock.util.PositionManager;

/**
 * An analog clock observing a clock timer.
 *
 * @author Andreas Ruppen
 */
public class AnalogClock extends AbstractClockFrame {

    private static final long serialVersionUID = 3258408447900069937L;

    /**
     *
     * @uml.property name="analogClockPanel"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    public AnalogClock(ClockTimer clockTimer) {
        super(clockTimer);
    }

    @Override
    public void init() {
// Create and set up the window.
        setTitle("Analog Clock");
        // Create and set up the analog clock panel.
        this.clockPanel = new AnalogClockPanel();
        this.clockPanel.setPreferredSize(new Dimension(200, 200));


    }
}