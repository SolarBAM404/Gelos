package com.lunardev.gelos.gelosgames.managers;

import com.lunardev.gelos.gelosgames.events.PlayerGainedScoreEvent;
import com.lunardev.gelos.gelosgames.events.PlayerLossScoreEvent;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

@Getter
public class PlayerManager {

    private List<Player> players = new ArrayList<>();
    private Hashtable<UUID, Integer> playerScores = new Hashtable<>();

    public PlayerManager() {
    }

    public PlayerManager(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public boolean containsPlayer(Player player) {
        return players.contains(player);
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
}