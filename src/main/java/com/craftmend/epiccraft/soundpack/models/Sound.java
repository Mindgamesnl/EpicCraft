package com.craftmend.epiccraft.soundpack.models;

import com.craftmend.epiccraft.detection.enums.SoundRequirement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Sound {

    private String randomId = UUID.randomUUID().toString();
    private String name;
    private String source;
    private SoundRequirement[] requirements;

}
