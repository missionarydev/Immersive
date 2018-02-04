package io.immersive.client.packet;

import io.immersive.Immersive;
import lombok.Getter;

import java.util.logging.Logger;

public abstract class Packet {
    private static final Logger LOGGER = Immersive.getLogger();
    @Getter private final long timestamp;

    public Packet() {
        this.timestamp = System.currentTimeMillis();
    }
}
