package io.immersive.event.extra;

import io.immersive.event.Event;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class CancellableEvent extends Event {
    @Getter @Setter private boolean cancelled;

    public CancellableEvent(@NonNull final boolean async) {
        super(async);
    }

    public CancellableEvent() {
        super(false);
    }
}
