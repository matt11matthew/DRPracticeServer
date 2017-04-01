package com.matthewedevelopment.ps.mechanics.player;

import com.matthewedevelopment.ps.api.file.yaml.YamlFile;
import com.matthewedevelopment.ps.api.file.yaml.YamlFileImpl;
import com.matthewedevelopment.ps.api.file.yaml.YamlLoadException;
import com.matthewedevelopment.ps.api.mechanic.GameMechanic;
import com.matthewedevelopment.ps.mechanics.player.events.PsPlayerJoinEvent;
import com.matthewedevelopment.ps.mechanics.player.ps.PsPlayer;
import org.bukkit.event.EventHandler;

import java.io.File;

/**
 * Created by Matthew E on 4/1/2017.
 */
public class JoinMechanic extends GameMechanic {

    private static JoinMechanic instance;

    public static JoinMechanic getInstance() {
        if (instance == null) {
            instance = new JoinMechanic();
        }
        return instance;
    }

    public JoinMechanic() {
        instance = this;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onPsPlayerJoin(PsPlayerJoinEvent event) {
        PsPlayer psPlayer = event.getPsPlayer();
        if (psPlayer.isNew()) {
            try {
                YamlFile yamlFile = new YamlFileImpl().load(new File(getDataFolder(), "starterKit.yml"));

            } catch (YamlLoadException e) {
                e.printStackTrace();
            }
        }
    }
}
