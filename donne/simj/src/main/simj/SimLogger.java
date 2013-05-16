/* SimJ - A framework for discrete event simulation.
 * @(#)SimLogger.java   08/05/09
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

import simj.util.logging.HTMLFormatter;
import simj.util.logging.SimJFormatter;

import java.io.File;
import java.io.IOException;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This singleton class implements a logging service.
 *
 * @author <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
 * @version 1.0
 */
public class SimLogger {

    private static ConsoleHandler console;
    private static FileHandler detailedLogFile;
    private static String detailedLogFileName = "detailed.html";
    private static SimLogger instance = new SimLogger();
    private static Logger logger;
    private static final String outputFolder = System.getProperty("logging.output.dir");//"output";
    private static FileHandler simpleLogFile;
    private static String simpleLogFileName = "short.html";
    private final String loggerName = "simj";

    /**
     * Private constructor in order to avoid direct instantiation of this
     * singleton class.
     */
    private SimLogger() {
        logger = Logger.getLogger(loggerName);
        logger.setUseParentHandlers(false);
        console = new ConsoleHandler();
        setConsoleHandler();
        logger.addHandler(console);
        logger.setLevel(Level.ALL);
        this.set(false);
    }

    private void closeFileHandlers() {
        logger.removeHandler(simpleLogFile);
        logger.removeHandler(detailedLogFile);

        if (simpleLogFile != null) {
            simpleLogFile.close();
        }

        if (detailedLogFile != null) {
            detailedLogFile.close();
        }
    }

    /**
     * Returns the unique logger managed by this class.
     *
     * @return The unique instance of the logger.
     */
    public static Logger getUniqueLogger() {
        return logger;
    }

    /**
     * Returns the unique instance of this singleton class.
     *
     * @return The unique instance of this singleton class.
     */
    public static SimLogger getUniqueInstance() {
        return instance;
    }

    /**
     * Enables or disables the detailed logging for the current simulation.
     * This method is invoked at the initialization of each simulation.
     *
     * @param pFineLogging A boolean indicating if detailed logging is enabled
     *                or no. If <code>false</code> there are just the global
     *                scan messages displayed to the console. If
     *                <code>true</code> the global scan messages are
     *                displayed to the console, logged to a simple log file,
     *                and detailed messages are logged to a detailed log file.
     */
    public void set(final boolean pFineLogging) {

        // First remove and close the "old" file handlers, if any.
        closeFileHandlers();

        if (pFineLogging) {
            setFileHandlers();
        }
    }

    private void setConsoleHandler() {
        console.setLevel(Level.INFO);
        console.setFormatter(new SimJFormatter());
    }

    private void setFileHandlers() {
        String nowID = new SimpleDateFormat("yyMMdd_HHmmss").format(
                Calendar.getInstance().getTime());

        try {
            Object[] filenameArgs = {outputFolder, File.separator, nowID,
                simpleLogFileName, detailedLogFileName};

            simpleLogFileName = new MessageFormat(
                    "{0}{1}{2}-{3}").format(filenameArgs);
            detailedLogFileName = new MessageFormat(
                    "{0}{1}{2}-{4}").format(filenameArgs);

            simpleLogFile = new FileHandler(simpleLogFileName);
            detailedLogFile = new FileHandler(detailedLogFileName);

            HTMLFormatter htmlFormatter = new HTMLFormatter(logger.getName());

            simpleLogFile.setFormatter(htmlFormatter);
            detailedLogFile.setFormatter(htmlFormatter);

            // send FINE and INFO messages to detailed logfile
            detailedLogFile.setLevel(Level.FINE);
            // send only INFO message to simple logfile
            simpleLogFile.setLevel(Level.INFO);
            logger.addHandler(simpleLogFile);
            logger.addHandler(detailedLogFile);
        } catch (SecurityException e) {
            logger.severe("SecurityException during creation of logger files.");
        } catch (IOException e) {
            logger.severe("IOException during creation of logger files.");
        }
    }
}

