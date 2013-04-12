package clock;

import clock.abstractGui.AbstractClockFrame;
import clock.analog.AnalogClock;
import clock.digital.DigitalClock;
import clock.observer.Observer;
import clock.timer.ClockTimer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The <code>ClockApp</code> class represents the application's main window.
 * The mechanisme for adding new clok is not the best... Sorry
 * @author Andreas Ruppen
 */
public class ClockApp {
 
    private ArrayList<AbstractClockFrame> clocks = new ArrayList<>();
    private ClockTimer timer;
    
    /**
     * Creates a new instance of <code>ClockApp</code>.
     */
    public ClockApp() {
		this.timer = new ClockTimer();
		timer.start();
                new AnalogClock(timer);
                new DigitalClock(timer);
    }
    
    /**
     * The application's main method.
     */
    
}

