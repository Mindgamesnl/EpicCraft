package com.craftmend.epiccraft.detection.checks;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;
import com.craftmend.epiccraft.utils.LogicUtil;
import lombok.NoArgsConstructor;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

@NoArgsConstructor
public class HotBiomeCheck implements RequirementTest {

    private Biome[] hotBiomes = new Biome[]{
            Biome.DESERT,
            Biome.DESERT_HILLS,
            Biome.DESERT_LAKES,
            Biome.NETHER_WASTES,
    };

    @Override
    public boolean isAbsolutelyNecessary() {
        return true;
    }

    @Override
    public boolean isApplicable(Player player) {
        return LogicUtil.contains(player.getLocation().getBlock().getBiome(), hotBiomes);
    }
}
