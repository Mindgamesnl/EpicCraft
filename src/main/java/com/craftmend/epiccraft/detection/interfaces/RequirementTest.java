package com.craftmend.epiccraft.detection.interfaces;

import org.bukkit.entity.Player;

public interface RequirementTest {

    public boolean isAbsolutelyNecessary();
    boolean isApplicable(Player player);

}
