package io.immersive.inventory;

import io.immersive.inventory.item.ItemStack;
import lombok.Getter;

import java.util.HashMap;

public class Inventory {
    @Getter private final String title;
    @Getter private final int rows;
    @Getter private final HashMap<Integer, ItemStack> items;

    public Inventory() {
        this.title = "";
        this.rows = 1;
        this.items = new HashMap<>();
    }
}
