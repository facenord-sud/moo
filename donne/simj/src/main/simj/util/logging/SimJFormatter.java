/* SimJ - A framework for discrete event simulation.
 * @(#)SimJFormatter.java   08/05/09
 *
 * Copyright (C) 2006 Software Engineering Group - University of Fribourg (CH)
 * URL:   http://diuf.unifr.ch/softeng
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation:
 * you may find a copy at the FSF website at 'www.fsf.org'.
 */

package simj.util.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
* This class implements a simple text formatter for log records.
* The output is usually sent to the console.
*
* @version 1.0
* @author <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
*/
public class SimJFormatter extends Formatter {

    /**
     * Formats a given log record in a very simple way.
     *
     * @param record The log record to format.
     *
     * @return A simple string representing the formatted log record.
     */
    public String format(final LogRecord record) {
        return record.getMessage() + '\n';
    }
}

