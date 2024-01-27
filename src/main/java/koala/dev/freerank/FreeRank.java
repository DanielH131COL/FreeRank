package koala.dev.freerank;

import koala.dev.freerank.commands.FreeRankAdmin;
import koala.dev.freerank.commands.freerank.FreeRankCommand;
import koala.dev.freerank.utils.CC;
import koala.dev.freerank.utils.FileConfig;
import koala.dev.freerank.utils.commands.CommandFramework;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class FreeRank extends JavaPlugin {

    private FileConfig mainConfig;

    private FreeRankAdmin freeRankAdmin;

    public void onEnable() {
        loadConfig();
        registerCommands();
        this.freeRankAdmin = new FreeRankAdmin();
        this.freeRankAdmin.load();
        CC.log("");
        CC.log("&bFreeRank &7| &3Koala Community");
        CC.log("");
        CC.log("&bAuthor&7: ");
        CC.log("");
    }
    public void registerCommands() {
        this.registerCommands(
                new FreeRankCommand());
    }
    private void registerCommands(Object... command) {
        CommandFramework commandFramework = new CommandFramework(this);
        Arrays.stream(command).forEach(commandFramework::registerCommands);
    }

    public void onDisable() {
        CC.log("");
    }

    private void loadConfig() {
        this.mainConfig = new FileConfig(this, "config.yml");
    }

    public static FreeRank get() {
        return (FreeRank)getPlugin(FreeRank.class);
    }

    public FileConfig getMainConfig() {
        return this.mainConfig;
    }

    public FreeRankAdmin getfreeRankAdmin() {
        return this.freeRankAdmin;
    }

}