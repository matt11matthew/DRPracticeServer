package com.matthewedevelopment.ps.mechanics.player.achievement;

import com.matthewedevelopment.ps.PracticeServer;
import com.matthewedevelopment.ps.api.mechanic.GameMechanic;
import com.matthewedevelopment.ps.mechanics.player.ps.PlayerManager;
import com.matthewedevelopment.ps.mechanics.player.ps.PsPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by matt1 on 3/19/2017.
 */
public class AchievementMechanics extends GameMechanic {

    private static AchievementMechanics instance;


    public static AchievementMechanics getInstance() {
        if (instance == null) {
            instance = new AchievementMechanics();
        }
        return instance;
    }
    public AchievementMechanics() {
        instance = this;
    }
    @Override
    public void onEnable() {
        //CommandManager.getInstance().registerCommand(new CommandAchievements());
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player  = event.getPlayer();
        new BukkitRunnable() {

            @Override
            public void run() {
                if (!PlayerManager.getManager().isBlind(player)) {
                    PsPlayer duelPlayer = PlayerManager.getManager().getPlayer(player);
                    if (duelPlayer.isNew()) {
                        duelPlayer.giveAchievement(EnumAchievements.FIRST_JOIN);
                    }
                }
            }
        }.runTaskLater(PracticeServer.getPracticeServer(), 120L);
    }
}
