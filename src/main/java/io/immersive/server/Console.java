package io.immersive.server;

import io.immersive.Immersive;
import io.immersive.commands.Sender;
import io.immersive.game.permissions.Permission;
import lombok.NonNull;

import java.util.List;

public class Console implements Sender {

    @Override
    public String getName() {
        return "Console";
    }

    @Override
    public boolean hasPermission(@NonNull final String node) {
        return true;
    }

    @Override
    public boolean hasPermission(@NonNull final Permission permission) {
        return true;
    }

    @Override
    public void sendMessage(@NonNull final String message) {
        Immersive.getLogger().info(message);
    }

    @Override
    public void sendMessage(@NonNull final List<String> messages) {
        messages.forEach(this::sendMessage);
    }
}
