package io.immersive.server;

import io.immersive.Immersive;
import io.immersive.commands.CommandManager;
import io.immersive.entity.Player;
import io.immersive.event.EventManager;
import io.immersive.plugins.PluginManager;
import io.immersive.scoreboard.ScoreboardManager;
import io.immersive.utils.Directories;
import io.immersive.utils.PerformanceUtils;
import lombok.Getter;
import lombok.NonNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    // Other
    @Getter private final HashMap<String, Player> players;
    @Getter private final Console console;

    // Managers
    @Getter private ScoreboardManager scoreboardManager;
    @Getter private EventManager eventManager;
    @Getter private CommandManager commandManager;
    @Getter private PluginManager pluginManager;

    // Threads
    @Getter private TerminalThread terminalThread;
    @Getter private final Thread loggerThread;

    public Server() {
        // Creating Directories
        Directories.createDirectories();

        // Enabling jline debug logs
        Logger.getLogger("org.jline").setLevel(Level.ALL);

        // Start logging thread
        loggerThread = new Thread(new io.immersive.utils.Logger());
        loggerThread.setName("Immersive-Logger-Thread");
        loggerThread.start();

        // Instating "Other"
        this.players = new HashMap<>();
        this.console = new Console();
    }

    public void start() {
        // Printing out a start message.
        System.out.println("Starting Immersive Server..");
        System.out.println("Copyright (c) 2017-2018, Matthew Penner");
        System.out.println("All rights reserved.");
        System.out.println();

        final long startTime = System.currentTimeMillis();

        // Pausing the startup for 2 seconds.
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch(InterruptedException ignored) { }

        // Loading the server
        Immersive.getLogger().info("Starting server.. (" + Immersive.VERSION + ")");
        Immersive.getLogger().info("Loading settings.");

        // Instating Managers
        this.scoreboardManager = new ScoreboardManager();
        this.eventManager = new EventManager();
        this.commandManager = new CommandManager();
        this.pluginManager = new PluginManager();

        // Server has been started, starting the terminal for command inputs.
        Immersive.getLogger().info("Server Started! (" + (System.currentTimeMillis() - startTime) + "ms)");
        Immersive.getLogger().info("Type \"help\" for a list of commands.");

        this.terminalThread = new TerminalThread(this);
    }

    public synchronized void shutdown() {
        Immersive.getLogger().info("Stopping server..");

        this.getTerminalThread().setRunning(false);

        this.getPluginManager().disablePlugins();
        Immersive.getLogger().info("Server stopped.");
        io.immersive.utils.Logger.ALLOW_RUN = false;
        System.exit(0);
    }

    public Player getPlayer(@NonNull final UUID identifier) {
        return this.getPlayer(identifier.toString());
    }

    public Player getPlayer(@NonNull final String identifier) {
        return this.getPlayers().get(identifier);
    }

    public Player getPlayerByName(@NonNull final String name) {
        return this.getPlayers().values().stream().filter(player -> player.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Collection<Player> getOnlinePlayers() {
        return Collections.unmodifiableCollection(this.getPlayers().values());
    }

    public String getUsedMemory() {
        return PerformanceUtils.getUsedMemory();
    }

    public String getMaxMemory() {
        return PerformanceUtils.getMaxMemory();
    }
}
