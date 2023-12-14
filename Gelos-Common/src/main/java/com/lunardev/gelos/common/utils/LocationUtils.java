package com.lunardev.gelos.common.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtils {

    private LocationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String locationToString(Location location, boolean yawAndPitch) {

        String string = location.getWorld().getName() + ","
                + location.getX() + ","
                + location.getY() + ","
                + location.getZ() + ",";
        if (yawAndPitch) {
            string += location.getYaw() + ","
                    + location.getPitch();
        }

        return string;
    }

    public static Location stringToLocation(String string) {

        String[] split = string.split(",");

        return new Location(
                LocationUtils.getWorld(split[0]),
                Double.parseDouble(split[1]),
                Double.parseDouble(split[2]),
                Double.parseDouble(split[3]),
                split.length == 6 ? Float.parseFloat(split[4]) : 0,
                split.length == 6 ? Float.parseFloat(split[5]) : 0
        );
    }

    public static World getWorld(String name) {
        return Bukkit.getWorld(name);
    }

    public static boolean isBetween(Location pos1, Location pos2, Location location) {
        int x1 = Math.min(pos1.getBlockX(), pos2.getBlockX());
        int x2 = Math.max(pos1.getBlockX(), pos2.getBlockX());
        int y1 = Math.min(pos1.getBlockY(), pos2.getBlockY());
        int y2 = Math.max(pos1.getBlockY(), pos2.getBlockY());
        int z1 = Math.min(pos1.getBlockZ(), pos2.getBlockZ());
        int z2 = Math.max(pos1.getBlockZ(), pos2.getBlockZ());

        return MathsUtils.isBetween(location.getBlockX(), x1, x2)
                && MathsUtils.isBetween(location.getBlockY(), y1, y2)
                && MathsUtils.isBetween(location.getBlockZ(), z1, z2);
    }

    public static boolean isBetweenXZ(Location pos1, Location pos2, Location location) {
        int x1 = Math.min(pos1.getBlockX(), pos2.getBlockX());
        int x2 = Math.max(pos1.getBlockX(), pos2.getBlockX());
        int z1 = Math.min(pos1.getBlockZ(), pos2.getBlockZ());
        int z2 = Math.max(pos1.getBlockZ(), pos2.getBlockZ());

        return MathsUtils.isBetween(location.getBlockX(), x1, x2)
                && MathsUtils.isBetween(location.getBlockZ(), z1, z2);
    }
}