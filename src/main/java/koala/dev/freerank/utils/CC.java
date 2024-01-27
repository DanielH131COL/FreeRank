package koala.dev.freerank.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.ChatColor;

public class CC {
    public static final String MENU_BAR = translate("&7&m------------------------");

    public static final String CHAT_BAR = translate("&7&m------------------------------------------------");

    public static final String SB_BAR = translate("&7&m----------------------");

    public static final String TAB_BAR = translate("&7&m-----------------");

    public static String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static List<String> translate(List<String> in) {
        return (List<String>)in.stream().map(CC::translate).collect(Collectors.toList());
    }

    public static String message(String[] args, int x) {
        StringBuilder builder = new StringBuilder();
        for (int i = x; i < args.length; i++) {
            builder.append(args[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
