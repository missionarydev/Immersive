package io.immersive.packets;

import io.immersive.Immersive;

import java.util.logging.Logger;

public abstract class Packet {
    private static final Logger LOGGER = Immersive.getLogger();
    private final long timestamp;

    public Packet() {
        this.timestamp = System.currentTimeMillis();
    }
}
