package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import lombok.NoArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Objects;

@NoArgsConstructor
public class PlayerUndergroundCheck implements RequirementTest {

    private final int radius = 15;

    @Override
    public boolean isAbsolutelyNecessary() {
        return true;
    }

    @Override
    public boolean isApplicable(Player player) {

        Location center = player.getLocation();
        int surface = radius * radius;
        int detectedBlocks = 0;

        for (int xMod = -radius; xMod <= radius; xMod++) {
            for (int zMod = -radius; zMod <= radius; zMod++) {
                Location test = center.getBlock().getRelative(xMod, 15, zMod).getLocation();
                if (Objects.requireNonNull(center.getWorld()).getHighestBlockAt(test).getY() > (test.getY() + 1)) {
                    detectedBlocks++;
                }
            }
        }

        return (surface / 2) < detectedBlocks;
    }

}
