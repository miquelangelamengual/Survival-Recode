package es.hulk.survival.commands.gamemode;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.GameMode;
import org.bukkit.Statistic;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand extends BaseCommand {

    @Command(name = "mode")
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender commandSender = command.getSender();
        String[] args = command.getArgs();
        Player player = command.getPlayer();

        if (player.getStatistic(Statistic.PLAY_ONE_MINUTE) >= 2160000) {
            if (args.length == 0) {
                getUsage(commandSender);
            }

            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("camera")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatUtil.translate("&aYou are being putted into Camera Mode"));
                    return;
                }

                if (args[0].equalsIgnoreCase("survival")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatUtil.translate("&aYou are being putted into Survival Mode"));
                    return;
                }

                getUsage(commandSender);

                if (args[0].isEmpty()) {
                    getUsage(commandSender);
                }
            }
        } else {
            player.sendMessage(ChatUtil.translate("&cNecesitas minimo 30h dentro del servidor &7(Usa el comando /playtime para ver el tiempo que llevas jugado)"));
        }
    }

    public void getUsage(CommandSender commandSender) {
        commandSender.sendMessage(ChatUtil.translate(ChatUtil.NORMAL_LINE));
        commandSender.sendMessage(ChatUtil.translate("&e/mode <survivalm/camera> &7- &fits put you in the mode u want"));
        commandSender.sendMessage(ChatUtil.translate("&e/cameram &7- &fPuts the player into spectator mode (can use /cm)"));
        commandSender.sendMessage(ChatUtil.translate("&e/survivalm &7- &fPuts the player into survival mode (can use /sm)"));
        commandSender.sendMessage(ChatUtil.translate(ChatUtil.NORMAL_LINE));

    }

}
