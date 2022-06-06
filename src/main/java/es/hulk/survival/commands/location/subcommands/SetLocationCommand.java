package es.hulk.survival.commands.location.subcommands;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import es.hulk.survival.location.WarpManager;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

import java.util.Locale;

public class SetLocationCommand extends BaseCommand {

    private final WarpManager warpManager = Survival.getInstance().getWarpManager();

    @Command(name = "setlocation")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(ChatUtil.translate("&cUsage: /setlocation <name>"));
        }

        if (args.length > 0) {
            player.sendMessage(ChatUtil.translate("&aLocation " + args[0] + " has been succesfuly setted"));
            warpManager.createWarp(args[0].toLowerCase(Locale.ROOT), player.getLocation());
            warpManager.saveWarps();
        }
    }


}
