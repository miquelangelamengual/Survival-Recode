package es.hulk.survival.providers;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class ScoreboardProvider implements ScoreboardAdapter {

    @Override
    public String getTitle(Player player) {
        return ChatUtil.translate("&6&lHulk &7| &fSurvival");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        PlayerUtils playerUtils = new PlayerUtils(player);
        lines.add(ChatUtil.translate("&7" + fullDateHour()));
        lines.add("");
        lines.add(ChatUtil.translate("&6Muertes"));
        for (Player online : Bukkit.getOnlinePlayers()) {
            PlayerUtils onlineUtils = new PlayerUtils(online);
            lines.add(ChatUtil.translate(" &7* &a" + online.getName() + "&7: &f" + onlineUtils.getDeaths()));
        }
        lines.add("");
        lines.add("&6Jugador");
        lines.add(" &7* &aKills&7: &f" + playerUtils.getKills());
        lines.add(" &7* &aDeaths&7: &f" + playerUtils.getDeaths());
        lines.add("");
        lines.add("&6Servidor");
        lines.add(" &7* &aJugadores&7: &f" + Bukkit.getOnlinePlayers().size());
        lines.add(" &7* &aTu Ping&7: &f" + player.getPing() + "ms");
        lines.add("");
        lines.add("&7&osurvival.mangel.lol");
        return lines;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }

    private String fullDateHour() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
        return sdf.format(new Date());
    }
}
