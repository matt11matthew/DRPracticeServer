package com.matthewedevelopment.ps.api.menu;


import com.matthewedevelopment.ps.api.menu.item.MenuItem;

/**
 * Created by matt1 on 3/21/2017.
 */
public interface IInventory {

    void addItem(MenuItem menuItem);

    void setItem(int slot, MenuItem menuItem);

    void removeItem(int slot);
}
