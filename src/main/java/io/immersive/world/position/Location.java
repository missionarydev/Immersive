package io.immersive.world.position;

import io.immersive.world.World;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class Location {
    @Getter private final Coordinates coordinates;
    @Getter private final World world;

    public Location(@NonNull final double x, @NonNull final double y, @NonNull final double z, @NonNull final World world) {
        this(new Coordinates(x, y, z), world);
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
