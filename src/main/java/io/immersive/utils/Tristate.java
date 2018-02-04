package io.immersive.utils;

import lombok.Getter;
import lombok.NonNull;

public enum Tristate {
    ALLOW(true),
    DENY(false),
    UNDEFINED(false);

    @Getter private final Boolean value;

    Tristate(@NonNull final boolean value) {
        this.value = value;
    }
}
