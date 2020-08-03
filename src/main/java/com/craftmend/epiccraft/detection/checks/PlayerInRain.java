package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import com.craftmend.epiccraft.utils.LogicUtil;
import lombok.NoArgsConstructor;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

@NoArgsConstructor
public class PlayerInRain implements RequirementTest {

    @Override
    public boolean isAbsolutelyNecessary() {
        return true;
    }

    @Override
    public boolean isApplicable(Player player) {
        return player.getWorld().hasStorm() && LogicUtil.contains(player.getLocation().getBlock().getBiome(), PlainBiomeCheck.PLAIN_BIOMES);
    }
}
