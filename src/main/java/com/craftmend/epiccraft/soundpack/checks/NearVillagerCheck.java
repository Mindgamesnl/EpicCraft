package com.craftmend.epiccraft.soundpack.checks;

import com.craftmend.epiccraft.soundpack.interfaces.RequirementTest;
import com.craftmend.epiccraft.utils.LogicUtil;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NearVillagerCheck implements RequirementTest {

    int radius = 50;

    @Override
    public boolean isApplicable(Player player) {
        boolean foundVillager = false;

        for (Entity nearbyEntity : player.getLocation().getWorld().getNearbyEntities(player.getLocation(), 50, 50, 50)) {
            if (nearbyEntity.getType() == EntityType.VILLAGER) {
                foundVillager = true;
            }
        }

        return foundVillager;
    }
}
