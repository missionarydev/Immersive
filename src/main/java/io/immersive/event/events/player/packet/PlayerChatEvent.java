package io.immersive.event.events.player.packet;

import io.immersive.entity.Player;
import io.immersive.event.extra.CancellableEvent;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class PlayerChatEvent extends CancellableEvent {
    @Getter private final Player player;
    @Getter @Setter private String chatDisplay;
    @Getter @Setter private String message;

    public PlayerChatEvent(@NonNull final Player player, @NonNull final String chatDisplay, @NonNull final String message) {
        super(true);

        this.player = player;
        this.chatDisplay = chatDisplay;
        this.message = message;
    }
}
