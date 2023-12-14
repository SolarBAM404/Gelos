package com.lunardev.gelos.gelosgames.events;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when a player has been teleported to the start location.
 */
public class PlayerJoinedGameEvent extends Event {

    @Getter
    private final Player player;

    public PlayerJoinedGameEvent(Player player) {
        this.player = player;
    }

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}