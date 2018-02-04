package io.immersive.commands.defaults;

import io.immersive.Immersive;
import io.immersive.commands.Command;
import io.immersive.commands.Sender;
import io.immersive.plugins.Plugin;

import java.util.Collections;
import java.util.List;

public class PluginsCommand extends Command {

    public PluginsCommand() {
        super("plugins", "Shows a list of plugins.", Collections.singletonList("pl"), "immersive.command.plugins");
    }

    public void onCommand(final Sender sender, final String label, final List<String> args) {
        final List<Plugin> plugins = Immersive.getServer().getPluginManager().getPlugins();

        sender.sendMessage("Plugins (" + plugins.size() + ")" + ":");
        plugins.forEach(plugin -> sender.sendMessage("  - " + plugin.getInfo().name() + " (" + plugin.getInfo().version() + ")"));
    }
}
