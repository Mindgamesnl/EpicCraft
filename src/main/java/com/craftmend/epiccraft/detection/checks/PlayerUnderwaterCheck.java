package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Player;

@NoArgsConstructor
public class WorldIsNightCheck implements RequirementTest {

    @Override
    public boolean isAbsolutelyNecessary() {
        return true;
    }

    @Override
    public boolean isApplicable(Player player) {
        long time = player.getWorld().getTime();
        return time <= 0 || time >= 12300;
    }

}
