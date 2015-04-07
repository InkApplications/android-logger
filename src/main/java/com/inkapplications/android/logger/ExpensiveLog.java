/*
 * Copyright (c) 2015 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger;

import org.apache.commons.logging.Log;

/**
 * A Logger that is always enabled for all types.
 *
 * @author Maxwell Vandervelde (Max@MaxVandervelde.com)
 */
abstract public class ExpensiveLog implements Log
{
    @Override
    final public boolean isDebugEnabled() {
        return true;
    }

    @Override
    final public boolean isErrorEnabled() {
        return true;
    }

    @Override
    final public boolean isFatalEnabled() {
        return true;
    }

    @Override
    final public boolean isInfoEnabled() {
        return true;
    }

    @Override
    final public boolean isTraceEnabled() {
        return true;
    }

    @Override
    final public boolean isWarnEnabled() {
        return true;
    }
}
