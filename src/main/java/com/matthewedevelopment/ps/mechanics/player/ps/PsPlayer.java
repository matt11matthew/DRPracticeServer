package com.matthewedevelopment.ps.mechanics.player.ps;


import com.matthewedevelopment.ps.PracticeServer;
import com.matthewedevelopment.ps.api.file.yaml.YamlFile;
import com.matthewedevelopment.ps.api.file.yaml.YamlFileImpl;
import com.matthewedevelopment.ps.api.file.yaml.YamlLoadException;
import com.matthewedevelopment.ps.mechanics.player.achievement.EnumAchievements;
import com.matthewedevelopment.ps.mechanics.player.events.PsPlayerJoinEvent;
import com.matthewedevelopment.ps.mechanics.player.events.PsPlayerQuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by matt1 on 3/13/2017.
 */
public class PsPlayer {

    private UUID uniqueId;
    private String username;
    private HashMap<String, Object> dataMap;
    private YamlFile yamlFile;
    private PlayerAttributes playerAttributes;

    public PsPlayer() {
        this.dataMap = new HashMap<>();
    }

    public PlayerAttributes getPlayerAttributes() {
        return playerAttributes;
    }

    public void setPlayerAttributes(PlayerAttributes playerAttributes) {
        this.playerAttributes = playerAttributes;
    }

    private void loadDataMap(Player player) {
        this.dataMap.put("ipAddress", player.getAddress().getAddress().toString().replace("/", ""));
        this.dataMap.put("isNew", true);
        for (EnumAchievements achievements : EnumAchievements.values()) {
            this.dataMap.put(achievements.getYamlName(), false);
        }
        // this.dataMap.put("currentVersion", ReflectionApi.getApi().getVersion(player).toString());
    }

    public boolean hasAchievement(EnumAchievements enumAchievements) {
        return get(enumAchievements.getYamlName()).getAsABoolean();
    }

    public void giveAchievement(EnumAchievements achievement) {
        if (hasAchievement(achievement)) {
            return;
        }
        set(achievement.getYamlName(), true);
        Player player = Bukkit.getPlayer(uniqueId);
        if ((player != null) && (player.isOnline())) {
            int reward = achievement.getReward();
            if (reward > 0) {
                add("points", achievement.getReward());
            }
            return;
        }
    }

    private void loadDataMap() {
        this.dataMap.put("ipAddress", "");
        this.dataMap.put("isNew", true);
        for (EnumAchievements achievements : EnumAchievements.values()) {
            this.dataMap.put(achievements.getYamlName(), false);
        }
    }

    public PsPlayer load(Player player) {
        this.uniqueId = player.getUniqueId();
        this.username = player.getName();
        boolean isNew = false;
        try {
            this.yamlFile = (YamlFile) new YamlFileImpl().load(new File(PracticeServer.getPracticeServer().getDataFolder() + "/players/", this.uniqueId.toString() + ".yml"));
        } catch (YamlLoadException e) {
            e.printStackTrace();
        }
        if (yamlFile.isNew()) {
            isNew = true;
        }
        this.loadDataMap(player);
        HashMap<String, Object> toAdd = new HashMap<>();
        for (String s : this.dataMap.keySet()) {
            if (this.yamlFile.getYamlConfiguration().isSet(s)) {
                toAdd.put(s, yamlFile.getYamlConfiguration().get(s));
            } else {
                toAdd.put(s, dataMap.get(s));
            }
        }
        for (String key : toAdd.keySet()) {
            dataMap.remove(key);
            dataMap.put(key, toAdd.get(key));
        }
        if (!isNew) {
            set("isNew", false);
        }
        this.save();
        return this;
    }

    public void save() {
        this.yamlFile.getYamlConfiguration().set("uniqueId", this.uniqueId.toString());
        this.yamlFile.getYamlConfiguration().set("username", this.username);
        this.dataMap.forEach((key, value) -> this.yamlFile.getYamlConfiguration().set(key, value));
        try {
            this.yamlFile.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getUsername() {
        return username;
    }

    public YamlFile getYamlFile() {
        return yamlFile;
    }

    public DataTypeObject get(String key) {
        if (this.dataMap.containsKey(key)) {
            return new DataTypeObject(this.dataMap.get(key));
        }
        return new DataTypeObject(null);
    }

    public PsPlayer set(String key, long value) {
        if (!this.dataMap.containsKey(key)) {
            this.dataMap.put(key, value);
        } else {
            this.dataMap.remove(key);
            this.dataMap.put(key, value);
        }
        return this;
    }

    public PsPlayer set(String key, Object value) {
        if (!this.dataMap.containsKey(key)) {
            this.dataMap.put(key, value);
        } else {
            this.dataMap.remove(key);
            this.dataMap.put(key, value);
        }
        return this;
    }

    public PsPlayer load(File file) {
        try {
            this.yamlFile = (YamlFile) new YamlFileImpl().load(file);
        } catch (YamlLoadException e) {
            e.printStackTrace();
        }
        boolean isNew = false;
        if (yamlFile.isNew()) {
            isNew = true;
        }
        this.uniqueId = UUID.fromString(yamlFile.getYamlConfiguration().getString("uniqueId"));
        this.username = yamlFile.getYamlConfiguration().getString("username");
        this.loadDataMap();
        HashMap<String, Object> toAdd = new HashMap<>();
        for (String s : this.dataMap.keySet()) {
            if (this.yamlFile.getYamlConfiguration().isSet(s)) {
                toAdd.put(s, yamlFile.getYamlConfiguration().get(s));
            } else {
                toAdd.put(s, dataMap.get(s));
            }
        }
        for (String key : toAdd.keySet()) {
            dataMap.remove(key);
            dataMap.put(key, toAdd.get(key));
        }
        if (!isNew) {
            set("isNew", false);
        }
        this.save();
        return this;
    }

    public void add(String key, long integer) {
        long value = get(key).getAsALong();
        set(key, (value + integer));
    }

    public boolean isNew() {
        return get("isNew").getAsABoolean();
    }

    public void join() {
        PsPlayerJoinEvent event = new PsPlayerJoinEvent(this);
        Bukkit.getPluginManager().callEvent(event);
    }

    public void quit() {
        PsPlayerQuitEvent event = new PsPlayerQuitEvent(this);
        Bukkit.getPluginManager().callEvent(event);
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uniqueId);
    }
}