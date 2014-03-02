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
        // TODO add the data here.
    }


    @Override
    public Object getNumber(String value, Class<? extends Number> clazz) throws ClassCastException {
        if (data.containsKey(value)) {
            Object newValue = clazz.cast(data.get(value)); // will be source of exceptions
            if (newValue != null)
                return newValue;
            else return null; // TODO or perhaps throws an exception
        } else {
            throw new ConfigurationKeyNotFoundException("Key not found: \"" + value + "\"");
        }
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
}
