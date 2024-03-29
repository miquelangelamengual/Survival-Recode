package es.hulk.survival.listeners;

import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatUtil.translate("&e" + player.getDisplayName() + " &aa entrado al servidor para jugar un poquito."));

        if (!player.hasPlayedBefore()) {
            player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 32));
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "recipe give " + player.getName() + " *");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatUtil.translate("&e" + event.getPlayer().getDisplayName() + " &aa salido del servidor."));
    }

}
