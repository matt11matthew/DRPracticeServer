package com.matthewedevelopment.ps.mechanics.player.ps;

import com.matthewedevelopment.ps.mechanics.item.builder.ItemBuilder;
import net.minecraft.server.v1_9_R2.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Matthew E on 4/2/2017.
 */
public class PlayerAttributes {

    private PsPlayer psPlayer;
    private HashMap<String, Integer[]> attributeMap;

    public PlayerAttributes(PsPlayer psPlayer) {
        this.psPlayer = psPlayer;
        this.attributeMap = new HashMap<>();

    }

    public void weapon() {
        ItemStack weapon = psPlayer.getPlayer().getItemInHand();
        if ((weapon==null) || (weapon.getType()== Material.AIR)) {
            return;
        }
        if (isWeapon(weapon)) {
            NBTTagCompound tag = CraftItemStack.asNMSCopy(weapon).getTag();
            assert tag != null;
            Arrays.asList(PsAttribute.WeaponAttributeType.values()).forEach(modifier -> {
                PsAttribute.WeaponAttributeType type = PsAttribute.WeaponAttributeType.getByNBTName(modifier.getNBTName());
                assert type != null;

                if (type.isRange()) {
                    attributeMap.put(type.getNBTName(), new Integer[]{attributeMap.getOrDefault(modifier.getNBTName(), new
                            Integer[]{0, 0})[0] + tag.getInt(modifier .getNBTName()+ "Min"), attributeMap.getOrDefault(modifier.getNBTName(), new
                            Integer[]{0, 0})[1] + tag.getInt(modifier.getNBTName() + "Max")
                    });
                } else {
                    attributeMap.put(type.getNBTName(), new Integer[]{0, attributeMap.getOrDefault(modifier.getNBTName(), new
                            Integer[]{0, 0})[1] + tag.getInt(modifier.getNBTName())});
                }
            });
        }
    }

    private boolean isWeapon(ItemStack weapon) {
        return new ItemBuilder(weapon).getTag().hasKey("weapon");
    }

    public void armor() {
        for (ItemStack armor : psPlayer.getPlayer().getInventory().getArmorContents()) {

            NBTTagCompound tag = CraftItemStack.asNMSCopy(armor).getTag();
            assert tag != null;

            Arrays.asList(PsAttribute.ArmorAttributeType.values()).forEach(modifier -> {
                PsAttribute.ArmorAttributeType type = PsAttribute.ArmorAttributeType.getByNBTName(modifier.getNBTName());
                assert type != null;

                if (type.isRange()) {
                    attributeMap.put(type.getNBTName(), new Integer[]{
                            attributeMap.getOrDefault(modifier, new  Integer[]{
                                    0,
                                    0
                            })[0] + tag.getInt(modifier.getNBTName() + "Min"), attributeMap.getOrDefault(modifier.getNBTName(), new Integer[]{
                            0, 0
                    })[1] + tag.getInt(modifier.getNBTName() + "Max")});
                } else {
                    attributeMap.put(type.getNBTName(), new Integer[]{0, attributeMap.get(modifier)[1] + tag.getInt(modifier.getNBTName())});
                }
            });
        }
    }
}
