package es.hulk.survival.utils;

import es.hulk.survival.utils.location.BedLocation;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

@Getter
public class PlayerUtils {

    private final Player player;

    private int kills;
    private int deaths;
    private int mobKills;

    private double health;
    private long playTime;

    private String biome;

    public PlayerUtils(Player player) {
        this.player = player;

        this.mobKills = player.getStatistic(Statistic.MOB_KILLS);
        this.deaths = player.getStatistic(Statistic.DEATHS);
        this.kills = player.getStatistic(Statistic.PLAYER_KILLS);

        this.health = player.getHealth() / 2;
        this.playTime = player.getStatistic(Statistic.PLAY_ONE_MINUTE);

        this.biome = String.valueOf(player.getWorld().getBiome(player.getLocation()));
    }

    public String getNicePlayTime() {

        long hour = ((playTime / 20) / 60) / 60;
        long minute = playTime / 1200 - hour * 60;
        long seconds = playTime / 20 - (hour * 60 * 60) - (minute * 60);

        return hour + ":" + minute + ":" + seconds;
    }

    public String getWorld() {
        switch (player.getWorld().getName()) {
            case "world":
                return "Overworld";
            case "world_nether":
                return "Nether";
            case "world_the_end":
                return "The End";
            default:
                return "Unknown";
        }
    }
}
