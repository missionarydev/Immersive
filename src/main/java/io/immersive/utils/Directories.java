package io.immersive.utils;

import io.immersive.Immersive;
import lombok.Getter;

import java.io.File;

public class Directories {
    @Getter private static final File rootDirectory = new File(System.getProperty("user.dir") + File.separator + ".immersive");

    @Getter private static final File pluginsDirectory = new File(getRootDirectory().getPath() + File.separator + "plugins");
    @Getter private static final File logsDirectory = new File(getRootDirectory().getPath() + File.separator + "logs");
    @Getter private static final File worldsDirectory = new File(getRootDirectory().getPath() + File.separator + "worlds");

    public static void createDirectories() {
        if(!getPluginsDirectory().exists())
            if(!getPluginsDirectory().mkdirs())
                Immersive.getLogger().severe("Failed to create Plugins directory.");

        if(!getLogsDirectory().exists())
            if(!getLogsDirectory().mkdirs())
                Immersive.getLogger().severe("Failed to create Logs directory.");

        if(!getWorldsDirectory().exists())
            if(!getWorldsDirectory().mkdirs())
                Immersive.getLogger().severe("Failed to create Worlds directory.");
    }
}
