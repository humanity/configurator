package me.jackt.configurator.providers;

import com.google.common.base.Preconditions;
import me.jackt.configurator.ConfigurationKeyNotFoundException;
import me.jackt.configurator.ConfigurationProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class FileProvider implements ConfigurationProvider {

    protected HashMap<String, String> data;
    protected String filePath;

    public FileProvider(String filePath) throws IOException {
        data = new HashMap<>();
        this.filePath = filePath;
        fill();
    }

    @Override
    public boolean fill() throws IOException {
        boolean changed = false;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while (reader.ready()) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            line = line.trim();
            if (line.startsWith("#") || line.isEmpty()) { // is a comment?
                continue;
            }
            String[] parts = line.split(":", 2);
            Preconditions.checkArgument(parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty(), "key or value not specified");
            if (!changed && this.data.containsKey(parts[0]) && !(this.data.get(parts[0]).equals(parts[1]))) {
                changed = true;
            }
            this.data.put(parts[0], parts[1]);
        }
        return changed;
    }


    @Override
    public String getString(String key) throws ConfigurationKeyNotFoundException {
        return data.get(key);
    }

    @Override
    public Set<String> getKeys() {
        return data.keySet();
    }

    @Override
    public boolean hasKey(String key) {
        return data.containsKey(key);
    }
}
