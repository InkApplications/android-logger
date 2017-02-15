package inkapplicaitons.android.logger;

public class DelegateLogger implements Logger {

    private Logger delegate;

    public DelegateLogger(Logger delegate) {
        this.delegate = delegate;
    }

    public void setDelegate(Logger logger) {
        this.delegate = logger;
    }

    @Override
    public void debug(String message) {
        this.delegate.debug(message);
    }

    @Override
    public void debug(String message, Object... args) {
        this.delegate.debug(message, args);
    }

    @Override
    public void debug(Throwable cause, String message) {
        this.delegate.debug(cause, message);
    }

    @Override
    public void error(String message) {
        this.delegate.error(message);
    }

    @Override
    public void error(String message, Object... args) {
        this.delegate.error(message, args);
    }

    @Override
    public void error(Throwable cause, String message) {
        this.delegate.error(cause, message);
    }

    @Override
    public void info(String message) {
        this.delegate.info(message);
    }

    @Override
    public void info(String message, Object... args) {
        this.delegate.info(message, args);
    }

    @Override
    public void info(Throwable cause, String message) {
        this.delegate.info(cause, message);
    }

    @Override
    public void trace(String message) {
        this.delegate.trace(message);
    }

    @Override
    public void trace(String message, Object... args) {
        this.delegate.trace(message, args);
    }

    @Override
    public void trace(Throwable cause, String message) {
        this.delegate.trace(cause, message);
    }

    @Override
    public void warn(String message) {
        this.delegate.warn(message);
    }

    @Override
    public void warn(String message, Object... args) {
        this.delegate.warn(message, args);
    }

    @Override
    public void warn(Throwable cause, String message) {
        this.delegate.warn(cause, message);
    }
}
