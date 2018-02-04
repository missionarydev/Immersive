package io.immersive.item;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class ItemStack {
    @Getter private final Material material;
    @Getter @Setter private int amount;
    @Getter @Setter private short data;
    @Getter @Setter private int durability;

    public ItemStack(@NonNull final Material material, @NonNull final int amount, @NonNull final short data) {
        this.material = material;
        this.amount = amount;
        this.data = data;
        this.durability = 0;
    }
}
