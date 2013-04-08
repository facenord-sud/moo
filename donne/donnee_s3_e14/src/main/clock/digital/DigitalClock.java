/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clock.digital;

import clock.abstractGui.AbstractClockFrame;
import clock.analog.AnalogClockPanel;
import clock.timer.ClockTimer;
import clock.util.PositionManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author leo
 */
public class DigitalClock extends AbstractClockFrame{
    
    public DigitalClock(ClockTimer clockTimer) {
        this.launch(clockTimer);
    }

    @Override
    protected void init() {
        setTitle("Digital Clock");
        // Create and set up the analog clock panel.
        this.clockPanel = new DigitalClockPanel();
        this.clockPanel.setPreferredSize(new Dimension(200, 100));
        
    }
}
