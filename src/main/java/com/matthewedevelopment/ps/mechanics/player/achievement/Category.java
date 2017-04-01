package com.matthewedevelopment.ps.mechanics.player.achievement;

import org.bukkit.Material;

/**
 * Created by matt1 on 3/20/2017.
 */
public enum Category {
    RANKED(0, "Ranked", Material.DIAMOND_SWORD),
    UNRANKED(1, "Unranked", Material.IRON_SWORD),
    RANKED_KILLS(2, "Ranked Kills", Material.GOLD_SWORD),
    RANKED_GAMES(3, "Ranked Games", Material.NOTE_BLOCK),
    RANKED_DEATHS(4, "Ranked Deaths", Material.SKULL_ITEM),
    MISC(5, "Miscellaneous", Material.ENDER_PEARL);

    private int id;
    private String name;
    private Material material;

    Category(int id, String name, Material material) {
        this.id = id;
        this.name = name;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }
}
