package com.matthewedevelopment.ps.mechanics.monster;

import com.matthewedevelopment.ps.api.mechanic.GameMechanic;
import com.matthewedevelopment.ps.mechanics.monster.entities.PsBowZombie;
import com.matthewedevelopment.ps.mechanics.monster.entities.PsMonsterTypes;
import com.matthewedevelopment.ps.mechanics.monster.entities.PsZombie;
import net.minecraft.server.v1_9_R2.EntityInsentient;
import net.minecraft.server.v1_9_R2.EntityTypes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Matthew E on 4/2/2017.
 */
public class MonsterMechanics extends GameMechanic {

    private static MonsterMechanics instance;

    public static MonsterMechanics getInstance() {
        if (instance == null) {
            instance = new MonsterMechanics();
        }
        return instance;
    }

    public MonsterMechanics() {
        instance = this;
    }

    @Override
    public void onEnable() {
//        for (PsMonsterTypes types : PsMonsterTypes.values()) {
//            registerEntity(types.getName(), types.getId(), types.getOldClazz(), types.getClazz());
//        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        PsMonsterTypes.spawnEntity(new PsZombie(Bukkit.getWorld("world")), new Location(Bukkit.getWorld("world"), loc.getX(), loc.getY(), loc.getZ()));
        PsMonsterTypes.spawnEntity(new PsBowZombie(Bukkit.getWorld("world")), new Location(Bukkit.getWorld("world"), loc.getX(), loc.getY(), loc.getZ()));
     }


    @Override
    public void onDisable() {

    }

    public void registerEntity(String name, int id, Class<? extends EntityInsentient> nmsClass, Class<? extends EntityInsentient> customClass){
        try {

            List<Map<?, ?>> dataMap = new ArrayList<Map<?, ?>>();
            for (Field f : EntityTypes.class.getDeclaredFields()){
                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())){
                    f.setAccessible(true);
                    dataMap.add((Map<?, ?>) f.get(null));
                }
            }

            if (dataMap.get(2).containsKey(id)){
                dataMap.get(0).remove(name);
                dataMap.get(2).remove(id);
            }

            Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, int.class);
            method.setAccessible(true);
            method.invoke(null, customClass, name, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
