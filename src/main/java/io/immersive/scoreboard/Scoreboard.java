package io.immersive.scoreboard;

import io.immersive.entity.Player;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Scoreboard {
    @Getter private final Map<String, Objective> objectives;
    @Getter private final Map<String, Team> teams;
    @Getter private final Set<Player> players;

    public Scoreboard() {
        this.objectives = new HashMap<>();
        this.teams = new HashMap<>();
        this.players = new HashSet<>();
    }
}
