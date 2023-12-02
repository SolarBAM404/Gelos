package com.lunardev.gelos.common.tasks.timers;

import com.lunardev.gelos.common.tasks.RunnableObject;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A repeated timer for an action
 */
public abstract class Timer extends RunnableObject {

    protected final JavaPlugin plugin;
    protected final int maxTime;
    protected int currentTime = 0;

    protected Timer(JavaPlugin plugin, int maxTime) {
        this.plugin = plugin;
        this.maxTime = maxTime;
    }

    @Override
    protected void action() {
        if (currentTime < maxTime) {
            secondAction();
        } else {
            cancelTask();
        }
        currentTime++;
    }

    public abstract void secondAction();

    public void startTimer() {
        this.startRepeating(plugin, 0, 1);
    }
}