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
}