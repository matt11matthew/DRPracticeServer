package com.matthewedevelopment.ps.mechanics.monster.spawner;

import com.matthewedevelopment.ps.api.file.yaml.YamlFile;
import com.matthewedevelopment.ps.mechanics.monster.Monster;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew E on 4/2/2017.
 */
public class SpawnerImpl implements Spawner {

    private Location location;
    private long delay;
    private String id;
    private boolean active;
    private List<Monster> monsterList;
    private int spawnRange;
    private int spawnCap;

    public SpawnerImpl(String id, YamlFile yamlFile) {
        this.id = id;
        ConfigurationSection section = yamlFile.get().getConfigurationSection("spawners." + id);
        this.location = yamlFile.getSpawnerLocation(section);
        this.spawnRange = section.getInt("spawnRange");
        this.spawnCap = section.getInt("spawnCap");
        this.monsterList = new ArrayList<>();

    }

    @Override
    public void spawn() {

    }

    @Override
    public void setDelay(long delay) {
        this.delay = delay;
    }

    @Override
    public long getDelay() {
        return delay;
    }

    @Override
    public List<Monster> getMonsterList() {
        return monsterList;
    }

    @Override
    public int getSpawnRange() {
        return spawnRange;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int getSpawnCap() {
        return spawnCap;
    }

    @Override
    public String getId() {
        return id;
    }
}
