package com.craftmend.epiccraft.soundpack.checks;

import com.craftmend.epiccraft.soundpack.interfaces.RequirementTest;
import org.bukkit.entity.Player;

public class WorldIsNightCheck implements RequirementTest {

    @Override
    public boolean isApplicable(Player player) {
        long time = player.getWorld().getTime();
        return time <= 0 || time >= 12300;
    }

}
