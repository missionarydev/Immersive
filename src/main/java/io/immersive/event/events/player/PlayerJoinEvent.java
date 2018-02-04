package io.immersive.event.events.player;

import io.immersive.event.Event;
import io.immersive.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PlayerJoinEvent extends Event {
    @Getter private final Player player;
}
