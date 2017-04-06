package com.matthewedevelopment.ps.mechanics.vendor;

import com.matthewedevelopment.ps.PracticeServer;
import com.matthewedevelopment.ps.api.menu.MenuImpl;
import com.matthewedevelopment.ps.api.menu.item.MenuItemBuilder;
import com.matthewedevelopment.ps.mechanics.item.builder.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew E on 4/5/2017.
 */
public class Vendor extends MenuImpl {

    public Vendor(String title, int slots) {
        super(title, slots, PracticeServer.getPracticeServer());
    }

    public void rightClick(Player player) {
        open(player);
    }

    public void addVendorItem(ItemStack stack, int price) {
        VendorItem vendorItem = VendorItem.getVendorItem(new ItemBuilder(stack));
        vendorItem.setCost(price);
        MenuItemBuilder item = new MenuItemBuilder(vendorItem.build());
        item.click((player, clickType) -> {
           player.closeInventory();
           vendorItem.buy(player);
        });
        addItem(item);
    }
}
