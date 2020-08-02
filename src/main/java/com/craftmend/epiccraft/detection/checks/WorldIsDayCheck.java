package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import org.bukkit.entity.Player;

public class WorldIsDayCheck implements RequirementTest {

    @Override
    public boolean isApplicable(Player player) {
        long time = player.getWorld().getTime();
        return !(time <= 0 || time >= 12300);
    }

}
