package io.immersive.commands.defaults;

import io.immersive.Immersive;
import io.immersive.ImmersiveConfig;
import io.immersive.commands.Command;
import io.immersive.commands.CommandAccess;
import io.immersive.commands.Sender;
import io.immersive.core.GameMode;
import io.immersive.entity.Player;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

public class GamemodeCommand extends Command {

    public GamemodeCommand() {
        super("gamemode", "Switch your gamemode.", Arrays.asList("gm", "gmode"),"immersive.command.gamemode", CommandAccess.PLAYER);
    }

    public void onCommand(final Sender sender, final String label, final List<String> args) {
        final Player player = (Player) sender;

        if(args.size() == 1 || args.size() == 2) {
            final GameMode gameMode = this.getGameMode(args.get(0));

            if(gameMode == null) {
                player.sendMessage(ImmersiveConfig.COMMAND_DEF_GAMEMODE_INVALID.toString());
                return;
            }

            final Player toSet;

            if(args.size() == 1) {
                toSet = player;
            } else {
                final Player target = Immersive.getServer().getPlayerByName(args.get(1));

                if(target == null) {
                    player.sendMessage(ImmersiveConfig.COMMAND_INVALID_PLAYER.toString());
                    return;
                }

                toSet = target;
            }

            toSet.setGameMode(gameMode);

            return;
        }

        player.sendMessage(ImmersiveConfig.COMMAND_USAGE.toString()
                .replaceAll("%cmd%", label)
                .replaceAll("%args%", "<(creative, c);(survival, s)> [player]")
                .replaceAll("%desc%", this.getDescription())
        );
    }

    private GameMode getGameMode(@NonNull final String arg) {
        return Arrays.stream(GameMode.values()).filter(gameMode -> gameMode.getAliases().contains(arg.toLowerCase())).findFirst().orElse(null);
    }
}
