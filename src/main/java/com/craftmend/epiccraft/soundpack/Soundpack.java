package com.craftmend.epiccraft.soundpack;

import com.craftmend.epiccraft.soundpack.models.PackFile;
import com.craftmend.epiccraft.soundpack.models.Sound;
import com.google.gson.Gson;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Soundpack {

    @Getter private Sound[] sounds;

    public Soundpack(String filename) throws FileNotFoundException {
        PackFile file = new Gson().fromJson(new FileReader(filename), PackFile.class);
        sounds = file.getSounds();
    }

}
