package io.immersive.event;

import lombok.Getter;
import lombok.NonNull;

public class Event {
    @Getter private final boolean async;

    public Event(@NonNull final boolean async) {
        this.async = async;
    }

    public Event() {
        this(false);
    }
}
