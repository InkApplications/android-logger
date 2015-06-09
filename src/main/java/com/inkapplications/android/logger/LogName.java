/*
 * Copyright (c) 2015 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a loggable string name for a class to be used if that object is
 * logged as an individual log statement.
 *
 * @author Maxwell Vandervelde (Max@MaxVandervelde.com)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LogName
{
    /**
     * The name of the class to be used in a logger.
     */
    String value();
}
