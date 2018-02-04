package io.immersive.world.chunk;

import io.immersive.world.World;
import lombok.Getter;
import lombok.NonNull;

public class Chunk {
    public static final int X_AXIS = 16;
    public static final int Y_AXIS = 256;
    public static final int Z_AXIS = 16;

    @Getter private final World world;
    @Getter private final int x;
    @Getter private final int z;

    public Chunk(@NonNull final World world) {
        this.world = world;
        this.x = 0;
        this.z = 0;
    }
}
