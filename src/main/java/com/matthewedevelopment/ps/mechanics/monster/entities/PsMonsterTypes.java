package com.matthewedevelopment.ps.mechanics.monster.entities;

import net.minecraft.server.v1_9_R2.Entity;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;

import java.util.Map;

import static com.matthewedevelopment.ps.mechanics.monster.entities.PsGolem.getPrivateField;

/**
 * Created by Matthew E on 4/2/2017.
 */
public enum PsMonsterTypes {
    PS_GOLEM("PsGolem", 99, PsGolem.class),
    PS_BOW_ZOMBIE("PsBowZombie", 54, PsBowZombie.class),
    PS_ZOMBIE("PsZombie", 54, PsZombie.class);


    private PsMonsterTypes(String name, int id, Class<? extends Entity> custom)
    {
        addToMaps(custom, name, id);
    }

    public static void spawnEntity(Entity entity, Location loc)
    {
        entity.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        ((CraftWorld)loc.getWorld()).getHandle().addEntity(entity);
    }

    private static void addToMaps(Class clazz, String name, int id)
    {
        //getPrivateField is the method from above.
        //Remove the lines with // in front of them if you want to override default entities (You'd have to remove the default entity from the map first though).
        ((Map)getPrivateField("c", net.minecraft.server.v1_9_R2.EntityTypes.class, null)).put(name, clazz);
        ((Map)getPrivateField("d", net.minecraft.server.v1_9_R2.EntityTypes.class, null)).put(clazz, name);
        //((Map)getPrivateField("e", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(Integer.valueOf(id), clazz);
        ((Map)getPrivateField("f", net.minecraft.server.v1_9_R2.EntityTypes.class, null)).put(clazz, Integer.valueOf(id));
        //((Map)getPrivateField("g", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(name, Integer.valueOf(id));
    }

}
