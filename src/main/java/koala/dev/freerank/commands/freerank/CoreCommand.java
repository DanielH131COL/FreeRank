package koala.dev.freerank.commands.freerank;

import koala.dev.freerank.FreeRank;
import koala.dev.freerank.utils.CC;
import koala.dev.freerank.utils.commands.Command;
import koala.dev.freerank.utils.commands.CommandArgs;
import org.bukkit.command.CommandSender;

public class CoreCommand {

    @Command(name = "core")
    public void onCommand(CommandArgs cmd){
        CommandSender sender = cmd.getSender();
        String[] args = cmd.getArgs();

        if (args.length == 0) {
            sender.sendMessage(CC.translate("&a------------------------"));
            sender.sendMessage(CC.translate("&b&lKoalaHub's"));
            sender.sendMessage(CC.translate(""));
            sender.sendMessage(CC.translate("&bVersion&7: &f" + FreeRank.get().getDescription().getVersion()));
            sender.sendMessage(CC.translate("&bAuthors&7: &f" + FreeRank.get().getDescription().getAuthors()));
            sender.sendMessage(CC.translate(""));
            sender.sendMessage(CC.translate("&3This server is using the KoalaHub core"));
            sender.sendMessage(CC.translate("&b->> &fhttps://discord.gg/2g9JeC7G7M"));
            sender.sendMessage(CC.translate(""));
            if (sender.hasPermission("koalahub.reload"))
                sender.sendMessage(CC.translate("&b/koalahub reload &7- Reload KoalaHub Files."));
            sender.sendMessage(CC.translate("&7&m------------------------------------"));
        }
    }
}

