package io.immersive.commands.defaults;

import io.immersive.Immersive;
import io.immersive.commands.Command;
import io.immersive.commands.Sender;

import java.util.Collections;
import java.util.List;

public class VersionCommand extends Command {

    public VersionCommand() {
        super("version", "Shows the server version.", Collections.singletonList("ver"), "immersive.command.version");
    }

    public void onCommand(final Sender sender, final String label, final List<String> args) {
        sender.sendMessage("This server is running Immersive. (" + Immersive.VERSION + ")");
        sender.sendMessage("This is an alpha build, this should only be ran in development.");
    }
}
