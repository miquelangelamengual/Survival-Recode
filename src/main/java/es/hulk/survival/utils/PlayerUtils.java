package es.hulk.survival.utils;

import lombok.Getter;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

@Getter
public class PlayerUtils {

    private final Player player;

    private int kills;
    private int deaths;
    private int mobKills;

    private long playTime;

    public PlayerUtils(Player player) {
        this.player = player;

        this.mobKills = player.getStatistic(Statistic.MOB_KILLS);
        this.deaths = player.getStatistic(Statistic.DEATHS);
        this.kills = player.getStatistic(Statistic.PLAYER_KILLS);
        this.playTime = player.getStatistic(Statistic.PLAY_ONE_MINUTE);
    }

    public String getPlayTime() {

        long hour = ((playTime / 20) / 60) / 60;
        long minute = playTime / 1200 - hour * 60;
        long seconds = playTime / 20 - (hour * 60 * 60) - (minute * 60);

        return hour + ":" + minute + ":" + seconds;
    }
}
