package io.immersive.plugins;

import io.immersive.Immersive;
import lombok.Getter;
import lombok.NonNull;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class PluginLogger extends Logger {
    @Getter private final Plugin plugin;

    PluginLogger(@NonNull final Plugin plugin) {
        super(plugin.getClass().getCanonicalName(), null);

        super.setParent(Immersive.getLogger());
        super.setLevel(Level.ALL);

        this.plugin = plugin;
    }

    @Override
    public void log(@NonNull final LogRecord record) {
        record.setMessage(String.format("[%s] %s", this.getPlugin().getInfo().name(), record.getMessage()));
        super.log(record);
    }
}
