package me.jackt.configurator;

public class ConfigurationKeyNotFoundException extends RuntimeException {

    public ConfigurationKeyNotFoundException() {
    }

    public ConfigurationKeyNotFoundException(String message) {
        super(message);
    }

    public ConfigurationKeyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationKeyNotFoundException(Throwable cause) {
        super(cause);
    }

    public ConfigurationKeyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
