package es.hulk.survival.commands.teleport;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.location.OfflinePlayerLocation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportCommand extends BaseCommand {

    @Command(name = "teleport", aliases = {"tp", "teleportar"})

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(ChatUtil.translate("&cUsage: /" + command.getLabel() + " <player>"));
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatUtil.translate("&cError, el jugador no esta online."));
            return;
        }

        player.teleport(target.getLocation());
        player.sendMessage(ChatUtil.translate("&aTe has teletransportado a &e" + target.getName()));
    }
}
