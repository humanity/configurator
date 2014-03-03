package me.jackt.configurator;

import java.util.Set;

/**
 * Most implementations of this will probably use something like HashMap, but there is no limit on what this could be
 * used for.
 */
public interface ConfigurationProvider {

    public String getString(String key) throws ConfigurationKeyNotFoundException;

    /**
     * Because this is mostly done on Maps, this will mostly correspond to the containsKey method of HashMaps.
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key);

    /**
     * """" to the keySet method "
     *
     * @return
     */
    public Set<String> getKeys();

    /**
     * This method, because it must be in the interface, will end up public, but it should not be called directly by
     * outside clients.
     *
     * @return a boolean representing whether or not this function actually altered any data. If this pulls from a file,
     *         but no data is changed, this still returns false.
     */
    boolean fill();
}
