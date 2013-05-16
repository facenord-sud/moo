/* SimJ - A framework for discrete event simulation.
 * @(#)SimResource.java   08/05/09
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
 * This class implements the generic concept of a resource. The
 * resource is initialized with a name and a number of service
 * channels (capacity). It offers features for managing the arrival,
 * the service, the departure and further management of temporary entities.
 * The concrete service time must be reimplemented.
 *
 * @version 1.0
 * @author  <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public abstract class SimResource {

    private int capacity;
    private String resourceName;
    private List<SimEntity> inServiceList;
    private List<SimEntity> waitingQueue;
    
    private SimScheduler uniqueScheduler = SimScheduler.getUniqueInstance();
    private Logger uniqueLogger = SimLogger.getUniqueLogger();
    protected SimRandom uniqueRandomizer = SimRandom.getUniqueInstance();
    

    /**
     * Constructs a resource.
     *
     * @param pCapacity The capacity of this resource, that is the maximum
     * number of entities that can be served simultaneously by this resource.
     * @param pResourceName The name of this resource.
     */
    public SimResource(final int pCapacity, final String pResourceName) {
        this.capacity      = pCapacity;
        this.resourceName  = pResourceName;
        this.waitingQueue  = new ArrayList<SimEntity>();
        this.inServiceList = new ArrayList<SimEntity>();
        SimSimulation.getInstance().registerResource(this);
    }

    /**
     * Returns the number of entities being served by this resource.
     *
     * @return The number of entities being served by this resource.
     */
    public int numberOfEntitiesBeingServed() {
        return inServiceList.size();
    }

    /**
     * Returns the number of entities waiting to be served by this resource.
     *
     * @return The number of entities waiting to be served by this resource.
     */
    public int numberOfEntitiesWaitingToBeServed() {
        return waitingQueue.size();
    }

    /**
     * Starts "managing" the entity, for which the resource is requested.
     *
     * @param pEntity The entity requesting this resource.
     */
    public void request(final SimEntity pEntity) {
        displayInfoRequest(pEntity);
        startWaiting(pEntity);

        if (isAvailable()) {
            new SimEventStartService(this, getCurrentTime());
        }
    }

    /**
     * Ends the service of an entity.
     *
     * @param pEntity The entity that is being served by this resource.
     */
    void endServing(final SimEntity pEntity) {
        displayInfoEndService(pEntity);
        inServiceList.remove(pEntity);
        afterEndService(pEntity);
    }

    /**
     * Start serving an entity.
     *
     * @param pEntity The entity this resource is starting to serve.
     */
    void startServing(final SimEntity pEntity) {
        displayInfoStartService(pEntity);
        waitingQueue.remove(pEntity);
        inServiceList.add(pEntity);
    }

    /**
     * Do whatever is appropriate after the end of the service of an entity.
     * By default it does nothing but this is a hook operation and may be
     * overriden by subclasses (for example, "send" the entity to another
     * resource).
     *
     * @param pEntity The entity that has been served by this resource.
     */
    protected void afterEndService(final SimEntity pEntity) {}

    /**
     * Logs default information about the end of service of an entity by this
     * resource.
     * This is a hook operation and may be overridden by subclasses.
     *
     * @param pEntity The entity that has been served by this resource.
     */
    protected void displayInfoEndService(final SimEntity pEntity) {
        StringBuffer message = new StringBuffer(64);

        message.append("The temp entity ");
        message.append(pEntity.getId());
        message.append(" is relinquished by the ");
        message.append(this.getResourceName());
        message.append(" at time ");
        message.append(getCurrentTime());
        uniqueLogger.fine(message.toString());
    }

    /**
     * Logs default information about an entity requesting this resource.
     * This is a hook operation and may be overridden by subclasses.
     *
     * @param pEntity The entity that is requesting this resource.
     */
    protected void displayInfoRequest(final SimEntity pEntity) {
        StringBuffer message = new StringBuffer(64);

        message.append("The temp entity ");
        message.append(pEntity.getId());
        message.append(" requests the ");
        message.append(this.getResourceName());
        message.append(" at time ");
        message.append(getCurrentTime());
        uniqueLogger.fine(message.toString());
    }

    /**
     * Logs default information about the start of service of an entity by
     * this resource.
     * This is a hook operation and may be overridden by subclasses.
     *
     * @param pEntity The entity beginning to be served by this resource.
     */
    protected void displayInfoStartService(final SimEntity pEntity) {
        StringBuffer message = new StringBuffer(64);

        message.append("The temp entity ");
        message.append(pEntity.getId());
        message.append(" starts being served by the ");
        message.append(this.getResourceName());
        message.append(" at time ");
        message.append(getCurrentTime());
        uniqueLogger.fine(message.toString());
    }

    /**
     * Logs default information each time an entity starts waiting in
     * front of this resource.
     * This is a hook operation and may be overridden by subclasses.
     *
     * @param pEntity The entity that starts waiting to be served by
     * this resource.
     */
    protected void displayInfoStartWaiting(final SimEntity pEntity) {
        StringBuffer message = new StringBuffer(64);

        message.append("The temp entity ");
        message.append(pEntity.getId());
        message.append(" starts waiting at time ");
        message.append(getCurrentTime());
        uniqueLogger.fine(message.toString());
    }

    private void startWaiting(final SimEntity pEntity) {
        displayInfoStartWaiting(pEntity);
        waitingQueue.add(pEntity);
    }

    /**
     * Returns the next entity to serve.
     *
     * @return The next entity to serve.
     */
    public SimEntity getNextEntityToServe() {
        return waitingQueue.get(0);
    }

    /**
     * Returns how much time is needed to serve the entity.
     * This is a primitive operation, and each concrete resource has to
     * implement it appropriately.
     *
     * @param pEntity The entity this resource will serve.
     *
     * @return The duration the entity will spend in this resource.
     */
    protected abstract double getServiceTime(SimEntity pEntity);

    /**
     * Returns the time at which this resource will relinquish the entity.
     *
     * @param pEntity The entity this resource will serve.
     *
     * @return The time at which the entity will have been finished serving.
     */
    public double getEndServiceTime(SimEntity pEntity) {
        return getCurrentTime() + getServiceTime(pEntity);
    }

    /**
     * Returns the current time of the simulation.
     * This commoditiy method is useful for subclasses.
     *
     * @return The current time of the simulation.
     */
    protected final double getCurrentTime() {
        return uniqueScheduler.getCurrentTime();
    }

    /**
     * Returns the name of this resource.
     *
     * @return The name of this resource.
     */
    protected String getResourceName() {
        return resourceName;
    }

    /**
     * Tells if there are entities waiting to be served by this resource or not.
     *
     * @return <code>true</code> if there are entities waiting to be served;
     *         <code>false</code> otherwise.
     */
     boolean hasEntitiesWaitingToBeServed() {
        return !waitingQueue.isEmpty();
    }

    /**
     * Tells if this resource is available or not.
     *
     * @return <code>true</code> if the resource is available;
     *         <code>false</code> otherwise.
     */
    private boolean isAvailable() {
        return numberOfEntitiesWaitingToBeServed()
               <= capacity - numberOfEntitiesBeingServed();
    }
}

