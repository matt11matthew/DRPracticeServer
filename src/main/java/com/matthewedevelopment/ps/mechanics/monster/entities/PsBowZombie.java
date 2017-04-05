package com.matthewedevelopment.ps.mechanics.monster.entities;

import net.minecraft.server.v1_9_R2.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;

/**
 * Created by Matthew E on 4/2/2017.
 */
public class PsBowZombie extends EntityZombie {

    public PsBowZombie(org.bukkit.World world)
    {
        super(((CraftWorld)world).getHandle());


//        this.goalSelector.a(0, new PathfinderGoalFloat(this));
//        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
//        this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
//        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
//        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
       // initAttributes();
        this.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(20d);
        this.getAttributeInstance(GenericAttributes.c).setValue(1.00d);
        this.noDamageTicks = 0;
        this.maxNoDamageTicks = 0;
//        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
//        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true));
        clearGoalSelectors();
        LivingEntity livingEntity = (LivingEntity) this.getBukkitEntity();
        livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9099999, 0, false, false));
         livingEntity.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(Material.BOW));
        this.goalSelector.a(0, new PathfinderGoalRandomStroll(this, .6F));
        this.goalSelector.a(1, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(2, new PathfinderGoalRandomLookaround(this));
        this.goalSelector.a(4, new PathFinderShootBow(this, 1.0D, 20, 15.0F));

    }


    public void a(EntityLiving entityLiving, float v) {
        net.minecraft.server.v1_9_R2.ItemStack nmsItem = this.getEquipment(EnumItemSlot.MAINHAND);
        NBTTagCompound tag = nmsItem.getTag();
        org.bukkit.World world =   Bukkit.getWorld(entityLiving.getWorld().getWorldData().getName());
        Location location =entityLiving.getBukkitEntity().getLocation();
        Bukkit.getWorld(entityLiving.getWorld().getWorldData().getName()).spawnArrow(location, location.toVector(), 1.0F, 1.0F);
        //TODO fire arrow
    }

    private void clearGoalSelectors() {
        try {
            Field a = PathfinderGoalSelector.class.getDeclaredField("b");
            Field b = PathfinderGoalSelector.class.getDeclaredField("c");
            a.setAccessible(true);
            b.setAccessible(true);
            ((LinkedHashSet) a.get(this.goalSelector)).clear();
            ((LinkedHashSet) b.get(this.goalSelector)).clear();
        } catch(Throwable e) {
            e.printStackTrace();
        }
    }



    public static Object getPrivateField(String fieldName, Class clazz, Object object)
    {
        Field field;
        Object o = null;
        try
        {
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            o = field.get(object);
        }
        catch(NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return o;
    }
}
