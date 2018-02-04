package io.immersive.plugins.ex;

import lombok.NonNull;

public class PluginLoadException extends RuntimeException {

    public PluginLoadException(@NonNull final String plugin, @NonNull final String message) {
        super("[Plugin] Failed to load Plugin '" + plugin + "', error: " + message);
    }
}