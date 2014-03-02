package me.jackt.configuratpr;

import java.util.Set;

public interface ConfigurationProvider {

    public Object getNumber(String value, Class<? extends Number> clazz) throws ClassCastException; // we'll see about this

    public String getString(String value);

    public Set<String> getKeys();

}
