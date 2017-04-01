package com.matthewedevelopment.ps.mechanics.player.ps;

import com.matthewedevelopment.ps.PracticeServer;
import com.matthewedevelopment.ps.api.file.yaml.YamlFile;
import com.matthewedevelopment.ps.api.file.yaml.YamlFileImpl;
import com.matthewedevelopment.ps.api.file.yaml.YamlLoadException;
import com.matthewedevelopment.ps.api.mechanic.GameMechanic;
import org.bukkit.Location;

import java.io.File;

/**
 * Created by Matthew E on 4/1/2017.
 */
public class LoadMechanics extends GameMechanic{

    private static LoadMechanics instance;

    public static LoadMechanics getInstance() {
        if (instance == null) {
            instance = new LoadMechanics();
        }
        return instance;
    }
    public LoadMechanics() {
        instance = this;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public static Location getLoadLocation() {
        YamlFile yamlFile = null;
        try {
            yamlFile = (YamlFile) new YamlFileImpl().load(new File(PracticeServer.getPracticeServer().getDataFolder() + "/load/", "spawn.yml"));
        } catch (YamlLoadException e) {
            e.printStackTrace();
        }
        if (yamlFile.getYamlConfiguration().isSet("load")) {
            return yamlFile.getLocation("load");
        }
        return null;
    }
}
