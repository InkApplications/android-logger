/*
 * Copyright (c) 2015 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger.analytics;

/**
 * An application screen that can be tracked with analytics.
 *
 * @author Maxwell Vandervelde (Max@MaxVandervelde.com)
 */
public class TrackedScreen
{
    /**
     * A readable name of the screen being tracked.
     */
    private String name;

    /**
     * @param name A readable name of the screen being tracked.
     */
    public TrackedScreen(String name)
    {
        this.name = name;
    }

    /**
     * @return A readable name of the screen being tracked.
     */
    final public String getName()
    {
        return name;
    }

    /**
     * @param name A readable name of the screen being tracked.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Screen{" +
            "name='" + name + '\'' +
            '}';
    }
}
