/*
 * Copyright (c) 2014 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger.console;

import org.apache.commons.logging.Log;

/**
 * Toggles the log functions based on whether the application is in Debug mode.
 *
 * @author Maxwell Vandervelde <Max@MaxVandervelde.com>
 */
public abstract class EnvironmentAwareLogger implements Log
{
    /** Whether low-level messages should be displayed. */
    final private boolean isDebug;

    /**
     * @param isDebug Changes whether low-level messages should be displayed.
     *                This should be false when the application is in production.
     */
    public EnvironmentAwareLogger(boolean isDebug)
    {
        this.isDebug = isDebug;
    }

    @Override
    final public boolean isDebugEnabled()
    {
        return this.isDebug;
    }

    @Override
    final public boolean isErrorEnabled()
    {
        return true;
    }

    @Override
    final public boolean isFatalEnabled()
    {
        return true;
    }

    @Override
    final public boolean isInfoEnabled()
    {
        return this.isDebug;
    }

    @Override
    final public boolean isTraceEnabled()
    {
        return this.isDebug;
    }

    @Override
    final public boolean isWarnEnabled()
    {
        return this.isDebug;
    }
}
