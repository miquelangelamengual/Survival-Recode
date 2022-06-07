package es.hulk.survival.utils.location;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

@Getter
public class BedLocation {

    private Player player;

    private int blockX;
    private int blockY;
    private int blockZ;
    private World world;

    private Location location;

    public BedLocation(Player player) {
        this.player = player;

        this.world = player.getWorld();

        if (player.getBedSpawnLocation() != null) {
            this.blockX = (int) player.getBedSpawnLocation().getX();
            this.blockY = (int) player.getBedSpawnLocation().getY();
            this.blockZ = (int) player.getBedSpawnLocation().getZ();
        }

        this.location = new Location(world, blockX, blockY, blockZ);
    }

    public String getWorld() {
        switch (player.getBedSpawnLocation().getWorld().getName()) {
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

    public void sendPlayerToBed() {
        player.teleport(location);
    }

}
