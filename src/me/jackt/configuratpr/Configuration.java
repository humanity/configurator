package me.jackt.configuratpr;

import me.jackt.configuratpr.me.jackt.configurator.providers.DefaultProvider;

/**
 * User: Jack Date: 3/1/14 Time: 11:34 PM
 */
public class Configuration {

    protected ConfigurationProvider normalProvider;

    protected static final ConfigurationProvider defaultProvider;

    static {
        defaultProvider = new DefaultProvider();
    }

    Configuration(ConfigurationProvider customProvider) {
        if (customProvider == null) {
            throw new NullPointerException();
        } else {
            normalProvider = customProvider;
        }
    }

}
