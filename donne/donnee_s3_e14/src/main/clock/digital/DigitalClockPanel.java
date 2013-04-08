/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clock.digital;

import clock.abstractGui.AbstractClockPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author leo
 */
class DigitalClockPanel extends AbstractClockPanel {

    public DigitalClockPanel() {
        setFont(new Font("TimesRoman", Font.PLAIN, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        String hourStr = Integer.toString(this.hour);
        if (this.hour < 10) {
            hourStr = "0" + this.hour;
        }
        String minuteStr = Integer.toString(this.minute);
        if (this.minute < 10) {
            minuteStr = "0" + this.minute;
        }
        String secondStr = Integer.toString(this.second);
        if (this.second < 10) {
            secondStr = "0" + this.second;
        }
        g.drawString(hourStr + ":" + minuteStr + ":" + secondStr, 10, getHeight() / 2);

    }
}
