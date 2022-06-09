package es.hulk.survival.commands.admin;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GetPlayerInformationCommand extends BaseCommand {

    @Command(name = "playerinfo", permission = "survival.comand.playerinfo")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(ChatUtil.translate("&cUsage: /playerinfo <player>"));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(ChatUtil.translate("&cEl Jugador " + args[0] + " no se ha encontrado."));
            }

            String fullip = String.valueOf(target.getAddress());
            String[] ip = fullip.split("/");
            String goodip = ip[1];

            player.sendMessage("");
            player.sendMessage(ChatUtil.translate("&aInformacion del Jugador"));
            player.sendMessage("");
            player.sendMessage(ChatUtil.translate("&eNombre&7: &f" + target.getDisplayName()));
            player.sendMessage(ChatUtil.translate("&eVersion&7: &f" + target.getServer().getBukkitVersion()));
            player.sendMessage(ChatUtil.translate("&ePing&7: &f" + target.getPing()));
            player.sendMessage(ChatUtil.translate("&eIP&7: &f" + goodip));
        }
    }
}
