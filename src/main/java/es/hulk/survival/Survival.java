package es.hulk.survival;

import dev.panda.chat.ChatUtil;
import dev.panda.file.FileConfig;
import dev.panda.rank.RankManager;
import es.hulk.survival.commands.SurvivalCommand;
import es.hulk.survival.hooks.ScoreboardHook;
import es.hulk.survival.hooks.TablistHook;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.CommandManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

@Getter @Setter
public final class Survival extends JavaPlugin {

    @Getter private static Survival instance;

    private CommandManager commandManager;
    private RankManager rankManager;
    private FileConfig mainConfig;

    @Override
    public void onEnable() {
        instance = this;

        this.mainConfig = new FileConfig(this, "settings.yml");
        this.loadManagers();

        rankManager.loadRank();

        ChatUtil.log("");
        ChatUtil.log("&aSurvival &e- &f" + getDescription().getVersion());
        ChatUtil.log("");
        ChatUtil.log("&aAuthor&7: &f" + getDescription().getAuthors());
        ChatUtil.log("&aVersion&7: &f1.18.1");
        ChatUtil.log("&aRank System&7: &f" + rankManager.getRankSystem());
        ChatUtil.log("");
        ScoreboardHook.init(this);
        TablistHook.init(this);
        loadCommands();
        ChatUtil.log("");
    }

    @Override
    public void onDisable() {
        ScoreboardHook.getScoreboard().getBoards().clear();
        TablistHook.getTablist().disable();
    }

    private void loadManagers() {
        this.commandManager = new CommandManager(this);
        this.rankManager = new RankManager(this);
    }

    private void loadCommands() {
        List<BaseCommand> commandList = Arrays.asList(new SurvivalCommand());

        for (BaseCommand command : commandList) {
            CommandManager.getInstance().registerCommands(command, null);
        }

        ChatUtil.log("&aLoaded &f" + commandList.size() + " &acommands!");
    }
}
