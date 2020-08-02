package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import com.craftmend.epiccraft.utils.LogicUtil;
import lombok.NoArgsConstructor;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

@NoArgsConstructor
public class PlayerInSnowyBiomeCheck implements RequirementTest {

    private Biome[] coldBiomes = new Biome[]{
            Biome.SNOWY_TUNDRA,
            Biome.SNOWY_MOUNTAINS,
            Biome.SNOWY_BEACH,
            Biome.SNOWY_TAIGA,
            Biome.SNOWY_TAIGA_HILLS,
            Biome.SNOWY_TAIGA_MOUNTAINS,
            Biome.ICE_SPIKES,
            Biome.FROZEN_OCEAN,
            Biome.FROZEN_RIVER,
            Biome.DEEP_COLD_OCEAN,
            Biome.DEEP_FROZEN_OCEAN
    };

    @Override
    public boolean isApplicable(Player player) {
        return LogicUtil.contains(player.getLocation().getBlock().getBiome(), coldBiomes);
    }
}
