package io.immersive.world.position;

import io.immersive.world.World;
import lombok.Getter;
import lombok.NonNull;

public class Position {
    @Getter private final Location location;
    @Getter private final double yaw, pitch;

    public Position(@NonNull final Location location, @NonNull final double yaw, @NonNull final double pitch) {
        this.location = location;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public Position(@NonNull final double x, @NonNull final double y, @NonNull final double z, @NonNull final World world, @NonNull final double yaw, @NonNull final double pitch) {
        this.location = new Location(x, y, z, world);
        this.yaw = yaw;
        this.pitch = pitch;
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
