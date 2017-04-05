package com.matthewedevelopment.ps.mechanics.monster.spawner;

import com.matthewedevelopment.ps.mechanics.monster.Monster;
import org.bukkit.Location;

import java.util.List;

/**
 * Created by Matthew E on 4/2/2017.
 */
public interface Spawner {

    void spawn();

    void setDelay(long delay);

    long getDelay();

    List<Monster> getMonsterList();

    int getSpawnRange();

    boolean isActive();

    Location getLocation();

    String getId();

    void setActive(boolean active);

    int getSpawnCap();
}
