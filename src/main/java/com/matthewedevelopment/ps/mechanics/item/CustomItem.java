package com.matthewedevelopment.ps.mechanics.item;

import com.matthewedevelopment.ps.PracticeServer;
import com.matthewedevelopment.ps.api.RandomAPI;
import com.matthewedevelopment.ps.api.file.yaml.YamlFile;
import com.matthewedevelopment.ps.api.file.yaml.YamlFileImpl;
import com.matthewedevelopment.ps.api.file.yaml.YamlLoadException;
import com.matthewedevelopment.ps.mechanics.item.builder.IItemBuilder;
import com.matthewedevelopment.ps.mechanics.item.builder.ItemBuilder;
import com.matthewedevelopment.ps.mechanics.item.tier.ItemTier;
import com.matthewedevelopment.ps.mechanics.item.tier.ItemType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Matthew E on 4/1/2017.
 */
public class CustomItem {

    private String name;
    private File itemFile;

    public CustomItem(String name) {
        this.name = name;
        this.itemFile = new File(PracticeServer.getPracticeServer().getDataFolder() + "/customitems/", name + ".yml");
    }

    public static void convert(File file) {
        String contents = "";
        String itemName = "";
        int itemId = 0;
        List<String> loreList = new ArrayList<>();
        if (file.getName().endsWith(".item")) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                    contents += currentLine + System.lineSeparator();
                    if (currentLine.startsWith("item_name=")) {
                        itemName = currentLine.split("item_name=")[1];
                    }
                    if (currentLine.startsWith("item_id=")) {
                        itemId = Integer.parseInt(currentLine.split("item_id=")[1]);
                    }
                    if (currentLine.startsWith("&")) {
                        loreList.add(currentLine.replaceAll(":", "\\[.]"));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String name = file.getName().replace(".item", "");
        File newFile = new File(PracticeServer.getPracticeServer().getDataFolder() + "/customitems/", name + ".yml");
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Material material = Material.getMaterial(itemId);
            YamlFile yamlFile = new YamlFileImpl().load(newFile);
            yamlFile.set("name", itemName);
            yamlFile.set("type", ItemType.getItemType(material).toString().toLowerCase());
            yamlFile.set("tier", ItemTier.getTier(material).getTierNumber());
            yamlFile.set("loreList", loreList);
            yamlFile.set("untradeable", loreList.contains("&7Untradeable"));
            yamlFile.set("soulbound", loreList.contains("&7Soulbound"));
            yamlFile.save();
        } catch (YamlLoadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ItemStack getItem() {
        try {
            YamlFile yamlFile = new YamlFileImpl().load(itemFile);
            ItemTier itemTier = ItemTier.getTier(yamlFile.getYamlConfiguration().getInt("tier"));
            ItemType itemType = ItemType.valueOf(yamlFile.getYamlConfiguration().getString("type").toUpperCase());
            Material type = itemTier.decideType(itemType);
            IItemBuilder itemBuilder = new ItemBuilder()
                    .setType(type)
                    .setDisplayName(format(yamlFile.getYamlConfiguration().getString("name"), true));
            boolean damage = false;
            int lowDamage = 0;
            List<String> loreList = new ArrayList<>();
            int highDamage = 0;
            int ice = 0;
            int pure = 0;
            int fire = 0;
            if (yamlFile.get().isSet("loreList")) {
                for (String lore : yamlFile.get().getStringList("loreList")) {
                    loreList.add(format(lore, true));
                }
            }
            if (yamlFile.getYamlConfiguration().isConfigurationSection("stats")) {
                for (String stat : yamlFile.getYamlConfiguration().getConfigurationSection("stats").getKeys(false)) {
                    System.out.println(stat);
                    ConfigurationSection config = yamlFile.getYamlConfiguration().getConfigurationSection("stats");
                    switch (stat.toLowerCase()) {
                        case "lowdamage":
                            damage = true;
                            lowDamage = Integer.parseInt(format(config.getString(stat), false));
                            break;
                        case "highdamage":
                            damage = true;
                            highDamage = Integer.parseInt(format(config.getString(stat), false));
                            break;
                        case "ice":
                            ice = Integer.parseInt(format(config.getString(stat), false));
                            break;
                        case "fire":
                            fire = Integer.parseInt(format(config.getString(stat), false));
                            break;
                        case "pure":
                            pure = Integer.parseInt(format(config.getString(stat), false));
                            break;
                    }
                }
            }
            if (damage) {
                loreList.add(ChatColor.RED + "DMG: " + lowDamage + " - " + highDamage);
            }
            if (ice > 0) {
                loreList.add(ChatColor.RED + "ICE DMG: +" + ice);
            }
            if (fire > 0) {
                loreList.add(ChatColor.RED + "FIRE DMG: +" + ice);
            }
            if (pure > 0) {
                loreList.add(ChatColor.RED + "PURE DMG: +" + ice);
            }
            if (yamlFile.getYamlConfiguration().isSet("untradeable")) {
                if (yamlFile.get().getBoolean("untradeable")) {
                    loreList.add(ChatColor.GRAY + ChatColor.ITALIC.toString() + "Untradeable");
                    itemBuilder.setTag("untradeable", true);
                }
            }
            if (yamlFile.getYamlConfiguration().isSet("soulbound")) {
                if (yamlFile.get().getBoolean("soulbound")) {
                    loreList.add(ChatColor.DARK_RED + "Soulbound");
                    itemBuilder.setTag("soulbound", true);
                }
            }
            itemBuilder.setLore(loreList);
            itemBuilder.setTier(itemTier);
            itemBuilder.setAmount(1);
            return itemBuilder.build();
        } catch (NullPointerException e) {

        } catch (YamlLoadException e) {
            e.printStackTrace();
        }
        return new ItemStack(Material.WOOD_AXE);
    }

    private String format(String line, boolean color) {
        if (line.contains("(")) {
            String line_copy = line;
            for (String s : line_copy.split("\\(")) {
                if (!(s.contains("~"))) {
                    continue;
                }
                s = s.replaceAll("%", "");
                int lower = Integer.parseInt(s.substring(0, s.indexOf("~")));
                int upper = Integer.parseInt(s.substring(s.indexOf("~") + 1, s.indexOf(")")));
                int val = new Random().nextInt((upper - lower)) + lower;
                line = line.replace("(" + lower + "~" + upper + ")", String.valueOf(val));
            }
        } else if (line.contains("~")) {
            String[] range = line.split("~");
            line = line.replaceAll(range[0] + "~" + range[1], RandomAPI.getInstance().random(Integer.parseInt(range[0]), Integer.parseInt(range[1])) + "");
        }
        if (line.contains("[.]")) {
            line = line.replaceAll("\\[\\.]", ":");
        }
        if (color) {
            line = ChatColor.translateAlternateColorCodes('&', line);
        }

        return line;
    }

    public String getName() {
        return name;
    }
}

/*
<customitem name="training sword">
    <name>Training Shortsword</name>
    <tier>1</tier>
    <type>sword</type>
    <stats>
        <lowdamage>1-2</lowdamage>
        <highdamage>3-5</highdamage>
    </stats>
    <untradable>true</untradable>
    <soulbound>false</soulbound>
</customitem>
 */