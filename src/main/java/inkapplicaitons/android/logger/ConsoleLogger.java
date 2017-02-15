package inkapplicaitons.android.logger;

import android.util.Log;

public class ConsoleLogger implements Logger {
    private final String name;

    public ConsoleLogger(String name) {
        this.name = name;
    }

    @Override
    public void debug(String message) {
        Log.d(this.name, message);
    }

    @Override
    public void debug(String message, Object... args) {
        Log.d(this.name, String.format(message, args));
    }

    @Override
    public void debug(Throwable cause, String message) {
        Log.d(this.name, message, cause);
    }

    @Override
    public void error(String message) {
        Log.e(this.name, message);
    }

    @Override
    public void error(String message, Object... args) {
        Log.e(this.name, String.format(message, args));
    }

    @Override
    public void error(Throwable cause, String message) {
        Log.e(this.name, message, cause);
    }

    @Override
    public void info(String message) {
        Log.i(this.name, message);
    }

    @Override
    public void info(String message, Object... args) {
        Log.i(this.name, String.format(message, args));
    }

    @Override
    public void info(Throwable cause, String message) {
        Log.i(this.name, message, cause);
    }

    @Override
    public void trace(String message) {
        Log.v(this.name, message);
    }

    @Override
    public void trace(String message, Object... args) {
        Log.v(this.name, String.format(message, args));
    }

    @Override
    public void trace(Throwable cause, String message) {
        Log.v(this.name, message, cause);
    }

    @Override
    public void warn(String message) {
        Log.w(this.name, message);
    }

    @Override
    public void warn(String message, Object... args) {
        Log.w(this.name, String.format(message, args));
    }

    @Override
    public void warn(Throwable cause, String message) {
        Log.w(this.name, message, cause);
    }
}
