package io.immersive.world.chunk;

import io.immersive.world.World;
import lombok.Getter;
import lombok.NonNull;

public class Chunk {
    @Getter private final World world;
    @Getter private final int x;
    @Getter private final int z;

    public Chunk(@NonNull final World world) {
        this.world = world;
        this.x = 0;
        this.z = 0;
    }
}
