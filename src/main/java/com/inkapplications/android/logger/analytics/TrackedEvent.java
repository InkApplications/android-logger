/*
 * Copyright (c) 2015 Ink Applications, LLC.
 * Distributed under the MIT License (http://opensource.org/licenses/MIT)
 */
package com.inkapplications.android.logger.analytics;

/**
 * An application event that can be tracked with analytics.
 *
 * @author Maxwell Vandervelde (Max@MaxVandervelde.com)
 */
public class TrackedEvent
{
    /**
     * The primary division of the types of Events you have on your application.
     *
     * Categories are at the root of Event tracking, and should function as a
     * first way to sort Events in your reports. Videos and Downloads are good
     * examples of categories, though you can be as specific or broad as your
     * content requires.
     */
    private String category;

    /**
     * A descriptor for a particular Event Category.
     *
     * You can use any string to define an Action, so you can be as specific as
     * necessary. For example, you could define Play or Pause as Actions for a
     * Video. You could also be more specific, and create an Action called Video
     * almost finished to trigger when the play-back slider on a video reaches
     * the 90% mark.
     */
    private String action;

    /**
     * An optional descriptor that you can use to provide further granularity.
     *
     * You can specify any string for a label.
     */
    private String label;

    /**
     * An optional numerical variable attached.
     *
     * You can use explicit values, like 30, or inferred values based variables
     * you define elsewhere, like downloadTime.
     */
    private Long value;

    /**
     * @param category The primary division of the types of Events you have on your application.
     * @param action A descriptor for a particular Event Category.
     */
    public TrackedEvent(String category, String action)
    {
        this.category = category;
        this.action = action;
    }

    /**
     * @param category The primary division of the types of Events you have on your application.
     * @param action A descriptor for a particular Event Category.
     * @param label An optional descriptor that you can use to provide further granularity.
     */
    public TrackedEvent(String category, String action, String label)
    {
        this.category = category;
        this.action = action;
        this.label = label;
    }

    /**
     * @param category The primary division of the types of Events you have on your application.
     * @param action A descriptor for a particular Event Category.
     * @param label An optional descriptor that you can use to provide further granularity.
     * @param value An optional numerical variable attached.
     */
    public TrackedEvent(String category, String action, String label, Long value)
    {
        this.category = category;
        this.action = action;
        this.label = label;
        this.value = value;
    }

    /**
     * @return The primary division of the types of Events you have on your application.
     */
    final public String getCategory()
    {
        return category;
    }

    /**
     * @param category The primary division of the types of Events you have on your application.
     */
    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * @return A descriptor for a particular Event Category.
     */
    final public String getAction()
    {
        return action;
    }

    /**
     * @param action A descriptor for a particular Event Category.
     */
    public void setAction(String action)
    {
        this.action = action;
    }

    /**
     * @return An optional descriptor that you can use to provide further granularity.
     */
    final public String getLabel()
    {
        return label;
    }

    /**
     * @param label An optional descriptor that you can use to provide further granularity.
     */
    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     * @return An optional numerical variable attached.
     */
    final public Long getValue()
    {
        return this.value;
    }

    /**
     * @param value An optional numerical variable attached.
     */
    public void setValue(Long value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "TrackedEvent{" +
            "category='" + category + '\'' +
            ", action='" + action + '\'' +
            ", label='" + label + '\'' +
            ", value=" + value +
            '}';
    }
}
