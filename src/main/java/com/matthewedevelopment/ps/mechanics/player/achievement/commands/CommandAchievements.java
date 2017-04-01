package com.matthewedevelopment.ps.mechanics.player.achievement.commands;

import com.matthewedevelopment.ps.api.command.BaseCommand;
import org.bukkit.entity.Player;

/**
 * Created by matt1 on 3/20/2017.
 */
public class CommandAchievements extends BaseCommand {
    public CommandAchievements() {
        super("achievements");
    }

    @Override
    public boolean execute(Player player, String[] args) {
        return true;
    }

}
