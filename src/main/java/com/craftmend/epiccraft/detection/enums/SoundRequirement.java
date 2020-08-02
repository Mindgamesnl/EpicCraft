package com.craftmend.epiccraft.detection.enums;

import com.craftmend.epiccraft.detection.checks.*;
import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;


public enum SoundRequirement {

    NEAR_VILLAGER(NearVillagerCheck.class), // REQUIRES THE PLAYER TO BE NEAR A VILLAGER
    UNDER_GROUND(PlayerUndergroundCheck.class), // REQUIRES THE PLAYER TO NOT BE IN A CAVE
    ABOVE_GROUND(PlayerAboveGroundCheck.class), // REQUIRES THE PLAYER TO BE ABOVE GROUND
    SNOWY_BIOME(PlayerInSnowyBiomeCheck.class), // REQUIRES THE PLAYER TO BE IN A SNOWY BIOME
    OCEAN_BIOME(OceanBiomeCheck.class), // REQUIRES THE PLAYER TO BE IN A OCEAN BIOME
    NORMAL_BIOME(PlainBiomeCheck.class), // REQUIRES THE BIOME TO BE PLAIN-ISH
    HOT_BIOME(HotBiomeCheck.class), // REQUIRES THE BIOME TO BE SUPER DUPER HOT (or lit)
    NIGHT(WorldIsNightCheck.class), // REQUIRES TIME TO BE NIGHT
    DAY(WorldIsDayCheck.class); // REQUIRES TIME TO BE DAY

    @Getter
    private final RequirementTest test;

    SoundRequirement(Class<?> check) {
        if (RequirementCache.TEST_CACHE.containsKey(check)) {
            test = RequirementCache.TEST_CACHE.get(check);
            return;
        }

        RequirementTest instance = null;
        try {
            instance = (RequirementTest) check.getConstructor().newInstance();
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            System.out.println("[EpicCraft] Failed to load " + toString() + "!");
        }
        RequirementCache.TEST_CACHE.put(check, instance);
        test = instance;
    }
}
