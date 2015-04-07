/*
 * Copyright (c) 2015 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger.console;

/**
 * Exception intended to crash the application on errors logged.
 *
 * This exception is intended to be thrown by the logger when the application
 * is being debugged and is more "strict" about errors.
 * It represents the error that would have been sent to a logger, but instead
 * gets thrown in this exception, hopefully crashing the application so that
 * the problems are found before release.
 *
 * @author Maxwell Vandervelde (Max@MaxVandervelde.com)
 */
final public class ErrorException extends RuntimeException
{
    /**
     * @param message The error message that was logged.
     */
    public ErrorException(String message)
    {
        super(message);
    }

    /**
     * @param message The error message that was logged
     * @param cause A root-cause exception that was logged with the error.
     */
    public ErrorException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
