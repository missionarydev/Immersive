package io.immersive.world;

import lombok.Getter;
import lombok.NonNull;

public class World {
    @Getter private final String name;
    @Getter private final Environment environment;
    @Getter private final Difficulty difficulty;

    public World(@NonNull final String name, @NonNull final Environment environment, @NonNull final Difficulty difficulty) {
        this.name = name;
        this.environment = environment;
        this.difficulty = difficulty;
    }
}
