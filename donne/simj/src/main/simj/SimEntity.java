/* SimJ - A framework for discrete event simulation.
 * @(#)SimEntity.java   08/05/09
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
 * This class allows for the creation of the simpliest possible temporary
 * entity, its single feature being its ID. Subclasses must be used in order to
 * work with entities containing more features.
 *
 * @version 1.0
 * @author  <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public class SimEntity {

    /** The unique ID of this entity. */
    private final int id;

    /**
     * Constructs a SimEntity object.
     *
     * @param pId
     *            An int specifying the unique ID of this entity.
     */
    public SimEntity(final int pId) {
        this.id = pId;
    }

    /**
     * Returns the unique ID value.
     *
     * @return An int representing the unique ID of this entity.
     */
    public final int getId() {
        return this.id;
    }
}

