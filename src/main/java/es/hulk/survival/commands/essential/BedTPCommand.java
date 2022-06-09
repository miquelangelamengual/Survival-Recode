package es.hulk.survival.commands.essential;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import es.hulk.survival.utils.location.BedLocation;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class BedTPCommand extends BaseCommand {

    @Command(name = "tptobed", aliases = "tpeameamicama")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (player.getStatistic(Statistic.PLAY_ONE_MINUTE) >= 1440000) {
            BedLocation bedLocation = new BedLocation(player);
            Location location = new Location(bedLocation.getLocation().getWorld(), bedLocation.getBlockX(), bedLocation.getBlockY(), bedLocation.getBlockZ());
            player.teleport(location);
        } else {
            player.sendMessage(ChatUtil.translate("&cNecesitas minimo 20h dentro del servidor &7(Para poder ver el tiempo usa /playtime)"));
        }

    }
}
