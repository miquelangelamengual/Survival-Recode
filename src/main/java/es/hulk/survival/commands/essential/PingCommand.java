package es.hulk.survival.commands.essential;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PingCommand extends BaseCommand {

    @Command(name = "ping")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(ChatUtil.translate("&eTu Ping&7: &a" + player.getPing()));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage("&cEl Jugador no esta en linea!");
                return;
            }
            if (target.getName().equals(player.getName())) {
                player.sendMessage(ChatUtil.translate("&eTu Ping&7: &a" + player.getPing()));
                return;
            }
            player.sendMessage(ChatUtil.translate("&eEl ping de &a" + target.getName() + " &ees de &a" + target.getPing()));
        }
    }
}
