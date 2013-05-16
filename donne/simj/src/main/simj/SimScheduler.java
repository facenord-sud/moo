/* SimJ - A framework for discrete event simulation.
 * @(#)SimScheduler.java   08/05/09
 *
 * Copyright (C) 2006 Software Engineering Group - University of Fribourg (CH)
 * URL:   http://diuf.unifr.ch/softeng
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation:
 * you may find a copy at the FSF website at 'www.fsf.org'.
 */

package simj;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * This class maintains the current time and has features for inserting new
 * events or for finding the next event in the event list or future event
 * chain (FETCH).
 *
 * @version 1.0
 * @author <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public final class SimScheduler {

    private static SimScheduler instance                                 =
        new SimScheduler();
    private static final long serialVersionUID                           =
        3834030242716397880L;
    private static TreeMap<Double, ArrayList<SimEvent>> futureEventChain =
        new TreeMap<Double, ArrayList<SimEvent>>();
    private double currentTime;

    /**
     * Private constructor in order to avoid direct instantiation of this
     * singleton class.
     */
    private SimScheduler() {}

    /**
     * Empties the scheduler completely.
     *
     */
    public void empty() {
        futureEventChain.clear();
    }

    /**
     * Insert a given event in the future event chain.
     *
     * @param pSimEvent The event to add to the future event chain.
     */
    public void insertEvent(final SimEvent pSimEvent) {
        Double key                 = Double.valueOf(pSimEvent.getFiringTime());
        ArrayList<SimEvent> events = futureEventChain.get(key);

        if (events == null) {
            events = new ArrayList<SimEvent>();
        }

        events.add(pSimEvent);
        futureEventChain.put(key, events);
    }

    /**
     * Returns the current time of the simulation.
     *
     * @return The current time of the simulation.
     */
    public double getCurrentTime() {
        return this.currentTime;
    }

    /**
     * Returns the unique instance of this Singleton class.
     *
     * @return The unique instance of this class.
     */
    public static SimScheduler getUniqueInstance() {
        return instance;
    }

    /**
     * Returns the next event that has to be executed.
     *
     * @return The next scheduled event.
     */
    public SimEvent getNextEvent() {
        Double key                        = futureEventChain.firstKey();
        ArrayList<SimEvent> theNextEvents = futureEventChain.remove(key);
        SimEvent theNextEvent             = theNextEvents.remove(0);

        if (!theNextEvents.isEmpty()) {
            futureEventChain.put(key, theNextEvents);
        }

        this.currentTime = theNextEvent.getFiringTime();

        return theNextEvent;
    }

    /**
     * Tells if the scheduler is empty or not.
     *
     * @return <code>true</code> if there are no more events in the scheduler;
     *         <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return futureEventChain.isEmpty();
    }
}

