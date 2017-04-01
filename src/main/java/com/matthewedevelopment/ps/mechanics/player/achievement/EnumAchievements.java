package com.matthewedevelopment.ps.mechanics.player.achievement;

import org.bukkit.ChatColor;

/**
 * Created by matt1 on 3/19/2017.
 */
public enum EnumAchievements {

    PLAY_5_GAMES_RANKED("Trying Ranked 1v1", new String[] {
            ChatColor.GRAY + "Play 5 Ranked 1v1 duels"
    }, 1, "achievements.playing_5_ranked_games", Category.RANKED),

    PLAY_25_GAMES_RANKED("Enjoying Ranked 1v1", new String[] {
            ChatColor.GRAY + "Play 25 Ranked 1v1 duels"
    }, 1, "achievements.playing_25_ranked_games", Category.RANKED),

    FIRST_JOIN("Welcome to duels", new String[] {
            ChatColor.GRAY + "Join duels for the first time."
    }, 1, "achievements.first_join", Category.MISC);

    private String name;
    private String[] message;
    private int reward;
    private String rawName;
    private Category category;

    EnumAchievements(String name, String[] message, int reward, String rawName, Category category) {
        this.name = name;
        this.message = message;
        this.reward = reward;
        this.rawName = rawName;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String[] getMessage() {
        return message;
    }

    public int getReward() {
        return reward;
    }

    public String getYamlName() {
        return rawName;
    }

    public Category getCategory() {
        return category;
    }
}

