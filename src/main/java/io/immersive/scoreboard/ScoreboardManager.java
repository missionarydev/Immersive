package io.immersive.scoreboard;

import lombok.Getter;
import lombok.Setter;

public class ScoreboardManager {
    @Getter @Setter private Scoreboard mainScoreboard;

    public Scoreboard getNewScoreboard() {
        return new Scoreboard();
    }
}
