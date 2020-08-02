package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import lombok.NoArgsConstructor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

@NoArgsConstructor
public class PlayerUnderwaterCheck implements RequirementTest {

    @Override
    public boolean isAbsolutelyNecessary() {
        return true;
    }

    @Override
    public boolean isApplicable(Player player) {
        return player.getLocation().getBlock().getRelative(0, 2, 0).isLiquid();
    }

}
