package com.lunardev.gelos.common;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class CommonPlugin extends JavaPlugin {

    @Override
    public final void onEnable() {
        // Plugin startup logic

        // TODO using reflection get auto register annotations and register them

        onStart();
    }

    @Override
    public final void onDisable() {
        // Plugin shutdown logic
        onShutdown();
    }

    public abstract void onStart();

    public void onShutdown() {}

}
