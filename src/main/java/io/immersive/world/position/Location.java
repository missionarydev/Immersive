package io.immersive.world.position;

import io.immersive.world.World;
import lombok.Getter;
import lombok.NonNull;

public class Location {
    @Getter private final Coordinates coordinates;
    @Getter private final World world;

    public Location(@NonNull final Coordinates coordinates, @NonNull final World world) {
        this.coordinates = coordinates;
        this.world = world;
    }

    public Location(@NonNull final double x, @NonNull final double y, @NonNull final double z, @NonNull final World world) {
        this.coordinates = new Coordinates(x, y, z);
        this.world = world;
    }

    public double getX() {
        return this.getCoordinates().getX();
    }

    public double getY() {
        return this.getCoordinates().getY();
    }

    public double getZ() {
        return this.getCoordinates().getZ();
    }
}
