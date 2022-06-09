package es.hulk.survival.commands.admin;

import dev.panda.chat.ChatUtil;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SetNameCommand extends BaseCommand {

    @Command(name = "setname", permission = "survival.command.setname")

    @Deprecated
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(ChatUtil.translate(ChatUtil.NORMAL_LINE));
            player.sendMessage(ChatUtil.translate("&aSetName Help"));
            player.sendMessage(ChatUtil.translate(""));
            player.sendMessage(ChatUtil.translate("&a/setname <player> <name> &7- &fSets the name for a player"));
            player.sendMessage(ChatUtil.translate("&a/setname <name> &7- &fChanges your own name"));
            player.sendMessage(ChatUtil.translate("&a/setname reset [player] &7- &fResets to the default name"));
            player.sendMessage(ChatUtil.translate(""));
            player.sendMessage(ChatUtil.translate("[player] es opcional "));
            player.sendMessage(ChatUtil.translate(ChatUtil.NORMAL_LINE));
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reset")) {
                player.setDisplayName(player.getName());
                player.setPlayerListName(player.getName());
                player.sendMessage(ChatUtil.translate("&aHas resetado tu nombre al predeterminado"));
                return;
            }
            player.setDisplayName(args[0]);
            player.setPlayerListName(args[0]);
            player.sendMessage(ChatUtil.translate("&aTu nombre a sido cambiado a &e" + args[0] + "&a."));
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[1]);

            if (args[0].equalsIgnoreCase("reset")) {

                if (target == null) {
                    player.sendMessage(ChatUtil.translate("&cEl Jugador &e" + args[1] + " &ano existe o no esta conectado."));
                    return;
                }

                target.setDisplayName(target.getName());
                target.setPlayerListName(target.getName());
                player.sendMessage(ChatUtil.translate("&aHas resetado el nombre del jugador &e" + target.getDisplayName() + " &aal predeterminado."));
                return;
            }
        }

        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(ChatUtil.translate("&cEl Jugador &e" + args[0] + " &ano existe o no esta conectado."));
                return;
            }

            target.setDisplayName(args[1]);
            target.setPlayerListName(args[1]);
            player.sendMessage(ChatUtil.translate("&aHas cambiado el nombre al jugador &e" + target.getName() + " &apor el nombre &e" + args[1] +" &a."));
        }
    }
}
