package es.hulk.survival.utils.location;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Objects;

@Getter
public class OfflinePlayerLocation {

    private OfflinePlayer offlinePlayer;

    private int blockX;
    private int blockY;
    private int blockZ;

    private Location location;

    public OfflinePlayerLocation(OfflinePlayer offlinePlayer) {
        this.offlinePlayer = offlinePlayer;

        this.blockX = (int) offlinePlayer.getPlayer().getLocation().getX();
        this.blockY = (int) offlinePlayer.getPlayer().getLocation().getY();
        this.blockZ = (int) offlinePlayer.getPlayer().getLocation().getZ();

        this.location = new Location(offlinePlayer.getPlayer().getWorld(), blockX, blockY, blockZ);
    }

    public String getWorld() {
        Player player = offlinePlayer.getPlayer();
        switch (Objects.requireNonNull(player).getWorld().getName()) {
            case "world":
                return "Overworld";
            case "world_nether":
                return "Nether";
            case "world_the_end":
                return "The End";
            default:
                return "No World Found";
        }
    }


}
