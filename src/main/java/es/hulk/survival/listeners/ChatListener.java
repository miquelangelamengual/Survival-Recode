package es.hulk.survival.listeners;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.location.BedLocation;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.concurrent.TimeUnit;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String prefix = Survival.getInstance().getRankManager().getRank().getPrefix(player.getUniqueId());

        event.setFormat(ChatUtil.translate(prefix + player.getName() + " &8» &r" + event.getMessage()));
    }

    @EventHandler
    public void playerChat(PlayerChatEvent event) {
        PlayerUtils playerUtils = new PlayerUtils(event.getPlayer());
        BedLocation bedLocation = new BedLocation(event.getPlayer());

        if (event.getMessage().contains("tpeame a mi casa") || event.getMessage().contains("tpeame a mi cama")) {
            if (playerUtils.getPlayTime() >= TimeUnit.MILLISECONDS.toHours(5)) {
                bedLocation.sendPlayerToBed();
                event.setCancelled(true);
            } else {
                event.getPlayer().sendMessage(ChatUtil.translate("&cNecesitas minimo 5h dentro del servidor &7(Para poder ver el tiempo usa /playtime)"));
                event.setCancelled(true);
            }
        }

    }

}
