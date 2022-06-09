package es.hulk.survival.commands.gamemode.subcommands;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.GameMode;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class SurvivalCommand extends BaseCommand {

    @Command(name = "survivalm", aliases = "sm")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (player.getStatistic(Statistic.PLAY_ONE_MINUTE) >= 2160000) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(ChatUtil.translate("&aYou are being putted into Survival Mode"));
        } else {
            player.sendMessage(ChatUtil.translate("&cNecesitas minimo 30h dentro del servidor &7(Usa el comando /playtime para ver el tiempo que llevas jugado)"));
        }
    }

}
