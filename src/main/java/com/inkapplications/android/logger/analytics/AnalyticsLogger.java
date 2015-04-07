/*
 * Copyright (c) 2015 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger.analytics;

import android.content.res.Resources;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import org.apache.commons.logging.Log;
import prism.framework.DisplayName;

final public class AnalyticsLogger implements Log
{
    final private Tracker analyticsTracker;
    final private Resources resources;

    public AnalyticsLogger(Tracker analyticsTracker, Resources resources)
    {
        this.analyticsTracker = analyticsTracker;
        this.resources = resources;
    }

    @Override
    public boolean isDebugEnabled()
    {
        return false;
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
        return false;
    }

    @Override
    public boolean isTraceEnabled()
    {
        return true;
    }

    @Override
    public boolean isWarnEnabled()
    {
        return false;
    }

    @Override
    public void error(Object o) {
        HitBuilders.ExceptionBuilder builder = new HitBuilders.ExceptionBuilder();
        builder.setDescription(o.toString());
        builder.setFatal(false);

        this.analyticsTracker.send(builder.build());
    }

    @Override
    public void error(Object o, Throwable throwable)
    {
        HitBuilders.ExceptionBuilder builder = new HitBuilders.ExceptionBuilder();
        builder.setDescription(o.toString() + ":" + throwable.getMessage());
        builder.setFatal(false);

        this.analyticsTracker.send(builder.build());
    }

    @Override
    public void fatal(Object o)
    {
        HitBuilders.ExceptionBuilder builder = new HitBuilders.ExceptionBuilder();
        builder.setDescription(o.toString());
        builder.setFatal(true);

        this.analyticsTracker.send(builder.build());
    }

    @Override
    public void fatal(Object o, Throwable throwable)
    {
        HitBuilders.ExceptionBuilder builder = new HitBuilders.ExceptionBuilder();
        builder.setDescription(o.toString() + ":" + throwable.getMessage());
        builder.setFatal(true);

        this.analyticsTracker.send(builder.build());
    }

    @Override
    public void trace(Object o)
    {
        if (o.getClass().isAnnotationPresent(DisplayName.class)) {
            this.logScreen(o);
            return;
        }
        if (o instanceof TrackedScreen) {
            this.logScreen((TrackedScreen) o);
            return;
        }
        if (o instanceof TrackedEvent) {
            this.logEvent((TrackedEvent) o);
            return;
        }
    }

    /**
     * Adds an event hit with Google Analytics.
     */
    private void logEvent(TrackedEvent event)
    {
        HitBuilders.EventBuilder builder = new HitBuilders.EventBuilder();
        builder.setCategory(event.getCategory());
        builder.setAction(event.getAction());
        builder.setLabel(event.getLabel());
        if (null != event.getValue()) {
            builder.setValue(event.getValue());
        }
        this.analyticsTracker.send(builder.build());
    }

    /**
     * Adds a screen hit with Google Analytics.
     */
    private void logScreen(TrackedScreen screen)
    {
        this.analyticsTracker.setScreenName(screen.getName());
        this.analyticsTracker.send(new HitBuilders.AppViewBuilder().build());
    }

    /**
     * Adds a screen hit with Google Analyics based off of an object's
     * ScreenName annotation.
     *
     * @param o The object containing a DisplayName annotation to be logged.
     * @see DisplayName
     */
    private void logScreen(Object o)
    {
        DisplayName annotation = o.getClass().getAnnotation(DisplayName.class);
        if (null == annotation) {
            return;
        }

        String name = this.resources.getString(annotation.value());
        this.analyticsTracker.setScreenName(name);
        this.analyticsTracker.send(new HitBuilders.AppViewBuilder().build());
    }

    @Override
    public void trace(Object o, Throwable throwable) {}
    @Override
    public void debug(Object o) {}
    @Override
    public void debug(Object o, Throwable throwable) {}
    @Override
    public void info(Object o) {}
    @Override
    public void info(Object o, Throwable throwable) {}
    @Override
    public void warn(Object o) {}
    @Override
    public void warn(Object o, Throwable throwable) {}
}
