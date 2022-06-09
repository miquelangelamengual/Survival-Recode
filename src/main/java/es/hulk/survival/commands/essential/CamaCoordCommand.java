package es.hulk.survival.commands.essential;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.location.BedLocation;
import org.bukkit.entity.Player;

public class CamaCoordCommand extends BaseCommand {

    @Command(name = "camacoords")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        BedLocation bedLocation = new BedLocation(player);

        player.sendMessage(ChatUtil.translate(""));
        player.sendMessage(ChatUtil.translate("&6Coords de tu Cama"));
        player.sendMessage(ChatUtil.translate("&eMundo&7: " + bedLocation.getNiceWorld()));
        player.sendMessage(ChatUtil.translate("&eX&7: " + bedLocation.getBlockX()));
        player.sendMessage(ChatUtil.translate("&eY&7: " + bedLocation.getBlockY()));
        player.sendMessage(ChatUtil.translate("&eZ&7: " + bedLocation.getBlockZ()));
        player.sendMessage(ChatUtil.translate(""));
    }
}
