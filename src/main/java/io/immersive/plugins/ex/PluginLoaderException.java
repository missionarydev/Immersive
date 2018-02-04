package io.immersive.plugins.ex;

import lombok.NonNull;

public class PluginLoaderException extends RuntimeException {

    public PluginLoaderException(@NonNull final String plugin) {
        super("[Plugin] Plugin '" + plugin + "' failed to be loaded due to an invalid class loader.");
    }
}
