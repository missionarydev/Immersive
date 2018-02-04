package io.immersive.event.events.player;

import io.immersive.event.Event;
import io.immersive.game.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PlayerLeaveEvent extends Event {
    @Getter private final Player player;
    @Getter private final ExitReason reason;

    public enum ExitReason {
        DISCONNECT,
        KICK
    }
}
