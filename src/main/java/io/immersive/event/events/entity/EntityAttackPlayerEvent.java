package io.immersive.event.events.entity;

import io.immersive.entity.Entity;
import io.immersive.entity.Player;
import io.immersive.event.extra.CancellableEvent;
import lombok.Getter;
import lombok.NonNull;

public class EntityAttackPlayerEvent extends CancellableEvent {
    @Getter private final Entity entity;
    @Getter private final Player player;

    public EntityAttackPlayerEvent(@NonNull final Entity entity, @NonNull final Player player) {
        this.entity = entity;
        this.player = player;
    }
}
