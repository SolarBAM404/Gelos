package com.lunardev.gelos.gelosgames.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when the game has started.
 * This event is called after the {@link GameStartTimerFinishEvent} has finished.
 */
public class GameStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}