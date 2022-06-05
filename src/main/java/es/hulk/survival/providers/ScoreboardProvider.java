package es.hulk.survival.providers;

import es.hulk.survival.utils.scoreboard.ScoreboardAdapter;
import es.hulk.survival.utils.scoreboard.ScoreboardStyle;
import org.bukkit.entity.Player;

import java.util.List;

public class ScoreboardProvider implements ScoreboardAdapter {
    @Override
    public String getTitle(Player player) {
        return null;
    }

    @Override
    public List<String> getLines(Player player) {
        return null;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return null;
    }
}
