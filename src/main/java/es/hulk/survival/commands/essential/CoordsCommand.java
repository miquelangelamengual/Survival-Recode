package es.hulk.survival.commands.essential;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.location.OfflinePlayerLocation;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.io.BukkitObjectInputStream;

public class CoordsCommand extends BaseCommand {

    @Command(name = "coords")

    @Override
    public void onCommand(CommandArgs command) {
        String[] args = command.getArgs();
        Player player = command.getPlayer();

        if (args.length == 0) {
            getPlayerCoords(player);
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null || !target.hasPlayedBefore()) {
            target = Bukkit.getPlayer(args[0]);
            player.sendMessage(ChatUtil.translate("&cEl jugador no ha jugado nunca!"));
            return;
        }

        if (target.getName().equals(player.getName())) {
            getPlayerCoords(player);
            return;
        }

        getPlayerCoords(target);
    }

    private void getPlayerCoords(Player player) {
        OfflinePlayerLocation playerLocation = new OfflinePlayerLocation(player);
        player.sendMessage(ChatUtil.translate(""));
        player.sendMessage(ChatUtil.translate("&6Tus Coordenadas"));
        player.sendMessage(ChatUtil.translate("&eMundo&7: " + playerLocation.getWorld()));
        player.sendMessage(ChatUtil.translate("&eX&7: " + playerLocation.getBlockX()));
        player.sendMessage(ChatUtil.translate("&eY&7: " + playerLocation.getBlockY()));
        player.sendMessage(ChatUtil.translate("&eZ&7: " + playerLocation.getBlockZ()));
        player.sendMessage(ChatUtil.translate(""));
    }
}