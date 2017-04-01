package com.matthewedevelopment.ps.api.mechanic;

import com.matthewedevelopment.ps.PracticeServer;
import org.bukkit.event.Listener;

/**
 * Created by Matthew E on 4/1/2017.
 */
public abstract class GameMechanic extends BaseMechanic implements Listener {

    public String getDataFolder() {
        return PracticeServer.getPracticeServer().getDataFolder() + "/";
    }
}
