package com.matthewedevelopment.ps.mechanics.player.events;

import com.matthewedevelopment.ps.mechanics.player.ps.PsPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Matthew E on 4/1/2017.
 */
public class PsPlayerQuitEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private PsPlayer psPlayer;

    public PsPlayerQuitEvent(PsPlayer psPlayer) {
        super(false);
        this.psPlayer = psPlayer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public PsPlayer getPsPlayer() {
        return psPlayer;
    }
}
