/* SimJ - A framework for discrete event simulation.
 * @(#)SimEventResource.java   08/05/09
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
 * This class implements the generic concept of a discrete event associated with
 * the request or the relinquish of a resource by a temporary entity. The
 * execute feature depends on the specific event.
 *
 * @version 1.0
 * @author  <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public abstract class SimEventResource extends SimEvent {

    /** The resource associated with this event. */
    protected SimResource resource;

    /**
     * Constructs a SimEventResource object.
     *
     * @param pResource
     *            The resource associated with this event.
     * @param pFiringTime
     *            The firing or execution time of this event.
     */
    public SimEventResource(final SimResource pResource,
                            final double pFiringTime) {
        super(pFiringTime);
        this.resource = pResource;
    }
}

