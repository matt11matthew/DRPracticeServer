package com.matthewedevelopment.ps.api.command;

import com.matthewedevelopment.ps.PracticeServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Matthew E on 4/1/2017.
 */
public abstract class BaseCommand implements CommandExecutor {

    private String name;

    public BaseCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            return execute((Player) sender, args);
        }
        return true;
    }

    public abstract boolean execute(Player sender, String[] args);

    public void register() {
        PracticeServer.getPracticeServer().getCommand(this.name).setExecutor(this);
    }
}
