package es.hulk.survival;

import dev.panda.chat.ChatUtil;
import dev.panda.file.FileConfig;
import dev.panda.rank.RankManager;
import es.hulk.survival.commands.SurvivalCommand;
import es.hulk.survival.commands.essentials.PlayTimeCommand;
import es.hulk.survival.commands.location.LocationCommand;
import es.hulk.survival.commands.teleport.TeleportAllCommand;
import es.hulk.survival.commands.teleport.TeleportCommand;
import es.hulk.survival.commands.teleport.TeleportCoordsCommand;
import es.hulk.survival.commands.teleport.TeleportHereCommand;
import es.hulk.survival.hooks.ScoreboardHook;
import es.hulk.survival.hooks.TablistHook;
import es.hulk.survival.listeners.*;
import es.hulk.survival.location.WarpManager;
import es.hulk.survival.recipes.RecipeManager;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.CommandManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

@Getter @Setter
public final class Survival extends JavaPlugin {

    @Getter private static Survival instance;

    private CommandManager commandManager;
    private RankManager rankManager;
    private WarpManager warpManager;
    private RecipeManager recipeManager;
    private FileConfig mainConfig;
    private FileConfig locationsConfig;

    @Override
    public void onEnable() {
        instance = this;

        this.mainConfig = new FileConfig(this, "settings.yml");
        this.locationsConfig = new FileConfig(this, "locations.yml");
        this.loadManagers();

        rankManager.loadRank();
        warpManager.loadWarps();
        if (mainConfig.getBoolean("TOGGLES.RECIPES")) recipeManager.loadRecipes();

        ChatUtil.log("");
        ChatUtil.log("&aSurvival &e- &f" + getDescription().getVersion());
        ChatUtil.log("");
        ChatUtil.log("&aAuthor&7: &f" + getDescription().getAuthors());
        ChatUtil.log("&aVersion&7: &f1.18.1");
        ChatUtil.log("&aRank System&7: &f" + rankManager.getRankSystem());
        ChatUtil.log("");
        this.loadCommands();
        this.loadListeners();
        this.prepareWorlds();
        ScoreboardHook.init(this);
        TablistHook.init(this);
        ChatUtil.log("");
    }

    @Override
    public void onDisable() {
        ScoreboardHook.getScoreboard().getBoards().clear();
        TablistHook.getTablist().disable();
        warpManager.saveWarps();
    }

    private void loadManagers() {
        this.recipeManager = new RecipeManager();
        this.warpManager = new WarpManager(this);
        this.commandManager = new CommandManager(this);
        this.rankManager = new RankManager(this);
    }

    private void loadCommands() {
        List<BaseCommand> commandList = Arrays.asList(
                new SurvivalCommand(),
                new PlayTimeCommand(),
                new LocationCommand(),
                new TeleportCommand(),
                new TeleportAllCommand(),
                new TeleportHereCommand(),
                new TeleportCoordsCommand()
        );

        for (BaseCommand command : commandList) {
            commandManager.registerCommands(command, null);
        }

        ChatUtil.log("&aLoaded &f" + commandList.size() + " &acommands!");
    }

    private void loadListeners() {
        List<Listener> listenerList = Arrays.asList(
                new JoinListener(),
                new ChatListener(),
                new DeathListener(),
                new EntityListener(),
                new CommandsListener(),
                new MotdListener()
        );

        for (Listener listener : listenerList) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }

        ChatUtil.log("&aLoaded &f" + listenerList.size() + " &alisteners!");
    }

    private void prepareWorlds() {
        for (World world : Bukkit.getWorlds()) {
            world.setDifficulty(Difficulty.HARD);
            world.setGameRule(GameRule.KEEP_INVENTORY, true);
            world.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, 0);
            world.setGameRule(GameRule.RANDOM_TICK_SPEED, 50);
        }

        ChatUtil.log("&aPrepared &f" + Bukkit.getWorlds().size() + " &aworlds!");
    }
}
