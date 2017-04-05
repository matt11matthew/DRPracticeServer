package com.matthewedevelopment.ps.mechanics.player.ps;

import com.matthewedevelopment.ps.PracticeServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by matt1 on 3/13/2017.
 */
public class PlayerManager implements Listener {

    private HashMap<UUID, PsPlayer> playerMap;
    private static PlayerManager manager;
    private List<PsPlayer> playerList;

    public static PlayerManager getManager() {
        if (manager == null) {
            manager = new PlayerManager();
        }
        return manager;
    }

    public PlayerManager() {
        manager = this;
        this.playerList = new ArrayList<>();
        this.playerMap = new HashMap<>();
        long time = System.currentTimeMillis();
        log("&aLOADING PLAYERS()");
        File playerDirectory = new File(PracticeServer.getPracticeServer().getDataFolder() + "/players/");
        if (!playerDirectory.exists()) {
            playerDirectory.mkdirs();
        }
        if (!playerDirectory.isDirectory()) {
            return;
        }
        if (playerDirectory.listFiles().length < 1) {
            return;
        }
        HashMap<PsPlayer, Long> toFinishLoadMin = new HashMap<>();
        HashMap<PsPlayer, Long> toFinishLoadMax = new HashMap<>();
        Arrays.asList(playerDirectory.listFiles()).forEach(file -> {
            long l = System.currentTimeMillis();
            PsPlayer duelPlayer = new PsPlayer().load(file);
            if (duelPlayer != null) {
                playerMap.put(duelPlayer.getUniqueId(), duelPlayer);
                log("&7 > " + duelPlayer.getUsername() + "...");
                toFinishLoadMin.put(duelPlayer, l);
                toFinishLoadMax.put(duelPlayer, System.currentTimeMillis());
            }
        });
        toFinishLoadMin.forEach((duelPlayer, aLong) -> {
            long max = toFinishLoadMax.get(duelPlayer);
            log("&7 > " + duelPlayer.getUsername() + " &e" + (max - aLong) + "ms");
        });
        log("&aLOADED "  + toFinishLoadMin.values().size() + " PLAYERS IN &e" + (System.currentTimeMillis() - time) + "ms");
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(PracticeServer.getPracticeServer(), this::saveAllPlayers, 3000L, 3000L);
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(PracticeServer.getPracticeServer(), this::sortPlayers, 10L, 10L);

    }

    private void sortPlayers() {
        playerList.clear();
        playerMap.values().forEach(duelPlayer -> playerList.add(duelPlayer));
    }

    public void saveAllPlayers() {
        Bukkit.getServer().getOnlinePlayers().forEach(player -> getPlayer(player).save());
    }

    private void log(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    event.getEntity().remove();
                }
            }.runTaskLater(PracticeServer.getPracticeServer(), 10L);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        PsPlayer duelPlayer =  getPlayer(event.getPlayer());
        duelPlayer.save();
        duelPlayer.quit();
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        PsPlayer psPlayer = getPlayer((Player) event.getWhoClicked());
        psPlayer.setPlayerAttributes(new PlayerAttributes(psPlayer));
        psPlayer.getPlayerAttributes().weapon();
        psPlayer.getPlayerAttributes().armor();
    }

    private List<Player> blind = new ArrayList<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location location = LoadMechanics.getLoadLocation();
        if (location != null) {
            player.teleport(location);
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100000, 20));
            blind.add(player);
        }
        PsPlayer duelPlayer = getPlayer(player);
        duelPlayer.set("ipAddress", player.getAddress().getAddress().toString().replace("/", ""));
        try {
            duelPlayer.save();
        } catch (Exception e) {
            player.kickPlayer(ChatColor.RED + "Failed to load data...");
        } finally {
            new BukkitRunnable() {

                @Override
                public void run() {
                    blind.remove(player);
                    player.removePotionEffect(PotionEffectType.BLINDNESS);
                    duelPlayer.join();
                }
            }.runTaskLater(PracticeServer.getPracticeServer(), 50L);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Location to = event.getTo();
        Location from = event.getFrom();
        Player player = event.getPlayer();
        if (blind.contains(player)) {
            if ((to.getBlockX() != from.getBlockX()) || (to.getBlockY() != from.getBlockY()) || (to.getBlockZ() != from.getBlockZ())) {
                event.setCancelled(true);
                player.teleport(from);
            }
        }
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (blind.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onAsyncChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (blind.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (blind.contains(player)) {
            event.setCancelled(true);
        }
    }

    public PsPlayer getPlayer(String name) {
        for (PsPlayer duelPlayer : this.playerMap.values()) {
            if (duelPlayer.getUsername().equals(name)) {
                return duelPlayer;
            }
        }
        return null;
    }


    public PsPlayer getPlayer(Player player) {
        if (this.playerMap.containsKey(player.getUniqueId())) {
            return this.playerMap.get(player.getUniqueId());
        }
        PsPlayer duelPlayer = new PsPlayer().load(player);
        this.playerMap.put(player.getUniqueId(), duelPlayer);
        return duelPlayer;
    }

    public List<PsPlayer> getPlayerList() {
        return playerMap.values().stream().collect(Collectors.toList());
    }

    public boolean isBlind(Player player) {
        return blind.contains(player);
    }
}
