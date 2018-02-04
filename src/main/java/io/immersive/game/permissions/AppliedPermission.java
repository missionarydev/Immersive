package io.immersive.game.permissions;

import io.immersive.utils.Tristate;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class AppliedPermission {
    @Getter private final Permission permission;
    @Getter @Setter private Tristate value;

    public AppliedPermission(@NonNull final Permission permission, @NonNull final Tristate value) {
        this.permission = permission;
        this.value = value;
    }

    public AppliedPermission(@NonNull final Permission permission) {
        this(permission, permission.getDefaultValue());
    }

    public String getNode() {
        return this.getPermission().getNode();
    }

    public Tristate getDefaultValue() {
        return this.getPermission().getDefaultValue();
    }
}
