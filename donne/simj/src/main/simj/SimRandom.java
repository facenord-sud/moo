/* SimJ - A framework for discrete event simulation.
 * @(#)SimRandom.java   08/05/09
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
 * This singleton class has features for producing random numbers. There is
 * one feature for each defined statistical law.
 *
 * @version 1.0
 * @author <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 */
public final class SimRandom extends java.util.Random {

    private static final long serialVersionUID = 3761691199454458674L;
    private static SimRandom instance          = new SimRandom();

    /**
     * Private constructor to prevent external instantiation of this singleton.
     *
     */
    private SimRandom() {}

    /**
     * Returns a double random number following an exponential law of mean <code>mu</code>.
     *
     * @param mu The mean of the exponential random variable.
     *
     * @return A random number following an exponential law of mean <code>mu</code>
     */
    public double expo(final double mu) {
        return -mu * java.lang.Math.log(nextDouble());
    }

    /**
     * Returns a double random number following a uniform law between
     * <code>minValue</code> and <code>maxValue</code>.
     *
     * @param minValue The minimal possible value of the uniform random variable.
     * @param maxValue The maximal possible value of the uniform random variable.
     *
     * @return A double random number following a uniform law between
     * <code>minValue</code> and <code>maxValue</code>.
     */
    public double uniform(final double minValue, final double maxValue) {
        return minValue + (maxValue - minValue) * nextDouble();
    }

    /**
     * Returns the unique instance of this Singleton class.
     *
     * @return The unique instance of this class.
     */
    public static SimRandom getUniqueInstance() {
        return instance;
    }

    // TODO add other probabilistic laws:
    // cash desk (truncated) normal law with parameters mu and sigma, triangular, ...
    // autres: Erlang, Weibull, Gamma
}

