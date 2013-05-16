/* SimJ - A framework for discrete event simulation.
 * @(#)SimEventEndService.java   08/05/09
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
 * This class implements the discrete event, which consists of ending serving an
 * entity at a given resource.
 *
 * @version 1.0
 * @author <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public final class SimEventEndService extends SimEventResource {

    /** The entity associated with this end service event. */
    private SimEntity entity;

    /**
     * Constructs a SimEventEndService object.
     *
     * @param pResource
     *                The resource associated with this end service event.
     * @param pEntity
     *                The entity associated with this end service event.
     * @param pFiringTime
     *                The firing or execution time of this event.
     */
    SimEventEndService(final SimResource pResource, final SimEntity pEntity,
                       final double pFiringTime) {
        super(pResource, pFiringTime);
        this.entity = pEntity;
    }

    /**
     * Terminates the service of the associated entity by the associated
     * resource. If there are other entities waiting, it creates the
     * corresponding <code>SimEventStartService</code>.
     */
    public void execute() {
        resource.endServing(entity);

        // Take the next entity which is waiting (if any) and create a
        // corresponding start service event.
        if (resource.hasEntitiesWaitingToBeServed()) {
            new SimEventStartService(resource, getCurrentTime());
        }
    }
}

