package io.immersive.scoreboard;

import io.immersive.core.Color;
import io.immersive.entity.Player;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class Team {
    @Getter private final Scoreboard scoreboard;
    @Getter private final String name;
    @Getter @Setter private String displayName;
    @Getter @Setter private String prefix;
    @Getter @Setter private String suffix;
    @Getter @Setter private Color color;
    @Getter @Setter private boolean friendlyFire;
    @Getter @Setter private boolean seeInvisible;
    @Getter private final Set<Player> players;

    public Team(@NonNull final Scoreboard scoreboard, @NonNull final String name) {
        this.scoreboard = scoreboard;
        this.name = name;
        this.displayName = name;
        this.prefix = "";
        this.suffix = "";
        this.color = Color.RESET;
        this.friendlyFire = true;
        this.seeInvisible = false;
        this.players = new HashSet<>();
    }
}
