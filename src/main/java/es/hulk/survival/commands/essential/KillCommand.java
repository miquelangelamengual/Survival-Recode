package es.hulk.survival.commands.essential;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KillCommand extends BaseCommand {

    @Command(name = "suicide")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.setHealth(0.0D);
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.sendMessage(ChatUtil.translate("&eEl jugador &a" + player.getDisplayName() + " &ese ha suicidado!"));
        }
    }
}
