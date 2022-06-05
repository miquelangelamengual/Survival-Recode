package es.hulk.survival;

import es.hulk.survival.utils.command.CommandManager;
import es.hulk.survival.utils.scoreboard.Scoreboard;
import es.hulk.tablist.Omega;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter @Setter
public final class Survival extends JavaPlugin {

    @Getter private static Survival instance;

    private CommandManager commandManager;
    private Scoreboard scoreboard;
    private Omega tablist;

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
