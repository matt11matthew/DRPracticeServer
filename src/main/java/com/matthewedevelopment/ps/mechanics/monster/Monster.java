package com.matthewedevelopment.ps.mechanics.monster;

import com.matthewedevelopment.ps.mechanics.item.tier.ItemTier;
import com.matthewedevelopment.ps.mechanics.monster.entities.PsMonsterTypes;
import com.matthewedevelopment.ps.mechanics.monster.spawner.Spawner;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew E on 4/2/2017.
 */
public interface Monster {

    void spawn(Location location);

    void despawn();

    void goBack(Location location);

    Spawner getSpawner();

    ItemTier getTier();

    PsMonsterTypes getMonsterType();

    ItemStack getHelmet();

    ItemStack getLeggings();

    ItemStack getChestplate();

    ItemStack getWeapon();

    ItemStack getBoots();

    boolean isElite();

    double getHp();
}
