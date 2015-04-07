/*
 * Copyright (c) 2015 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger;

import org.apache.commons.logging.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Container class for multiple loggers.
 *
 * This class is a logger that proxies all log messages to multiple loggers
 * bound to the class.
 * This service acts as a container, so loggers may be added/removed at will.
 *
 * Not that this log is Expensive, meaning that all the log types are enabled
 * all of the time.
 *
 * @author Maxwell Vandervelde (Max@MaxVandervelde.com)
 */
final public class CompositeLogger extends ExpensiveLog
{
    /** Loggers to forward log messages to. */
    final private List<Log> loggers = new ArrayList<>();

    /**
     * @param logger A logger to register for receiving messages sent to this.
     */
    public void addLogger(Log logger)
    {
        this.loggers.add(logger);
    }

    /**
     * Remove all loggers currently being proxied to.
     */
    public void clearLoggers()
    {
        this.loggers.clear();
    }

    @Override
    public void trace(Object o)
    {
        for (Log log : this.loggers) {
            log.trace(o);
        }
    }

    @Override
    public void trace(Object o, Throwable throwable)
    {
        for (Log log : this.loggers) {
            log.trace(o, throwable);
        }
    }

    @Override
    public void debug(Object o)
    {
        for (Log log : this.loggers) {
            log.debug(o);
        }
    }

    @Override
    public void debug(Object o, Throwable throwable)
    {
        for (Log log : this.loggers) {
            log.debug(o, throwable);
        }
    }

    @Override
    public void info(Object o)
    {
        for (Log log : this.loggers) {
            log.info(o);
        }
    }

    @Override
    public void info(Object o, Throwable throwable)
    {
        for (Log log : this.loggers) {
            log.info(o, throwable);
        }
    }

    @Override
    public void warn(Object o)
    {
        for (Log log : this.loggers) {
            log.warn(o);
        }
    }

    @Override
    public void warn(Object o, Throwable throwable)
    {
        for (Log log : this.loggers) {
            log.warn(o, throwable);
        }
    }

    @Override
    public void error(Object o)
    {
        for (Log log : this.loggers) {
            log.error(o);
        }
    }

    @Override
    public void error(Object o, Throwable throwable)
    {
        for (Log log : this.loggers) {
            log.error(o, throwable);
        }
    }

    @Override
    public void fatal(Object o)
    {
        for (Log log : this.loggers) {
            log.fatal(o);
        }
    }

    @Override
    public void fatal(Object o, Throwable throwable)
    {
        for (Log log : this.loggers) {
            log.fatal(o, throwable);
        }
    }
}
