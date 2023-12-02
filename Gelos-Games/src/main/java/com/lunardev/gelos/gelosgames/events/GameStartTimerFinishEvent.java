package com.lunardev.gelos.gelosgames.events;

import com.lunardev.gelos.gelosgames.managers.GameManager;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when the start timer has started.
 * This event is called after the {@link GameStartTimerEvent} and before the {@link GameStartEvent}
 */
public class GameStartTimerFinishEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Getter
    private GameManager gameManager;

    public GameStartTimerFinishEvent(GameManager manager) {
        this.gameManager = manager;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}