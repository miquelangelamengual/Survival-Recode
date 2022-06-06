package es.hulk.survival.commands.location.subcommands;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import es.hulk.survival.location.WarpManager;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class ListLocationCommand extends BaseCommand {

    private final WarpManager warpManager = Survival.getInstance().getWarpManager();

    @Command(name = "location.list")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (warpManager.getNames().isEmpty()) {
            player.sendMessage(ChatUtil.translate("&cNo Available Locations."));
            return;
        }

        player.sendMessage(ChatUtil.translate("&aAvailable Locations&7: &f" + warpManager.getNames().toString().replace("[", "").replace("]", "")));
    }
}
