package com.matthewedevelopment.ps.mechanics.monster;

import com.matthewedevelopment.ps.mechanics.item.tier.ItemTier;
import com.matthewedevelopment.ps.mechanics.monster.entities.PsMonsterTypes;
import com.matthewedevelopment.ps.mechanics.monster.spawner.Spawner;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew E on 4/2/2017.
 */
public class MonsterImpl implements Monster {


    private PsMonsterTypes monsterType;
    private Spawner spawner;
    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack weapon;
    private ItemTier tier;
    private boolean isElite;
    private ItemStack boots;

    @Override
    public void spawn(Location location) {

    }

    @Override
    public void despawn() {

    }

    @Override
    public void goBack(Location location) {

    }

    @Override
    public Spawner getSpawner() {
        return spawner;
    }

    @Override
    public ItemTier getTier() {
        return tier;
    }

    @Override
    public PsMonsterTypes getMonsterType() {
        return monsterType;
    }

    @Override
    public ItemStack getHelmet() {
        return helmet;
    }

    @Override
    public ItemStack getLeggings() {
        return leggings;
    }

    @Override
    public ItemStack getChestplate() {
        return chestplate;
    }

    @Override
    public ItemStack getWeapon() {
        return weapon;
    }

    @Override
    public ItemStack getBoots() {
        return boots;
    }

    @Override
    public boolean isElite() {
        return isElite;
    }

    @Override
    public double getHp() {
        return 0;
    }
}
