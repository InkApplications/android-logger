package inkapplicaitons.android.logger;

import java.util.List;

public class CompositeLogger implements Logger {
    final private List<Logger> loggers;

    public CompositeLogger(List<Logger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void debug(String message) {
        for (Logger logger : this.loggers) {
            logger.debug(message);
        }
    }

    @Override
    public void debug(String message, Object... args) {
        for (Logger logger : this.loggers) {
            logger.debug(message, args);
        }
    }

    @Override
    public void debug(Throwable cause, String message) {
        for (Logger logger : this.loggers) {
            logger.debug(cause, message);
        }
    }

    @Override
    public void error(String message) {
        for (Logger logger : this.loggers) {
            logger.error(message);
        }
    }

    @Override
    public void error(String message, Object... args) {
        for (Logger logger : this.loggers) {
            logger.error(message, args);
        }
    }

    @Override
    public void error(Throwable cause, String message) {
        for (Logger logger : this.loggers) {
            logger.error(cause, message);
        }
    }

    @Override
    public void info(String message) {
        for (Logger logger : this.loggers) {
            logger.info(message);
        }
    }

    @Override
    public void info(String message, Object... args) {
        for (Logger logger : this.loggers) {
            logger.info(message, args);
        }
    }

    @Override
    public void info(Throwable cause, String message) {
        for (Logger logger : this.loggers) {
            logger.info(cause, message);
        }
    }

    @Override
    public void trace(String message) {
        for (Logger logger : this.loggers) {
            logger.trace(message);
        }
    }

    @Override
    public void trace(String message, Object... args) {
        for (Logger logger : this.loggers) {
            logger.trace(message, args);
        }
    }

    @Override
    public void trace(Throwable cause, String message) {
        for (Logger logger : this.loggers) {
            logger.trace(cause, message);
        }
    }

    @Override
    public void warn(String message) {
        for (Logger logger : this.loggers) {
            logger.warn(message);
        }
    }

    @Override
    public void warn(String message, Object... args) {
        for (Logger logger : this.loggers) {
            logger.warn(message, args);
        }
    }

    @Override
    public void warn(Throwable cause, String message) {
        for (Logger logger : this.loggers) {
            logger.warn(cause, message);
        }
    }
}
