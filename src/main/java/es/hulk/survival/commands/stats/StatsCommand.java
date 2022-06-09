package es.hulk.survival.commands.stats;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 13/10/2021 23:35
 * Project: Survival
 * Class: StatsCommand
 */

public class StatsCommand extends BaseCommand {

    @Command(name = "stats")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            getUsage(player, player);
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(ChatUtil.translate("&cEl Jugador no esta conectado o no existe"));
                return;
            }

            getUsage(player, target);
        }
    }

    public void getUsage(Player player, Player target) {
        PlayerUtils playerUtils = new PlayerUtils(target);
        if (target.getName().equals(player.getName())) {
            player.sendMessage(ChatUtil.translate("&aTus Estadisticas"));
        } else {
            player.sendMessage(ChatUtil.translate("&aEstadisticas del jugador &e" + target.getName()));
        }

        player.sendMessage("");
        player.sendMessage(ChatUtil.translate("&bMobs Asesinados&7: &e" + playerUtils.getMobKills()));
        player.sendMessage(ChatUtil.translate("&bJugadores Asesinados&7: &e" + playerUtils.getKills()));
        player.sendMessage(ChatUtil.translate("&bMuertes&7: &e" + playerUtils.getDeaths()));
        player.sendMessage(ChatUtil.translate("&bTiempo Jugado&7: &e" + playerUtils.getPlayTime()));
        player.sendMessage(ChatUtil.translate("&bVida&7: &e" + playerUtils.getHealth()));
    }
}
