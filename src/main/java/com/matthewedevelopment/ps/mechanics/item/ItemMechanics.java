package com.matthewedevelopment.ps.mechanics.item;

import com.google.common.collect.Maps;
import com.matthewedevelopment.ps.PracticeServer;
import com.matthewedevelopment.ps.api.mechanic.GameMechanic;

import java.io.File;
import java.util.HashMap;

/**
 * Created by Matthew E on 4/1/2017.
 */
public class ItemMechanics extends GameMechanic {

    private static ItemMechanics instance;
    private HashMap<String, CustomItem> customItemHashMap;

    public static ItemMechanics getInstance() {
        if (instance == null) {
            instance = new ItemMechanics();
        }
        return instance;
    }

    public ItemMechanics() {
        instance = this;
        this.customItemHashMap = Maps.newHashMap();
    }

     public void reloadCustomItems() {
         this.customItemHashMap.clear();
         this.loadCustomItems();
     }

     public boolean isCustomItem(String name) {
        return customItemHashMap.containsKey(name);
     }

     public CustomItem getCustomItem(String name) {
        return customItemHashMap.get(name);
     }

    private void loadCustomItems() {
        File folder = new File(getDataFolder() + "customitems/");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        if (!folder.isDirectory()) {
            folder.delete();
            folder.mkdirs();
            System.out.println("Fixing broken custom items directory.");
        }
        if (folder.listFiles().length < 1) {
            System.out.println("0 Custom items found.");
        } else {
            for (File file : folder.listFiles()) {
                CustomItem customItem = new CustomItem(file.getName().replace(".yml", ""));
                try {
                    customItem.getItem();
                    this.customItemHashMap.put(customItem.getName(), customItem);
                    System.out.println("CustomItems > Loaded " + customItem.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }

    @Override
    public void onEnable() {
        this.loadCustomItems();
    }

    @Override
    public void onDisable() {
        this.customItemHashMap.clear();
    }

    public void createCustomItem(String name) {
         File file = new File(PracticeServer.getPracticeServer().getDataFolder() + "/", "template.yml");
        file.renameTo(new File( getDataFolder() + "customitems/", name + ".yml"));
        CustomItem customItem = new CustomItem(file.getName().replace(".yml", ""));
        try {
            customItem.getItem();
            this.customItemHashMap.put(customItem.getName(), customItem);
            System.out.println("CustomItems > Loaded " + customItem.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
