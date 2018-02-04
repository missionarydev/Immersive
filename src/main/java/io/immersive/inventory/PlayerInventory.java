package io.immersive.inventory;

import io.immersive.entity.Player;
import lombok.Getter;
import lombok.NonNull;

public class PlayerInventory extends Inventory {
    @Getter private final Player owner;

    public PlayerInventory(@NonNull final Player owner) {
        this.owner = owner;
    }
}
