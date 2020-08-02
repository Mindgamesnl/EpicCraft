package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import com.craftmend.epiccraft.utils.LogicUtil;
import lombok.NoArgsConstructor;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

@NoArgsConstructor
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
    public boolean isAbsolutelyNecessary() {
        return true;
    }

    @Override
    public boolean isApplicable(Player player) {
        return LogicUtil.contains(player.getLocation().getBlock().getBiome(), oceanBiomes);
    }
}
