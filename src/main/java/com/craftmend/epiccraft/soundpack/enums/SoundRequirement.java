package com.craftmend.epiccraft.soundpack.enums;

import com.craftmend.epiccraft.soundpack.checks.*;
import com.craftmend.epiccraft.soundpack.interfaces.RequirementTest;
import lombok.Getter;
import lombok.SneakyThrows;


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

    @SneakyThrows
    SoundRequirement(Class<?> check) {
        if (RequirementCache.TEST_CACHE.containsKey(check)) {
            test = RequirementCache.TEST_CACHE.get(check);
            return;
        }

        RequirementTest instance = (RequirementTest) check.getConstructor().newInstance();
        RequirementCache.TEST_CACHE.put(check, instance);
        test = instance;
    }
}
