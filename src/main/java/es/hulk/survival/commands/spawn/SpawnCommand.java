package es.hulk.survival.commands.spawn;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class SpawnCommand extends BaseCommand {

    @Command(name = "spawn")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.teleport(player.getWorld().getSpawnLocation());
        player.sendMessage(ChatUtil.translate("&eHas sido teletransportado en los spawnchunks."));
    }
}
