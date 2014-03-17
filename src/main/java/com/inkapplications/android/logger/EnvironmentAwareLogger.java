package com.inkapplications.android.logger;

import org.apache.commons.logging.Log;

/**
 * EnvironmentAwareLogger
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public abstract class EnvironmentAwareLogger implements Log
{
    private boolean isDebug;

    public EnvironmentAwareLogger(boolean isDebug)
    {
        this.isDebug = isDebug;
    }

    @Override
    public boolean isDebugEnabled()
    {
        return this.isDebug;
    }

    @Override
    public boolean isErrorEnabled()
    {
        return true;
    }

    @Override
    public boolean isFatalEnabled()
    {
        return true;
    }

    @Override
    public boolean isInfoEnabled()
    {
        return this.isDebug;
    }

    @Override
    public boolean isTraceEnabled()
    {
        return this.isDebug;
    }

    @Override
    public boolean isWarnEnabled()
    {
        return this.isDebug;
    }
}
