/*
 * Copyright (c) 2015 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import org.apache.commons.logging.Log;

/**
 * Automatically logs a trace entry every time an Activity is resumed.
 *
 * @author Maxwell Vandervelde (Max@MaxVandervelde.com)
 */
final public class AutoLogger implements Application.ActivityLifecycleCallbacks
{
    final private Log logger;

    public AutoLogger(Log logger)
    {
        this.logger = logger;
    }

    @Override
    public void onActivityResumed(Activity activity)
    {
        this.logger.trace(activity);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {}
    @Override
    public void onActivityStarted(Activity activity) {}
    @Override
    public void onActivityPaused(Activity activity) {}
    @Override
    public void onActivityStopped(Activity activity) {}
    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {}
    @Override
    public void onActivityDestroyed(Activity activity) {}
}
