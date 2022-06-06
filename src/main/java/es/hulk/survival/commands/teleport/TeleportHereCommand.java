package es.hulk.survival.commands.teleport;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportHereCommand extends BaseCommand {

    @Command(name = "teleporthere", aliases = {"tphere", "s"})
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
            player.sendMessage(ChatUtil.translate("&cPlayer '" + args[0] + "' not found."));
            return;
        }

        target.teleport(player.getLocation());
        player.sendMessage(ChatUtil.translate("&aHas teletransportado a &e" + target.getDisplayName() + " &aa tu posicion."));
        target.sendMessage(ChatUtil.translate("&aHas sido teletransportado a &e" + player.getDisplayName()) + "&a.");
    }
}
