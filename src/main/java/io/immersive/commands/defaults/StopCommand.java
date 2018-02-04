package io.immersive.commands.defaults;

import io.immersive.Immersive;
import io.immersive.commands.Command;
import io.immersive.commands.CommandAccess;
import io.immersive.commands.Sender;

import java.util.Arrays;
import java.util.List;

public class StopCommand extends Command {

    public StopCommand() {
        super("stop", "Stop the server.", Arrays.asList("exit", "end"), "immersive.command.stop", CommandAccess.CONSOLE);
    }

    public void onCommand(final Sender sender, final String label, final List<String> args) {
        Immersive.getServer().shutdown();
    }
}
