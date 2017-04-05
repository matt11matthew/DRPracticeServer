package com.matthewedevelopment.ps.mechanics.item.tier;

import com.matthewedevelopment.ps.mechanics.item.builder.IItemBuilder;
import com.matthewedevelopment.ps.mechanics.item.builder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew E on 4/1/2017.
 */
public enum ItemType {
    SWORD, BOW, AXE, CHESTPLATE, GEM, POLEARM, PICKAXE, HELMET, LEGGINGS, BOOTS, STAFF, FOOD, POTION, VANILLA;

    public static ItemType getItemType(ItemStack itemStack) {
        if (isPsItem(itemStack)) {
            if (itemStack.getType().toString().contains("SWORD")) {
                return ItemType.SWORD;
            }
            if (itemStack.getType().toString().contains("SPADE")) {
                return ItemType.POLEARM;
            }
            if (itemStack.getType().toString().contains("HOE")) {
                return ItemType.STAFF;
            }
            if (itemStack.getType().toString().contains("PICKAXE")) {
                return ItemType.PICKAXE;
            }
            if ((!itemStack.getType().toString().contains("PICKAXE")) && (itemStack.getType().toString().contains("AXE"))) {
                return ItemType.AXE;
            }
            if (itemStack.getType().toString().contains("HELMET")) {
                return ItemType.HELMET;
            }
            if (itemStack.getType().toString().contains("LEGGINGS")) {
                return ItemType.LEGGINGS;
            }
            if (itemStack.getType() == Material.EMERALD) {
                return ItemType.GEM;
            }
            if (itemStack.getType().toString().contains("CHESTPLATE")) {
                return ItemType.CHESTPLATE;
            }
            if (itemStack.getType().toString().contains("BOOTS")) {
                return ItemType.BOOTS;
            }
            if (itemStack.getType().toString().contains("BOW")) {
                return ItemType.BOW;
            }
            if (isFood(itemStack)) {
                return ItemType.FOOD;
            }
            if (isPotion(itemStack)) {
                return ItemType.POTION;
            }
        }
        return ItemType.VANILLA;
    }

    private static boolean isPotion(ItemStack itemStack) {
        IItemBuilder itemBuilder = new ItemBuilder(itemStack);
        return itemBuilder.getTag().hasKey("psPotion");
    }

    private static boolean isPsItem(ItemStack itemStack) {
        IItemBuilder itemBuilder = new ItemBuilder(itemStack);
        return itemBuilder.getTag().hasKey("psItem");
    }
    private static boolean isFood(ItemStack itemStack) {
        IItemBuilder itemBuilder = new ItemBuilder(itemStack);
        return itemBuilder.getTag().hasKey("psFood");
    }

    public static ItemType getItemType(Material material) {
        if (material.toString().contains("SWORD")) {
            return ItemType.SWORD;
        }
        if (material.toString().contains("SPADE")) {
            return ItemType.POLEARM;
        }
        if (material.toString().contains("HOE")) {
            return ItemType.STAFF;
        }
        if (material.toString().contains("PICKAXE")) {
            return ItemType.PICKAXE;
        }
        if ((!material.toString().contains("PICKAXE")) && (material.toString().contains("AXE"))) {
            return ItemType.AXE;
        }
        if (material.toString().contains("HELMET")) {
            return ItemType.HELMET;
        }
        if (material.toString().contains("LEGGINGS")) {
            return ItemType.LEGGINGS;
        }
        if (material == Material.EMERALD) {
            return ItemType.GEM;
        }
        if (material.toString().contains("CHESTPLATE")) {
            return ItemType.CHESTPLATE;
        }
        if (material.toString().contains("BOOTS")) {
            return ItemType.BOOTS;
        }
        if (material.toString().contains("BOW")) {
            return ItemType.BOW;
        }
        return VANILLA;
    }

    public boolean isArmor() {
        switch (this) {
            case CHESTPLATE:
            case HELMET:
            case LEGGINGS:
            case BOOTS:
                return true;
        }
        return false;
    }
}
