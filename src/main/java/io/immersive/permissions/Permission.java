package io.immersive.permissions;

import io.immersive.utils.Tristate;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;

public class Permission {
    @Getter private static final HashMap<String, Permission> permissions = new HashMap<>();

    @Getter private final String node;
    @Getter @Setter private Tristate defaultValue;

    public Permission(@NonNull final String node, @NonNull final Tristate defaultValue) {
        this.node = node;
        this.defaultValue = defaultValue;
    }

    public Permission(@NonNull final String node) {
        this(node, Tristate.UNDEFINED);
    }
}
