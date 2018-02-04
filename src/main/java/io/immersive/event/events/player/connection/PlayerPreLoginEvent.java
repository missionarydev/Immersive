package io.immersive.event.events.player.connection;

import io.immersive.event.Event;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

public class PlayerPreLoginEvent extends Event {
    @Getter private final UUID identifier;
    @Getter private final String name;
    @Getter private final String ipAddress;

    public PlayerPreLoginEvent(@NonNull final UUID identifier, @NonNull final String name, @NonNull final String ipAddress) {
        super(true);

        this.identifier = identifier;
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public void deny(@NonNull final DenyReason reason, @NonNull final String message) {

    }

    public enum DenyReason {
        SERVER_FULL,
        BANNED,
        OTHER
    }
}
