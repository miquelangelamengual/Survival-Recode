package es.hulk.survival.commands.essentials;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayTimeCommand extends BaseCommand {

    @Command(name = "playtime")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        PlayerUtils playerUtils = new PlayerUtils(player);

        if (args.length == 0) {
            player.sendMessage(ChatUtil.translate("&aHas jugado un total de &e" + playerUtils.getPlayTime() + " &adentro del Servidor."));
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatUtil.translate("&cEl jugador &4" + args[0] + " &cno se ha encontrado."));
            return;
        }

        if (target.getName().equals(player.getName())) {
            player.sendMessage(ChatUtil.translate("&aHas jugado un total de &e" + playerUtils.getPlayTime() + " &adentro del Servidor."));
            return;
        }
        PlayerUtils targetUtils = new PlayerUtils(target);

        player.sendMessage(ChatUtil.translate("&aEl Jugador &e" + target.getDisplayName() + " &aha jugado un total de &e" + targetUtils.getPlayTime() + " &adentro del Servidor."));
    }
}
