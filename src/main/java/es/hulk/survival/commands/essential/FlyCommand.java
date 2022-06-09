package es.hulk.survival.commands.essential;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class FlyCommand extends BaseCommand {

    @Command(name = "fly")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        PlayerUtils playerUtils = new PlayerUtils(player);

        if (player.getPlayerTime() >= 720000) {
            if (!player.getAllowFlight()) {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(ChatUtil.translate("&8* &aTu modo de vuelo a sido activado."));
            } else {
                player.setFlying(false);
                player.setAllowFlight(false);
                player.sendMessage(ChatUtil.translate("&8* &cTu modo de vuelo a sido desactivado."));
            }
        } else {
            player.sendMessage(ChatUtil.translate("&cNecesitas minimo 10h dentro del servidor &7(Para poder ver el tiempo usa /playtime)"));
        }

    }
}