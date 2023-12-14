package com.lunardev.gelos.common;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;

public class Common {

    private Common() {
        throw new IllegalStateException("Utility class");
    }

    @Getter
    @Setter
    private static String prefix = "§7[§bGelos-Games§7] ";

    /**
     * The error color
     */
    @Getter
    @Setter
    private static String errorColor = "&c";

    /**
     * The warning color
     */
    @Getter
    @Setter
    private static String warningColor = "&e";

    private static String line = "&7&m-----------------------------------------------------";

    /**
     * Logs a message to the console
     *
     * @param message the message to log
     */
    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(prefix + message);
    }

    /**
     * Logs a message to the console, with arguments
     *
     * @param message the message to log
     * @param args    the arguments to format the message with
     */
    public static void log(String message, Object... args) {
        Bukkit.getConsoleSender().sendMessage(prefix + String.format(message, args));
    }

    /**
     * Logs an error to the console
     *
     * @param message the message to log
     */
    public static void logError(String message) {
        Bukkit.getConsoleSender().sendMessage(prefix + "&c" + message);
    }

    /**
     * Logs an error to the console, with arguments
     *
     * @param message the message to log
     * @param args    the arguments to format the message with
     */
    public static void logError(String message, Object... args) {
        Bukkit.getConsoleSender().sendMessage(prefix + "&c" + String.format(message, args));
    }

    public static void logError(Throwable t) {
        Bukkit.getConsoleSender().sendMessage(line);
        Bukkit.getConsoleSender().sendMessage(prefix + "&c" + t.getMessage());
    }

    public static void logError(Throwable t, String message) {
        Bukkit.getConsoleSender().sendMessage(line);
        Bukkit.getConsoleSender().sendMessage(prefix + "&c" + message);
        Bukkit.getConsoleSender().sendMessage(prefix + "&c" + t.getMessage());
    }

    /**
     * Logs a warning to the console
     *
     * @param message the message to log
     */
    public static void logWarning(String message) {
        Bukkit.getConsoleSender().sendMessage(prefix + "&e" + message);
    }

    /**
     * Logs a warning to the console, with arguments
     *
     * @param message the message to log
     * @param args    the arguments to format the message with
     */
    public static void logWarning(String message, Object... args) {
        Bukkit.getConsoleSender().sendMessage(prefix + "&e" + String.format(message, args));
    }

    // Region: String Utils

    /**
     * Replaces {player} with the player's name
     *
     * @param message    the message to replace
     * @param playerName the player to replace the message with
     * @return the message with the player's name
     */
    public static String replacePlayer(String message, String playerName) {
        return message.replace("{player}", playerName);
    }


    // Region: Command Utils

    /**
     * Dispatches a command as the console
     *
     * @param command the command to dispatch
     */
    public static void dispatchCommand(String command) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}