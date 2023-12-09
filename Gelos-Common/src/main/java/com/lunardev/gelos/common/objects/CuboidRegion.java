package com.lunardev.gelos.common.objects;

import com.lunardev.gelos.common.utils.LocationUtils;
import lombok.Getter;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This class represents a cuboid region in a Minecraft world.
 * The region is defined by two points: pos1 and pos2.
 */
@Getter
public class CuboidRegion {

    private final Location pos1;
    private final Location pos2;

    /**
     * Constructs a new CuboidRegion with the given locations.
     *
     * @param pos1 the first point of the cuboid region
     * @param pos2 the second point of the cuboid region
     */
    public CuboidRegion(Location pos1, Location pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    /**
     * Checks if a given location is within the cuboid region.
     *
     * @param location the location to check
     * @return true if the location is within the region, false otherwise
     */
    public boolean isInRegion(Location location) {
        return location.getX() >= pos1.getX() && location.getX() <= pos2.getX() &&
                location.getY() >= pos1.getY() && location.getY() <= pos2.getY() &&
                location.getZ() >= pos1.getZ() && location.getZ() <= pos2.getZ();
    }

    /**
     * Checks if a given location is within the cuboid region considering an offset.
     *
     * @param location the location to check
     * @param offset   the offset to consider in all directions
     * @return true if the location is within the region, false otherwise
     */
    public boolean isInRegion(Location location, double offset) {
        return location.getX() >= pos1.getX() - offset && location.getX() <= pos2.getX() + offset &&
                location.getY() >= pos1.getY() - offset && location.getY() <= pos2.getY() + offset &&
                location.getZ() >= pos1.getZ() - offset && location.getZ() <= pos2.getZ() + offset;
    }

    /**
     * Checks if a given location is within the cuboid region considering different offsets for each axis.
     *
     * @param location the location to check
     * @param offsetX  the offset to consider in the X direction
     * @param offsetY  the offset to consider in the Y direction
     * @param offsetZ  the offset to consider in the Z direction
     * @return true if the location is within the region, false otherwise
     */
    public boolean isInRegion(Location location, double offsetX, double offsetY, double offsetZ) {
        return location.getX() >= pos1.getX() - offsetX && location.getX() <= pos2.getX() + offsetX &&
                location.getY() >= pos1.getY() - offsetY && location.getY() <= pos2.getY() + offsetY &&
                location.getZ() >= pos1.getZ() - offsetZ && location.getZ() <= pos2.getZ() + offsetZ;
    }

    /**
     * Checks if a given location is within the cuboid region in the XZ plane (ignoring Y).
     *
     * @param location the location to check
     * @return true if the location is within the region, false otherwise
     */
    public boolean isInRegionWithoutY(Location location) {
        return location.getX() >= pos1.getX() && location.getX() <= pos2.getX() &&
                location.getZ() >= pos1.getZ() && location.getZ() <= pos2.getZ();
    }

    /**
     * Checks if a given location is within the cuboid region in the XZ plane (ignoring Y) considering an offset.
     *
     * @param location the location to check
     * @param offset   the offset to consider in the X and Z directions
     * @return true if the location is within the region, false otherwise
     */
    public boolean isInRegionWithoutY(Location location, double offset) {
        return location.getX() >= pos1.getX() - offset && location.getX() <= pos2.getX() + offset &&
                location.getZ() >= pos1.getZ() - offset && location.getZ() <= pos2.getZ() + offset;
    }

    /**
     * Checks if a given location is within the cuboid region in the XZ plane (ignoring Y) considering different offsets for each axis.
     *
     * @param location the location to check
     * @param offsetX  the offset to consider in the X direction
     * @param offsetZ  the offset to consider in the Z direction
     * @return true if the location is within the region, false otherwise
     */
    public boolean isInRegionWithoutY(Location location, double offsetX, double offsetZ) {
        return location.getX() >= pos1.getX() - offsetX && location.getX() <= pos2.getX() + offsetX &&
                location.getZ() >= pos1.getZ() - offsetZ && location.getZ() <= pos2.getZ() + offsetZ;
    }

    /**
     * Calculates and returns the center location of the cuboid region.
     *
     * @return a Location object representing the center of the cuboid region
     */
    public Location getCenter() {
        return new Location(pos1.getWorld(),
                (pos1.getX() + pos2.getX()) / 2,
                (pos1.getY() + pos2.getY()) / 2,
                (pos1.getZ() + pos2.getZ()) / 2);
    }

    /**
     * Generates and returns a random location within the cuboid region.
     *
     * @param random a Random object to generate random numbers
     * @return a Location object representing a random location within the cuboid region
     */
    public Location getRandomLocation(Random random) {
        return new Location(pos1.getWorld(),
                pos1.getX() + random.nextDouble() * (pos2.getX() - pos1.getX()),
                pos1.getY() + random.nextDouble() * (pos2.getY() - pos1.getY()),
                pos1.getZ() + random.nextDouble() * (pos2.getZ() - pos1.getZ()));
    }

    /**
     * Calculates and returns the size of the cuboid region along the X-axis.
     *
     * @return an integer representing the size of the cuboid region along the X-axis
     */
    public int getXSize() {
        if (pos1.getX() > pos2.getX())
            return (int) (pos1.getX() - pos2.getX());
        else
            return (int) (pos2.getX() - pos1.getX());
    }

    /**
     * Calculates and returns the size of the cuboid region along the Y-axis.
     *
     * @return an integer representing the size of the cuboid region along the Y-axis
     */
    public int getYSize() {
        if (pos1.getY() > pos2.getY())
            return (int) (pos1.getY() - pos2.getY());
        else
            return (int) (pos2.getY() - pos1.getY());
    }

    /**
     * Calculates and returns the size of the cuboid region along the Z-axis.
     *
     * @return an integer representing the size of the cuboid region along the Z-axis
     */
    public int getZSize() {
        if (pos1.getZ() > pos2.getZ())
            return (int) (pos1.getZ() - pos2.getZ());
        else
            return (int) (pos2.getZ() - pos1.getZ());
    }

    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();

        map.put("world", pos1.getWorld().getName());
        map.put("pos1", LocationUtils.locationToString(pos1, false));
        map.put("pos2", LocationUtils.locationToString(pos2, false));
        return map;
    }

    public static CuboidRegion deserialize(Map<String, Object> map) {
        String world = map.get("world").toString();
        return new CuboidRegion(
                LocationUtils.stringToLocation(world + "," + map.get("pos1")),
                LocationUtils.stringToLocation(world + "," + map.get("pos2"))
        );
    }

}