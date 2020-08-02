package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@NoArgsConstructor
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
