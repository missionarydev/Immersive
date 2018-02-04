package io.immersive.event.events.player.damage;

import io.immersive.entity.Entity;
import io.immersive.entity.Player;
import io.immersive.event.extra.CancellableEvent;
import lombok.Getter;
import lombok.NonNull;

public class PlayerAttackEntityEvent extends CancellableEvent {
    @Getter private final Player player;
    @Getter private final Entity entity;

    public PlayerAttackEntityEvent(@NonNull final Player player, @NonNull final Entity entity) {
        this.player = player;
        this.entity = entity;
    }
}
