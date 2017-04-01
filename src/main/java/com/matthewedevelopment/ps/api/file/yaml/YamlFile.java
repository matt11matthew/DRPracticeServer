package com.matthewedevelopment.ps.api.file.yaml;

import com.matthewedevelopment.ps.api.file.FileOperations;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by matt1 on 3/22/2017.
 */
public interface YamlFile extends FileOperations, YamlLoadable, INew {

    File getFile();
    YamlConfiguration getYamlConfiguration();
void set(String key, Object to);
    Location getLocation(String load);
}
