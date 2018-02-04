package io.immersive.event.events.player.connection;

import io.immersive.entity.Player;
import io.immersive.event.extra.CancellableEvent;
import io.immersive.world.position.Position;
import lombok.Getter;
import lombok.NonNull;

public class PlayerTeleportEvent extends CancellableEvent {
    @Getter private final Player player;
    @Getter private final Position origin;
    @Getter private final Position position;
    @Getter private final TeleportReason reason;

    public PlayerTeleportEvent(@NonNull final Player player, @NonNull final Position origin, @NonNull final Position position, @NonNull final TeleportReason reason) {
        this.player = player;
        this.origin = origin;
        this.position = position;
        this.reason = reason;
    }

    public enum TeleportReason {
        MANUAL,
        ENDER_PEARL,
        NETHER_PORTAL,
        END_PORTAL
    }
}
