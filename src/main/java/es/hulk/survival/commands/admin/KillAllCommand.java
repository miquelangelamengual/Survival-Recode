package es.hulk.survival.commands.admin;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KillAllCommand extends BaseCommand {

    @Command(name = "killall", permission = "survival.command.killall")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.setHealth(0.0D);
        }
        Bukkit.broadcastMessage(ChatUtil.translate("&cTodos los jugadores han muerto!"));
    }
}
