package com.lunardev.gelos.gelosgames.managers;

import com.lunardev.gelos.gelosgames.events.PlayerGainedScoreEvent;
import com.lunardev.gelos.gelosgames.events.PlayerLossScoreEvent;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class PlayerManager {

    private List<Player> players = new ArrayList<>();
    private final Hashtable<UUID, Integer> playerScores = new Hashtable<>();

    public PlayerManager() {
    }

    public PlayerManager(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        playerScores.put(player.getUniqueId(), 0);
    }

    public void removePlayer(Player player) {
        players.remove(player);
        playerScores.remove(player.getUniqueId());
    }

    public boolean containsPlayer(Player player) {
        return players.contains(player);
    }

    public boolean containsPlayer(UUID uuid) {
        if (playerScores.containsKey(uuid)) {
            return true;
        }

        AtomicBoolean contains = new AtomicBoolean(false);

        players.forEach(player -> {
            if (player.getUniqueId().equals(uuid)) {
                contains.set(true);
            }
        });

        return contains.get();
    }

    public boolean containsPlayer(String name) {
        if (playerScores.containsKey(name)) {
            return true;
        }

        AtomicBoolean contains = new AtomicBoolean(false);

        players.forEach(player -> {
            if (player.getName().equals(name)) {
                contains.set(true);
            }
        });

        return contains.get();
    }

    public void clearPlayers() {
        players.clear();
    }

    public void addScore(Player player, int score) {
        playerScores.put(player.getUniqueId(), playerScores.get(player.getUniqueId()) + score);
        new PlayerGainedScoreEvent(player).callEvent();
    }

    public void removeScore(Player player, int score) {
        playerScores.put(player.getUniqueId(), playerScores.get(player.getUniqueId()) - score);
        new PlayerLossScoreEvent(player).callEvent();
    }

    public int getScore(Player player) {
        return playerScores.get(player.getUniqueId());
    }

    public void setScore(Player player, int score) {
        playerScores.put(player.getUniqueId(), score);
    }

    public void clearScores() {
        playerScores.clear();
    }

    public void resetScores() {
        playerScores.forEach((uuid, score) -> {
            playerScores.put(uuid, 0);
        });
    }

    public int size() {
        return players.size();
    }

    public boolean isEmpty() {
        return players.isEmpty();
    }
}