package io.immersive.event.events.player.connection;

import io.immersive.entity.Player;
import io.immersive.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PlayerJoinEvent extends Event {
    @Getter private final Player player;
}
