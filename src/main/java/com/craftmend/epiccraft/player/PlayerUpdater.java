package com.craftmend.epiccraft.player;

import com.craftmend.epiccraft.EpicCraft;
import com.craftmend.epiccraft.detection.enums.SoundRequirement;
import com.craftmend.openaudiomc.OpenAudioMc;
import com.craftmend.openaudiomc.generic.networking.client.objects.player.ClientConnection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerUpdater implements Runnable {

    // more efficient since it makes a new collection otherwise
    private final SoundRequirement[] soundRequirements = SoundRequirement.values();
    private final EpicCraft epicCraft;

    public PlayerUpdater(EpicCraft epicCraft) {
        this.epicCraft = epicCraft;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            ClientConnection connection = OpenAudioMc.getInstance().getNetworkingService().getClient(player.getUniqueId());
            if (!connection.isConnected()) continue;

            List<SoundRequirement> metRequirements = new ArrayList<>();

            for (SoundRequirement soundRequirement : soundRequirements) {
                if (soundRequirement.getTest().isApplicable(player)) metRequirements.add(soundRequirement);
            }

            // debug
            player.sendMessage("You match " + OpenAudioMc.getGson().toJson(metRequirements));
        }
    }
}
