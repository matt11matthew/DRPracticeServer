package com.matthewedevelopment.ps.mechanics.player.ps;

import com.matthewedevelopment.ps.mechanics.item.tier.ItemType;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew E on 4/2/2017.
 */
public class PsAttribute {

    public interface AttributeType {
        int getId();

        String getName();

        String getNBTName();

        boolean isPercentage();

        boolean isRange();
    }

    private static boolean isArmor(ItemStack armor) {
        return (ItemType.getItemType(armor).isArmor());
    }

    public enum WeaponAttributeType implements AttributeType {
        DAMAGE(0, "DMG", "damage", false, true),
        PURE_DAMAGE(1, "PURE DMG", "pureDamage"),
        CRITICAL_HIT(2, "CRITICAL HIT", "criticalHit", true), //Percentage
        ARMOR_PENETRATION(3, "ARMOR PENETRATION", "armorPenetration", true), //Percentage
        VS_MONSTERS(4, "vs. MONSTERS", "vsMonsters", true), //Percentage
        VS_PLAYER(5, "vs. PLAYERS", "vsPlayers", true), //Percentage
        LIFE_STEAL(6, "LIFE STEAL", "lifesteal", true), //Percentage
        VITALITY(7, "VIT", "vitality"),
        DEXTERITY(8, "DEX", "dexterity"),
        ICE_DAMAGE(9, "ICE DMG", "iceDamage"),
        FIRE_DAMAGE(10, "FIRE DMG", "fireDamage"),
        POISON_DAMAGE(11, "POISON DMG", "poisonDamage"),
        ACCURACY(12, "ACCURACY", "accuracy", true), //Percentage
        STRENGTH(13, "STR", "strength"),
        INTELLECT(14, "INT", "intellect"),
        KNOCKBACK(15, "KNOCKBACK", "knockback", true), //Percentage
        BLIND(16, "BLIND", "blind", true), //Percentage
        SLOW(17, "SLOW", "slow", true); //Percentage

        private int id;
        private String name;
        private String NBTName;
        private boolean isPercentage;
        private boolean isRange;

        /**
         * @return the isRange
         */
        public boolean isRange() {
            return isRange;
        }

        /**
         * @return the isPercentage
         */
        public boolean isPercentage() {
            return isPercentage;
        }

        WeaponAttributeType(int id, String name, String NBTName) {
            this.id = id;
            this.name = name;
            this.NBTName = NBTName;
            this.isPercentage = false;
            this.isRange = false;
        }

        WeaponAttributeType(int id, String name, String NBTName, boolean percentage) {
            this.id = id;
            this.name = name;
            this.NBTName = NBTName;
            this.isPercentage = percentage;
            this.isRange = false;
        }

        WeaponAttributeType(int id, String name, String NBTName, boolean percentage, boolean range) {
            this.id = id;
            this.name = name;
            this.NBTName = NBTName;
            this.isPercentage = percentage;
            this.isRange = range;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getNBTName() {
            return NBTName;
        }

        public static WeaponAttributeType getById(int id) {
            for (WeaponAttributeType at : values()) {
                if (at.id == id) {
                    return at;
                }
            }
            return null;
        }

        public static WeaponAttributeType getByName(String name) {
            for (WeaponAttributeType at : values()) {
                if (at.getName().equals(name)) {
                    return at;
                }
            }
            return null;
        }

        public static WeaponAttributeType getByNBTName(String name) {
            for (WeaponAttributeType at : values()) {
                if (at.getNBTName().equals(name)) {
                    return at;
                }
            }
            return null;
        }
    }

    public enum ArmorAttributeType implements AttributeType {
        ARMOR(0, "ARMOR", "armor", true, true), //Percentage
        HEALTH_POINTS(1, "HP", "healthPoints"),
        HEALTH_REGEN(2, "HP REGEN", "healthRegen"),
        ENERGY_REGEN(3, "ENERGY REGEN", "energyRegen", true), //Percentage
        INTELLECT(4, "INT", "intellect"),
        FIRE_RESISTANCE(5, "FIRE RESISTANCE", "fireResistance", true), //Percentage
        BLOCK(6, "BLOCK", "block", true), //Percentage
        LUCK(7, "LUCK", "luck", true), //Percentage
        THORNS(8, "THORNS", "thorns", true), //Percentage
        STRENGTH(9, "STR", "strength"),
        VITALITY(10, "VIT", "vitality"),
        DODGE(11, "DODGE", "dodge", true), //Percentage
        DAMAGE(12, "DPS", "dps", true, true), //Percentage
        DEXTERITY(13, "DEX", "dexterity"),
        REFLECTION(14, "REFLECTION", "reflection", true), //Percentage
        GEM_FIND(15, "GEM FIND", "gemFind", true), //Percentage
        ITEM_FIND(16, "ITEM FIND", "itemFind", true), //Percentage
        ICE_RESISTANCE(17, "ICE RESISTANCE", "iceResistance", true), //Percentage
        POISON_RESISTANCE(18, "POISON RESISTANCE", "poisonResistance", true); //Percentage

        private int id;
        private String name;
        private String NBTName;
        private boolean isPercentage;
        private boolean isRange;

        /**
         * @return the isRange
         */
        public boolean isRange() {
            return isRange;
        }

        /**
         * @return the isPercentage
         */
        public boolean isPercentage() {
            return isPercentage;
        }

        ArmorAttributeType(int id, String name, String NBTName) {
            this.id = id;
            this.name = name;
            this.NBTName = NBTName;
            this.isPercentage = false;
            this.isRange = false;
        }

        ArmorAttributeType(int id, String name, String NBTName, boolean percentage) {
            this.id = id;
            this.name = name;
            this.NBTName = NBTName;
            this.isPercentage = percentage;
            this.isRange = false;
        }

        ArmorAttributeType(int id, String name, String NBTName, boolean percentage, boolean range) {
            this.id = id;
            this.name = name;
            this.NBTName = NBTName;
            this.isPercentage = percentage;
            this.isRange = range;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getNBTName() {
            return NBTName;
        }

        public static ArmorAttributeType getById(int id) {
            for (ArmorAttributeType at : values()) {
                if (at.getId() == id) {
                    return at;
                }
            }
            return null;
        }

        public static ArmorAttributeType getByName(String name) {
            for (ArmorAttributeType at : values()) {
                if (at.getName().equals(name)) {
                    return at;
                }
            }
            return null;
        }

        public static ArmorAttributeType getByNBTName(String name) {
            for (ArmorAttributeType at : values()) {
                if (at.getNBTName().equals(name)) {
                    return at;
                }
            }
            return null;
        }
    }

}
