package com.craftmend.epiccraft.soundpack.checks;

import com.craftmend.epiccraft.soundpack.interfaces.RequirementTest;
import com.craftmend.epiccraft.utils.LogicUtil;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

public class OceanBiomeCheck implements RequirementTest {

    private Biome[] oceanBiomes = new Biome[]{
            Biome.OCEAN,
            Biome.DEEP_OCEAN,
            Biome.WARM_OCEAN,
            Biome.LUKEWARM_OCEAN,
            Biome.COLD_OCEAN,
            Biome.DEEP_WARM_OCEAN,
            Biome.DEEP_LUKEWARM_OCEAN,
    };

    @Override
    public boolean isApplicable(Player player) {
        return LogicUtil.contains(player.getLocation().getBlock().getBiome(), oceanBiomes);
    }
}
