package com.lunardev.gelos.gelosgames.managers;

import com.lunardev.gelos.gelosgames.events.*;
import com.lunardev.gelos.gelosgames.timers.GameEndTimer;
import com.lunardev.gelos.gelosgames.timers.GameLobbyTimer;
import com.lunardev.gelos.gelosgames.timers.GameStartTimer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
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
    private int lobbyTimer = 60;
    @Setter
    private int startTimer = 30;
    @Setter
    private int gameTimer = 60 * 5;
    @Setter
    private int endTimer = 10;

    @Setter
    private int minPlayers = 2;
    @Setter
    private int maxPlayers = 8;

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
        new GameStartTimer(plugin, this, lobbyTimer).startTimer();
        state = GameState.START_TIMER;
    }

    public void lobbyTimer() {
        new GameLobbyTimerEvent(this).callEvent();
        new GameLobbyTimer(plugin, this, lobbyTimer).startTimer();
    }

    @EventHandler
    public void onGameStartTimerFinish(GameStartTimerFinishEvent event) {
        startGame();
    }

    @EventHandler
    public void onGameEnd(GameEndEvent event) {
        new GameEndTimer(plugin, this, endTimer).startTimer();
        new GameEndTimerEvent(this).callEvent();
        state = GameState.ENDED;
        playerManager.clearPlayers();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (joinOnConnect
                && state == GameState.WAITING
                && !event.getPlayer().hasPermission(bypassPermission)
                && playerManager.getPlayers().size() < maxPlayers) {
            playerManager.addPlayer(event.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        playerManager.removePlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerJoinGame(PlayerJoinedGameEvent event) {
        if (state == GameState.WAITING) {
            if (playerManager.getPlayers().size() >= minPlayers) {
                lobbyTimer();
            }
        }
    }

    @EventHandler
    public void onPlayerLeftGame(PlayerLeftGameEvent event) {
        if (state == GameState.WAITING) {
            if (playerManager.getPlayers().size() < minPlayers) {
                new GameLobbyTimerCancelEvent(this).callEvent();
            }
        }
    }
}