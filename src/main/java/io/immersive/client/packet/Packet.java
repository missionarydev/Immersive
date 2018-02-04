package io.immersive.client.packet;

import com.google.common.collect.BiMap;
import io.immersive.Immersive;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.NonNull;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Packet {
    private static final Logger LOGGER = Immersive.getLogger();

    @Getter private final long timestamp;

    public Packet() {
        this.timestamp = System.currentTimeMillis();
    }

    public static Packet create(@NonNull final BiMap map, final int packet) {
        try {
            final Class oclass = (Class) map.get(packet);

            return oclass == null ? null : (Packet) oclass.newInstance();
        } catch(Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to create packet \"" + packet + "\"", e);
            return null;
        }
    }

    public static void write(@NonNull final ByteBuf buffer, final byte[] bytes) {
        buffer.writeBytes(bytes);
    }

    public static byte[] get(@NonNull final ByteBuf buffer) {
        byte[] bytes = new byte[buffer.readShort()];
        buffer.readBytes(bytes);

        return bytes;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public abstract void handle(PacketListener packetlistener);
}
