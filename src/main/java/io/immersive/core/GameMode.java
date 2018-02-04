package io.immersive.core;

import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

public enum GameMode {
    ADVENTURE("&6Adventure", Arrays.asList("adventure", "a", "0")),
    CREATIVE("&aCreative", Arrays.asList("creative", "c", "1")),
    SURVIVAL("&cSurvival", Arrays.asList("survival", "s", "2"));

    @Getter private final String displayName;
    @Getter private final List<String> aliases;

    GameMode(@NonNull final String displayName, @NonNull final List<String> aliases) {
        this.displayName = displayName;
        this.aliases = aliases;
    }
}
