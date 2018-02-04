package io.immersive.event.events.entity;

import io.immersive.event.extra.CancellableEvent;
import io.immersive.world.position.Position;
import lombok.Getter;
import lombok.NonNull;

public class EntitySpawnEvent extends CancellableEvent {
    @Getter private final Object entity;
    @Getter private final Position position;

    public EntitySpawnEvent(@NonNull final Object entity, @NonNull final Position position) {
        this.entity = entity;
        this.position = position;
    }
}
