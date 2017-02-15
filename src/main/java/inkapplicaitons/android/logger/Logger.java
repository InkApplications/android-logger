package inkapplicaitons.android.logger;

public interface Logger {
    void debug(String message);
    void debug(String message, Object... args);
    void debug(Throwable cause, String message);

    void error(String message);
    void error(String message, Object... args);
    void error(Throwable cause, String message);

    void info(String message);
    void info(String message, Object... args);
    void info(Throwable cause, String message);

    void trace(String message);
    void trace(String message, Object... args);
    void trace(Throwable cause, String message);

    void warn(String message);
    void warn(String message, Object... args);
    void warn(Throwable cause, String message);
}
