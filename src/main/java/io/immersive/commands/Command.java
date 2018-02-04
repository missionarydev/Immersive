package io.immersive.commands;

import io.immersive.entity.Player;
import io.immersive.server.Console;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    @Getter private final String label;
    @Getter private final String description;
    @Getter private final List<String> aliases;
    @Getter private final String permission;
    @Getter private final CommandAccess access;

    public Command(@NonNull final String label, @NonNull final String description, @NonNull final List<String> aliases, @NonNull final String permission, @NonNull final CommandAccess access) {
        this.label = label;
        this.description = description;
        this.aliases = aliases;
        this.permission = permission;
        this.access = access;
    }

    public Command(@NonNull final String label, @NonNull final String description, @NonNull final List<String> aliases, @NonNull final String permission) {
        this(label, description, aliases, permission, CommandAccess.ANYONE);
    }

    public Command(@NonNull final String label, @NonNull final String description, @NonNull final List<String> aliases) {
        this(label, description, aliases, "");
    }

    public Command(@NonNull final String label, @NonNull final String description, @NonNull final String permission) {
        this(label, description, new ArrayList<>(), permission);
    }

    public Command(@NonNull final String label, @NonNull final String description) {
        this(label, description, new ArrayList<>());
    }

    public boolean isPlayer(@NonNull final Sender sender) {
        return sender instanceof Player;
    }

    public boolean isConsole(@NonNull final Sender sender) {
        return sender instanceof Console;
    }

    public final boolean checkPermissions(@NonNull final Sender sender) {
        return this.getPermission().length() == 0 || sender.hasPermission(this.getPermission());
    }

    public abstract void onCommand(final Sender sender, final String label, final List<String> args);
}
