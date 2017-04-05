package com.matthewedevelopment.ps.mechanics.item.builder;

import com.matthewedevelopment.ps.mechanics.item.tier.ItemTier;
import net.minecraft.server.v1_9_R2.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Created by Matthew E on 4/1/2017.
 */
public interface IItemBuilder {

    ItemStack build();

    IItemBuilder setTier(ItemTier tier);

    IItemBuilder setTag(String key, Object value);

    IItemBuilder setItemMeta(ItemMeta itemMeta);

    IItemBuilder setFood();

    IItemBuilder setPotion();

    ItemMeta getItemMeta();

    IItemBuilder setAmount(int amount);

    IItemBuilder setDisplayName(String name);

    IItemBuilder setData(int data);

    IItemBuilder setLore(List<String> loreList);

    IItemBuilder addLore(String lore);

    IItemBuilder addItemFlag(ItemFlag itemFlag);

    IItemBuilder removeItemFlag(ItemFlag itemFlag);

    IItemBuilder setType(Material type);

    NBTTagCompound getTag();
}
