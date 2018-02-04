package io.immersive;

import lombok.Getter;
import lombok.NonNull;

public enum ImmersiveConfig {
    COMMAND_UNKNOWN("command.unknown", "Unknown command \"%cmd%\", type \"help\" for a list of commands."),
    COMMAND_USAGE("command.usage", "Usage: /%cmd% %args% - %desc%"),
    COMMAND_NO_ACCESS("command.no-access", "No access."),
    COMMAND_NO_PERMISSION("command.no-permission", "No permission.");

    @Getter private final String key;
    @Getter private final String value;

    ImmersiveConfig(@NonNull final String key, @NonNull final String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
