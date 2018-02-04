package io.immersive.event.events.player.connection;

import io.immersive.entity.Player;
import io.immersive.event.Event;
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
