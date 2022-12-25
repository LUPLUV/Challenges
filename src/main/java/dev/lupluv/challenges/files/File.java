package dev.lupluv.challenges.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

public class File extends java.io.File {
    public File(@NotNull String pathname) {
        super(pathname);
    }

    public FileConfiguration asConfig(){
        return YamlConfiguration.loadConfiguration(this);
    }

}
