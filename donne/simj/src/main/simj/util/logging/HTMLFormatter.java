/* SimJ - A framework for discrete event simulation.
 * @(#)HTMLFormatter.java   08/05/09
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

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.apache.commons.lang.StringEscapeUtils;

/**
* This class implements an HTMLFormatter for log records.
* The output is usually written to a file.
*
* @version 1.0
* @author <a href="mailto:patrik.fuhrer@unifr.ch">Patrik Fuhrer</a>
*/
public class HTMLFormatter extends Formatter {

    private String loggerName;

    /**
     * Constructs an instance of an HTML formatter.
     *
     * @param name The name this formatter uses to display a title.
     */
    public HTMLFormatter(final String name) {
        super();
        loggerName = name;
    }

    /**
     * Formats a given log record in an HTML way.
     *
     * @param record The log record to format.
     *
     * @return An HTML string representing the formatted log record.
     */
    public String format(final LogRecord record) {
        StringBuffer buf = new StringBuffer(2048);

        buf.append(getLogEntry(record));

        return buf.toString();
    }

    /**
     * Returns the header string for the HTML file containing the formatted
     * records of this logger.
     * This method is called just after the handler using this formatter is
     * created.
     * This method overrides the empty
     * <code>java.util.logging.Formatter.getHead</code> method.
     *
     * @param handler The target handler.
     *
     * @return The header string for the HTML file containing the formatted
     * records of this logger.
     */
    public String getHead(final Handler handler) {
        String beginTime       = getTime();
        String cssDeclarations =
            "<style type=\"text/css\">\n" + "BODY {\n"
            + "FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;\n}\n"
            + "TABLE {\n    FONT-SIZE: 75%;\n}\n</style>";
        String htmlHead = "<HEAD>\n<TITLE>SimJ Log: " + loggerName
                          + "</TITLE>\n" + cssDeclarations + "\n</HEAD>";
        String htmlTitle = "<H2>" + loggerName + "<BR>\nLog started: "
                           + beginTime + "</H2>";

        return "<HTML>\n" + htmlHead + "\n<BODY>\n" + htmlTitle
               + "\n<table width=\"100%\" border=\"0\">\n";
    }

    /**
     * Returns the tail string for the HTML file containing the formatted
     * records of this logger.
     * This method is called just after the handler using this formatter is
     * closed.
     * This method overrides the empty
     * <code>java.util.logging.Formatter.getTail</code> method.
     *
     * @param handler The target handler.
     *
     * @return The tail string for the HTML file containing the formatted
     * records of this logger.
     */
    public String getTail(final Handler handler) {
        String endTime = getTime();
        String endLog  = "<H2>Log finished: " + endTime + "</H2>";

        return "</TABLE>\n" + endLog + "\n</BODY>\n</HTML>\n";
    }

    private String getLogEntry(final LogRecord record) {
        StringBuffer buf = new StringBuffer(2048);

        buf.append("<TR>\n");
        buf.append("<TD><DIV ALIGN=\"right\">");
        buf.append(record.getSequenceNumber());
        buf.append("</DIV></TD>");
        buf.append("<TD>");

        // Bold any levels >= INFO, for instance severe error messages.
        if (record.getLevel().intValue() >= Level.INFO.intValue()) {
            buf.append("<b>");

            if (record.getLevel().intValue() >= Level.WARNING.intValue()) {
                buf.append("<i>");
                buf.append(record.getLevel());
                buf.append("</i>");
            } else {
                buf.append(record.getLevel());
            }

            buf.append("</b>");
        } else {
            buf.append(record.getLevel());
        }

        buf.append("</TD>");
        buf.append("<TD>");
        buf.append(record.getMillis());
        buf.append("</TD>");
        buf.append("<TD>");
        buf.append(record.getSourceClassName());
        buf.append("</TD>");
        buf.append("<TD>");
        buf.append(record.getSourceMethodName());
        buf.append("</TD>");
        buf.append("<TD>");
        buf.append("\n</TR>\n");
        buf.append("<TR>\n");
        buf.append("<TD>");
        buf.append("</TD>");
        buf.append("<TD COLSPAN=\"4\">");
        buf.append("<EM>");
        buf.append(cleanUpHTML(formatMessage(record)));
        buf.append("</EM>");
        buf.append("</TD>");
        buf.append("\n</TR>\n");
        buf.append("<TR>");
        buf.append("<TD COLSPAN=\"5\"><HR SIZE=\"1\" NOSHADE></TD>");
        buf.append("</TR>\n\n");

        return buf.toString();
    }

    private String cleanUpHTML(String message) {
        return StringEscapeUtils.escapeHtml(message).replaceAll("\n", "<BR>\n");
    }

    private String getTime() {
        Date now = Calendar.getInstance().getTime();

        return new SimpleDateFormat("dd/MM/yyyy").format(now) + " at "
               + new SimpleDateFormat("HH:MM:ss").format(now);
    }
}

