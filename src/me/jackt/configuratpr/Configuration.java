package me.jackt.configuratpr;

import me.jackt.configuratpr.me.jackt.configurator.providers.DefaultProvider;

import java.util.Set;

/**
 * User: Jack Date: 3/1/14 Time: 11:34 PM
 */
public abstract class Configuration {

    protected ConfigurationProvider normalProvider;

    protected static final ConfigurationProvider defaultProvider;

    static {
        defaultProvider = new DefaultProvider();
    }

    /**
     * Fill the normal provider with whatever it likes, based on the Constructors it defines.
     */
    protected abstract void fillNormal();




}
