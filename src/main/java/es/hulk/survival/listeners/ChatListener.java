package es.hulk.survival.listeners;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String prefix = Survival.getInstance().getRankManager().getRank().getPrefix(player.getUniqueId());

        event.setFormat(ChatUtil.translate(prefix + player.getName() + " &8» &r" + event.getMessage()));
    }

}
