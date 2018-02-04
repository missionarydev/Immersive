package io.immersive.core;

import lombok.Getter;
import lombok.NonNull;

public enum GameMode {
    ADVENTURE("&6Adventure", 0),
    SURVIVAL("&cSurvival", 1),
    CREATIVE("&aCreative", 2),
    SPECTATOR("&7Spectator", 3);

    @Getter private final String displayName;
    @Getter private final int level;

    GameMode(@NonNull final String displayName, @NonNull final int level) {
        this.displayName = displayName;
        this.level = level;
    }
}
