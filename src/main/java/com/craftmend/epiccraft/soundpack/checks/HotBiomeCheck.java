package com.craftmend.epiccraft.soundpack.checks;

import com.craftmend.epiccraft.soundpack.interfaces.RequirementTest;
import com.craftmend.epiccraft.utils.LogicUtil;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

public class HotBiomeCheck implements RequirementTest {

    private Biome[] hotBiomes = new Biome[]{
            Biome.DESERT,
            Biome.DESERT_HILLS,
            Biome.DESERT_LAKES,
            Biome.NETHER_WASTES,
    };

    @Override
    public boolean isApplicable(Player player) {
        return LogicUtil.contains(player.getLocation().getBlock().getBiome(), hotBiomes);
    }
}
