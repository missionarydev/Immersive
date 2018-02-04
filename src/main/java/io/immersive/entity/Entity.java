package io.immersive.entity;

import io.immersive.world.position.Position;

public interface Entity {

    Position getPosition();

    void setPosition(final Position position);

    double getHealth();

    void setHealth(final double health);

    int getHunger();

    void setHunger(final int hunger);

}
