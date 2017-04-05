package com.matthewedevelopment.ps;

import com.matthewedevelopment.ps.api.command.CommandManager;
import com.matthewedevelopment.ps.api.mechanic.MechanicManager;
import com.matthewedevelopment.ps.mechanics.item.CustomItem;
import com.matthewedevelopment.ps.mechanics.item.ItemMechanics;
import com.matthewedevelopment.ps.mechanics.item.commands.CommandCreateDrop;
import com.matthewedevelopment.ps.mechanics.item.commands.CommandCustomItem;
import com.matthewedevelopment.ps.mechanics.monster.MonsterMechanics;
import com.matthewedevelopment.ps.mechanics.player.JoinMechanic;
import com.matthewedevelopment.ps.mechanics.player.achievement.AchievementMechanics;
import com.matthewedevelopment.ps.mechanics.player.ps.LoadMechanics;
import com.matthewedevelopment.ps.mechanics.player.ps.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class PracticeServer extends JavaPlugin {

    private static PracticeServer practiceServer;

    public static PracticeServer getPracticeServer() {
        return practiceServer;
    }

    @Override
    public void onEnable() {
        practiceServer = this;
        MechanicManager mechanicManager = MechanicManager.getInstance();
        Bukkit.getPluginManager().registerEvents(PlayerManager.getManager(), this);
        mechanicManager.registerMechanic(LoadMechanics.getInstance());
        mechanicManager.registerMechanic(AchievementMechanics.getInstance());
        mechanicManager.registerMechanic(JoinMechanic.getInstance());
        mechanicManager.registerMechanic(ItemMechanics.getInstance());
        mechanicManager.registerMechanic(new MonsterMechanics());
        mechanicManager.registerMechanics();
        File folder = new File(getDataFolder() + "/olditems/");
        for (File file : folder.listFiles()) {
            CustomItem.convert(file);
        }
        CommandManager commandManager = CommandManager.getInstance();
        commandManager.registerCommand(new CommandCustomItem());
        commandManager.registerCommand(new CommandCreateDrop());
    }

    @Override
    public void onDisable() {
        MechanicManager.getInstance().disableMechanics();
    }
}
