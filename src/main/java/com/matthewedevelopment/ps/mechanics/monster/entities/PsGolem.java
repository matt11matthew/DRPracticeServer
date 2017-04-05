package com.matthewedevelopment.ps.mechanics.monster.entities;

import net.minecraft.server.v1_9_R2.*;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;

/**
 * Created by Matthew E on 4/2/2017.
 */
public class PsGolem extends EntityIronGolem {

    public PsGolem(org.bukkit.World world)
    {
        super(((CraftWorld)world).getHandle());
//        LinkedHashSet goalB = (LinkedHashSet)getPrivateField("b", PathfinderGoalSelector.class, goalSelector); goalB.clear();
//        LinkedHashSet goalC = (LinkedHashSet)getPrivateField("c", PathfinderGoalSelector.class, goalSelector); goalC.clear();
//        LinkedHashSet targetB = (LinkedHashSet)getPrivateField("b", PathfinderGoalSelector.class, targetSelector); targetB.clear();
//        LinkedHashSet targetC = (LinkedHashSet)getPrivateField("c", PathfinderGoalSelector.class, targetSelector); targetC.clear();

//        this.goalSelector.a(0, new PathfinderGoalFloat(this));
//        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
//        this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
//        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
//        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityH
// uman.class, 8.0F));
        clearGoalSelectors();
       // initAttributes();
        this.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(20d);
        this.getAttributeInstance(GenericAttributes.c).setValue(1.00d);
        this.noDamageTicks = 0;
        this.maxNoDamageTicks = 0;
//        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
//        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true))
// ;

        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
       // this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 0.2D));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
        this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, 1.0D, false));
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
