package com.lunardev.gelos.gelosgames.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when the end timer has started.
 * This event is called after the {@link GameEndEvent} and before the {@link GameStartEvent}
 */
public class GameEndTimerFinishEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}