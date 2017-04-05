package com.matthewedevelopment.ps.mechanics.item.commands;

import com.matthewedevelopment.ps.api.command.BaseCommand;
import com.matthewedevelopment.ps.mechanics.item.CustomItem;
import com.matthewedevelopment.ps.mechanics.item.ItemMechanics;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Matthew E on 4/1/2017.
 */
public class CommandCustomItem extends BaseCommand {
    public CommandCustomItem() {
        super("customitem");
    }

    @Override
    public boolean execute(Player player, String[] args) {
        if (!player.isOp()) {
            return true;
        }
        if (args.length >= 1) {
            ItemMechanics itemMechanics = ItemMechanics.getInstance();
            switch (args[0].toLowerCase()) {
                case "reload":
                    player.sendMessage(ChatColor.YELLOW + "Reloading custom items...");
                    itemMechanics.reloadCustomItems();
                    player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "Completed");
                    break;
                case "create":
                    if (itemMechanics.isCustomItem(args[1])) {
                        player.sendMessage(ChatColor.RED + "The custom item " + args[1] + " already exists.");
                        return true;
                    } else {
                        player.sendMessage(ChatColor.YELLOW + "Generating custom item template for " + args[1] + "...");
                        itemMechanics.createCustomItem(args[1]);
                        player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "Completed");
                        return true;
                    }
                case "add":
                    if (itemMechanics.isCustomItem(args[1])) {
                        CustomItem customItem = itemMechanics.getCustomItem(args[1]);
                        player.getInventory().addItem(customItem.getItem());
                        return true;
                    } else {
                        player.sendMessage(ChatColor.RED + "The custom item " + args[1] + " doesn't exist.");
                        return true;
                    }
            }
        }
        return true;
    }
}
