package inkapplicaitons.android.logger;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleLogger implements Logger {
    private final String name;
    private final Integer loggerOffset;

    /**
     * Create the logger with a specified tag.
     *
     * @param name the tag to use when outputting lines
     */
    public ConsoleLogger(String name) {
        this.name = name;
        this.loggerOffset = 0;
    }

    /**
     * Create logger and use the invoking class name as the tag
     */
    public ConsoleLogger() {
        this.name = null;
        this.loggerOffset = 0;
    }

    /**
     * Create logger and use class name as tag.
     *
     * @param loggerOffset The offset of classes to ignore when picking the
     *                     class name. This is useful when the logger is wrapped
     *                     inside another logger, so that the invoking class
     *                     won't be labeled as that other logger.
     */
    public ConsoleLogger(int loggerOffset) {
        this.name = null;
        this.loggerOffset = loggerOffset;
    }

    @Override
    public void debug(String message) {
        Log.d(this.getTag(), message);
    }

    @Override
    public void debug(String message, Object... args) {
        Log.d(this.getTag(), String.format(message, args));
    }

    @Override
    public void debug(Throwable cause, String message) {
        Log.d(this.getTag(), message, cause);
    }

    @Override
    public void error(String message) {
        Log.e(this.getTag(), message);
    }

    @Override
    public void error(String message, Object... args) {
        Log.e(this.getTag(), String.format(message, args));
    }

    @Override
    public void error(Throwable cause, String message) {
        Log.e(this.getTag(), message, cause);
    }

    @Override
    public void info(String message) {
        Log.i(this.getTag(), message);
    }

    @Override
    public void info(String message, Object... args) {
        Log.i(this.getTag(), String.format(message, args));
    }

    @Override
    public void info(Throwable cause, String message) {
        Log.i(this.getTag(), message, cause);
    }

    @Override
    public void trace(String message) {
        Log.v(this.getTag(), message);
    }

    @Override
    public void trace(String message, Object... args) {
        Log.v(this.getTag(), String.format(message, args));
    }

    @Override
    public void trace(Throwable cause, String message) {
        Log.v(this.getTag(), message, cause);
    }

    @Override
    public void warn(String message) {
        Log.w(this.getTag(), message);
    }

    @Override
    public void warn(String message, Object... args) {
        Log.w(this.getTag(), String.format(message, args));
    }

    @Override
    public void warn(Throwable cause, String message) {
        Log.w(this.getTag(), message, cause);
    }

    /*
        The Following code is from Jake Wharton's Timber library,
        sources received from: https://github.com/JakeWharton/timber

        Copyright Jake Wharton and licensed under:
        Apache License
        Version 2.0, January 2004
        http://www.apache.org/licenses/

        Modifications include:
            - Change getTag first return condition to return tag name of local class context
     */

    private static final int MAX_TAG_LENGTH = 23;
    private static final int CALL_STACK_INDEX = 2;
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");

    /**
     * Extract the tag which should be used for the message from the {@code element}. By default
     * this will use the class name without any anonymous class suffixes (e.g., {@code Foo$1}
     * becomes {@code Foo}).
     * <p>
     * Note: This will not be called if a {@linkplain #tag(String) manual tag} was specified.
     */
    private String createStackElementTag(StackTraceElement element) {
        String tag = element.getClassName();
        Matcher m = ANONYMOUS_CLASS.matcher(tag);
        if (m.find()) {
            tag = m.replaceAll("");
        }
        tag = tag.substring(tag.lastIndexOf('.') + 1);
        return tag.length() > MAX_TAG_LENGTH ? tag.substring(0, MAX_TAG_LENGTH) : tag;
    }

    private String getTag() {
        if (null != this.name) {
            return this.name;
        }

        // DO NOT switch this to Thread.getCurrentThread().getStackTrace(). The test will pass
        // because Robolectric runs them on the JVM but on Android the elements are different.
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length <= CALL_STACK_INDEX) {
            throw new IllegalStateException(
                    "Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        return createStackElementTag(stackTrace[CALL_STACK_INDEX + loggerOffset]);
    }

    /* End of Timber Code */
}
