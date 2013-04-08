package clock.abstractGui;

import clock.observer.Observer;
import clock.timer.ClockTimer;
import clock.util.PositionManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * classe abstraite pour créer une horloge
 *
 * @author Numa de MOntmollin
 */
public abstract class AbstractClockFrame extends JFrame {

    protected ClockTimer clockTimer;
    protected Observer observer;
    protected AbstractClockPanel clockPanel;

    protected abstract void init();

    protected void launch(ClockTimer clockTimer) {
        this.clockTimer = clockTimer;
        this.observer = new Observer() {
            @Override
            public void update(int hour, int minute, int second) {
                clockPanel.setTime(hour, minute, second);
                repaint();
            }
        };
        this.clockTimer.addObserver(this.observer);
        addWindowListener(new DetachOnClosingWindowListener());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.init();

        // Add the panel to the window.
        getContentPane().add(this.clockPanel, BorderLayout.CENTER);

        // Set screen position.
        setLocation(PositionManager.getUniqueInstance().getClockWindowPosition());

        // Display the window.
        pack();
        setVisible(true);
    }

    public void setClockTimer(ClockTimer clockTimer) {
        this.clockTimer = clockTimer;
    }

    /**
     * A window listener that detaches the clock from the timer when the window
     * is being closed.
     */
    public class DetachOnClosingWindowListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            clockTimer.removeObserver(observer);
        }
    }
}
