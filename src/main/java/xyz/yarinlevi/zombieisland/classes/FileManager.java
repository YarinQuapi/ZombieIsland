package xyz.yarinlevi.zombieisland.classes;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {
    public static void registerData(File file, FileConfiguration data) {
        if(!file.exists()) {
            file.getParentFile().mkdirs();
        } else {
            try {
                data.load(file);
            } catch (InvalidConfigurationException | IOException e) {
                e.printStackTrace();
            }
        }
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
