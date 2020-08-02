package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PlayerUndergroundCheck implements RequirementTest {

    private final int radius = 5;

    @Override
    public boolean isApplicable(Player player) {

        Location center = player.getLocation();
        boolean isAbove = false;

        for (int xMod = -radius; xMod <= radius; xMod++) {
            for (int zMod = -radius; zMod <= radius; zMod++) {
                Location test = center.getBlock().getRelative(xMod, 0, zMod).getLocation();
                if (Objects.requireNonNull(center.getWorld()).getHighestBlockAt(test).getY() > center.getY()) {
                    isAbove = true;
                }
            }
        }

        return !isAbove;
    }

}
