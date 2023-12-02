package com.lunardev.gelos.gelosgames.timers;

import com.lunardev.gelos.common.tasks.timers.Timer;
import com.lunardev.gelos.gelosgames.events.GameEndEvent;
import com.lunardev.gelos.gelosgames.events.GameStartEvent;
import com.lunardev.gelos.gelosgames.managers.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A timer for the match
 */
public class MatchTimer extends Timer {

    private final GameManager manager;

    public MatchTimer(JavaPlugin plugin, GameManager manager, int gameTime) {
        super(plugin, gameTime);
        this.manager = manager;
    }

    @Override
    public void secondAction() {

    }

    public void startGame() {
        this.startTimer();
        new GameStartEvent(manager).callEvent();
    }

    @Override
    public void cancelTask() {
        super.cancelTask();
        new GameEndEvent(manager).callEvent();
    }
}