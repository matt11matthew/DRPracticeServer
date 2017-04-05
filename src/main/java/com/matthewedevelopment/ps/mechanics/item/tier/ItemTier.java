package com.matthewedevelopment.ps.mechanics.item.tier;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Matthew E on 4/1/2017.
 */
public enum ItemTier {
    TIER_1(1, ChatColor.WHITE, new Material[]{Material.WOOD_SWORD, Material.WOOD_AXE, Material.WOOD_SPADE, Material.WOOD_HOE, Material.WOOD_PICKAXE, Material.LEATHER_BOOTS, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_HELMET}),
    TIER_2(2, ChatColor.GREEN, new Material[]{Material.STONE_SWORD, Material.STONE_AXE, Material.STONE_SPADE, Material.STONE_HOE, Material.STONE_PICKAXE, Material.CHAINMAIL_BOOTS, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_HELMET}),
    TIER_3(3, ChatColor.AQUA, new Material[]{Material.IRON_SWORD, Material.IRON_AXE, Material.IRON_SPADE, Material.IRON_HOE, Material.IRON_PICKAXE, Material.IRON_BOOTS, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_HELMET}),
    TIER_4(4, ChatColor.LIGHT_PURPLE, new Material[]{Material.DIAMOND_SWORD, Material.DIAMOND_AXE, Material.DIAMOND_SPADE, Material.DIAMOND_HOE, Material.DIAMOND_PICKAXE, Material.DIAMOND_BOOTS, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_HELMET}),
    TIER_5(5, ChatColor.YELLOW, new Material[]{Material.GOLD_SWORD, Material.GOLD_AXE, Material.GOLD_SPADE, Material.GOLD_HOE, Material.GOLD_PICKAXE, Material.GOLD_BOOTS, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_HELMET}),
    TIER_0(0, null, new Material[] {});

    private int tier;
    private ChatColor chatColor;
    private Material[] materials;

    ItemTier(int tier, ChatColor chatColor, Material[] materials) {
        this.tier = tier;
        this.chatColor = chatColor;
        this.materials = materials;
    }

    public int getTierNumber() {
        return tier;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public List<Material> getMaterialList() {
        return Arrays.asList(materials);
    }

    public static ItemTier getTier(int tier) {
        for (ItemTier itemTier : ItemTier.values()) {
            if (itemTier.getTierNumber()==tier) {
                return itemTier;
            }
        }
        return null;
    }

    public static ItemTier getTier(ItemStack itemStack) {
        for (ItemTier itemTier : ItemTier.values()) {
            if (itemTier.getMaterialList().contains(itemStack.getType())) {
                if (itemStack.hasItemMeta()) {
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    if (itemMeta.hasDisplayName()) {
                        String name = itemMeta.getDisplayName();
                        if (name.startsWith(itemTier.getChatColor().toString())) {
                            return itemTier;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Material decideType(ItemType itemType) {
        for (Material material : this.getMaterialList()) {
            if (material.toString().contains(itemType.toString())) {
                return material;
            }
        }
        switch (itemType) {
            case GEM:
                return Material.EMERALD;
            case POLEARM:
                for (Material material : this.getMaterialList()) {
                    if (material.toString().contains("SPADE")) {
                        return material;
                    }
                }
            case STAFF:
                for (Material material : this.getMaterialList()) {
                    if (material.toString().contains("HOE")) {
                        return material;
                    }
                }
            case FOOD:
            case POTION:
            case VANILLA:
                break;
        }
        return Material.PAPER;
    }

    public static ItemTier getTier(Material material) {
        for (ItemTier itemTier : ItemTier.values()) {
            if (itemTier.getMaterialList().contains(material)) {
                return itemTier;
            }
        }
        return TIER_0;
    }
}
