package koala.dev.freerank.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class CC {

    public static String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void log(String text) {
        Bukkit.getConsoleSender().sendMessage(translate(text));
    }

    private void Util() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

}
