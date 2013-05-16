/* SimJ - A framework for discrete event simulation.
 * @(#)SimEntityFactory.java   08/05/09
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
 * This singleton class implements an entity factory.
 *
 * @version 1.0
 * @author <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public class SimEntityFactory {

    private static SimEntityFactory instance = new SimEntityFactory();
    private int counter;

    /**
     * Protected constructor to avoid external instantiation of this singleton class.
     */
    protected SimEntityFactory() {}

    /**
     * Creates a new entity with an unique ID.
     * This is a template method.
     *
     * @return A new entity with an unique ID.
     */
    public SimEntity createSimEntity() {
        counter++;

        return doCreateSimEntity(counter);
    }

    /**
     * Resets the entity factory. To be specific, the next generated entity
     * will have ID = 1. This method must be invoked only before the beginning
     * of a simulation. Indeed, one must be sure that the ID of an entity is
     * unique in a simulation.
     */
    public void reset() {
        counter = 0;
    }

    /**
     * Creates a new entity with the given unique ID.
     * This is a factory method, and may be overridden by subclasses.
     * For instance to create more specific entities.
     *
     * @param pId The unique ID of the entity that will be created.
     *
     * @return The new entity.
     */
    protected SimEntity doCreateSimEntity(final int pId) {
        return new SimEntity(pId);
    }

    /**
     * Returns the unique instance of this singleton class.
     *
     * @return The unique instance of this singleton class.
     */
    public static SimEntityFactory getUniqueInstance() {
        return instance;
    }
}

