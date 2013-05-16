/* SimJ - A framework for discrete event simulation.
 * @(#)SimEventStartService.java   08/05/09
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
 * This class implements the discrete event, which consists of starting serving an
 * entity at a given resource.
 *
 * @version 1.0
 * @author  <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public final class SimEventStartService extends SimEventResource {

    /**
     * Constructs a SimEventStartService object.
     *
     * @param pResource
     *            The resource associated with this start of service event.
     * @param pFiringTime
     *            The firing or execution time of this event.
     */
    SimEventStartService(final SimResource pResource,
                         final double pFiringTime) {
        super(pResource, pFiringTime);
    }

    /**
     * Gets the next entity waiting to be served, tells the associated
     * resource to serve it and creates the corresponding
     * <code>SimEventEndService</code>.
     */
    public void execute() {
        SimEntity nextEntityToServe = resource.getNextEntityToServe();
        resource.startServing(nextEntityToServe);
        double endServiceTime = resource.getEndServiceTime(nextEntityToServe);
        new SimEventEndService(resource, nextEntityToServe, endServiceTime);
    }
}

