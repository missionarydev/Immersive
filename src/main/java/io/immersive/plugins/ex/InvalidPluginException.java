package io.immersive.plugins.ex;

import lombok.NonNull;

public class InvalidPluginException extends Exception {

    public InvalidPluginException(@NonNull final String message) {
        super("[Plugin] " + message);
    }

    public InvalidPluginException(@NonNull final Throwable throwable) {
        super(throwable);
    }

    public InvalidPluginException(@NonNull final String message, @NonNull final Throwable throwable) {
        super("[Plugin] " + message, throwable);
    }
}
