package com.craftmend.epiccraft;

import com.craftmend.epiccraft.soundpack.Soundpack;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

public final class EpicCraft extends JavaPlugin {

    @Getter private Soundpack soundpack;

    @SneakyThrows
    @Override
    public void onEnable() {
        // save default soundpack
        saveResource("soundpack.json", false);

        // load default soundpack
        soundpack = new Soundpack(getDataFolder() + "soundpack.json");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
