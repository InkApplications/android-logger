/*
 * Copyright (c) 2014-2015 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger.console;

import android.content.res.Resources;
import android.util.Log;
import prism.framework.DisplayName;

/**
 * Logs to Android's static Logcat logger.
 *
 * Simply adapts Android's static logger utility to a Apache logger interface
 * object.
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class ConsoleLogger extends EnvironmentAwareLogger
{
    /** Android resources service for looking up message strings. */
    final private Resources resources;

    /** The tag used on the Android logger on all messages. */
    final private String loggerTag;

    /** Whether the application should crash on error/fatal reports. */
    final private boolean sensitive;

    /**
     * @param resources Android resources service for looking up message strings.
     * @param isDebug Changes whether low-level messages should be displayed.
     *                This should be false when the application is in production.
     * @param isSensitive Whether the application should crash on error/fatal
     *                    reports. This MUST be false when the application is
     *                    in production
     * @param loggerTag The tag used on the Android logger on all messages.
     */
    public ConsoleLogger(
        Resources resources,
        boolean isDebug,
        boolean isSensitive,
        String loggerTag
    ) {
        super(isDebug);

        this.resources = resources;
        this.loggerTag = loggerTag;
        this.sensitive = isSensitive;
    }

    @Override
    public void trace(Object o)
    {
        if (false == this.isTraceEnabled()) {
            return;
        }

        String message = this.getDisplayedMessage(o);
        Log.v(this.loggerTag, message);
    }

    @Override
    public void trace(Object o, Throwable throwable)
    {
        if (false == this.isTraceEnabled()) {
            return;
        }

        String message = this.getDisplayedMessage(o);
        Log.v(this.loggerTag, message, throwable);
    }

    @Override
    public void debug(Object o)
    {
        if (false == this.isDebugEnabled()) {
            return;
        }

        String message = this.getDisplayedMessage(o);
        Log.d(this.loggerTag, message);
    }

    @Override
    public void debug(Object o, Throwable throwable)
    {
        if (false == this.isDebugEnabled()) {
            return;
        }

        String message = this.getDisplayedMessage(o);
        Log.d(this.loggerTag, message, throwable);
    }

    @Override
    public void info(Object o)
    {
        if (false == this.isInfoEnabled()) {
            return;
        }

        String message = this.getDisplayedMessage(o);
        Log.v(this.loggerTag, message);
    }

    @Override
    public void info(Object o, Throwable throwable)
    {
        if (false == this.isInfoEnabled()) {
            return;
        }

        String message = this.getDisplayedMessage(o);
        Log.v(this.loggerTag, message, throwable);
    }

    @Override
    public void warn(Object o)
    {
        if (false == this.isWarnEnabled()) {
            return;
        }

        String message = this.getDisplayedMessage(o);
        Log.w(this.loggerTag, message);
    }

    @Override
    public void warn(Object o, Throwable throwable)
    {
        if (false == this.isWarnEnabled()) {
            return;
        }

        String message = this.getDisplayedMessage(o);
        Log.w(this.loggerTag, message);
    }

    @Override
    public void error(Object o)
    {
        String message = this.getDisplayedMessage(o);
        if (this.sensitive) {
            throw new ErrorException(message);
        }

        Log.e(this.loggerTag, message);
    }

    @Override
    public void error(Object o, Throwable throwable)
    {
        String message = this.getDisplayedMessage(o);
        if (this.sensitive) {
            throw new ErrorException(message, throwable);
        }

        Log.e(this.loggerTag, message, throwable);
    }

    @Override
    public void fatal(Object o)
    {
        String message = this.getDisplayedMessage(o);
        if (this.sensitive) {
            throw new ErrorException(message);
        }

        Log.e(this.loggerTag, message);
    }

    @Override
    public void fatal(Object o, Throwable throwable)
    {
        String message = this.getDisplayedMessage(o);
        if (this.sensitive) {
            throw new ErrorException(message, throwable);
        }

        Log.e(this.loggerTag, message, throwable);
    }

    /**
     * Get the loggable message from a logged object
     */
    private String getDisplayedMessage(Object logged)
    {
        if (null == logged) {
            return "null";
        }

        if (logged.getClass().isAnnotationPresent(DisplayName.class)) {
            int resource = logged.getClass().getAnnotation(DisplayName.class).value();
            return this.resources.getString(resource);
        }

        return logged.toString();
    }
}
