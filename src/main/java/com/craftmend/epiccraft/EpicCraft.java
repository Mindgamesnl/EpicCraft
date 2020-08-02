package com.craftmend.epiccraft;

import com.craftmend.epiccraft.audio.AudioService;
import com.craftmend.epiccraft.command.EpicSubCommand;
import com.craftmend.epiccraft.player.PlayerUpdater;
import com.craftmend.epiccraft.soundpack.Soundpack;
import com.craftmend.openaudiomc.OpenAudioMc;
import com.craftmend.openaudiomc.spigot.services.threading.ExecutorService;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;

public final class EpicCraft extends JavaPlugin {

    @Getter private ExecutorService executorService;
    @Getter private Soundpack soundpack;
    @Getter private AudioService audioService;

    @SneakyThrows
    @Override
    public void onEnable() {
        // save default soundpack
        saveResource("soundpack.json", false);
        audioService = new AudioService(this);
        loadSoundpack();

        // register command
        OpenAudioMc.getInstance().getCommandModule().registerSubCommand(new EpicSubCommand(this));

        // do threading
        executorService = new ExecutorService(this);
        executorService.getTickRunnables().add(new PlayerUpdater(this));
    }

    public void loadSoundpack() throws FileNotFoundException {
        soundpack = new Soundpack(getDataFolder() + "/soundpack.json");
        audioService.initializeAudio(soundpack.getSounds());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
