package com.inkapplications.android.logger;

import android.util.Log;

/**
 * Console Logger
 *
 * Simply adapts Android's static logger utility to a Apache logger interface
 * object
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class ConsoleLogger extends EnvironmentAwareLogger
{
    private String loggerTag;

    public ConsoleLogger(boolean isDebug, String loggerTag)
    {
        super(isDebug);

        this.loggerTag = loggerTag;
    }

    @Override
    public void trace(Object o)
    {
        if (false == this.isTraceEnabled()) {
            return;
        }

        Log.v(this.loggerTag, o.toString());
    }

    @Override
    public void trace(Object o, Throwable throwable)
    {
        if (false == this.isTraceEnabled()) {
            return;
        }

        Log.v(this.loggerTag, o.toString(), throwable);
    }

    @Override
    public void debug(Object o)
    {
        if (false == this.isDebugEnabled()) {
            return;
        }

        Log.d(this.loggerTag, o.toString());
    }

    @Override
    public void debug(Object o, Throwable throwable)
    {
        if (false == this.isDebugEnabled()) {
            return;
        }

        Log.d(this.loggerTag, o.toString(), throwable);
    }

    @Override
    public void info(Object o)
    {
        if (false == this.isInfoEnabled()) {
            return;
        }

        Log.v(this.loggerTag, o.toString());
    }

    @Override
    public void info(Object o, Throwable throwable)
    {
        if (false == this.isInfoEnabled()) {
            return;
        }

        Log.v(this.loggerTag, o.toString(), throwable);
    }

    @Override
    public void warn(Object o)
    {
        if (false == this.isWarnEnabled()) {
            return;
        }

        Log.w(this.loggerTag, o.toString());
    }

    @Override
    public void warn(Object o, Throwable throwable)
    {
        if (false == this.isWarnEnabled()) {
            return;
        }

        Log.w(this.loggerTag, o.toString());
    }

    @Override
    public void error(Object o)
    {
        if (false == this.isErrorEnabled()) {
            return;
        }

        Log.e(this.loggerTag, o.toString());
    }

    @Override
    public void error(Object o, Throwable throwable)
    {
        if (false == this.isErrorEnabled()) {
            return;
        }

        Log.e(this.loggerTag, o.toString(), throwable);
    }

    @Override
    public void fatal(Object o)
    {
        if (false == this.isFatalEnabled()) {
            return;
        }

        Log.wtf(this.loggerTag, o.toString());
    }

    @Override
    public void fatal(Object o, Throwable throwable)
    {
        if (false == this.isFatalEnabled()) {
            return;
        }

        Log.wtf(this.loggerTag, o.toString(), throwable);
    }
}
