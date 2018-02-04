package io.immersive.scoreboard;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class Score {
    @Getter private final Objective objective;
    @Getter private final String entry;
    @Getter @Setter private int score;
    @Getter @Setter private boolean locked;

    public Score(@NonNull final Objective objective, @NonNull final String entry) {
        this.objective = objective;
        this.entry = entry;
    }
}
