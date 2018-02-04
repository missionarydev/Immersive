package io.immersive.game.world.block;

import io.immersive.game.world.position.Location;
import lombok.Getter;
import lombok.NonNull;

public class Block {
    @Getter private final Location location;

    public Block(@NonNull final Location location) {
        this.location = location;
    }
}
