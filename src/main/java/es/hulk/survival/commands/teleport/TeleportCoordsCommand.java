package es.hulk.survival.commands.teleport;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TeleportCoordsCommand extends BaseCommand {

    @Command(name = "teleportcoords", aliases = {"tppos", "teleportarcoords"})

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(ChatUtil.translate("&cUsage: /tppos <x> <y> <z>"));
        }

        if (args.length > 3) {
            player.sendMessage(ChatUtil.translate("&cError, /tppos <x> <y> <z>"));
            return;
        }
        if (args.length < 3) {
            player.sendMessage(ChatUtil.translate("&cError, /tppos <x> <y> <z>"));
            return;
        }

        player.teleport(new Location(player.getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2])));
        player.sendMessage(ChatUtil.translate("&aTe has teletransportado a &ex: " + args[0] + " y: " + args[1] + " z: " + args[2]));
    }
}
