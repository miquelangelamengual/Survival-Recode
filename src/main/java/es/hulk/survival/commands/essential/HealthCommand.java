package es.hulk.survival.commands.essential;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HealthCommand extends BaseCommand {

    @Command(name = "health", aliases = "vida")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        PlayerUtils playerUtils = new PlayerUtils(player);
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(ChatUtil.translate("&eTu Vida&7: &a" + playerUtils.getHealth()));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(ChatUtil.translate("&cEl Jugador no esta en linea."));
                return;
            }

            if (target.equals(player)) {
                player.sendMessage(ChatUtil.translate("&eTu Vida&7: &a" + playerUtils.getHealth()));
                return;
            }
            player.sendMessage(ChatUtil.translate("&eLa Vida de &a" + target.getDisplayName() + "7: &a" + playerUtils.getHealth()));
        }
    }
}
