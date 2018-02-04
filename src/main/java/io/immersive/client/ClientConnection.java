package io.immersive.client;

import io.immersive.Immersive;
import io.immersive.client.packet.Packet;
import io.immersive.client.packet.PacketInListener;
import io.immersive.entity.Player;
import io.immersive.server.Server;
import lombok.Getter;
import lombok.NonNull;

import java.util.logging.Logger;

public class ClientConnection implements PacketInListener {
    private static final Logger LOGGER = Immersive.getLogger();

    @Getter private final Player player;
    @Getter private final Server server;
    @Getter private final NetworkManager networkManager;

    public ClientConnection(@NonNull final Player player) {
        this.player = player;
        this.server = Immersive.getServer();
        this.networkManager = null;
    }

    @Override
    public void onPacketIn(final Packet packet) {

    }
}
