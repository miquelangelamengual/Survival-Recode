package es.hulk.survival.listeners;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.location.OfflinePlayerLocation;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Hulk
 * at 05/03/2022 13:41
 * Project: Survival
 * Class: DeathListener
 */

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        assert player != null;
        PlayerUtils playerUtils = new PlayerUtils(player);
        OfflinePlayerLocation playerLocation = new OfflinePlayerLocation(player);

        player.sendTitle(ChatUtil.translate("&4&lHAS MUERTO"), "", 10, 100, 10);
        player.sendMessage("");
        player.sendMessage(ChatUtil.translate("&aCoordenadas donde has muerto&7: "));
        player.sendMessage(ChatUtil.translate("&bMundo&7: &a" + playerUtils.getWorld()));
        player.sendMessage(ChatUtil.translate("&bX&7: &a" + playerLocation.getBlockX()));
        player.sendMessage(ChatUtil.translate("&bY&7: &a" + playerLocation.getBlockY()));
        player.sendMessage(ChatUtil.translate("&bZ&7: &a" + playerLocation.getBlockZ()));
        player.sendMessage("");
    }
}
