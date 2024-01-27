package koala.dev.freerank.commands.freerank;

import koala.dev.freerank.FreeRank;
import koala.dev.freerank.commands.FreeRankAdmin;
import koala.dev.freerank.utils.CC;
import koala.dev.freerank.utils.commands.Command;
import koala.dev.freerank.utils.commands.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreeRankCommand {
    @Command(name = "freerank")
    public void onCommand(CommandArgs cmd){
        CommandSender sender = cmd.getSender();
        Player player = cmd.getPlayer();
        String[] args = cmd.getArgs();
        FreeRankAdmin whitelist = FreeRank.get().getfreeRankAdmin();
        if (FreeRank.get().getMainConfig().getBoolean("can_claim")) {
            if (!whitelist.isReclaimed(player.getName())) {
                Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), FreeRank.get().getMainConfig().getString("command").replace("%player%", player.getName()));
                player.sendMessage(CC.translate(FreeRank.get().getMainConfig().getString("claimed_message")));
                whitelist.addReclaimed(player.getName());
            } else {
                player.sendMessage(CC.translate(FreeRank.get().getMainConfig().getString("already_claimed_message")));
            }
        } else {
            player.sendMessage(CC.translate(FreeRank.get().getMainConfig().getString("disabled_message")));
        }
    }
}

