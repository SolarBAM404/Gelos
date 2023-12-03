package com.lunardev.gelos.gelosgames.events;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when the player has gained some score points.
 */
public class PlayerGainedScoreEvent extends Event {

    @Getter
    private final Player player;

    public PlayerGainedScoreEvent(Player player) {
        this.player = player;
    }

    private static final HandlerList handlers = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}