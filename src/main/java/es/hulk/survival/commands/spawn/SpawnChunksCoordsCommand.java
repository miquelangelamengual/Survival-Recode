package es.hulk.survival.commands.spawn;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class SpawnChunksCoordsCommand extends BaseCommand {

    @Command(name = "spawnchunkscoords")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.sendMessage(ChatUtil.translate("&aCoords de los SpawnChunks"));
        player.sendMessage("");
        player.sendMessage(ChatUtil.translate("&aMundo &7: &b" + player.getWorld().getSpawnLocation().getWorld()));
        player.sendMessage(ChatUtil.translate("&aX &7: &b" + player.getWorld().getSpawnLocation().getBlockX()));
        player.sendMessage(ChatUtil.translate("&aY &7: &b" + player.getWorld().getSpawnLocation().getBlockY()));
        player.sendMessage(ChatUtil.translate("&aZ &7: &b" + player.getWorld().getSpawnLocation().getBlockZ()));
    }
}
