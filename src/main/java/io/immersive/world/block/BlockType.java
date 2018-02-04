package io.immersive.world.block;

import io.immersive.inventory.item.ItemStack;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class BlockType {
    @Getter private final List<ItemStack> drops;

    public BlockType() {
        this.drops = new ArrayList<>();
    }
}
