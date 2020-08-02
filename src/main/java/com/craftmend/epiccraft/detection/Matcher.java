package com.craftmend.epiccraft.detection;

import com.craftmend.epiccraft.detection.enums.SoundRequirement;
import com.craftmend.epiccraft.soundpack.models.Sound;

import java.util.List;

public class Matcher {

    public Sound bestMatchFor(Sound[] sounds, List<SoundRequirement> metRequirementsByPlayer) {
        int highestScore = 0;
        Sound bestMatch =  null;

        goOverSound:
        for (Sound sound : sounds) {
            // go over all requirements, and +1 for each that is met
            int metRequirementsForSound = 0;
            for (SoundRequirement requirement : sound.getRequirements()) {
                if (metRequirementsByPlayer.contains(requirement)) {
                    metRequirementsForSound++;
                } else {
                    metRequirementsForSound--;
                    if (requirement.getTest().isAbsolutelyNecessary()) continue goOverSound;
                }
            }

            if (metRequirementsForSound > highestScore) {
                highestScore = metRequirementsForSound;
                bestMatch = sound;
            }
        }

        return bestMatch;
    }

}
