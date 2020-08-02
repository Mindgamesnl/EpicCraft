package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import com.craftmend.epiccraft.utils.LogicUtil;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@NoArgsConstructor
public class NearVillagerCheck implements RequirementTest {

    int radius = 50;

    @Override
    public boolean isAbsolutelyNecessary() {
        return true;
    }

    @Override
    public boolean isApplicable(Player player) {
        boolean foundVillager = false;

        for (Entity nearbyEntity : LogicUtil.getEntitiesAroundPoint(player.getLocation(), radius)) {
            if (nearbyEntity.getType() == EntityType.VILLAGER) {
                foundVillager = true;
            }
        }

        return foundVillager;
    }
}
