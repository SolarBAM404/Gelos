package com.lunardev.gelos.gelosgames.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when the game has Ended.
 * This event is called after the game has finished but before the {@link GameEndTimerEvent} has started.
 */
public class GameEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}