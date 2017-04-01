package com.matthewedevelopment.ps;

import com.matthewedevelopment.ps.api.command.CommandManager;
import com.matthewedevelopment.ps.api.mechanic.MechanicManager;
import com.matthewedevelopment.ps.mechanics.item.ItemMechanics;
import com.matthewedevelopment.ps.mechanics.player.JoinMechanic;
import com.matthewedevelopment.ps.mechanics.player.ps.LoadMechanics;
import com.matthewedevelopment.ps.mechanics.player.ps.PlayerManager;
import com.matthewedevelopment.ps.mechanics.player.achievement.AchievementMechanics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PracticeServer extends JavaPlugin {

    private static PracticeServer practiceServer;

    public static PracticeServer getPracticeServer() {
        return practiceServer;
    }

    @Override
    public void onEnable() {
        practiceServer = this;
        CommandManager commandManager = CommandManager.getInstance();
        MechanicManager mechanicManager = MechanicManager.getInstance();
        Bukkit.getPluginManager().registerEvents(PlayerManager.getManager(), this);
        mechanicManager.registerMechanic(LoadMechanics.getInstance());
        mechanicManager.registerMechanic(AchievementMechanics.getInstance());
        mechanicManager.registerMechanic(JoinMechanic.getInstance());
        mechanicManager.registerMechanic(ItemMechanics.getInstance());
        mechanicManager.registerMechanics();
    }

    @Override
    public void onDisable() {
        MechanicManager.getInstance().disableMechanics();
    }
}
