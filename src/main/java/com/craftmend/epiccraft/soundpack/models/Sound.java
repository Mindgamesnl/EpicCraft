package com.craftmend.epiccraft.soundpack.models;

import com.craftmend.epiccraft.detection.enums.SoundRequirement;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Sound {

    private String source;
    private SoundRequirement[] requirements;

}
