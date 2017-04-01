package com.matthewedevelopment.ps.mechanics.item;

import com.matthewedevelopment.ps.api.mechanic.GameMechanic;

/**
 * Created by Matthew E on 4/1/2017.
 */
public class ItemMechanics extends GameMechanic {

    private static ItemMechanics instance;

    public static ItemMechanics getInstance() {
        if (instance == null) {
            instance = new ItemMechanics();
        }
        return instance;
    }

    public ItemMechanics() {
        instance = this;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }


}
