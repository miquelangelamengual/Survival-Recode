package es.hulk.survival.utils;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class PlayerUtils {

    private final Player player;

    public PlayerUtils(Player player) {
        this.player = player;
    }

    public int getDeaths() {
        return player.getStatistic(Statistic.DEATHS);
    }

    public int getKills() {
        return player.getStatistic(Statistic.PLAYER_KILLS);
    }

    public int getMobKills() {
        return player.getStatistic(Statistic.MOB_KILLS);
    }

    public String getPlayTime() {
        long ticks = player.getStatistic(Statistic.PLAY_ONE_MINUTE);

        long hour = ((ticks / 20) / 60) / 60;
        long minute = ticks / 1200 - hour * 60;
        long seconds = ticks / 20 - (hour * 60 * 60) - (minute * 60);

        return hour + ":" + minute + ":" + seconds;
    }
}
