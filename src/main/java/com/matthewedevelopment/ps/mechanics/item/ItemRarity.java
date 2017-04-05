package com.matthewedevelopment.ps.mechanics.item;

import org.bukkit.ChatColor;

/**
 * Created by Matthew E on 4/2/2017.
 */
public enum ItemRarity {
    COMMON(0, "Common", ChatColor.GRAY + ChatColor.ITALIC.toString()),
    UNCOMMON(1, "Uncommon", ChatColor.GREEN+ ChatColor.ITALIC.toString()),
    RARE(2, "Rare", ChatColor.AQUA + ChatColor.ITALIC.toString()),
    UNIQUE(3, "Unique", ChatColor.YELLOW+ ChatColor.ITALIC.toString());

    private int id;
    private String name;
    private String color;

    ItemRarity(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
