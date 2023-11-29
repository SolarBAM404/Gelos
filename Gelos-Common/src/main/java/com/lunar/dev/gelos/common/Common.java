package com.lunar.dev.gelos.common;

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

    /**
     * Logs a message to the console
     *
     * @param message the message to log
     */
    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + message);
    }

    /**
     * Logs a message to the console, with arguments
     *
     * @param message the message to log
     * @param args    the arguments to format the message with
     */
    public static void log(String message, Object... args) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + String.format(message, args));
    }

    /**
     * Logs an error to the console
     *
     * @param message the message to log
     */
    public static void logError(String message) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "&c" + message);
    }

    /**
     * Logs an error to the console, with arguments
     *
     * @param message the message to log
     * @param args    the arguments to format the message with
     */
    public static void logError(String message, Object... args) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "&c" + String.format(message, args));
    }

    /**
     * Logs a warning to the console
     *
     * @param message the message to log
     */
    public static void logWarning(String message) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "&e" + message);
    }

    /**
     * Logs a warning to the console, with arguments
     *
     * @param message the message to log
     * @param args    the arguments to format the message with
     */
    public static void logWarning(String message, Object... args) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "&e" + String.format(message, args));
    }



}
