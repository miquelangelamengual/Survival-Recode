package es.hulk.survival.commands.admin;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class MoreCommand extends BaseCommand {

    @Command(name = "more", permission = "survival.command.more")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        int amount = player.getInventory().getItemInMainHand().getAmount();

        if (args.length == 0) {
            player.getInventory().getItemInMainHand().setAmount(64);
            player.sendMessage(ChatUtil.translate("&aThe item you have been holding has been stacked to 64."));
        }
        if (args.length > 0) {
            if (Integer.parseInt(args[0]) <= amount) {
                player.sendMessage(ChatUtil.translate("&cYou have more amount for this item"));
                return;
            }
            player.getInventory().getItemInMainHand().setAmount(Integer.parseInt(args[0]));
            player.sendMessage(ChatUtil.translate("&aThe item you have been holding has been stacked to " + args[0] + "."));
        }
    }
}
