package es.hulk.survival.commands.location.subcommands;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import es.hulk.survival.location.WarpManager;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class DeleteLocationCommand extends BaseCommand {

    @Command(name = "deletelocation")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        WarpManager warpManager = Survival.getInstance().getWarpManager();

        if (args.length == 0) {
            player.sendMessage(ChatUtil.translate("&cUsage: /deletelocation <name>"));
        }

        if (args.length > 0) {
            player.sendMessage(ChatUtil.translate("&cLocation " + args[0] + " has been succesfuly removed"));
            warpManager.deleteWarpByName(args[0]);
        }
    }
}
