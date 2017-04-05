package com.matthewedevelopment.ps.mechanics.item.generator;

import com.matthewedevelopment.ps.mechanics.item.ItemRarity;
import com.matthewedevelopment.ps.mechanics.item.builder.ItemBuilder;
import com.matthewedevelopment.ps.mechanics.item.tier.ItemTier;
import com.matthewedevelopment.ps.mechanics.item.tier.ItemType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Matthew E on 4/2/2017.
 */
public class ItemGenerator {
    public static ItemStack createDrop(ItemTier tier, ItemType item, ItemRarity rarity) {
        String name = "";
        String rare = "";
        ItemStack is = new ItemStack(Material.AIR);
        final List<String> lore = new ArrayList<>();
        final Random random = new Random();
        final int armdps = random.nextInt(2) + 1;
        final int nrghp = random.nextInt(2) + 1;
        final int elem = random.nextInt(12) + 1;
        final int pure = random.nextInt(4) + 1;
        final int life = random.nextInt(4) + 1;
        final int crit = random.nextInt(4) + 1;
        final int acc = random.nextInt(4) + 1;
        final int dodge = random.nextInt(3) + 1;
        final int block = random.nextInt(3) + 1;
        final int vit = random.nextInt(3) + 1;
        final int str = random.nextInt(3) + 1;
        final int intel = random.nextInt(3) + 1;
        int hp = 0;
        int mindmg = 0;
        int maxdmg = 0;
        int dpsamt = 0;
        int dodgeamt = 0;
        int blockamt = 0;
        int vitamt = 0;
        int intamt = 0;
        int stramt = 0;
        int elemamt = 0;
        int pureamt = 0;
        int lifeamt = 0;
        int critamt = 0;
        int accamt = 0;
        int hps = 0;
        int nrg = 0;
        if (rarity.getId() == 3) {
            rare = new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.ITALIC).append("Unique").toString();
        } else if (rarity.getId() == 2) {
            rare = new StringBuilder().append(ChatColor.AQUA).append(ChatColor.ITALIC).append("Rare").toString();
        } else if (rarity.getId() == 1) {
            rare = new StringBuilder().append(ChatColor.GREEN).append(ChatColor.ITALIC).append("Uncommon").toString();
        } else if (rarity.getId() == 0) {
            rare = new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("Common").toString();
        }
        if (tier.getTierNumber() == 1) {
            tier = ItemTier.TIER_1;
            if (rarity == ItemRarity.COMMON) {
                dpsamt = 1;
                hp = random.nextInt(21) + 10;
                final int min_min_dmg = 1;
                final int max_min_dmg = 3;
                final int max_max_dmg = 6;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNCOMMON) {
                dpsamt = random.nextInt(3) + 1;
                hp = random.nextInt(30) + 31;
                final int min_min_dmg = 3;
                final int max_min_dmg = 6;
                final int max_max_dmg = 9;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.RARE) {
                dpsamt = random.nextInt(3) + 1;
                hp = random.nextInt(30) + 61;
                final int min_min_dmg = 6;
                final int max_min_dmg = 10;
                final int max_max_dmg = 24;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNIQUE) {
                dpsamt = random.nextInt(3) + 1;
                hp = random.nextInt(30) + 91;
                final int min_min_dmg = 9;
                final int max_min_dmg = 16;
                final int max_max_dmg = 25;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            hps = random.nextInt(11) + 5;
            nrg = random.nextInt(3) + 1;
            dodgeamt = random.nextInt(5) + 1;
            blockamt = random.nextInt(5) + 1;
            vitamt = random.nextInt(15) + 1;
            stramt = random.nextInt(15) + 1;
            intamt = random.nextInt(15) + 1;
            elemamt = random.nextInt(4) + 1;
            pureamt = random.nextInt(4) + 1;
            lifeamt = random.nextInt(30) + 1;
            critamt = random.nextInt(3) + 1;
            accamt = random.nextInt(10) + 1;
            if (item == ItemType.STAFF) {
                name = "Staff";
                is.setType(Material.WOOD_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Spear";
                is.setType(Material.WOOD_SPADE);
            }
            if (item == ItemType.SWORD) {
                name = "Shortsword";
                is.setType(Material.WOOD_SWORD);
            }
            if (item == ItemType.AXE) {
                name = "Hatchet";
                is.setType(Material.WOOD_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Leather Coif";
                is.setType(Material.LEATHER_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Leather Chestplate";
                is.setType(Material.LEATHER_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Leather Leggings";
                is.setType(Material.LEATHER_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Leather Boots";
                is.setType(Material.LEATHER_BOOTS);
            }
        }
        if (tier == ItemTier.TIER_2) {
            tier = ItemTier.TIER_2;
            if (rarity == ItemRarity.COMMON) {
                dpsamt = random.nextInt(3) + 1;
                hp = random.nextInt(41) + 70;
                final int min_min_dmg = 10;
                final int max_min_dmg = 13;
                final int max_max_dmg = 18;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNCOMMON) {
                dpsamt = random.nextInt(3) + 3;
                hp = random.nextInt(80) + 111;
                final int min_min_dmg = 16;
                final int max_min_dmg = 19;
                final int max_max_dmg = 25;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.RARE) {
                dpsamt = random.nextInt(3) + 5;
                hp = random.nextInt(50) + 191;
                final int min_min_dmg = 20;
                final int max_min_dmg = 31;
                final int max_max_dmg = 66;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNIQUE) {
                dpsamt = random.nextInt(3) + 5;
                hp = random.nextInt(70) + 241;
                final int min_min_dmg = 22;
                final int max_min_dmg = 36;
                final int max_max_dmg = 71;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            hps = random.nextInt(16) + 10;
            nrg = random.nextInt(3) + 1;
            dodgeamt = random.nextInt(8) + 1;
            blockamt = random.nextInt(8) + 1;
            vitamt = random.nextInt(35) + 1;
            stramt = random.nextInt(35) + 1;
            intamt = random.nextInt(35) + 1;
            elemamt = random.nextInt(9) + 1;
            pureamt = random.nextInt(9) + 1;
            lifeamt = random.nextInt(15) + 1;
            critamt = random.nextInt(6) + 1;
            accamt = random.nextInt(12) + 1;
            if (item == ItemType.STAFF) {
                name = "Battletaff";
                is.setType(Material.STONE_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Halberd";
                is.setType(Material.STONE_SPADE);
            }
            if (item == ItemType.SWORD) {
                name = "Broadsword";
                is.setType(Material.STONE_SWORD);
            }
            if (item == ItemType.AXE) {
                name = "Great Axe";
                is.setType(Material.STONE_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Medium Helmet";
                is.setType(Material.CHAINMAIL_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Chainmail";
                is.setType(Material.CHAINMAIL_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Chainmail Leggings";
                is.setType(Material.CHAINMAIL_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Chainmail Boots";
                is.setType(Material.CHAINMAIL_BOOTS);
            }
        }
        if (tier == ItemTier.TIER_3) {
            tier = ItemTier.TIER_3;
            if (rarity == ItemRarity.COMMON) {
                dpsamt = random.nextInt(3) + 5;
                hp = random.nextInt(251) + 200;
                final int min_min_dmg = 25;
                final int max_min_dmg = 31;
                final int max_max_dmg = 46;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNCOMMON) {
                dpsamt = random.nextInt(5) + 6;
                hp = random.nextInt(200) + 451;
                final int min_min_dmg = 30;
                final int max_min_dmg = 36;
                final int max_max_dmg = 71;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.RARE) {
                dpsamt = random.nextInt(3) + 8;
                hp = random.nextInt(99) + 651;
                final int min_min_dmg = 50;
                final int max_min_dmg = 91;
                final int max_max_dmg = 151;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNIQUE) {
                dpsamt = random.nextInt(4) + 8;
                hp = random.nextInt(101) + 750;
                final int min_min_dmg = 60;
                final int max_min_dmg = 101;
                final int max_max_dmg = 161;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            hps = random.nextInt(21) + 35;
            nrg = random.nextInt(3) + 2;
            dodgeamt = random.nextInt(10) + 1;
            blockamt = random.nextInt(10) + 1;
            vitamt = random.nextInt(75) + 1;
            stramt = random.nextInt(75) + 1;
            intamt = random.nextInt(75) + 1;
            elemamt = random.nextInt(15) + 1;
            pureamt = random.nextInt(15) + 1;
            lifeamt = random.nextInt(12) + 1;
            critamt = random.nextInt(8) + 1;
            accamt = random.nextInt(25) + 1;
            if (item == ItemType.STAFF) {
                name = "Wizard Staff";
                is.setType(Material.IRON_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Magic Polearm";
                is.setType(Material.IRON_SPADE);
            }
            if (item == ItemType.SWORD) {
                name = "Magic Sword";
                is.setType(Material.IRON_SWORD);
            }
            if (item == ItemType.AXE) {
                name = "War Axe";
                is.setType(Material.IRON_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Full Helmet";
                is.setType(Material.IRON_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Platemail";
                is.setType(Material.IRON_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Platemail Leggings";
                is.setType(Material.IRON_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Platemail Boots";
                is.setType(Material.IRON_BOOTS);
            }
        }
        if (tier == ItemTier.TIER_4) {
            tier = ItemTier.TIER_4;
            if (rarity == ItemRarity.COMMON) {
                dpsamt = random.nextInt(3) + 8;
                hp = random.nextInt(311) + 650;
                final int min_min_dmg = 65;
                final int max_min_dmg = 81;
                final int max_max_dmg = 126;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNCOMMON) {
                dpsamt = random.nextInt(3) + 10;
                hp = random.nextInt(490) + 961;
                final int min_min_dmg = 70;
                final int max_min_dmg = 86;
                final int max_max_dmg = 156;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.RARE) {
                dpsamt = random.nextInt(3) + 11;
                hp = random.nextInt(850) + 1451;
                final int min_min_dmg = 90;
                final int max_min_dmg = 111;
                final int max_max_dmg = 221;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNIQUE) {
                dpsamt = random.nextInt(3) + 12;
                hp = random.nextInt(500) + 2301;
                final int min_min_dmg = 110;
                final int max_min_dmg = 151;
                final int max_max_dmg = 241;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            hps = random.nextInt(16) + 60;
            nrg = random.nextInt(3) + 3;
            dodgeamt = random.nextInt(12) + 1;
            blockamt = random.nextInt(12) + 1;
            vitamt = random.nextInt(115) + 1;
            stramt = random.nextInt(115) + 1;
            intamt = random.nextInt(115) + 1;
            elemamt = random.nextInt(25) + 1;
            pureamt = random.nextInt(25) + 1;
            lifeamt = random.nextInt(10) + 1;
            critamt = random.nextInt(10) + 1;
            accamt = random.nextInt(28) + 1;
            if (item == ItemType.STAFF) {
                name = "Ancient Staff";
                is.setType(Material.DIAMOND_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Ancient Polearm";
                is.setType(Material.DIAMOND_SPADE);
            }
            if (item == ItemType.SWORD) {
                name = "Ancient Sword";
                is.setType(Material.DIAMOND_SWORD);
            }
            if (item == ItemType.AXE) {
                name = "Ancient Axe";
                is.setType(Material.DIAMOND_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Ancient Full Helmet";
                is.setType(Material.DIAMOND_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Magic Platemail";
                is.setType(Material.DIAMOND_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Magic Platemail Leggings";
                is.setType(Material.DIAMOND_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Magic Platemail Boots";
                is.setType(Material.DIAMOND_BOOTS);
            }
        }
        if (tier == ItemTier.TIER_5) {
            tier = ItemTier.TIER_5;
            if (rarity == ItemRarity.COMMON) {
                dpsamt = random.nextInt(3) + 11;
                hp = random.nextInt(1051) + 1450;
                final int min_min_dmg = 130;
                final int max_min_dmg = 141;
                final int max_max_dmg = 211;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNCOMMON) {
                dpsamt = random.nextInt(3) + 13;
                hp = random.nextInt(1300) + 2501;
                final int min_min_dmg = 150;
                final int max_min_dmg = 161;
                final int max_max_dmg = 261;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.RARE) {
                dpsamt = random.nextInt(3) + 16;
                hp = random.nextInt(1700) + 3801;
                final int min_min_dmg = 160;
                final int max_min_dmg = 231;
                final int max_max_dmg = 408;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            if (rarity == ItemRarity.UNIQUE) {
                dpsamt = random.nextInt(3) + 17;
                hp = random.nextInt(500) + 5501;
                final int min_min_dmg = 190;
                final int max_min_dmg = 251;
                final int max_max_dmg = 451;
                mindmg = random.nextInt(max_min_dmg - min_min_dmg) + min_min_dmg;
                maxdmg = random.nextInt(max_max_dmg - mindmg) + mindmg;
            }
            hps = random.nextInt(41) + 80;
            nrg = random.nextInt(3) + 3;
            dodgeamt = random.nextInt(12) + 1;
            blockamt = random.nextInt(12) + 1;
            vitamt = random.nextInt(315) + 1;
            stramt = random.nextInt(315) + 1;
            intamt = random.nextInt(315) + 1;
            elemamt = random.nextInt(55) + 1;
            pureamt = random.nextInt(55) + 1;
            lifeamt = random.nextInt(8) + 1;
            critamt = random.nextInt(11) + 1;
            accamt = random.nextInt(35) + 1;
            if (item == ItemType.STAFF) {
                name = "Legendary Staff";
                is.setType(Material.GOLD_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Legendary Polearm";
                is.setType(Material.GOLD_SPADE);
            }
            if (item == ItemType.SWORD) {
                name = "Legendary Sword";
                is.setType(Material.GOLD_SWORD);
            }
            if (item == ItemType.AXE) {
                name = "Legendary Axe";
                is.setType(Material.GOLD_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Legendary Full Helmet";
                is.setType(Material.GOLD_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Legendary Platemail";
                is.setType(Material.GOLD_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Legendary Platemail Leggings";
                is.setType(Material.GOLD_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Legendary Platemail Boots";
                is.setType(Material.GOLD_BOOTS);
            }
        }
        if (item == ItemType.STAFF || item == ItemType.POLEARM) {
            mindmg = (int) (mindmg * 0.5);
            if (mindmg < 1) {
                mindmg = 1;
            }
            maxdmg = (int) (maxdmg * 0.5);
            if (maxdmg < 1) {
                maxdmg = 1;
            }
            lore.add(ChatColor.RED + "DMG: " + mindmg + " - " + maxdmg);
            ItemBuilder itemBuilder = new ItemBuilder(is);
            itemBuilder.setTag("damage", mindmg + "-" + maxdmg);
            if (life == 1) {
                lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
                name = "Vampyric " + name;
                itemBuilder.setTag("lifesteal", lifeamt);
            } else {
                itemBuilder.setTag("lifesteal", 0);
            }
            if (crit == 1) {
                lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + "%");
                name = "Deadly " + name;
                itemBuilder.setTag("crit", critamt);
            } else {
                itemBuilder.setTag("crit", 0);
            }
            if (elem == 3) {
                lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
                name = String.valueOf(name) + " of Ice";
                itemBuilder.setTag("ice", elemamt);
            } else {
                itemBuilder.setTag("ice", 0);
            }
            if (elem == 2) {
                lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
                name = String.valueOf(name) + " of Poison";
                itemBuilder.setTag("poison", elemamt);
            } else {
                itemBuilder.setTag("poison", 0);
            }
            if (elem == 1) {
                lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
                name = String.valueOf(name) + " of Fire";
                itemBuilder.setTag("fire", elemamt);
            } else {
                itemBuilder.setTag("fire", 0);
            }
            is = itemBuilder.build();
        }
        ItemBuilder itemBuilder = new ItemBuilder(is);
        itemBuilder.setTag("damage", mindmg + "-" + maxdmg);
        if (acc == 1) {
            lore.add(ChatColor.RED + "ACCURACY: " + accamt + "%");
            name = "Accurate " + name;
            itemBuilder.setTag("accuracy", accamt);
        } else {
            itemBuilder.setTag("accuracy", 0);
        }
        if (life == 1) {
            lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
            name = "Vampyric " + name;
            itemBuilder.setTag("lifesteal", lifeamt);
        } else {
            itemBuilder.setTag("lifesteal", 0);
        }
        if (crit == 1) {
            lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + "%");
            name = "Deadly " + name;
            itemBuilder.setTag("crit", critamt);
        } else {
            itemBuilder.setTag("crit", 0);
        }
        if (elem == 3) {
            lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            name = String.valueOf(name) + " of Ice";
            itemBuilder.setTag("ice", elemamt);
        } else {
            itemBuilder.setTag("ice", 0);
        }
        if (elem == 2) {
            lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            name = String.valueOf(name) + " of Poison";
            itemBuilder.setTag("poison", elemamt);
        } else {
            itemBuilder.setTag("poison", 0);
        }
        if (elem == 1) {
            lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            name = String.valueOf(name) + " of Fire";
            itemBuilder.setTag("fire", elemamt);
        } else {
            itemBuilder.setTag("fire", 0);
        }
        if (item == ItemType.AXE) {
            lore.add(ChatColor.RED + "DMG: " + (int) (mindmg * 1.2) + " - " + (int) (maxdmg * 1.2));
            itemBuilder.setTag("poison", 0);

            if (pure == 1) {
                lore.add(ChatColor.RED + "PURE DMG: +" + pureamt);
                name = "Pure " + name;
            }
            if (life == 1) {
                lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
                name = "Vampyric " + name;
            }
            if (crit == 1) {
                lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + "%");
                name = "Deadly " + name;
            }
            if (elem == 3) {
                lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
                name = String.valueOf(name) + " of Ice";
            }
            if (elem == 2) {
                lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
                name = String.valueOf(name) + " of Poison";
            }
            if (elem == 1) {
                lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
                name = String.valueOf(name) + " of Fire";
            }
        }
        is = itemBuilder.build();
        if (item == ItemType.BOOTS || item == ItemType.HELMET) {
            dpsamt = (int) (dpsamt * 0.5);
            if (dpsamt < 1) {
                dpsamt = 1;
            }
            hp = (int) (hp * 0.5);
            if (hp < 1) {
                hp = 1;
            }
            if (armdps == 1) {
                lore.add(ChatColor.RED + "ARMOR: " + dpsamt + " - " + dpsamt + "%");
            }
            if (armdps == 2) {
                lore.add(ChatColor.RED + "DPS: " + dpsamt + " - " + dpsamt + "%");
            }
            lore.add(ChatColor.RED + "HP: +" + hp);
            if (nrghp == 2) {
                lore.add(ChatColor.RED + "ENERGY REGEN: +" + nrg + "%");
            }
            if (nrghp == 1) {
                lore.add(ChatColor.RED + "HP REGEN: +" + hps + " HP/s");
            }
            if (intel == 1) {
                lore.add(ChatColor.RED + "INT: +" + intamt);
            }
            if (str == 1) {
                lore.add(ChatColor.RED + "STR: +" + stramt);
            }
            if (vit == 1) {
                lore.add(ChatColor.RED + "VIT: +" + vitamt);
            }
            if (dodge == 1) {
                lore.add(ChatColor.RED + "DODGE: " + dodgeamt + "%");
                name = "Agile " + name;
            }
            if (nrghp == 1) {
                name = "Mending " + name;
            }
            if (block == 1) {
                lore.add(ChatColor.RED + "BLOCK: " + blockamt + "%");
                name = "Protective " + name;
            }
            if (nrghp == 2) {
                name = String.valueOf(name) + " of Fortitude";
            }
        }
        if (item == ItemType.CHESTPLATE || item == ItemType.LEGGINGS) {
            if (armdps == 1) {
                lore.add(ChatColor.RED + "ARMOR: " + dpsamt + " - " + dpsamt + "%");
            }
            if (armdps == 2) {
                lore.add(ChatColor.RED + "DPS: " + dpsamt + " - " + dpsamt + "%");
            }
            lore.add(ChatColor.RED + "HP: +" + hp);
            if (nrghp == 2) {
                lore.add(ChatColor.RED + "ENERGY REGEN: +" + nrg + "%");
            }
            if (nrghp == 1) {
                lore.add(ChatColor.RED + "HP REGEN: +" + hps + " HP/s");
            }
            if (intel == 1) {
                lore.add(ChatColor.RED + "INT: +" + intamt);
            }
            if (str == 1) {
                lore.add(ChatColor.RED + "STR: +" + stramt);
            }
            if (vit == 1) {
                lore.add(ChatColor.RED + "VIT: +" + vitamt);
            }
            if (dodge == 1) {
                lore.add(ChatColor.RED + "DODGE: " + dodgeamt + "%");
                name = "Agile " + name;
            }
            if (nrghp == 1) {
                name = "Mending " + name;
            }
            if (block == 1) {
                lore.add(ChatColor.RED + "BLOCK: " + blockamt + "%");
                name = "Protective " + name;
            }
            if (nrghp == 2) {
                name = String.valueOf(name) + " of Fortitude";
            }
        }
        lore.add(rare);
        if (tier == ItemTier.TIER_1) {
            name = ChatColor.WHITE + name;
        }
        if (tier == ItemTier.TIER_2) {
            name = ChatColor.GREEN + name;
        }
        if (tier == ItemTier.TIER_3) {
            name = ChatColor.AQUA + name;
        }
        if (tier == ItemTier.TIER_4) {
            name = ChatColor.LIGHT_PURPLE + name;
        }
        if (tier == ItemTier.TIER_5) {
            name = ChatColor.YELLOW + name;
        }
        final ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        im.setLore(lore);
        is.setItemMeta(im);
        return new ItemBuilder(is).build();
    }

    public static ItemStack randomizeStats(final ItemStack is) {
        String name = "";
        String rare = "";
        int tier = ItemTier.getTier(is).getTierNumber();
        final ItemType item =ItemType.getItemType(is);
        final List<String> oldlore = (List<String>)is.getItemMeta().getLore();
        final List<String> lore = new ArrayList<String>();
        final Random random = new Random();
        final int elem = random.nextInt(9) + 1;
        final int pure = random.nextInt(3) + 1;
        final int life = random.nextInt(3) + 1;
        final int crit = random.nextInt(3) + 1;
        final int acc = random.nextInt(3) + 1;
        final int dodge = random.nextInt(3) + 1;
        final int block = random.nextInt(3) + 1;
        final int vit = random.nextInt(3) + 1;
        final int str = random.nextInt(3) + 1;
        final int intel = random.nextInt(3) + 1;
        int dodgeamt = 0;
        int blockamt = 0;
        int vitamt = 0;
        int stramt = 0;
        int intamt = 0;
        int elemamt = 0;
        int pureamt = 0;
        int lifeamt = 0;
        int critamt = 0;
        int accamt = 0;
        rare = oldlore.get(oldlore.size() - 1);
        if (tier == 1) {
            tier = 1;
            dodgeamt = random.nextInt(5) + 1;
            blockamt = random.nextInt(5) + 1;
            vitamt = random.nextInt(15) + 1;
            stramt = random.nextInt(15) + 1;
            intamt = random.nextInt(15) + 1;
            elemamt = random.nextInt(4) + 1;
            pureamt = random.nextInt(4) + 1;
            lifeamt = random.nextInt(30) + 1;
            critamt = random.nextInt(3) + 1;
            accamt = random.nextInt(10) + 1;
            if (item == ItemType.STAFF) {
                name = "Staff";
                is.setType(Material.WOOD_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Spear";
                is.setType(Material.WOOD_SPADE);
            }
            if (item == ItemType.SWORD) {
                name = "Shortsword";
                is.setType(Material.WOOD_SWORD);
            }
            if (item == ItemType.AXE) {
                name = "Hatchet";
                is.setType(Material.WOOD_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Leather Coif";
                is.setType(Material.LEATHER_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Leather Chestplate";
                is.setType(Material.LEATHER_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Leather Leggings";
                is.setType(Material.LEATHER_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Leather Boots";
                is.setType(Material.LEATHER_BOOTS);
            }
        }
        if (tier == 2) {
            tier = 2;
            dodgeamt = random.nextInt(8) + 1;
            blockamt = random.nextInt(8) + 1;
            vitamt = random.nextInt(35) + 1;
            stramt = random.nextInt(35) + 1;
            intamt = random.nextInt(35) + 1;
            elemamt = random.nextInt(9) + 1;
            pureamt = random.nextInt(9) + 1;
            lifeamt = random.nextInt(15) + 1;
            critamt = random.nextInt(6) + 1;
            accamt = random.nextInt(12) + 1;
            if (item == ItemType.STAFF) {
                name = "Battletaff";
                is.setType(Material.STONE_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Halberd";
                is.setType(Material.STONE_SPADE);
            }
            if (item == ItemType.SWORD) {
                name = "Broadsword";
                is.setType(Material.STONE_SWORD);
            }
            if (item == ItemType.AXE) {
                name = "Great Axe";
                is.setType(Material.STONE_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Medium Helmet";
                is.setType(Material.CHAINMAIL_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Chainmail";
                is.setType(Material.CHAINMAIL_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Chainmail Leggings";
                is.setType(Material.CHAINMAIL_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Chainmail Boots";
                is.setType(Material.CHAINMAIL_BOOTS);
            }
        }
        if (tier == 3) {
            tier = 3;
            dodgeamt = random.nextInt(10) + 1;
            blockamt = random.nextInt(10) + 1;
            vitamt = random.nextInt(75) + 1;
            stramt = random.nextInt(75) + 1;
            intamt = random.nextInt(75) + 1;
            elemamt = random.nextInt(15) + 1;
            pureamt = random.nextInt(15) + 1;
            lifeamt = random.nextInt(12) + 1;
            critamt = random.nextInt(8) + 1;
            accamt = random.nextInt(25) + 1;
            if (item == ItemType.STAFF) {
                name = "Wizard Staff";
                is.setType(Material.IRON_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Magic Polearm";
                is.setType(Material.IRON_SPADE);
            }
            if (item == ItemType.SWORD) {
                name = "Magic Sword";
                is.setType(Material.IRON_SWORD);
            }
            if (item ==ItemType.AXE) {
                name = "War Axe";
                is.setType(Material.IRON_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Full Helmet";
                is.setType(Material.IRON_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Platemail";
                is.setType(Material.IRON_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Platemail Leggings";
                is.setType(Material.IRON_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Platemail Boots";
                is.setType(Material.IRON_BOOTS);
            }
        }
        if (tier == 4) {
            tier = 4;
            dodgeamt = random.nextInt(12) + 1;
            blockamt = random.nextInt(12) + 1;
            vitamt = random.nextInt(115) + 1;
            stramt = random.nextInt(115) + 1;
            intamt = random.nextInt(115) + 1;
            elemamt = random.nextInt(25) + 1;
            pureamt = random.nextInt(25) + 1;
            lifeamt = random.nextInt(10) + 1;
            critamt = random.nextInt(10) + 1;
            accamt = random.nextInt(28) + 1;
            if (item == ItemType.STAFF) {
                name = "Ancient Staff";
                is.setType(Material.DIAMOND_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Ancient Polearm";
                is.setType(Material.DIAMOND_SPADE);
            }
            if (item == ItemType.SWORD) {
                name = "Ancient Sword";
                is.setType(Material.DIAMOND_SWORD);
            }
            if (item == ItemType.AXE) {
                name = "Ancient Axe";
                is.setType(Material.DIAMOND_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Ancient Full Helmet";
                is.setType(Material.DIAMOND_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Magic Platemail";
                is.setType(Material.DIAMOND_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Magic Platemail Leggings";
                is.setType(Material.DIAMOND_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Magic Platemail Boots";
                is.setType(Material.DIAMOND_BOOTS);
            }
        }
        if (tier == 5) {
            tier = 5;
            dodgeamt = random.nextInt(12) + 1;
            blockamt = random.nextInt(12) + 1;
            vitamt = random.nextInt(315) + 1;
            stramt = random.nextInt(315) + 1;
            intamt = random.nextInt(315) + 1;
            elemamt = random.nextInt(55) + 1;
            pureamt = random.nextInt(55) + 1;
            lifeamt = random.nextInt(8) + 1;
            critamt = random.nextInt(11) + 1;
            accamt = random.nextInt(35) + 1;
            if (item == ItemType.STAFF) {
                name = "Legendary Staff";
                is.setType(Material.GOLD_HOE);
            }
            if (item == ItemType.POLEARM) {
                name = "Legendary Polearm";
                is.setType(Material.GOLD_SPADE);
            }
            if (item ==ItemType.SWORD) {
                name = "Legendary Sword";
                is.setType(Material.GOLD_SWORD);
            }
            if (item == ItemType.AXE) {
                name = "Legendary Axe";
                is.setType(Material.GOLD_AXE);
            }
            if (item == ItemType.HELMET) {
                name = "Legendary Full Helmet";
                is.setType(Material.GOLD_HELMET);
            }
            if (item == ItemType.CHESTPLATE) {
                name = "Legendary Platemail";
                is.setType(Material.GOLD_CHESTPLATE);
            }
            if (item == ItemType.LEGGINGS) {
                name = "Legendary Platemail Leggings";
                is.setType(Material.GOLD_LEGGINGS);
            }
            if (item == ItemType.BOOTS) {
                name = "Legendary Platemail Boots";
                is.setType(Material.GOLD_BOOTS);
            }
        }
        if (item == ItemType.STAFF || item == ItemType.POLEARM || item == ItemType.SWORD || item == ItemType.AXE) {
            lore.add(oldlore.get(0));
            if (item == ItemType.AXE && pure == 1) {
                lore.add(ChatColor.RED + "PURE DMG: +" + pureamt);
                name = "Pure " + name;
            }
            if (item == ItemType.SWORD && acc == 1) {
                lore.add(ChatColor.RED + "ACCURACY: " + accamt + "%");
                name = "Accurate " + name;
            }
            if (life == 1) {
                lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
                name = "Vampyric " + name;
            }
            if (crit == 1) {
                lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + "%");
                name = "Deadly " + name;
            }
            if (elem == 3) {
                lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
                name = String.valueOf(name) + " of Ice";
            }
            if (elem == 2) {
                lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
                name = String.valueOf(name) + " of Poison";
            }
            if (elem == 1) {
                lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
                name = String.valueOf(name) + " of Fire";
            }
        }
        if (item == ItemType.BOOTS || item == ItemType.CHESTPLATE || item == ItemType.LEGGINGS || item == ItemType.HELMET) {
            lore.add(oldlore.get(0));
            lore.add(oldlore.get(1));
            lore.add(oldlore.get(2));
            if (intel == 1) {
                lore.add(ChatColor.RED + "INT: +" + intamt);
            }
            if (str == 1) {
                lore.add(ChatColor.RED + "STR: +" + stramt);
            }
            if (vit == 1) {
                lore.add(ChatColor.RED + "VIT: +" + vitamt);
            }
            if (dodge == 1) {
                lore.add(ChatColor.RED + "DODGE: " + dodgeamt + "%");
                name = "Agile " + name;
            }
            if (oldlore.get(2).contains("HP REGEN:")) {
                name = "Mending " + name;
            }
            if (block == 1) {
                lore.add(ChatColor.RED + "BLOCK: " + blockamt + "%");
                name = "Protective " + name;
            }
            if (oldlore.get(2).contains("ENERGY REGEN:")) {
                name = String.valueOf(name) + " of Fortitude";
            }
        }
        lore.add(rare);
        if (tier == 1) {
            name = ChatColor.WHITE + name;
        }
        if (tier == 2) {
            name = ChatColor.GREEN + name;
        }
        if (tier == 3) {
            name = ChatColor.AQUA + name;
        }
        if (tier == 4) {
            name = ChatColor.LIGHT_PURPLE + name;
        }
        if (tier == 5) {
            name = ChatColor.YELLOW + name;
        }
        //TODO
//        if (Enchants.getPlus(is) > 0) {
//            name = ChatColor.RED + "[+" + Enchants.getPlus(is) + "] " + name;
//        }
        final ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        im.setLore((List)lore);
        is.setItemMeta(im);
        return new ItemBuilder(is).build();
    }
}
