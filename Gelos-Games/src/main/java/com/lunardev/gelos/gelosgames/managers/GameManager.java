package com.lunardev.gelos.gelosgames.managers;

import com.lunardev.gelos.gelosgames.events.GameEndEvent;
import com.lunardev.gelos.gelosgames.events.GameStartEvent;
import com.lunardev.gelos.gelosgames.events.GameStartTimerEvent;
import com.lunardev.gelos.gelosgames.events.GameStartTimerFinishEvent;
import com.lunardev.gelos.gelosgames.timers.GameEndTimer;
import com.lunardev.gelos.gelosgames.timers.GameStartTimer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class GameManager implements Listener {

    private static GameManager instance;

    @Getter(AccessLevel.NONE)
    private final JavaPlugin plugin;

    private GameState state = GameState.WAITING;
    private final PlayerManager playerManager = new PlayerManager();

    @Setter
    private boolean joinOnConnect = false;

    @Setter(AccessLevel.PROTECTED)
    private String bypassPermission = "games.join.bypass";

    @Setter
    private int startTimer = 30;
    @Setter
    private int gameTimer = 60 * 5;
    @Setter
    private int endTimer = 10;

    public GameManager(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void startGame() {
        state = GameState.PLAYING;
        new GameStartEvent(this).callEvent();
    }

    public void startTimer() {
        new GameStartTimerEvent(this).callEvent();
        state = GameState.START_TIMER;
    }

    @EventHandler
    public void onGameStartTimer(GameStartTimerEvent event) {
        new GameStartTimer(plugin, this, startTimer).startTimer();
    }

    @EventHandler
    public void onGameStartTimerFinish(GameStartTimerFinishEvent event) {
        startGame();
    }

    @EventHandler
    public void onGameEnd(GameEndEvent event) {
        new GameEndTimer(plugin, this, endTimer).startTimer();
        state = GameState.ENDED;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (joinOnConnect
                && state == GameState.WAITING
                && !event.getPlayer().hasPermission(bypassPermission)) {
            playerManager.addPlayer(event.getPlayer());
        }
    }
}