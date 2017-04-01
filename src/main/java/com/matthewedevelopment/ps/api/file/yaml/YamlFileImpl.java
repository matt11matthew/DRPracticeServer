package com.matthewedevelopment.ps.api.file.yaml;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by matt1 on 3/22/2017.
 */
public class YamlFileImpl implements YamlFile {

    private File file;
    private YamlConfiguration yamlConfiguration;
    private boolean isNew;

    @Override
    public void delete() {
        this.file.delete();
    }

    @Override
    public void save() throws IOException {
        this.yamlConfiguration.save(this.file);
    }

    @Override
    public void rename(String newName) {
        this.file.renameTo(new File(file.getParent() + "/", newName));
        try {
            load(this.file);
        } catch (YamlLoadException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create() {
        try {
            this.file.createNewFile();
            this.isNew = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public YamlFile load(File file) throws YamlLoadException {
        this.file = file;
        File path = file.getParentFile();
        if (!path.exists()) {
            path.mkdirs();
        }
        if (!this.file.exists()) {
            this.create();
        }
        try {
            this.yamlConfiguration = YamlConfiguration.loadConfiguration(this.file);
        } catch (Exception e) {
            throw new YamlLoadException("Could not load yaml file " + e.getLocalizedMessage(), e.getCause());
        }
        return this;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }


    @Override
    public void set(String key, Object value) {
        if (value instanceof Location) {
            Location location = (Location) value;
            this.get().set(key + ".location.world", location.getWorld().getName());
            this.get().set(key + ".location.x", location.getX());
            this.get().set(key + ".location.y", location.getY());
            this.get().set(key + ".location.z", location.getZ());
            this.get().set(key + ".location.yaw", location.getYaw());
            this.get().set(key + ".location.pitch", location.getPitch());
            try {
                this.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        this.yamlConfiguration.set(key, value);
        try {
            this.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private YamlConfiguration get() {
        return yamlConfiguration;
    }

    @Override
    public Location getLocation(String key) {
        World world = Bukkit.getWorld(yamlConfiguration.getString(key +".location.world"));
        double x = yamlConfiguration.getDouble(key+".location.x");
        double y = yamlConfiguration.getDouble(key+".location.y");
        double z = yamlConfiguration.getDouble(key+".location.z");
        double yaw = yamlConfiguration.getDouble(key+".location.yaw");
        double pitch = yamlConfiguration.getDouble(key+".location.pitch");
        Location location = new Location(world, x, y, z, Float.valueOf(String.valueOf(yaw)), Float.valueOf(String.valueOf(pitch)));
        return location;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @Override
    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }
}
