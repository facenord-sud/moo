/* SimJ - A framework for discrete event simulation.
 * @(#)SimSimulation.java   08/05/09
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
import java.util.List;
import java.util.logging.Logger;

/**
 * This class manages the simulation event loop, and provides features for
 * initializing the simulation (that is, creating and providing the unique scheduler
 * and randomizer, creating and registering resources, setting the simulation
 * end time,...). The final event time and the creation of resources depend on
 * the given simulation. These tasks are thus deferred.
 *
 * @version 1.0
 * @author <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public abstract class SimSimulation {

    /**
     * Like in singleton classes, this is the instance of this class.
     * Since this class is abstract, this field has protected visibility,
     * to allow implementing subclaccess to access it.
     */
    protected static SimSimulation instance;
    private SimScheduler uniqueScheduler = SimScheduler.getUniqueInstance();
    private SimLogger simjLogger = SimLogger.getUniqueInstance();
    private Logger uniqueLogger = SimLogger.getUniqueLogger();
    private double finalEventTime;
    private List<SimResource> resources;
    private double scanInterval;

    /**
     * Protected (to avoid external instantiation) constructor of the general
     * simulation class.
     *
     * @param pFinalEventTime The
     * @param pScanInterval The interval between two "scan events"
     * (<code>SimEventScanResources</code>).
     * @param pFineLogging A boolean determining if detailed logging is enabled
     * (<code>true</code>) for this simulation or not (<code>false</code>).
     */
    protected SimSimulation(final double pFinalEventTime,
            final int pScanInterval,
            final boolean pFineLogging) {
        this.resources = new ArrayList<SimResource>();
        this.finalEventTime = pFinalEventTime;
        this.scanInterval = pScanInterval;
        simjLogger.set(pFineLogging);
    }

    /**
     * Initializes and starts the simulation.
     * This is a template method and calls several primitive and hook operations.
     */
    public final void startSimulation() {
        createResources();
        createEvents();
        setupSimulation();
        SimEntityFactory.getUniqueInstance().reset();
        new SimEventScanResources(this.scanInterval);
        this.eventLoopManager();
    }

    /**
     * Adds a resource to this simulation.
     *
     * @param pRes The resource to add to this simulation.
     */
    void registerResource(final SimResource pRes) {
        resources.add(pRes);
    }

    /**
     * Creates the bootstrapping events of the simulation.
     * This is a primitive operation and has to be implemented by subclasses.
     */
    protected abstract void createEvents();

    /**
     * Creates the several resources of the simulation.
     * This is a primitive operation and has to be implemented by subclasses.
     */
    protected abstract void createResources();

    /**
     * Does some additional simulation initialization configuration.
     * This is a hook operation and may be overridden by subclasses.
     * By default it does nothing.
     */
    protected void setupSimulation() {
    }

    private void eventLoopManager() {
        SimEvent currentEvent;

        for (currentEvent = uniqueScheduler.getNextEvent();
                !isSimulationFinished();
                currentEvent = uniqueScheduler.getNextEvent()) {
            currentEvent.execute();
        }

        // The end of simulation time is either the firing time of the
        // first not executed event (if the simulation time elapsed)
        // or the firing time of the last executed event (if the
        // scheduler has been emptied)
        uniqueLogger.info("End of simulation at time " + SimScheduler.getUniqueInstance().getCurrentTime() + ".");

        // just in case there are still event in the future event chain
        // or scheduler.
        uniqueScheduler.empty();
    }

    /**
     * Returns the unique instance of this singleton class.
     *
     * @return The unique instance of this singleton class.
     */
    public static SimSimulation getInstance() {
        return instance;
    }

    /**
     * Returns the number of resources of the simulation.
     *
     * @return The number of resources of the simulation.
     */
    public int getNumberOfResources() {
        return resources.size();
    }

    /**
     * Returns the resource at the specified index.
     *
     * @param index An index into the resources of this simulation
     * (between <code>1</code> and <code>getNumberOfResources</code>).
     *
     * @return The resource at the specified index.
     */
    public SimResource getResource(final int index) {
        return resources.get(index - 1);
    }

    private boolean isSimulationFinished() {
        return (uniqueScheduler.isEmpty() || (uniqueScheduler.getCurrentTime() > this.finalEventTime));
    }
}

