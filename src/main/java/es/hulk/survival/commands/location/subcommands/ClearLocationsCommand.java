package es.hulk.survival.commands.location.subcommands;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import es.hulk.survival.location.WarpManager;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class ClearLocationsCommand extends BaseCommand {

    private final WarpManager warpManager = Survival.getInstance().getWarpManager();

    @Command(name = "location.clear", permission = "survival.command.clearlocations")
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender commandSender = command.getSender();

        warpManager.clearWarp();
        commandSender.sendMessage(ChatUtil.translate("&aSuccesfully cleared all saved locations"));
    }
}
