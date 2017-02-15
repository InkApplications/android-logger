package inkapplicaitons.android.logger;

public class EmptyLogger implements Logger {
    @Override public void debug(String message) {}
    @Override public void debug(String message, Object... args) {}
    @Override public void debug(Throwable cause, String message) {}
    @Override public void error(String message) {}
    @Override public void error(String message, Object... args) {}
    @Override public void error(Throwable cause, String message) {}
    @Override public void info(String message) {}
    @Override public void info(String message, Object... args) {}
    @Override public void info(Throwable cause, String message) {}
    @Override public void trace(String message) {}
    @Override public void trace(String message, Object... args) {}
    @Override public void trace(Throwable cause, String message) {}
    @Override public void warn(String message) {}
    @Override public void warn(String message, Object... args) {}
    @Override public void warn(Throwable cause, String message) {}
}
