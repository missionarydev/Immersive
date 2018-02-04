package io.immersive.event.events.player.damage;

import io.immersive.entity.Player;
import io.immersive.event.extra.CancellableEvent;
import lombok.Getter;
import lombok.NonNull;

public class PlayerAttackPlayerEvent extends CancellableEvent {
    @Getter private final Player attacker;
    @Getter private final Player victim;

    public PlayerAttackPlayerEvent(@NonNull final Player attacker, @NonNull final Player victim) {
        this.attacker = attacker;
        this.victim = victim;
    }
}
