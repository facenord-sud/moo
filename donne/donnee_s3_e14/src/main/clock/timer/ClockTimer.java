package clock.timer;

import java.util.Calendar;
import java.util.GregorianCalendar;

import clock.observer.Observable;
import clock.observer.Observer;
import java.util.ArrayList;
import java.util.logging.*;

/**
 * <code>ClockTimer</code> is a subject for storing and maintaining the time of
 * day. It notifies its observers every second. The class provides an interface
 * for retrieving individual time units such as hour, minute and second.
 *
 * @author Andreas Ruppen
 */
public class ClockTimer implements Runnable, Observable {

    private long time;
    private ArrayList<Observer> observers = new ArrayList<>();
    private Calendar calendar;
    // delay in milliseconds
    private long delay = 1000;
    private Thread thread;
    private static Logger loggingService = Logger.getLogger("ClockTimer");
    

    /**
     * Creates a new instance of
     * <code>ClockTimer</code>.
     */
    public ClockTimer() {
        
        calendar = new GregorianCalendar();
    }

    /**
     * Returns the current hour.
     */
    private int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Returns the current minute.
     */
    private int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * Returns the current second.
     */
    private int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    /**
     * Notifies the observers every second.
     */
    @Override
    public void run() {
        while (thread != null) {
            try {
                time = System.currentTimeMillis();
                calendar.setTimeInMillis(time);
                // TODO Notify observers here, instead of setting the time direcly.
                // Program against the observer interface, instead of programming against the analog clock class!
                this.notifyObs();
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                loggingService.severe("Timer got interrupted");
            }
        }
    }

    /**
     * Starts the timer.
     */
    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        if (thread != null) {
            thread = null;
        }
    }
    
    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }
    
    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }
    
    @Override
    public void notifyObs() {
        for (Observer o : this.observers) {
            o.update(this.getHour(), this.getMinute(), this.getSecond());
        }
    }
}
