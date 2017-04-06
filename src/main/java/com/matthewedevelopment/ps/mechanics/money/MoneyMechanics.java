package com.matthewedevelopment.ps.mechanics.money;

import com.matthewedevelopment.ps.api.mechanic.GameMechanic;
import com.matthewedevelopment.ps.mechanics.item.builder.IItemBuilder;
import com.matthewedevelopment.ps.mechanics.item.builder.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.UUID;

/**
 * Created by Matthew E on 4/5/2017.
 */
public class MoneyMechanics extends GameMechanic {
    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public int getMoneyInInventory(Player player) {
        PlayerInventory inventory = player.getInventory();
        int money = 0;
        for (ItemStack itemStack : inventory.getContents()) {
            if ((itemStack == null) || (itemStack.getType() == Material.AIR)) {
                continue;
            }
            if (itemStack.getType() == Material.EMERALD) {
                money += itemStack.getAmount();
            }
            if (itemStack.getType() == Material.PAPER) {

            }
        }
        return money;
    }

    public int getBankNoteValue(ItemStack stack) {
        ItemBuilder itemBuilder = new ItemBuilder(stack);
        if (itemBuilder.getTag().hasKey("value")) {
            return itemBuilder.getTag().getInt("value");
        }
        return -1;
    }

    public ItemStack createBankNote(Player player, int value) {
        IItemBuilder itemBuilder = new ItemBuilder()
                .setType(Material.PAPER)
                .setAmount(1)
                .setDisplayName(ChatColor.GREEN + "Bank Note")
                .addLore(ChatColor.WHITE + ChatColor.BOLD.toString() + "Value: " + ChatColor.WHITE + value + " Gems")
                .addLore(ChatColor.YELLOW + "=========================")
                .addLore(ChatColor.GRAY + "Signer " + player.getName())
                .addLore(ChatColor.YELLOW + "=========================")
                .addLore(ChatColor.GRAY + "Exchange at any bank for GEM(s)")
                .setTag("value", value)
                .setTag("signer", player)
                .setTag("uniqueId", UUID.randomUUID().toString());
        return itemBuilder.build();
    }

/*
&aBank Note
&f&lValue: &f1 Gems
&7Exchange at any bank for GEM(s)

 */
}
