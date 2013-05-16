/* SimJ - A framework for discrete event simulation.
 * @(#)SimEvent.java   08/05/09
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

/**
 * This class implements the generic concept of a discrete event. The management
 * of the event firing is implemented, but the abstract execute feature must be
 * implemented.
 *
 * @version 1.0
 * @author <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public abstract class SimEvent {

    private double firingTime;
    
    private SimScheduler uniqueScheduler = SimScheduler.getUniqueInstance();

    /**
     * Constructs a SimEvent object.
     *
     * @param pFiringTime
     *                The firing or execution time of this event.
     */
    public SimEvent(final double pFiringTime) {
        this.schedule(pFiringTime);
    }

    /**
     * Does the actual work of this event.
     * This is a primitive operation and each concrete event has to
     * implement it appropriately.
     *
     */
    public abstract void execute();

    /**
     * Schedules this event at a given time. This visibility of this
     * method is protected to allow subclasses to reschedule themselves
     * if needed.
     *
     * @param pFiringTime
     *                The firing or execution time of this event.
     */
    protected final void schedule(final double pFiringTime) {
        firingTime = pFiringTime;
        this.uniqueScheduler.insertEvent(this);
    }

    /**
     * Returns the firing or execution time of this event.
     *
     * @return The firing or execution time of this event.
     */
    public double getFiringTime() {
        return firingTime;
    }

    /**
     * Returns the current time of the simulation.
     * This commoditiy method is useful for subclasses.
     *
     * @return The current time of the simulation.
     */
    protected final double getCurrentTime() {
        return this.uniqueScheduler.getCurrentTime();
    }
}

