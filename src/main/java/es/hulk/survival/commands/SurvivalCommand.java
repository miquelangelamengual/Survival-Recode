package es.hulk.survival.commands;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.Survival;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class SurvivalCommand extends BaseCommand {

    @Command(name = "survival")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage("");
            player.sendMessage(ChatUtil.translate("&aSurvival Help"));
            player.sendMessage("");
            player.sendMessage(ChatUtil.translate("&a/survival version &7- &fShow the info about the plugin"));
            player.sendMessage(ChatUtil.translate("&a/survival reload &7- &freload the plugin"));
            player.sendMessage("");
            return;
        }

        if (args[0].equalsIgnoreCase("version")) {
            player.sendMessage("");
            player.sendMessage(ChatUtil.translate("&aSurvival &7- &fRecode"));
            player.sendMessage("");
            player.sendMessage(ChatUtil.translate("&aVersion&7: &e" + Survival.getInstance().getDescription().getVersion()));
            player.sendMessage(ChatUtil.translate("&aAuthor&7: &e" + Survival.getInstance().getDescription().getAuthors()));
            player.sendMessage("");
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            Survival.getInstance().getMainConfig().reload();
            player.sendMessage(ChatUtil.translate("&aConfig reloaded"));
        }

    }
}
