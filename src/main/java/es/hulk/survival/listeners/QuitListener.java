package es.hulk.survival.listeners;

import dev.panda.chat.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatUtil.translate("&e" + event.getPlayer().getDisplayName() + " &aa salido del servidor."));
    }

}
