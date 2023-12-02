package com.lunardev.gelos.gelosgames.timers;

import com.lunardev.gelos.common.tasks.timers.Timer;
import com.lunardev.gelos.gelosgames.events.GameEndTimerFinishEvent;
import com.lunardev.gelos.gelosgames.managers.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GameEndTimer extends Timer {

    private final GameManager manager;

    public GameEndTimer(JavaPlugin plugin, GameManager manager, int endTime) {
        super(plugin, endTime);
        this.manager = manager;
    }

    @Override
    public void secondAction() {

    }

    @Override
    public void cancelTask() {
        super.cancelTask();
        new GameEndTimerFinishEvent(manager).callEvent();
    }
}