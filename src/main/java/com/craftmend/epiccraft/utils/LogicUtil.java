package com.craftmend.epiccraft.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LogicUtil {

    public static <T> boolean contains(T value, T... values) {
        Object[] var2;
        int var3;
        int var4;
        Object v;
        if (value == null) {
            var2 = values;
            var3 = values.length;

            for(var4 = 0; var4 < var3; ++var4) {
                v = var2[var4];
                if (v == null) {
                    return true;
                }
            }
        } else {
            var2 = values;
            var3 = values.length;

            for(var4 = 0; var4 < var3; ++var4) {
                v = var2[var4];
                if (value.equals(v)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static List<Entity> getEntitiesAroundPoint(Location location, double radius) {
        List<Entity> entities = new ArrayList<Entity>();
        World world = location.getWorld();

        // To find chunks we use chunk coordinates (not block coordinates!)
        int smallX = (int) Math.floor((location.getX() - radius) / 16.0D);
        int bigX = (int) Math.floor((location.getX() + radius) / 16.0D);
        int smallZ = (int) Math.floor((location.getZ() - radius) / 16.0D);
        int bigZ = (int) Math.floor((location.getZ() + radius) / 16.0D);

        for (int x = smallX; x <= bigX; x++) {
            for (int z = smallZ; z <= bigZ; z++) {
                if (world.isChunkLoaded(x, z)) {
                    entities.addAll(Arrays.asList(world.getChunkAt(x, z).getEntities())); // Add all entities from this chunk to the list
                }
            }
        }

        // Remove the entities that are within the box above but not actually in the sphere we defined with the radius and location
        // This code below could probably be replaced in Java 8 with a stream -> filter
        Iterator<Entity> entityIterator = entities.iterator(); // Create an iterator so we can loop through the list while removing entries
        while (entityIterator.hasNext()) {
            if (entityIterator.next().getLocation().distanceSquared(location) > radius * radius) { // If the entity is outside of the sphere...
                entityIterator.remove(); // Remove it
            }
        }
        return entities;
    }

}
