package com.lunardev.gelos.gelosgames.events;

import com.lunardev.gelos.gelosgames.managers.GameManager;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when the game is ready to start.
 * This event is called before the {@link GameStartEvent}
 */
public class GameReadyEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Getter
    private GameManager gameManager;

    public GameReadyEvent(GameManager manager) {
        this.gameManager = manager;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}