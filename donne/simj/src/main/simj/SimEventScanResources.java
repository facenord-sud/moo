/* SimJ - A framework for discrete event simulation.
 * @(#)SimEventScanResources.java   08/05/09
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
 * This class implements an event, which schedules itself every
 * <code>interval</code> and prints the status (# being served
 * and # waiting) for each resource.
 *
 * @version 1.0
 * @author  <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public final class SimEventScanResources extends SimEvent {

    /** The time between two resources scanning events. */
    private final double interval;

    /**
     * Constructs a SimEventScanResources object.
     *
     * @param pInterval
     *            The time between two recource scanning events.
     */
    public SimEventScanResources(final double pInterval) {
        // This event will be scheduled for the first time at pInterval.
        super(pInterval);
        this.interval = pInterval;
    }

    /**
     * Logs the status of all the resources of the simulation and
     * reschedules itself.
     *
     */
    public final void execute() {
        this.displayInfo();
        // This event reschudeles itself...
        this.schedule(getCurrentTime() + this.interval);
    }

    /**
     * Sends the status of each resource to the logger. Information consists of
     * the number of entities being served and the number of entities waiting
     * to be served.
     */
    private void displayInfo() {
        SimSimulation uniqueSimulation = SimSimulation.getInstance();
        final int numberOfRes = uniqueSimulation.getNumberOfResources();
        StringBuffer message  = new StringBuffer(256);

        message.append(
            "\n=============================================\nAt time ");
        message.append(getCurrentTime());
        for (int i = 1; i <= numberOfRes; i++) {
            SimResource currentR = uniqueSimulation.getResource(i);

            message.append("\nin resource ");
            message.append(currentR.getResourceName());
            message.append(", there are:\n");
            message.append(currentR.numberOfEntitiesBeingServed());
            message.append(" entities being served and ");
            message.append(currentR.numberOfEntitiesWaitingToBeServed());
            message.append(" waiting.\n");
        }
        message.append("=============================================\n");
        SimLogger.getUniqueLogger().info(message.toString());
    }
}

