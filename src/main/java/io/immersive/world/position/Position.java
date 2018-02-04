package io.immersive.world.position;

import io.immersive.world.World;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class Position {
    @Getter private final Location location;
    @Getter private final double yaw, pitch;

    public Position(@NonNull final double x, @NonNull final double y, @NonNull final double z, @NonNull final World world, @NonNull final double yaw, @NonNull final double pitch) {
        this(new Location(x, y, z, world), yaw, pitch);
    }

    public double getX() {
        return this.getLocation().getX();
    }

    public double getY() {
        return this.getLocation().getY();
    }

    public double getZ() {
        return this.getLocation().getZ();
    }

    public World getWorld() {
        return this.getLocation().getWorld();
    }
}
