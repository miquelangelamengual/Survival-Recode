package es.hulk.survival.commands.essential;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class SeedCommand extends BaseCommand {

    @Command(name = "semilla")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String seed = String.valueOf(Bukkit.getWorlds().get(0).getSeed());

        player.sendMessage(ChatUtil.translate("&eLa semilla del mapa es &a" + seed));
        player.sendMessage(ChatUtil.translate(""));
        player.sendMessage(ChatUtil.translate("&cP.D: La semilla se ha copiado a tu portapapeles."));

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(seed);
        clipboard.setContents(selection, null);
    }
}
