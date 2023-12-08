package com.lunardev.gelos.gelosgames.events;

import com.lunardev.gelos.gelosgames.managers.GameManager;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when the start timer has started.
 * This event is called after the {@link GameReadyEvent} and before the {@link GameStartEvent}
 */
public class GameStartTimerEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Getter
    private GameManager gameManager;

    public GameStartTimerEvent(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}