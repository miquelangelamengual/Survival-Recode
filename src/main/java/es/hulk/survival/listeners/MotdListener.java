package es.hulk.survival.listeners;

import dev.panda.chat.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdListener implements Listener {

    @EventHandler
    public void onPlayerPing(ServerListPingEvent event) {
        event.setMotd(ChatUtil.translate(
                "&aBienvenido a &6Hulk Survival" +
                    "\n" +
                    "&6Esperamos que disfrutes del servidor!"));
        event.setMaxPlayers(50);
    }

}
