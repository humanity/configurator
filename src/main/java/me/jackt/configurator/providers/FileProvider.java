package me.jackt.configurator.providers;

import me.jackt.configurator.ConfigurationKeyNotFoundException;
import me.jackt.configurator.ConfigurationProvider;

import java.util.Set;

public class FileProvider implements ConfigurationProvider {

    @Override
    public String getString(String key) throws ConfigurationKeyNotFoundException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<String> getKeys() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasKey(String key) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean fill() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
