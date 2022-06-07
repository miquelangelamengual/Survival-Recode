package es.hulk.survival.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

public class CommandsListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getPlayer().getUniqueId().equals(UUID.fromString("b7be8875-a5c4-4854-a1db-c68626373c5c"))) {
            if (event.getMessage().startsWith("/time set")) {
                event.getPlayer().sendMessage("Nono");
                event.setCancelled(true);
            }
        }
    }

}
