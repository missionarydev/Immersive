package io.immersive.commands;

import io.immersive.Immersive;
import io.immersive.ImmersiveConfig;
import io.immersive.commands.defaults.*;
import io.immersive.entity.Player;
import io.immersive.server.Console;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    @Getter private final List<Command> commands;

    public CommandManager() {
        this.commands = new ArrayList<>();

        this.commands.add(new HelpCommand());
        this.commands.add(new PluginsCommand());
        this.commands.add(new StopCommand());
        this.commands.add(new VersionCommand());
        this.commands.add(new GamemodeCommand());
    }

    public Command checkCommand(@NonNull final String label) {
        for(Command command : this.getCommands()) {
            if(command.getLabel().equalsIgnoreCase(label))
                return command;

            if(command.getAliases().stream().filter(alias -> alias.equalsIgnoreCase(label)).findFirst().orElse(null) != null)
                return command;
        }

        return null;
    }

    public void callCommand(@NonNull final Sender sender, @NonNull final String label, @NonNull final List<String> args) {
        Immersive.getLogger().info(sender.getName() + " issued command \"" + label.toLowerCase() + "\"");

        final Command command = this.checkCommand(label);

        if(command != null) {
            if(command.getAccess() != CommandAccess.ANYONE) {
                if(command.getAccess() == CommandAccess.PLAYER) {
                    if(!(sender instanceof Player)) {
                        sender.sendMessage(ImmersiveConfig.COMMAND_NO_ACCESS.toString());
                        return;
                    }
                }

                if(command.getAccess() == CommandAccess.CONSOLE) {
                    if(!(sender instanceof Console)) {
                        sender.sendMessage(ImmersiveConfig.COMMAND_NO_ACCESS.toString());
                        return;
                    }
                }
            }

            if(command.checkPermissions(sender)) {
                command.onCommand(sender, label.toLowerCase(), args);
                return;
            } else {
                sender.sendMessage(ImmersiveConfig.COMMAND_NO_PERMISSION.toString());
                return;
            }
        }

        sender.sendMessage(ImmersiveConfig.COMMAND_UNKNOWN.toString().replaceAll("%cmd%", label.toLowerCase()));
    }
}
