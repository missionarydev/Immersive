package io.immersive.game.world;

import io.immersive.game.world.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Chunk {
    private final List<Block> blocks;

    public Chunk() {
        this.blocks = new ArrayList<>();
    }
}
