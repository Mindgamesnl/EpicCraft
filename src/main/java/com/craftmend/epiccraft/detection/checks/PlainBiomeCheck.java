package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import com.craftmend.epiccraft.utils.LogicUtil;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

public class PlainBiomeCheck implements RequirementTest {

    private Biome[] plainBiomes = new Biome[]{
            Biome.PLAINS,
            Biome.FOREST,
            Biome.RIVER,
            Biome.WOODED_MOUNTAINS,
            Biome.WOODED_BADLANDS_PLATEAU,
            Biome.MODIFIED_WOODED_BADLANDS_PLATEAU,
    };

    @Override
    public boolean isApplicable(Player player) {
        return LogicUtil.contains(player.getLocation().getBlock().getBiome(), plainBiomes);
    }
}
