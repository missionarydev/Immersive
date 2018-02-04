package io.immersive;

import lombok.Getter;
import lombok.NonNull;

public enum ImmersiveConfig {
    SERVER_NAME("server.name", "Immersive"),
    SERVER_TPS("server.tps", "20.0"),
    SERVER_VERSION("server.version", "5"),

    WORLD_DAY_LENGTH("world.day-length", "24000"),

    CHUNK_X_AXIS("chunk.x-axis", "16"),
    CHUNK_Y_AXIS("chunk.y-axis", "256"),
    CHUNK_Z_AXIS("chunk.z-axis", "16"),

    COMMAND_UNKNOWN("command.unknown", "Unknown command \"%cmd%\", type \"help\" for a list of commands."),
    COMMAND_USAGE("command.usage", "Usage: /%cmd% %args% - %desc%"),
    COMMAND_NO_ACCESS("command.no-access", "No access."),
    COMMAND_NO_PERMISSION("command.no-permission", "No permission."),
    COMMAND_INVALID_PLAYER("command.invalid-player", "That player is invalid."),

    COMMAND_DEF_GAMEMODE_INVALID("command.def.gamemode.invalid", "That gamemode is invalid.");

    @Getter private final String key;
    @Getter private final String value;

    ImmersiveConfig(@NonNull final String key, @NonNull final String value) {
        this.key = key;
        this.value = value;
    }

    public int asI() {
        return Integer.valueOf(this.getValue());
    }

    public double asD() {
        return Double.valueOf(this.getValue());
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
