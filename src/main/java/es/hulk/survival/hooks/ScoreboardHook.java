package es.hulk.survival.hooks;

import es.hulk.survival.Survival;
import es.hulk.survival.providers.ScoreboardProvider;
import es.hulk.survival.utils.scoreboard.Scoreboard;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ScoreboardHook {

    @Getter private Scoreboard scoreboard;

    public void init(Survival survival) {
        if (survival.getMainConfig().getBoolean("TOGGLES.TABLIST")) {
            scoreboard = new Scoreboard(survival, new ScoreboardProvider());
        }
    }
}
