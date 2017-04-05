package com.matthewedevelopment.ps.mechanics.item.commands;

import com.matthewedevelopment.ps.api.command.BaseCommand;
import com.matthewedevelopment.ps.mechanics.item.ItemRarity;
import com.matthewedevelopment.ps.mechanics.item.generator.ItemGenerator;
import com.matthewedevelopment.ps.mechanics.item.tier.ItemTier;
import com.matthewedevelopment.ps.mechanics.item.tier.ItemType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Matthew E on 4/2/2017.
 */
public class CommandCreateDrop extends BaseCommand {
    public CommandCreateDrop() {
        super("createitem");
    }

    @Override
    public boolean execute(Player sender, String[] args) {
        if (!sender.isOp()) {
            return true;
        }
        if (args.length == 3) {
            try {
                int tier = Integer.parseInt(args[0]);
                ItemType itemType = ItemType.valueOf(args[1].toUpperCase());
                ItemRarity itemRarity = ItemRarity.valueOf(args[2].toUpperCase());
                if ((tier <= 5) && (tier >= 1)) {
                    sender.getInventory().addItem( ItemGenerator.createDrop(ItemTier.getTier(tier), itemType, itemRarity));
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "/createitem <tier> <type> <rarity>");
                    return true;
                }
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "/createitem <tier> <type> <rarity>");
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "/createitem <tier> <type> <rarity>");
            return true;
        }
    }
}
