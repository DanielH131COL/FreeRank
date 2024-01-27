package koala.dev.freerank.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Util {
    public static String VERSION = "&6Version: &f0.0.1-SNAPSHOT";

    public static String VERSIONARROW = " &7&6Version: &f0.0.1-SNAPSHOT";

    public static String LONG_LINE = "&7&m----------------------------------------";

    public static String NORMAL_LINE = "&7&m-----------------------------";

    public static String SHORT_LINE = "&7&m---------------";

    public static String BLUE = ChatColor.BLUE.toString();

    public static String AQUA = ChatColor.AQUA.toString();

    public static String YELLOW = ChatColor.YELLOW.toString();

    public static String RED = ChatColor.RED.toString();

    public static String GRAY = ChatColor.GRAY.toString();

    public static String GOLD = ChatColor.GOLD.toString();

    public static String GREEN = ChatColor.GREEN.toString();

    public static String WHITE = ChatColor.WHITE.toString();

    public static String BLACK = ChatColor.BLACK.toString();

    public static String BOLD = ChatColor.BOLD.toString();

    public static String ITALIC = ChatColor.ITALIC.toString();

    public static String UNDER_LINE = ChatColor.UNDERLINE.toString();

    public static String STRIKE_THROUGH = ChatColor.STRIKETHROUGH.toString();

    public static String RESET = ChatColor.RESET.toString();

    public static String MAGIC = ChatColor.MAGIC.toString();

    public static String DARK_BLUE = ChatColor.DARK_BLUE.toString();

    public static String DARK_AQUA = ChatColor.DARK_AQUA.toString();

    public static String DARK_GRAY = ChatColor.DARK_GRAY.toString();

    public static String DARK_GREEN = ChatColor.DARK_GREEN.toString();

    public static String DARK_PURPLE = ChatColor.DARK_PURPLE.toString();

    public static String DARK_RED = ChatColor.DARK_RED.toString();

    public static String PINK = ChatColor.LIGHT_PURPLE.toString();

    public static String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> translate(List<String> list) {
        return (List<String>)list.stream().map(Util::translate).collect(Collectors.toList());
    }

    public static String strip(String text) {
        return ChatColor.stripColor(text);
    }

    public static void sender(CommandSender sender, String text) {
        sender.sendMessage(translate(text));
    }

    public static void message(Player player, String text) {
        player.sendMessage(translate(text));
    }

    public static void broadcast(String text) {
        Bukkit.broadcastMessage(translate(text));
    }

    public static void log(String text) {
        Bukkit.getConsoleSender().sendMessage(translate(text));
    }

    public static String capitalize(String str) {
        return WordUtils.capitalize(str);
    }

    public static String toReadable(Enum<?> enu) {
        return WordUtils.capitalize(enu.name().replace("_", " ").toLowerCase());
    }

    private Util() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
