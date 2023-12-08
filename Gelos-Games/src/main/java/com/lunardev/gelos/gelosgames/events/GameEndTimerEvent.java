package com.lunardev.gelos.gelosgames.events;

import com.lunardev.gelos.gelosgames.managers.GameManager;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when the end timer has started.
 * This event is called after the {@link GameEndEvent} and before the {@link GameEndTimerFinishEvent}
 */
public class GameEndTimerEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Getter
    private GameManager gameManager;

    public GameEndTimerEvent(GameManager manager) {
        this.gameManager = manager;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}