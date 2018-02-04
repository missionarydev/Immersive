package io.immersive.game.entity;

import io.immersive.commands.Sender;
import io.immersive.event.events.player.PlayerTeleportEvent;
import io.immersive.game.GameMode;
import io.immersive.game.inventory.InventoryOwner;
import io.immersive.game.inventory.PlayerInventory;
import io.immersive.game.permissions.IPermissible;
import io.immersive.game.permissions.Permissible;
import io.immersive.game.permissions.Permission;
import io.immersive.game.world.World;
import io.immersive.game.world.position.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public class Player implements Entity, Sender, InventoryOwner {
    @Getter private final UUID uuid;
    @Getter private final String name;
    @Getter private Position position;
    @Getter @Setter private double health;
    @Getter @Setter private int hunger;
    @Getter @Setter private GameMode gameMode;
    @Getter @Setter private boolean sprinting;
    @Getter @Setter private boolean crouching;
    @Getter private final PlayerInventory inventory;
    @Getter @Setter private IPermissible permissible;

    public Player(@NonNull final UUID uuid, @NonNull final String name) {
        this.uuid = uuid;
        this.name = name;
        this.position = new Position(0, 120, 0, new World(), 0, 0);
        this.health = 20;
        this.hunger = 20;
        this.gameMode = GameMode.SURVIVAL;
        this.sprinting = false;
        this.crouching = false;
        this.inventory = new PlayerInventory(this);
        this.permissible = new Permissible();
    }

    public void teleport(@NonNull final Position position) {
        this.teleport(position, PlayerTeleportEvent.TeleportReason.MANUAL);
    }

    public void teleport(@NonNull final Position position, @NonNull final PlayerTeleportEvent.TeleportReason reason) {
        final PlayerTeleportEvent teleportEvent = new PlayerTeleportEvent(this, this.getPosition(), position, reason);

        if(teleportEvent.isCancelled())
            return;

        this.setPosition(position);
    }

    @Override
    public void setPosition(@NonNull final Position position) {
        this.position = position;
    }

    @Override
    public boolean hasPermission(@NonNull final String node) {
        return this.getPermissible().hasPermission(node);
    }

    @Override
    public boolean hasPermission(@NonNull final Permission permission) {
        return this.getPermissible().hasPermission(permission);
    }

    @Override
    public void sendMessage(@NonNull final String message) {
        System.out.println(this.getName() + ": " + message);
    }

    @Override
    public void sendMessage(@NonNull final List<String> messages) {
        messages.forEach(this::sendMessage);
    }
}
