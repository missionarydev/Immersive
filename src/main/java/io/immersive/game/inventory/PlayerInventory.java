package io.immersive.game.inventory;

import io.immersive.game.entity.Player;
import lombok.Getter;
import lombok.NonNull;

public class PlayerInventory extends Inventory {
    @Getter private final Player owner;

    public PlayerInventory(@NonNull final Player owner) {
        this.owner = owner;
    }
}
