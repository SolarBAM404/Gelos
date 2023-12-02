package com.lunardev.gelos.gelosgames.timers;

import com.lunardev.gelos.common.tasks.timers.Timer;
import com.lunardev.gelos.gelosgames.events.GameStartTimerFinishEvent;
import com.lunardev.gelos.gelosgames.managers.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GameStartTimer extends Timer {

    private final GameManager manager;

    public GameStartTimer(JavaPlugin plugin, GameManager manager, int startTime) {
        super(plugin, startTime);
        this.manager = manager;
    }

    @Override
    public void secondAction() {

    }

    @Override
    public void cancelTask() {
        super.cancelTask();
        new GameStartTimerFinishEvent(manager).callEvent();
    }
}