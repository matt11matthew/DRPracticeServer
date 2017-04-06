package com.matthewedevelopment.ps.mechanics.vendor;

import com.matthewedevelopment.ps.mechanics.item.builder.ItemBuilder;
import com.matthewedevelopment.ps.mechanics.player.ps.PlayerManager;
import com.matthewedevelopment.ps.mechanics.player.ps.PsPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Matthew E on 4/5/2017.
 */
public class VendorItem extends ItemBuilder {

    private int cost;

    public static VendorItem getVendorItem(ItemBuilder itemBuilder) {
        return (VendorItem) new ItemBuilder(itemBuilder.build());
    }
    public int getCost() {
        return cost;
    }

    public VendorItem setCost(int cost) {
        this.cost = cost;
        setTag("price", cost);
        addLore(ChatColor.GREEN + "Price: " + ChatColor.WHITE + cost + "g");
        return this;
    }

    public void buy(Player player) {
        PsPlayer psPlayer = PlayerManager.getManager().getPlayer(player);
        long gems = psPlayer.get("gems").getAsAInteger();
        if (gems >= this.cost) {
            psPlayer.set("gems", (gems - this.cost));
        } else {
            player.sendMessage(ChatColor.RED + "You do NOT have enough gems to purchase this " + getItemMeta().getDisplayName());
        }

    }
}
