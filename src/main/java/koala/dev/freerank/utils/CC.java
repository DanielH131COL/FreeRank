package koala.dev.freerank.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class CC {

    public static String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void log(String text) {
        Bukkit.getConsoleSender().sendMessage(translate(text));
    }

}
