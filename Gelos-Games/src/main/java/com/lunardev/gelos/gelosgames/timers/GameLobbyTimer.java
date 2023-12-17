package com.lunardev.gelos.gelosgames.timers;

import com.lunardev.gelos.common.tasks.timers.Timer;
import com.lunardev.gelos.gelosgames.events.GameLobbyTimerFinishedEvent;
import com.lunardev.gelos.gelosgames.managers.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GameLobbyTimer extends Timer {

    private final GameManager manager;

    public GameLobbyTimer(JavaPlugin plugin, GameManager manager, int time) {
        super(plugin, time);
        this.manager = manager;
    }

    @Override
    public void secondAction() {

    }

    @Override
    public void cancelTask() {
        super.cancelTask();
        new GameLobbyTimerFinishedEvent(manager).callEvent();
    }
}