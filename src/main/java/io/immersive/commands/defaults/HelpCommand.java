package io.immersive.commands.defaults;

import io.immersive.Immersive;
import io.immersive.commands.Command;
import io.immersive.commands.Sender;

import java.util.Collections;
import java.util.List;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help", "Show a list of commands.", Collections.singletonList("?"), "immersive.command.help");
    }

    public void onCommand(final Sender sender, final String label, final List<String> args) {
        sender.sendMessage("Help:");
        for(Command command : Immersive.getServer().getCommandManager().getCommands()) {
            final StringBuilder sb = new StringBuilder();
            final String aliases;

            if(command.getAliases().size() > 0) {
                sb.append(" (Aliases: ");

                for(String alias : command.getAliases()) {
                    if(sb.toString().equals(" (Aliases: ")) {
                        sb.append(alias);
                    } else {
                        sb.append(", ").append(alias);
                    }
                }

                sb.append(")");

                aliases = sb.toString();
            } else {
                aliases = "";
            }

            sender.sendMessage("  * /" + command.getLabel() + " - " + command.getDescription() + aliases);
        }
    }
}
