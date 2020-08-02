package com.craftmend.epiccraft.audio;

import com.craftmend.epiccraft.EpicCraft;
import com.craftmend.epiccraft.soundpack.models.Sound;
import com.craftmend.openaudiomc.spigot.modules.regions.objects.RegionMedia;

import java.util.HashMap;
import java.util.Map;

public class AudioService {

    private Map<String, RegionMedia> mediaSources = new HashMap<>();

    private EpicCraft epicCraft;

    public AudioService(EpicCraft epicCraft) {
        this.epicCraft = epicCraft;
    }

    public RegionMedia findBySource(String query) {
        for (Map.Entry<String, RegionMedia> entry : mediaSources.entrySet()) {
            if (entry.getValue().getSource().equals(query)) return entry.getValue();
        }
        return null;
    }

    public void initializeAudio(Sound[] clips) {
        mediaSources.clear();
        for (Sound clip : clips) {
            mediaSources.put(clip.getRandomId(), new RegionMedia(clip.getSource(), 100));
        }
    }

}
