package io.immersive.game.permissions;

import io.immersive.utils.Tristate;
import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;

public class Permissible implements IPermissible {
    @Getter private final HashMap<String, AppliedPermission> permissions;

    public Permissible() {
        this.permissions = new HashMap<>();
    }

    public void addPermission(@NonNull final AppliedPermission permission) {
        this.getPermissions().put(permission.getNode(), permission);
    }

    public void removePermission(@NonNull final String node) {
        this.getPermissions().remove(node);
    }

    public void removePermission(@NonNull final AppliedPermission permission) {
        this.removePermission(permission.getNode());
    }

    public boolean isSet(@NonNull final String node) {
        return this.getPermissions().containsKey(node);
    }

    public boolean isSet(@NonNull final Permission permission) {
        return this.isSet(permission.getNode());
    }

    public Tristate getPermissionValue(@NonNull final String node) {
        return (this.isSet(node)) ? this.getPermissions().get(node).getValue() : Tristate.UNDEFINED;
    }

    public Tristate getPermissionValue(@NonNull final Permission permission) {
        return (this.isSet(permission)) ? this.getPermissions().get(permission.getNode()).getValue() : permission.getDefaultValue();
    }

    public boolean hasPermission(@NonNull String node) {
        node = node.toLowerCase();

        for(String perm : this.permissions.keySet()) {
            if(perm.contains("*")) {
                if(perm.equals("*"))
                    return true;

                if(perm.contains(".")) {
                    final String start = perm.split("\\.")[0];

                    if(node.startsWith(start))
                        return true;
                }
            }
        }

        return this.getPermissionValue(node).getValue();
    }

    public boolean hasPermission(@NonNull final Permission permission) {
        return this.hasPermission(permission.getNode());
    }

    public void clearPermissions() {
        this.getPermissions().clear();
    }
}
