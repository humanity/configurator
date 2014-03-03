package me.jackt.configurator;

import me.jackt.configurator.me.jackt.configurator.providers.DefaultProvider;

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

    protected String getString0(String key) {
        if (normalProvider.hasKey(key)) {
            return normalProvider.getString(key);
        } else if (defaultProvider.hasKey(key)) {
            return defaultProvider.getString(key);
        } else {
            throw new ConfigurationKeyNotFoundException("Key \"" + key + "\" not found");
        }
    }

    public String getString(String key) {
        return getString0(key).trim();
    }

    public int getInt(String key) {
        String str = getString0(key);
        return Integer.parseInt(str); // allow this to be thrown
    }

    public double getDouble(String key) {
        String str = getString0(key);
        return Double.parseDouble(str); // allow this to be thrown
    }

    public long getLong(String key) {
        String str = getString0(key);
        return Long.parseLong(str); // allow this to be thrown
    }

    public char getChar(String key) {
        return getString0(key).charAt(0);
    }


}
