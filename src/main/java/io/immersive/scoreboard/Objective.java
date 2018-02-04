package io.immersive.scoreboard;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Objective {
    @Getter private final String name;
    @Getter @Setter private String displayName;
    @Getter private final String criteria;
    @Getter private final Map<String, Score> scores;

    public Objective(@NonNull final String name, @NonNull final String criteria) {
        this.name = name;
        this.displayName = name;
        this.criteria = criteria;
        this.scores = new HashMap<>();
    }
}
