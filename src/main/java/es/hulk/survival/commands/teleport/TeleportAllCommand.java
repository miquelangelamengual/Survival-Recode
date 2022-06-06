package es.hulk.survival.commands.teleport;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportAllCommand extends BaseCommand {

    @Command(name = "tpall", permission = "survival.command.tpall")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.teleport(player.getLocation());
        }

        player.sendMessage(ChatUtil.translate("&aHabeis sido teletransportado a la localizacion de &e" + player.getDisplayName()));
    }
}
