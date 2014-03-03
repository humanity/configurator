package me.jackt.configuratpr.me.jackt.configurator.providers;

import me.jackt.configuratpr.ConfigurationKeyNotFoundException;
import me.jackt.configuratpr.ConfigurationProvider;

import java.util.HashMap;
import java.util.Set;

/**
 * User: Jack Date: 3/1/14 Time: 11:48 PM
 */
public class DefaultProvider implements ConfigurationProvider {

    HashMap<String, Object> data;

    {
        data = new HashMap<String, Object>();
        // TODO add the default data here.
    }


    @Override
    public String getString(String value) {
        if (data.containsKey(value)) {
            return data.get(value).toString();
        } else {
            throw new ConfigurationKeyNotFoundException("Key not found: \"" + value + "\"");
        }
    }

    @Override
    public Set<String> getKeys() {
        return data.keySet();
    }

    public boolean hasKey(String key) {
        return data.containsKey(key);
    }


    public boolean fill() {
        return false;
    }
}
