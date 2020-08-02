package com.craftmend.epiccraft.command;

import com.craftmend.epiccraft.EpicCraft;
import com.craftmend.openaudiomc.generic.commands.interfaces.GenericExecutor;
import com.craftmend.openaudiomc.generic.commands.interfaces.SubCommand;
import com.craftmend.openaudiomc.generic.commands.objects.Argument;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.io.FileNotFoundException;

public class EpicSubCommand extends SubCommand {

    private final EpicCraft epicCraft;

    public EpicSubCommand(EpicCraft epicCraft) {
        super("epic");
        this.epicCraft = epicCraft;

        registerArguments(
                new Argument("reload", "reload the soundpack file"),
                new Argument("restore", "restore the default soundpack file")
        );
    }

    @Override
    public void onExecute(GenericExecutor sender, String[] args) {

        // reload sub command
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            message(sender, "Reloading EpicCraft soundpack file..");
            try {
                epicCraft.loadSoundpack();
                message(sender, "Reloaded EpicCraft soundpack file!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                message(sender, "Failed to reload soundpack. Error: " + e.getMessage());
            }
            return;
        }

        // reload sub command
        if (args.length == 1 && args[0].equalsIgnoreCase("restore")) {
            epicCraft.saveResource("soundpack.json", true);
            message(sender, "Restored to the original soundpack file. Please use '/oa epic reload' to apply the pack");
            return;
        }


        Bukkit.getServer().dispatchCommand((CommandSender) sender.getOriginal(), "oa help " + getCommand());
    }
}
